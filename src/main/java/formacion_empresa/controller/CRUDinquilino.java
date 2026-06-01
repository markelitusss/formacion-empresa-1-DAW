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

    public static int insertar(Connection con, Inquilino i) {
        try {
            String sql = "CALL sp_ins_inquilino(?, ?, ?, ?, ?, ?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, i.getDNI());
            cs.setString(2, i.getNombre());
            cs.setString(3, i.getEmail());
            cs.setString(4, i.getTelefono());
            cs.setBoolean(5, i.getMascota());

            cs.execute();
            int id = cs.getInt(6);
            int err = cs.getInt(7);

            if (err == -1) {
                throw new SQLException();
            }

            return id;
        }
        catch (SQLException e) {
            return -1;
        }
    }

    public static int actualizar(Connection con, Inquilino i) {
        try {
            String sql = "CALL sp_upd_inquilino(?, ?, ?, ?, ?, ?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, i.getId());
            cs.setString(2, i.getDNI());
            cs.setString(3, i.getNombre());
            cs.setString(4, i.getEmail());
            cs.setString(5, i.getTelefono());
            cs.setBoolean(6, i.getMascota());

            cs.execute();
            int err = cs.getInt(7);

            if (err == -1) {
                throw new SQLException();
            }
            else if (err == -2) {
                throw new NullPointerException();
            }

            return 0;
        }
        catch (SQLException e) {
            return -1;
        }
        catch (NullPointerException e) {
            return -2;
        }
    }

    public static int eliminar(Connection con, int id) {
        try {
            String sql = "CALL sp_del_inquilino(?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, id);

            cs.execute();
            int err = cs.getInt(2);

            if (err == -1) {
                throw new SQLException();
            }
            else if (err == -2) {
                throw new NullPointerException();
            }

            return 0;
        }
        catch (SQLException e) {
            return -1;
        }
        catch (NullPointerException e) {
            return -2;
        }
    }

}
