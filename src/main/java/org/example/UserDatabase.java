package org.example;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.secure;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
/**
 * Clase que representa un sistema de base de datos de usuarios.
 */
public class UserDatabase {
    /**
     * Mapa estático que almacena los usuarios y sus contraseñas cifradas.
     */
    private static Map<String, String> db = new HashMap<>();
    /**
     * Método principal de la clase.
     * @param args Argumentos de la línea de comandos.
     * @throws NoSuchAlgorithmException Si ocurre un error al cifrar las contraseñas.

     */
    public static void main(String[] args) throws NoSuchAlgorithmException {

        db.put("Juliana", PasswordCypher.cypherPassword("harryStyles08"));
        db.put("Erika", PasswordCypher.cypherPassword("prueba28"));

        secure("certificados/ecikeystore.p12", "123456", null, null);
        port(getPort());
        get("/login", (req, res) -> {
            String username = req.queryParams("user");
            String password = req.queryParams("pass");
            if (!db.containsKey(username)) {
                return "Usuario no encontrado &#x1F612";
            } else if (password.equals("")) {
                return "Porfavor ingrese una contraseña &#x263A";
            }
            return PasswordCypher.validatePassword(password, db.get(username)) ? "Inicio de sesión exitosamente &#128151" : "Contraseña incorrecta &#x1F622";
        });
    }
    
     /**
     * Método que devuelve el número de puerto en el que se ejecutará.
     * @return Número de puerto.
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5100;
    }

}
