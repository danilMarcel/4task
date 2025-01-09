package ru.vsu.cs.vetokhin.kg4task;



import javafx.fxml.FXML;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

import ru.vsu.cs.vetokhin.kg4task.math.matrices.Matrix3f;
import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector3f;
import ru.vsu.cs.vetokhin.kg4task.camera.Camera;
import ru.vsu.cs.vetokhin.kg4task.model.Model;

import static ru.vsu.cs.vetokhin.kg4task.camera.CameraControl.*;
import static ru.vsu.cs.vetokhin.kg4task.camera.CameraControl.rotateAroundTarget;

public class GuiController {

    final private float TRANSLATION = 0.5F;
    final private float ROTATION = 0.01F;
    final private float ZOOM = 0.1F;


    private double lastMouseX;
    private double lastMouseY;
    private boolean isMousePressed;


    public TextField xCameraPosition;
    public TextField yCameraPosition;
    public TextField zCameraPosition;
    private Vector3f cameraPosition;

    public TextField xTargetPosition;
    public TextField yTargetPosition;
    public TextField zTargetPosition;
    private Vector3f targetPosition;



    public TextField xScale;
    public TextField yScale;
    public TextField zScale;
    public TextField xRotation;
    public TextField yRotation;
    public TextField zRotation;
    public TextField xTrans;
    public TextField yTrans;
    public TextField zTrans;
    public Matrix3f trsParams = new Matrix3f(new Vector3f(), new Vector3f(), new Vector3f(1, 1, 1));


    @FXML
    AnchorPane anchorPane;

    @FXML
    private Canvas canvas;


    private int modelCounter = 0;
    private int cameraCounter = 2;
    private int globalCameraIndex = 1;
    private int currCameraIndex = 0;

    private ArrayList<Camera> cameraArrayList = new ArrayList<>();
    private ArrayList<Model> modelArrayList = new ArrayList<>();
    private ArrayList<Matrix3f> trsParamsArrayList = new ArrayList<>();



    private Camera cameraC = new Camera(
            new Vector3f(0, 0, 75),
            new Vector3f(0, 0, 0),
            1.0F, 1, 0.01F, 100);

    private Camera nullCamera = new Camera(
            new Vector3f(0, 0, 25),
            new Vector3f(0, 0, 0),
            1.0F, 1, 0.01F, 100);


    private Timeline timeline;

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);

        KeyFrame frame = new KeyFrame(Duration.millis(15), event -> {
            double width = canvas.getWidth();
            double height = canvas.getHeight();

            canvas.getGraphicsContext2D().clearRect(0, 0, width, height);
            cameraC.setAspectRatio((float) (width / height));

//            if (mesh != null) {
//                RenderEngine.render(canvas.getGraphicsContext2D(), camera, mesh, (int) width, (int) height);
//            }
        });

        timeline.getKeyFrames().add(frame);
        timeline.play();
    }

    public void positionChange(KeyEvent keyEvent) {
        cameraPosition = new Vector3f(
                Float.parseFloat(xCameraPosition.getText()),
                Float.parseFloat(yCameraPosition.getText()),
                Float.parseFloat(zCameraPosition.getText()));
    }

    public void targetChange(KeyEvent keyEvent) {
        targetPosition = new Vector3f(
                Float.parseFloat(xTargetPosition.getText()),
                Float.parseFloat(yTargetPosition.getText()),
                Float.parseFloat(zTargetPosition.getText()));
    }



    @FXML
    private void onOpenModelMenuItemClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Model (*.obj)", "*.obj"));
        fileChooser.setTitle("Load Model");

        File file = fileChooser.showOpenDialog((Stage) canvas.getScene().getWindow());
        if (file == null) {
            return;
        }

        Path fileName = Path.of(file.getAbsolutePath());

        try {
            String fileContent = Files.readString(fileName);
//            mesh = ObjReader.read(fileContent);
            // todo: обработка ошибок
        } catch (IOException exception) {

        }
    }

    public void transform(KeyEvent actionEvent) {
        trsParams.setV1(new Vector3f(
                Float.parseFloat(xTrans.getText()),
                Float.parseFloat(yTrans.getText()),
                Float.parseFloat(zTrans.getText())));
        trsParams.setV2(new Vector3f(
                Float.parseFloat(xRotation.getText()),
                Float.parseFloat(yRotation.getText()),
                Float.parseFloat(zRotation.getText())));
        trsParams.setV3(new Vector3f(
                Float.parseFloat(xScale.getText()),
                Float.parseFloat(yScale.getText()),
                Float.parseFloat(zScale.getText())));
    }

    private void updateTRSFields() {
        xTrans.setText(String.valueOf(trsParams.getV1().getX()));
        yTrans.setText(String.valueOf(trsParams.getV1().getY()));
        zTrans.setText(String.valueOf(trsParams.getV1().getZ()));
        xRotation.setText(String.valueOf(trsParams.getV2().getX()));
        yRotation.setText(String.valueOf(trsParams.getV2().getY()));
        zRotation.setText(String.valueOf(trsParams.getV2().getZ()));
        xScale.setText(String.valueOf(trsParams.getV3().getX()));
        yScale.setText(String.valueOf(trsParams.getV3().getY()));
        zScale.setText(String.valueOf(trsParams.getV3().getZ()));
    }


    @FXML
    public void handleCameraMove(ActionEvent actionEvent) {
        String id = ((Control) actionEvent.getSource()).getId();
        switch (id) {
            case "cameraRotateUp" -> rotateAroundTarget(-ROTATION, 0, cameraC);
            case "cameraRotateDown" -> rotateAroundTarget(ROTATION, 0, cameraC);
            case "cameraRotateLeft" -> rotateAroundTarget(0, -ROTATION, cameraC);
            case "cameraRotateRight" -> rotateAroundTarget(0, ROTATION, cameraC);
            case "cameraForward" -> moveCamera("forward", TRANSLATION, cameraC);
            case "cameraBackward" -> moveCamera("backward", TRANSLATION, cameraC);
            case "cameraLeft" -> moveCamera("left", TRANSLATION, cameraC);
            case "cameraRight" -> moveCamera("right", TRANSLATION, cameraC);
            case "cameraUp" -> moveCamera("up", TRANSLATION, cameraC);
            case "cameraDown" -> moveCamera("down", TRANSLATION, cameraC);

        }
    }
}




//    @FXML
//    public void handleCameraForward(ActionEvent actionEvent) {
//        camera.movePosition(new Vector3f(0, 0, -TRANSLATION));
//    }
//
//    @FXML
//    public void handleCameraBackward(ActionEvent actionEvent) {
//        camera.movePosition(new Vector3f(0, 0, TRANSLATION));
//    }
//
//    @FXML
//    public void handleCameraLeft(ActionEvent actionEvent) {
//        camera.movePosition(new Vector3f(TRANSLATION, 0, 0));
//    }
//
//    @FXML
//    public void handleCameraRight(ActionEvent actionEvent) {
//        camera.movePosition(new Vector3f(-TRANSLATION, 0, 0));
//    }
//
//    @FXML
//    public void handleCameraUp(ActionEvent actionEvent) {
//        camera.movePosition(new Vector3f(0, TRANSLATION, 0));
//    }
//
//    @FXML
//    public void handleCameraDown(ActionEvent actionEvent) {
//        camera.movePosition(new Vector3f(0, -TRANSLATION, 0));
//    }
