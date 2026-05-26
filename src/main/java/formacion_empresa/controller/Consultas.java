/********************************/
/*  Formación Empresa           */
/*  Clase Consultas             */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.controller;

import java.sql.*;

public class Consultas {
    
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

}
