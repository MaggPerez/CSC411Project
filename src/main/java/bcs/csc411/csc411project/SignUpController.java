package bcs.csc411.csc411project;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
        //Shows error alert if both fields are empty
        if(emailField.getText().isEmpty() && passwordField.getText().isEmpty()){
            alert.setTitle("TextFields are empty");
            alert.setContentText("Fill in email and password");
            alert.show();
        }
        //Error alert if both password fields are not the same.
        else if(!passwordField.getText().equals(confirmPasswordField.getText())){
            alert.setTitle("Error!");
            alert.setContentText("Passwords are not the same.");
            alert.show();
        }
        else{
            //adds user's account to DB
            String email = emailField.getText();
            String password = passwordField.getText();
            //Validation here (YOU WILL ADD THIS)

            //generating salt
            byte[] byteSalt = PasswordManager.generateSalt();
            String strSalt = PasswordManager.byteArrayToString(byteSalt);

            //generating password hash
            String passwordHash = PasswordManager.generatePasswordHash(password, byteSalt);

            //adding user to database
            User newUser = new User(email, strSalt, passwordHash);
            DBManager.addUser(newUser);

            //Shows alert that account was created
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success!");
            alert.setContentText("Account created!");
            alert.show();
            switchToLogin();
        }


    }
}
