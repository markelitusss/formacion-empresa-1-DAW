/********************************/
/*  Formación Empresa           */
/*  Clase Conexion              */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.controller;

import java.sql.*;

public class Conexion {

    private static final String url = System.getenv("DB_URL");
    private static final String user = System.getenv("DB_USER");
    private static final String password = System.getenv("DB_PASSWORD");
    
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

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

}
