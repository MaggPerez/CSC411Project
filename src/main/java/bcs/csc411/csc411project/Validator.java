package bcs.csc411.csc411project;

public class Validator {

    public static String validateEmail(String email){
        String message = "";

        //if email field is empty, it will return a message saying it's empty
        if(email.isEmpty()){
            return message = "Email field cannot be empty.";
        }
        //if email passes regular expression test, no message is thrown which means there are no errors
        else if(email.matches("[A-Za-z0-9#$%&*-]*@[A-Za-z0-9]+[.][a-z]{2,4}")){
            return "";
        }
        else{
            //if email doesn't meet the requirements, it will return a message showing a list of requirements
            return message = "1. Email should contain lowercase letters, uppercase letters, digits, and characters #$%&*-\n" +
                    "2. After the @ symbol it must contain lowercase letters, uppercase letters, and digits (\"gmail\" or \"hotmail\")\n" +
                    "3. Top Level Domain must contain 2 to 4 letters. Examples are com, edu, co, org, info, ca, uk ";
        }

    }

    /**
     * @param password
     * @param confirmPassword
     * @return
     */
    public static String validatePasswords(String password, String confirmPassword){
        String message = "";


        //returns message that both password fields are empty
        if(password.isEmpty() && confirmPassword.isEmpty()){
            return message = "Both password fields are empty.";
        }

        //returns message that one of the password fields are empty
        else if(password.isEmpty() || confirmPassword.isEmpty()){
            return message = "One of the password fields are empty";
        }

        //checking if both password fields are equal
        if(!password.equals(confirmPassword)){
            return message = "Passwords do not match";
        }

        //if they are equal, password requirements will occur here.
        if(password.matches("[A-Za-z\\d-+_!@#$%^&*]{8,}")){
            return "";
        }
        else{
            //if password doesn't meet the requirements, it will return password requirements
            return message = "Password must be at least 8 characters long and \ncontain at least one" +
                    "lowercase letter, one uppercase letter, \none digit," +
                    " and one special character of the following -+_!@#$%^&*";
        }

    }


}
