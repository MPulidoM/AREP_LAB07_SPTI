package org.example;
import static spark.Spark.*;
/**
 * Clase principal que define el servidor web y sus rutas.
 */
public class HelloWorld {
    /**
     * Método principal que inicia el servidor web.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        secure("certificados/ecikeystore.p12", "123456", null, null);
        port(getPort());
        staticFiles.location("/public");
        get("/hello", (req, res) -> "Hello World");
        post("/login", (req, res) -> {
            String username = req.queryParams("user");
            String password = req.queryParams("pass");

            return URLReader.secureReadUrl(username, password);
        });

    }
    /**
     * Método que obtiene el puerto en el que el servidor web escuchará.
     * @return El puerto en el que el servidor web escuchará.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; 
    }


}
