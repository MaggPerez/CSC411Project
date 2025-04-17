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
        Alert alert = new Alert(Alert.AlertType.ERROR);

        //getting user info from all TextFields
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        //Validating email and password
        String emailValidation = Validator.validateEmail(email);
        String passwordValidation = Validator.validatePasswords(password, confirmPassword);


        //if email and password validations contain an error, it will be displayed
        if(!emailValidation.isEmpty() && !passwordValidation.isEmpty()){
            alert.setTitle("Error");
            alert.setContentText(emailValidation + "\n" + passwordValidation);
            alert.show();
        }
        //if email validation contains an error, it will be displayed
        else if(!emailValidation.isEmpty()){
            alert.setTitle("Error in Email");
            alert.setContentText(emailValidation);
            alert.show();
        }
        //if password validation contains an error, it will be displayed
        else if(!passwordValidation.isEmpty()){
            alert.setTitle("Error in Password");
            alert.setContentText(passwordValidation);
            alert.show();
        }

        //if there are no error messages, the user gets added into database
        else{
            //generating salt
            byte[] byteSalt = PasswordManager.generateSalt();
            String strSalt = PasswordManager.byteArrayToString(byteSalt);

            //generating password hash
            String passwordHash = PasswordManager.generatePasswordHash(password, byteSalt);

            //adding user to database with salt and password hash
            User newUser = new User(email, strSalt, passwordHash);
            DBManager.addUser(newUser);

            //displaying alert message that it was a success
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success!");
            alert.setContentText("Account created!");
            alert.show();

            //switching to login screen
            switchToLogin();
        }

    }
}
