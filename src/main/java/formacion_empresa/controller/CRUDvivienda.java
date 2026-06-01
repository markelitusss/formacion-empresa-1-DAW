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

    public static int insertar(Connection con, Vivienda v) {
        try {
            String sql = "CALL sp_ins_vivienda(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, v.getCodigo());
            cs.setInt(2, v.getId_propietario());
            cs.setString(3, v.getDireccion());
            cs.setDouble(4, v.getPrecio());
            cs.setInt(5, v.getSuperficie());
            cs.setString(6, v.getDescripcion());
            cs.setString(7, v.getTipo());
            cs.setBoolean(8, v.isAcepta_mascota());

            cs.execute();
            int err = cs.getInt(9);

            if (err == -1) {
                throw new SQLException();
            }
            else if (err == -3) {
                throw new IndexOutOfBoundsException();
            }

            return 0;
        }
        catch (SQLException e) {
            return -1;
        }
        catch (IndexOutOfBoundsException e) {
            return -3;
        }
    }

    public static int actualizar(Connection con, Vivienda v) {
        try {
            String sql = "CALL sp_upd_vivienda(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, v.getCodigo());
            cs.setInt(2, v.getId_propietario());
            cs.setString(3, v.getDireccion());
            cs.setDouble(4, v.getPrecio());
            cs.setInt(5, v.getSuperficie());
            cs.setString(6, v.getDescripcion());
            cs.setString(7, v.getTipo());
            cs.setBoolean(8, v.isAcepta_mascota());

            cs.execute();
            int err = cs.getInt(9);

            if (err == -1) {
                throw new SQLException();
            }
            else if (err == -2) {
                throw new NullPointerException();
            }
            else if (err == -3) {
                throw new IndexOutOfBoundsException();
            }

            return 0;
        }
        catch (SQLException e) {
            return -1;
        }
        catch (NullPointerException e) {
            return -2;
        }
        catch (IndexOutOfBoundsException e) {
            return -3;
        }
    }

    public static int eliminar(Connection con, String codigo) {
        try {
            String sql = "CALL sp_del_vivienda(?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, codigo);

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
