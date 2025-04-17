package bcs.csc411.csc411project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage primaryStage;
    private static Scene scene;

    public static void initializeScene(Parent root){
        scene = new Scene(root);
    }


    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setStage(Stage stage){
        primaryStage = stage;
    }

    @Override
    public void start(Stage stage) throws IOException {
        initializeScene(loadFXML("home"));
        setStage(stage);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void sceneSwitcher(String fxmlFile) throws IOException {
        Stage stage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("CSC 411 App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
