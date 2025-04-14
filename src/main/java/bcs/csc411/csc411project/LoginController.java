package bcs.csc411.csc411project;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController extends HelloApplication{

    @FXML
    private TextField passwordField;

    @FXML
    private TextField emailField;

    @FXML
    public void switchToHome() throws IOException {
        sceneSwitcher("home.fxml");
    }

    @FXML
    public void switchToMainMenu() throws IOException {
        sceneSwitcher("main-menu.fxml");
    }


    @FXML
    public void login() throws IOException {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        String email = emailField.getText();
        String enteredPassword = passwordField.getText();

        //checks if user exists, returns true if found.
        boolean isAuthenticated = PasswordManager.authenticate(email, enteredPassword);
        if(isAuthenticated){
            System.out.println("Login successful");
            switchToMainMenu();
        }
        else{
            alert.setTitle("Login Failed");
            alert.setContentText("Username or password is incorrect");
            alert.show();
        }

    }
}
