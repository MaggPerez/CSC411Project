package bcs.csc411.csc411project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ValidatorTest {

    @Test
    @DisplayName("Validating email if it meets" +
            "the requirements")
    void validateEmail() {
        //Valid Emails
        assertEquals("", Validator.validateEmail("user123@gmail.com"), "Should accept valid email");
        assertEquals("", Validator.validateEmail("admin#$@domain.co"), "Should accept email with special chars");
        assertEquals("", Validator.validateEmail("samjames@unity.uk"), "Should accept valid TLD");


        //Invalid Emails
        assertNotEquals("", Validator.validateEmail("@example.com"), "Should reject missing local part");
        assertNotEquals("", Validator.validateEmail("user@.com"), "Should reject missing SLD");
        assertNotEquals("", Validator.validateEmail("john@gmail.c"), "Should reject TLD that's too short");
        assertNotEquals("", Validator.validateEmail("mike@yahoo.commm"), "Should reject TLD that's too long");
        assertNotEquals("", Validator.validateEmail("romeo!@hotmail.com"), "Should reject invalid chars");
        assertNotEquals("", Validator.validateEmail(""), "Should reject empty email");

    }

    @Test
    @DisplayName("Validating password to see" +
            "if they both meet the requirements.")
    void validatePasswords() {
//        assertEquals("");

    }

    @Test
    @DisplayName("Validating confirmPassword to see" +
            "if password and confirmPassword match")
    void validateConfirmPassword(){

    }
}