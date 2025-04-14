package bcs.csc411.csc411project;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PasswordManager {
    final static SecureRandom rand = new SecureRandom();


    public static byte[] generateSalt() {
        byte[] salt = new byte[32];
        rand.nextBytes(salt);
        return salt;
    }

    public static String byteArrayToString(byte[] barray){
        //convert byte salt into string salt
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        return encoder.encodeToString(barray);
    }

    public static byte[] stringToByteArray(String str){
        Base64.Decoder decoder = Base64.getUrlDecoder();
        return decoder.decode(str);
    }

    public static String generatePasswordHash(String password, byte[] salt){
        byte[] passwordHash = null;
//        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 512);
//        passwordHash = factory.generateSecret(spec).getEncoded();
        return null;
    }

    public static boolean authenticate(String email, String enteredPassword) {
        boolean authenticated = false;
        String storedPassword = DBManager.retrievePassword(email);

        authenticated = enteredPassword.equals(storedPassword);

        return authenticated;
    }
}
