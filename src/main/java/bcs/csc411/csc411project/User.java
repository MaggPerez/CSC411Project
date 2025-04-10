package bcs.csc411.csc411project;

public class User {
    private String email;
    private String salt;
    private String password;


    public User() {
        this.email = "";
        this.password = "";
        this.salt = "";
    }

    public User(String username, String salt, String password){
        this.email = username;
        this.password = password;
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

