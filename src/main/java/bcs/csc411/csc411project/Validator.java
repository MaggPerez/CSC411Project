package bcs.csc411.csc411project;

public class Validator {
    private String email;
    private String password;
    private String confirmPassword;

    public Validator(){
        this.email = "";
        this.password = "";
        this.confirmPassword = "";
    }

    public Validator(String email, String password, String confirmPassword) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}
