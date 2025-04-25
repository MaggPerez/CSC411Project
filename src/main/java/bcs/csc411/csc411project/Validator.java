package bcs.csc411.csc411project;

public class Validator {

    /**
     * method that validates email
     * @param email
     * @return a string with an error message or not
     */
    public static String validateEmail(String email){

        //email requirement message that tells users what their email must have
        String emailRequirements = "1. Email should contain lowercase letters, uppercase letters, digits, and characters #$%&*-\n" +
                "2. After the @ symbol it must contain lowercase letters, uppercase letters, and digits (\"gmail\" or \"hotmail\")\n" +
                "3. Top Level Domain must contain 2 to 4 letters. Examples are com, edu, co, org, info, ca, uk \n";

        //if email field is empty, it will return a message saying it's empty
        if(email.isEmpty()){
            return "Email field cannot be empty.";
        }

        //if email passes regular expression test, no message is thrown which means there are no errors
        else if(email.matches("[A-Za-z0-9#$%&*-]+@[A-Za-z0-9]+\\.[a-zA-Z]{2,4}")) {
            return "";
        }

        else{
            //if email doesn't meet the requirements, it will return a message showing a list of requirements
            return emailRequirements;
        }

    }

    /**
     * method that validates password, takes in password and confirm password fields
     * @param password
     * @param confirmPassword
     * @return a string with an error message or not
     */
    public static String validatePasswords(String password, String confirmPassword){

        //password requirement message that tells users what their password must have
        String passwordRequirementMessage = "Password must be at least 8 characters long and \ncontain at least one" +
                " lowercase letter, one uppercase letter, \none digit," +
                " and one special character of the following -+_!@#$%^&*";

        //will return true if both password fields are the same, otherwise false
        boolean passwordsMatch = validateConfirmPassword(password, confirmPassword);

        //regular expression that checks if password fulfills the requirements.
        //returns true if password fulfills requirements, otherwise false
        boolean meetsRequirements = password.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-+_!@#$%^&*]).{8,}");

        //returns error message if both password fields are empty
        if(password.isEmpty() && confirmPassword.isEmpty()){
            return "Both password fields are empty.";
        }

        //returns error message if one of the password fields are empty
        else if(password.isEmpty() || confirmPassword.isEmpty()){
            return "One of the password fields are empty";
        }

        //returns error message if both password fields are not the same and password requirements not met
        if(!passwordsMatch && !meetsRequirements){
            return passwordRequirementMessage + "\nConfirm password must match Password";
        }

        //checking if both password fields are equal
        else if(!passwordsMatch){
            return "Both Password Fields do not match";
        }

        //if they are equal, password requirements will occur here.
        else if(!meetsRequirements){
            //if password doesn't meet the requirements, it will return password requirements
            return passwordRequirementMessage;
        }

        //return empty string which means that there are no error messages and
        //user's password fulfills the requirements, and both password fields match
        return "";
    }



    /**
     * Boolean method that validates if password and confirm password match
     * @param password
     * @param confirmPassword
     * @return true if both passwords match, otherwise false
     */
    public static boolean validateConfirmPassword(String password, String confirmPassword){
        //returns true if both passwords match
        if(password.equals(confirmPassword)){
            return true;
        }
        else{
            //returns false if password fields do not match
            return false;
        }
    }


}
