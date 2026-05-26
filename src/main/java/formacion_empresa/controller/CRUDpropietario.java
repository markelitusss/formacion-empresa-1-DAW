/********************************/
/*  Formación Empresa           */
/*  Funciones CRUD propietario  */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.controller;

import java.sql.*;

public class CRUDpropietario {
    
    public static ResultSet consultar(Connection con, int id) {
        try {
            String sql = "CALL sp_get_propietario(?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, id);

            cs.execute();
            int err = cs.getInt(2);
            if (err == 1) {
                throw new SQLException();
            }
            else if (err == 2) {
                String errSql = "SELECT @err";
                PreparedStatement ps = con.prepareStatement(errSql);
                ResultSet rs = ps.executeQuery();
                return rs;
            }
            else {
                ResultSet rs = cs.getResultSet();
                return rs;
            }
            
        }
        catch (SQLException e) {
            return null;
        } 
    }

}
