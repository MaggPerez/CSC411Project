package bcs.csc411.csc411project;

import javafx.fxml.FXML;

import java.io.IOException;

public class MainMenuController extends HelloApplication {
    @FXML
    public void switchToHome() throws IOException {
        sceneSwitcher("home.fxml");
    }
}
