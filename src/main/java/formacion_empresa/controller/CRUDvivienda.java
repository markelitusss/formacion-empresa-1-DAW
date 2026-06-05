/********************************/
/*  Formación Empresa           */
/*  Funciones CRUD vivienda     */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.controller;

import java.sql.*;

import formacion_empresa.model.Vivienda;

/**
 * @author Markel Canales Ramos
 */
public class CRUDvivienda {
    
    /**
     * Method that executes the select procedure
     * @param con Connection to the DB
     * @param codigo The code of the house to select on
     * @return A Vivienda object with the data of the selected house. The landlord's ID of the object will be -2 in case the selected house doesn't exist 
     * @throws SQLException In case an SQL error occurs
     */
    public static Vivienda consultar(Connection con, String codigo) {
        try {
            String sql = "CALL sp_get_vivienda(?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, codigo);

            // primero obtenemos todos los datos menos el tipo y luego lo obtenemos mediante una consulta propia
            cs.execute();
            ResultSet rs = cs.getResultSet();
            rs.next();
            ResultSet rsTipo = Consultas.consultarCustom(con, "SELECT tipo FROM tipo_vivienda WHERE id = " + rs.getInt(7));
            rsTipo.next();

            // montamos el objeto Vivienda a devolver
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

    /**
     * Method that executes the insert procedure
     * @param con Connection to the DB
     * @param v A Vivienda object with the data of the house to insert
     * @return 0 if no errors occur
     * @throws SQLException If any SQL error occurs, the method will return -1
     * @throws IndexOutOfBoundsException If the house has a reference to a landlord that doesn't exist, the method will return -3
     */
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

    /**
     * Method that executes the update procedure
     * @param con Connection to the DB
     * @param v A Vivienda object with the data of the house to update
     * @return 0 if no errors occur
     * @throws SQLException If any SQL error occurs, the method will return -1
     * @throws NullPointerException If the house's code doesn't exist in the DB, the method will return -2
     * @throws IndexOutOfBoundsException If the new house has a reference to a landlord that doesn't exist, the method will return -3
     */
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

    /**
     * Method that executes the delete procedure
     * @param con Connection to the DB
     * @param codigo The ID of the house to delete
     * @return 0 if no errors occur
     * @throws SQLException If any SQL error occurs, the method will return -1
     * @throws NullPointerException If the house's code doesn't exist in the DB, the method will return -2
     */
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
