module ru.vsu.cs.vetokhin.kg4task {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.vsu.cs.vetokhin.kg4task to javafx.fxml;
    exports ru.vsu.cs.vetokhin.kg4task;
}