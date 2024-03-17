# LABORATORIO 7 - DISTRIBUIDA SEGURA EN TODOS SUS FRENTES
En este laboratorio, desarrollara una aplicación web segura que garantice la autenticación, autorización e integridad de los usuarios. 
Los entregables incluirán el código fuente en GitHub, un informe descriptivo en el README y un video demostrativo en AWS, 
A través de la implementación de protocolos seguros como HTTPS y el acceso a servicios remotos sean confiables y seguros.
mostrando la seguridad y funcionalidad de tu prototipo. 

## HERRAMIENTAS 
- [MAVEN](https://maven.apache.org) : Para el manejo de las dependecias.
  <p align="center">
  <IMG src=https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Apache_Maven_logo.svg/1280px-Apache_Maven_logo.svg.png height=150 width=250 >
    <p/>
- [GIT](https://git-scm.com) : Para el manejo de las versiones.
  <p align="center">
  <IMG src=https://logowik.com/content/uploads/images/git6963.jpg height=150 width=250 >
    <p/>
- [JAVA](https://www.java.com/es/) : Lenguaje de programación manejado.
  <p align="center">
  <IMG src=https://1000marcas.net/wp-content/uploads/2020/11/Java-logo.png height=150 width=250> 
  <p/>
- 
# ARQUITECTURA 
la arquitectura del proyecto sigue un patrón de diseño en el que cada clase tiene una responsabilidad específica.

La clase **UserDatabase** se encarga de gestionar los usuarios y las contraseñas, y proporciona métodos para agregar y validar usuarios. La clase **PasswordCypher** se encarga de cifrar y validar contraseñas utilizando el **algoritmo SHA-3** de 256 bits. La clase **URLReader** se encarga de leer el contenido de una URL de forma segura utilizando la validación de certificados SSL. Por último, la clase **HelloWorld** es el punto de entrada del servidor web y proporciona dos rutas HTTP: una ruta GET que devuelve el texto "Hello World" y una ruta POST que utiliza el método URLReader.secureReadUrl para leer el contenido de una URL de forma segura.

En cuanto a la arquitectura de seguridad, se utiliza un enfoque de autenticación de usuario mediante el cifrado de contraseñas con el **algoritmo SHA-3** de 256 bits. Además, se utiliza una conexión SSL para establecer una conexión segura con el servidor.

Para **mejorar la escalabilidad de la arquitectura de seguridad**, se podría implementar una base de datos externa para almacenar los datos de usuarios y una infraestructura de autenticación más robusta, como OAuth2. Además, se podría implementar una capa de autorización para restringir el acceso a ciertas rutas o recursos.

# DISEÑO DE CLASES  
Este laboratori está compuesto por 4 clases principales:
1. **UserDatabase:** Esta clase es responsable de gestionar los usuarios y las contraseñas de la aplicación. Proporciona dos métodos principales:
   * addUser(String username, String password): Agrega un nuevo usuario a la base de datos con la contraseña cifrada utilizando el algoritmo SHA-3 de 256 bits.
    validatePassword(String username, String password): Valida la contraseña de un usuario dado.
2. **PasswordCypher:** Esta clase es responsable de cifrar y validar las contraseñas de los usuarios. Proporciona dos métodos principales:

   * *cypherPassword(String password):* Cifra una contraseña utilizando el algoritmo SHA-3 de 256 bits.
    validatePassword(String plainTextPassword, String cypherTextPassword): Valida una contraseña cifrada.
3. **URLReader:** Esta clase es responsable de leer el contenido de una URL de forma segura. Proporciona dos métodos principales:

   * *secureReadUrl(String username, String password):* Lee el contenido de una URL de forma segura utilizando la validación de certificados SSL.
   * *readUrl(String url):* Lee el contenido de una URL de forma no segura.
4. **HelloWorld:** Esta clase es el punto de entrada principal para el servidor web y proporciona dos rutas HTTP: una ruta GET que devuelve el texto "Hello World" y una ruta POST que utiliza el método URLReader.secureReadUrl para leer el contenido de una URL de forma segura.


# INSTALACIÓN 
+ Se clona el repositorio en una máquina local con el siguiente comando:
  
    ```
    git clone https://github.com/Juc28/AREP_LAB07.git
    ```
+ Entrar al directorio del proyecto con el siguiente comando:
    ```
    cd AREP_LAB07
    ```
+ Compilar :
  ```
  mvn clean install
  ```
  ![imagen](https://github.com/Juc28/AREP_LAB07/assets/118181224/2c719d62-437a-488b-8233-1be49802bdd1)

+ Luego abrir en dos consolas el laboratorio para correr las clases
  ```
  java -cp "target/classes;target/dependency/*" org.example.HelloWorld

  ```

  ```
  java -cp "target/classes;target/dependency/*" org.example.UserDatabase
  ```

  ![imagen](https://github.com/Juc28/AREP_LAB07/assets/118181224/1c8f65e7-513f-4313-b2ed-b002638a9a83)

    
# PRUEBAS 
## Local 
* Abrir en el navegador:
 ```
 https://localhost:5000/index.html
 ```
![imagen](https://github.com/Juc28/AREP_LAB07/assets/118181224/e983667f-ed20-46c0-9c70-a86b9dff0279)
* Al ingresar un usario que si existe:
  ![imagen](https://github.com/Juc28/AREP_LAB07/assets/118181224/d1ea3d62-e8cd-4db0-b600-3d34cc742818)
* Al ingresar mal la clave de un usuario que existe:
  ![imagen](https://github.com/Juc28/AREP_LAB07/assets/118181224/069f2daf-c938-490f-a412-364c02de1a9f)
* Al ingresar un que no usario que si existe:
  ![imagen](https://github.com/Juc28/AREP_LAB07/assets/118181224/d1c251ae-101d-4e4a-99ec-5ff9a97bb44b)

# AWS 
* Se entro a la mquina
* Se instalo java con el siguiente comado:
  ```
  sudo yum install java 
  ```
  ![imagen](https://github.com/Juc28/AREP_LAB07/assets/118181224/6c78d6ca-bf8e-48dc-a569-1cf5b0990eec)
* Se instalo java con el siguiente comado:
  ```
  sudo yum install git 
  ```
  ![imagen](https://github.com/Juc28/AREP_LAB07/assets/118181224/837e6798-57fa-4712-b54b-282e068f86f1)
* Se instalo java con el siguiente comado:
  ```
  sudo yum install maven 
  ```

   ![imagen](https://github.com/Juc28/AREP_LAB07/assets/118181224/1f5701b2-32cf-49fe-a8db-846e5a85b1c1)

* Se clona el repositorio en una máquina local con el siguiente comando:
  
    ```
    git clone https://github.com/Juc28/AREP_LAB07.git
    ```
* Entrar al directorio del proyecto con el siguiente comando:
    ```
    cd AREP_LAB07
    ```

  ![imagen](https://github.com/Juc28/AREP_LAB07/assets/118181224/c9223a61-7bf0-4092-bd77-0edb3bd04589)
* Compilar :
  ```
  mvn clean install
  ```

* Luego abrir en dos consolas el laboratorio para correr las clases
  ```
  java -cp "target/classes;target/dependency/*" org.example.HelloWorld

  ```

  ```
  java -cp "target/classes;target/dependency/*" org.example.UserDatabase
  ```

  ![imagen](https://github.com/Juc28/AREP_LAB07/assets/118181224/62c571e3-587b-4969-85d2-08b934076580)

 * Entrar al navegador con la url que nos dio aws que es:
   ```
   
   ```

  ![imagen](https://github.com/Juc28/AREP_LAB07/assets/118181224/3d1b5d72-80ed-4bb7-8037-77808f2f4ea6)

  ![imagen](https://github.com/Juc28/AREP_LAB07/assets/118181224/f61c78c5-b023-4e54-9b11-e50cad5603b7)






# Prueba del Despliegue: 
[VIDEO DESPLIEGUE AWS](https://youtu.be/CsM3Jy75i3k)

# Autor 
Erika Juliana Castro Romero [Juc28](https://github.com/Juc28)
