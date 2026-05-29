/********************************/
/*  Formación Empresa           */
/*  Funciones CRUD inquilino    */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.controller;

import java.sql.*;

import formacion_empresa.model.Inquilino;

public class CRUDinquilino {
    
    public static Inquilino consultar(Connection con, int id) {
        try {
            String sql = "CALL sp_get_inquilino(?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, id);

            cs.execute();
            ResultSet rs = cs.getResultSet();
            rs.next();
            Inquilino i = new Inquilino(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));

            int err = cs.getInt(2);

            if (err == -1) {
                throw new SQLException();
            }
            else if (err == -2) {
                i.setId(-2);
            }

            return i;
        }
        catch (SQLException e) {
            return null;
        } 
    }

}
