/********************************/
/*  Formación Empresa           */
/*  Clase Conexion              */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.controller;

import java.sql.*;

/**
 * @author Markel Canales Ramos
 */
public class Conexion {

    private static final String url = System.getenv("DB_URL");
    private static final String user = System.getenv("DB_USER");
    private static final String password = System.getenv("DB_PASSWORD");
    
    /**
     * Función que devuelve una conexión abierta a una base de datos MySQL
     * @param url La URL utilizada por JDBC para realizar la conexión
     * @param user El usuario que accede a la base de datos
     * @param pass La contraseña del usuario que accede a la base de datos
     * @return Un objeto Connection con una conexión abierta
     */
    public static Connection getConexion(String url, String user, String pass) {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el Driver JDBC.");
        } 
        catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }

        return con;
    }

    /**
     * Devuelve la URL utilizada por JDBC para la conexión
     * @return Un String que contiene la URL para conectarse a una BD
     */
    public static String getUrl() {
        return url;
    }

    /**
     * Devuelve el usuario utilizado para la conexión
     * @return Un String que contiene el usuario para conectarse a una BD
     */
    public static String getUser() {
        return user;
    }

    /**
     * Devuelve la contraseña utilizada por el usuario para la conexión
     * @return Un String que contiene la contraseña para el usuario que se conecta a la BD
     */
    public static String getPassword() {
        return password;
    }

}
