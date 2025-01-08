package ru.vsu.cs.vetokhin.kg4task.camera;

import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector3f;

import static ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector3f.*;

public class CameraControl {
    public static void rotateAroundTarget(float deltaPhi, float deltaTheta, Camera camera) {
        Vector3f direction = subtract(camera.getPosition(), camera.getTarget());
        float radius = direction.length();
        float phi = (float) Math.acos(direction.getY() / radius);
        float theta = (float) Math.atan2(direction.getZ(), direction.getX());

        phi = Math.max(0.1F, Math.min((float) Math.PI - 0.1F, phi + deltaPhi));
        theta = theta + deltaTheta;

        float x = (float) (radius * Math.sin(phi) * Math.cos(theta));
        float y = (float) (radius * Math.cos(phi));
        float z = (float) (radius * Math.sin(phi * Math.sin(theta)));

        camera.setPosition(add(camera.getTarget(), new Vector3f(x, y, z)));
    }

    public static void moveCamera(String direction, float translationSpeed, Camera camera) {
        Vector3f moveVector = new Vector3f();


        switch (direction) {
            case "forward" -> {
                Vector3f forward = subtract(camera.getTarget(), camera.getPosition());
                forward.normalize();
                forward.multiply(translationSpeed);
                moveVector = forward;
            }
            case "backward" -> {
                Vector3f backwards = subtract(camera.getPosition(), camera.getTarget());
                backwards.normalize();
                backwards.multiply(translationSpeed);
                moveVector = backwards;
            }
            case "left" -> {
                Vector3f forward = subtract(camera.getTarget(), camera.getPosition());
                forward.normalize();
                Vector3f up = new Vector3f(0, 1, 0);
                Vector3f left = crossProduct( up, forward);
                left.normalize();
                left.multiply(-translationSpeed);
                moveVector = left;
            }
            case "right" -> {
                Vector3f forward = subtract(camera.getTarget(), camera.getPosition());
                forward.normalize();
                Vector3f up = new Vector3f(0, 1 ,0);
                Vector3f right = crossProduct(up, forward);
                right.normalize();
                right.multiply(translationSpeed);
                moveVector = right;
            }
            case "up" -> {
                Vector3f up = new Vector3f(0, 1, 0);
                up.multiply(translationSpeed);
                moveVector = up;
            }
            case "down" -> {
                Vector3f down = new Vector3f(0, 1, 0);
                down.multiply(-translationSpeed);
                moveVector = down;
            }
        }
        camera.moveTarget(moveVector);
        camera.movePosition(moveVector);
    }

    public static void mouseDrag(double deltaX, double deltaY, Camera camera, float rotationSpeed) {
        float deltaTheta = (float) (deltaX * rotationSpeed);
        float deltaPhi = (float) (deltaY * rotationSpeed);
        rotateAroundTarget(deltaPhi, deltaTheta, camera);

    }

    public static void mouseScroll(double deltaY, Camera camera, float zoomSpeed) {
        Vector3f direction = subtract(camera.getTarget(), camera.getPosition());
        float distance = direction.length();

        if (distance - deltaY * zoomSpeed > 0.5F) {
            direction.normalize();
            direction.multiply((float) deltaY * zoomSpeed);
            camera.movePosition(direction);
        }
    }

}
