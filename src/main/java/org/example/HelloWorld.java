package org.example;
import java.security.MessageDigest;

import static spark.Spark.*;

public class HelloWorld {
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

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }


}