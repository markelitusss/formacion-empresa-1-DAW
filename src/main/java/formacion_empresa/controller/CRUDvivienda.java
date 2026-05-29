/********************************/
/*  Formación Empresa           */
/*  Funciones CRUD vivienda     */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.controller;

import java.sql.*;

import formacion_empresa.model.Vivienda;

public class CRUDvivienda {
    
    public static Vivienda consultar(Connection con, String codigo) {
        try {
            String sql = "CALL sp_get_vivienda(?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, codigo);

            cs.execute();
            ResultSet rs = cs.getResultSet();
            rs.next();
            ResultSet rsTipo = Consultas.consultarCustom(con, "SELECT tipo FROM tipo_vivienda WHERE id = " + rs.getInt(7));
            rsTipo.next();

            Vivienda v = new Vivienda(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6), rsTipo.getString(1), rs.getBoolean(8));

            int err = cs.getInt(2);

            if (err == -1) {
                throw new SQLException();
            }
            else if (err == -2) {
                v.setId_propietario(-2);
            }
            
            return v;
        }
        catch (SQLException e) {
            return null;
        } 
    }

}
