package org.example;

import java.io.*;
import java.net.*;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.util.logging.Logger;
/**
 * Clase que permite leer el contenido de una URL.
 */
public class URLReader {
    private static final Logger logger = Logger.getLogger(String.valueOf(URLReader.class));
    /**
     * Método que lee el contenido de una URL utilizando un protocolo seguro (HTTPS).
     * @param username Nombre de usuario para la autenticación.
     * @param password Contraseña para la autenticación.
     * @return Contenido de la URL en formato de texto.
     */
    public static String secureReadUrl(String username, String password) {
        String secureResponse = "";
        try {
            File trustStoreFile = new File("certificados/myTrustStore.p12");
            char[] trustStorePassword = "123456".toCharArray();
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(new FileInputStream(trustStoreFile), trustStorePassword);
            TrustManagerFactory tmf = TrustManagerFactory
                    .getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(trustStore);
            for (TrustManager t : tmf.getTrustManagers()) {
                logger.info((Supplier<String>) t);
            }
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);
            SSLContext.setDefault(sslContext);
            secureResponse = readURL("https://localhost:5100/login?user=" + username + "&pass=" + password);
        } catch (KeyStoreException ex) {
            Logger.getLogger(URLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(URLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(URLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(URLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CertificateException ex) {
            Logger.getLogger(URLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(URLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return secureResponse;
    }

    private URLReader(){
        throw new IllegalStateException("Utility class");
    }
    
    /**
     * Método que lee el contenido de una URL y lo devuelve como una cadena de texto.
     * @param sitetoread URL a leer.
     * @return Contenido de la URL como una cadena de texto.
     * @throws IOException Si ocurre un error al leer la URL.
     */
    public static String readURL(String sitetoread) {
        StringBuilder response = new StringBuilder();
        try {
            URL siteURL = new URL(sitetoread);
            URLConnection urlConnection = siteURL.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                logger.info(inputLine);
                response.append(inputLine);
            }
        } catch (IOException x) {
            response.append(x);
        }
        return response.toString();
    }
}
