package bcs.csc411.csc411project;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HelloController extends HelloApplication {

    @FXML
    private TextField confirmPasswordField;


    @FXML
    private TextField passwordField;

    @FXML
    private TextField emailField;

    public void initialize(){
        DBManager.createUserTable();
    }


    @FXML
    public void switchToSignUp() throws IOException {
        sceneSwitcher("SignUp.fxml");
    }

    @FXML
    public void switchToLogin() throws IOException {
        sceneSwitcher("sign-in.fxml");
    }

    @FXML
    public void switchToMainMenu() throws IOException {
        sceneSwitcher("main-menu.fxml");
    }

    @FXML
    public void switchToHome() throws IOException {
        sceneSwitcher("home.fxml");
    }

    @FXML
    public void createAccount() throws IOException {
//        String email = emailField.getText();
//        String password = passwordField.getText();
//        String confirmPassword = confirmPasswordField.getText();
//        String salt = "";
//
//        User newUser = new User(email, salt, password);
//        DBManager.addUser(newUser);


        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(emailField.getText().isEmpty() && passwordField.getText().isEmpty()){
            alert.setTitle("TextFields are empty");
            alert.setContentText("Fill in email and password");
            alert.show();
        }
        else if(!passwordField.getText().equals(confirmPasswordField.getText())){
            alert.setTitle("Error!");
            alert.setContentText("Passwords are not the same.");
            alert.show();
        }
        else{
            String email = emailField.getText();
            String password = passwordField.getText();
            String confirmPassword = confirmPasswordField.getText();
            String salt = "";

            User newUser = new User(email, salt, password);
//            DBManager.addUser(newUser);
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success!");
            alert.setContentText("Account created!");
            alert.show();
            switchToLogin();
        }


    }

    @FXML
    public void login() throws IOException {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(userManager.getCurrentUser().getUsername().isEmpty()){
            alert.setTitle("Login failed!");
            alert.setContentText("User doesn't exist");
            alert.show();
            return;
        }

        //Uses the static userManager to access user data
        if(emailField.getText().equals(userManager.getCurrentUser().getUsername()) &&
                passwordField.getText().equals(userManager.getCurrentUser().getPassword())){
            System.out.println("Login successful!");
            switchToMainMenu();
        }
        else{
            System.out.println("Login failed!");

            alert.setTitle("Login Failed");
            alert.setContentText("Username or password is incorrect");
            alert.show();
        }
    }
}