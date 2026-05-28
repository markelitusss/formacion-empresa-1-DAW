/********************************/
/*  Formación Empresa           */
/*  Funciones CRUD vivienda     */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.controller;

import java.sql.*;

public class CRUDvivienda {
    
    public static ResultSet consultar(Connection con, String codigo) {
        try {
            String sql = "CALL sp_get_vivienda(?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, codigo);

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
