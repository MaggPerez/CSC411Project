package bcs.csc411.csc411project;

import javafx.fxml.FXML;

import java.io.IOException;

public class HomeController extends HelloApplication{

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
}
