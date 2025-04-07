module bcs.csc411.csc411project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens bcs.csc411.csc411project to javafx.fxml;
    exports bcs.csc411.csc411project;
}