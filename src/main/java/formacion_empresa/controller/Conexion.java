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
     * Method that returns an open connection to a DB
     * @param url The URL used by JDBC to connect to the DB
     * @param user The username of the user that has access to the DB
     * @param pass The password of the user that has access to the DB
     * @return A Connection object with an open connection
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
     * Returns the URL used by JDBC for the connection
     * @return A String that contains the URL to connect to the DB
     */
    public static String getUrl() {
        return url;
    }

    /**
     * Returns the username used in the connection
     * @return A String that contains the username used to connect to the DB
     */
    public static String getUser() {
        return user;
    }

    /**
     * Returns the password used in the connection
     * @return A String that contains the password used to connect to the DB
     */
    public static String getPassword() {
        return password;
    }

}
