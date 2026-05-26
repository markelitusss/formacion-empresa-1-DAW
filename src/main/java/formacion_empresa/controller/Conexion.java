/********************************/
/*  Formación Empresa           */
/*  Clase Conexion              */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.controller;

import java.sql.*;

public class Conexion {
    
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

}
