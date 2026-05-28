/********************************/
/*  Formación Empresa           */
/*  Funciones CRUD inquilino    */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.controller;

import java.sql.*;

public class CRUDinquilino {
    
    public static ResultSet consultar(Connection con, int id) {
        try {
            String sql = "CALL sp_get_inquilino(?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, id);

            cs.execute();
            ResultSet rs = cs.getResultSet();
            int err = cs.getInt(2);

            if (err == -1) {
                throw new SQLException();
            }
            else if (err == -2) {
                while (rs.next()) {
                    rs.deleteRow();
                }
                
                rs.moveToInsertRow();
                rs.updateInt(1, err);
                rs.insertRow();
                
                return rs;
            }
            else {
                return rs;
            }
            
        }
        catch (SQLException e) {
            return null;
        } 
    }

}
