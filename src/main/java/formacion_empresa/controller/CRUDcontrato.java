package formacion_empresa.controller;

import java.sql.*;

import formacion_empresa.model.Contrato;

public class CRUDcontrato {
    
    public static Contrato consultar(Connection con, int id) {
        try {
            String sql = "CALL sp_get_contrato(?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, id);

            cs.execute();
            ResultSet rs = cs.getResultSet();
            rs.next();
            ResultSet rsEstado = Consultas.consultarCustom(con, "SELECT estado FROM tipo_estado WHERE id = " + rs.getInt(7));
            rsEstado.next();

            Contrato c = new Contrato(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rsEstado.getString(1));

            int err = cs.getInt(2);

            if (err == -1) {
                throw new SQLException();
            }
            else if (err == -2) {
                c.setId(-2);
            }
            
            return c;
        }
        catch (SQLException e) {
            return null;
        }
    }

}
