package bcs.csc411.csc411project;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignUpController extends HelloApplication {
    @FXML
    private TextField confirmPasswordField;


    @FXML
    private TextField passwordField;

    @FXML
    private TextField emailField;

    @FXML
    public void switchToLogin() throws IOException {
        sceneSwitcher("sign-in.fxml");
    }
}
