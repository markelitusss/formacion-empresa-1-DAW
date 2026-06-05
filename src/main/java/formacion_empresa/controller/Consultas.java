/********************************/
/*  Formación Empresa           */
/*  Clase Consultas             */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.controller;

import java.io.PrintWriter;
import java.sql.*;

/**
 * @author Markel Canales Ramos
 */
public class Consultas {
    
    /**
     * Method that executes a query on a full table of the DB
     * @param con Connection to the DB
     * @param tabla The table's name used in the query
     * @return A ResultSet with the query's results
     * @throws SQLException If there is an SQL error during the query
     */
    public static ResultSet consultarTodo(Connection con, String tabla) {
        try {
            String sql = "SELECT * FROM " + tabla;

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            return rs;
        }
        catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that executes the query specified in the "sql" parameter
     * @param con Connection to the DB
     * @param sql A valid SQL query
     * @return A ResultSet with the query's results
     * @throws SQLException If there is an SQL error during the query
     */
    public static ResultSet consultarCustom(Connection con, String sql) {
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            return rs;
        }
        catch (SQLException e) {
            return null;
        }
    }

    /**
     * Method that exports a complete table to CSV format
     * @param con Connection to the DB
     * @param tabla The name of the table to export
     * @return 0 if the export is done correctly
     * @throws Exception If any error occurs during the export the method returns -1
     */
    public static int exportar(Connection con, String tabla) {
        try (PrintWriter pw = new PrintWriter(tabla + ".csv")) {
            ResultSet rs = consultarTodo(con, tabla);

            while (rs.next()) {
                switch (tabla) {
                    case "propietario" -> 
                        pw.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4) + ", " + rs.getString(5));
                    case "inquilino" ->
                        pw.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4) + ", " + rs.getString(5) + ", " + rs.getBoolean(6));
                    case "vivienda" ->
                        pw.println(rs.getString(1) + ", " + rs.getInt(2) + ", " + rs.getString(3) + ", " + rs.getDouble(4) + ", " + rs.getInt(5) + ", " + rs.getString(6) + ", " + rs.getString(7) + ", " + rs.getBoolean(8));
                    case "contrata" ->
                        pw.println(rs.getInt(1) + ", " + rs.getInt(2) + ", " + rs.getString(3) + ", " + rs.getString(4) + ", " + rs.getString(5) + ", " + rs.getDouble(6) + ", " + rs.getString(7));
                }
                
            }

            pw.close();
            return 0;
        }
        catch (Exception e) {
            return -1;
        }
    }

}
