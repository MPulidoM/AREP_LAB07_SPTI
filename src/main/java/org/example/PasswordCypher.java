package org.example;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * Clase que proporciona métodos para cifrar y validar contraseñas utilizando el algoritmo de hash SHA-3.
 */
public class PasswordCypher {
    /**
     * Método que cifra una contraseña utilizando el algoritmo de hash SHA-3.
     * @param password La contraseña a cifrar.
     * @return La contraseña cifrada como una cadena de texto hexadecimal de 64 caracteres.
     * @throws NoSuchAlgorithmException Si el algoritmo de hash especificado no está disponible.
     */
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
    
    /**
     * Método que valida una contraseña cifrada.
     * @param passToValidate La contraseña a validar.
     * @param correctPassword La contraseña cifrada correcta.
     * @return Verdadero si la contraseña a validar coincide con la contraseña cifrada correcta, falso en caso contrario.
     * @throws NoSuchAlgorithmException Si el algoritmo de hash especificado no está disponible.
     */
    public static boolean validatePassword(String passToValidate, String correctPassword)
            throws NoSuchAlgorithmException {
        System.out.println(PasswordCypher.cypherPassword(passToValidate));
        return correctPassword.equals(PasswordCypher.cypherPassword(passToValidate));
    }

}
