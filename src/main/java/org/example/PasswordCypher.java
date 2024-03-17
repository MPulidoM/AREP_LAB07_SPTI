package org.example;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordCypher {

    public static String cypherPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA3-256");
        byte[] hash = md.digest(password.getBytes());
        BigInteger number = new BigInteger(1, hash);
        String hexString = number.toString(16);
        while (hexString.length() < 64) {
            hexString = "0" + hexString;
        }
        return hexString;
    }

    public static boolean validatePassword(String passToValidate, String correctPassword)
            throws NoSuchAlgorithmException {
        System.out.println(PasswordCypher.cypherPassword(passToValidate));
        return correctPassword.equals(PasswordCypher.cypherPassword(passToValidate));
    }

}
