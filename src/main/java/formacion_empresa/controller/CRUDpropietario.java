/********************************/
/*  Formación Empresa           */
/*  Funciones CRUD propietario  */
/*  Markel Canales Ramos 1º DAW */
/********************************/

package formacion_empresa.controller;

import java.sql.*;

import formacion_empresa.model.Propietario;

/**
 * @author Markel Canales Ramos
 */
public class CRUDpropietario {
    
    /**
     * Method that executes the select procedure
     * @param con Connection to the DB
     * @param id The ID of the landlord to select on
     * @return A Propietario object with the data of the selected landlord. The ID of the object will be -2 in case the selected landlord doesn't exist 
     * @throws SQLException In case an SQL error occurs
     */
    public static Propietario consultar(Connection con, int id) {
        try {
            String sql = "CALL sp_get_propietario(?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, id);

            cs.execute();
            ResultSet rs = cs.getResultSet();
            rs.next();
            Propietario p = new Propietario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

            int err = cs.getInt(2);

            if (err == -1) {
                throw new SQLException();
            }
            else if (err == -2) {
                p.setId(-2);
            }
            
            return p;
        }
        catch (SQLException e) {
            return null;
        } 
    }

    /**
     * Method that executes the insert procedure
     * @param con Connection to the DB
     * @param p A Propietario object with the data of the landlord to insert
     * @return The ID of the inserted landlord if no errors occur
     * @throws SQLException If any SQL error occurs, the method will return -1
     */
    public static int insertar(Connection con, Propietario p) {
        try {
            String sql = "CALL sp_ins_propietario(?, ?, ?, ?, ?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, p.getDNI());
            cs.setString(2, p.getNombre());
            cs.setString(3, p.getEmail());
            cs.setString(4, p.getTelefono());

            cs.execute();
            int id = cs.getInt(5);
            int err = cs.getInt(6);

            if (err == -1) {
                throw new SQLException();
            }

            return id;
        }
        catch (SQLException e) {
            return -1;
        }
    }

    /**
     * Method that executes the update procedure
     * @param con Connection to the DB
     * @param p A Propietario object with the data of the landlord to update
     * @return 0 if no errors occur
     * @throws SQLException If any SQL error occurs, the method will return -1
     * @throws NullPointerException If the landlord's ID doesn't exist in the DB, the method will return -2
     */
    public static int actualizar(Connection con, Propietario p) {
        try {
            String sql = "CALL sp_upd_propietario(?, ?, ?, ?, ?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, p.getId());
            cs.setString(2, p.getDNI());
            cs.setString(3, p.getNombre());
            cs.setString(4, p.getEmail());
            cs.setString(5, p.getTelefono());

            cs.execute();
            int err = cs.getInt(6);

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

    /**
     * Method that executes the delete procedure
     * @param con Connection to the DB
     * @param id The ID of the landlord to delete
     * @return 0 if no errors occur
     * @throws SQLException If any SQL error occurs, the method will return -1
     * @throws NullPointerException If the landlord's ID doesn't exist in the DB, the method will return -2
     */
    public static int eliminar(Connection con, int id) {
        try {
            String sql = "CALL sp_del_propietario(?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, id);

            cs.execute();
            int err = cs.getInt(2);

            if (err == .1) {
                throw new SQLException();
            }
            else if (err == -2) {
                return -2;
            }

            return 0;
        }
        catch (SQLException e) {
            return -1;
        }
    }

}
