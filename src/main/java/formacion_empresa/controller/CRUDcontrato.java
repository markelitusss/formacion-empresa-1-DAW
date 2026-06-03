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

    public static int insertar(Connection con, Contrato c) {
        try {
            String sql = "CALL sp_ins_contrato(?, ?, ?, ?, ?, ?, ?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, c.getId_inquilino());
            cs.setString(2, c.getCodigo_vivienda());
            cs.setString(3, c.getFecha_inicio());
            cs.setString(4, c.getFecha_fin());
            cs.setDouble(5, c.getPrecio());
            cs.setString(6, c.getEstado());

            cs.execute();
            int id = cs.getInt(7);
            int err = cs.getInt(8);

            if (err == -1) {
                throw new SQLException();
            }
            else if (err == -3) {
                throw new IndexOutOfBoundsException();
            }
            else if (err == -4) {
                throw new IllegalArgumentException();
            }

            return id;
        }
        catch (SQLException e) {
            return -1;
        }
        catch (IndexOutOfBoundsException e) {
            return -3;
        }
        catch (IllegalArgumentException e) {
            return -4;
        }

    }

    public static int actualizar(Connection con, Contrato c) {
        try {
            String sql = "CALL sp_upd_contrato(?, ?, ?, ?, ?, ?, ?, ?)";
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, c.getId());
            cs.setInt(2, c.getId_inquilino());
            cs.setString(3, c.getCodigo_vivienda());
            cs.setString(4, c.getFecha_inicio());
            cs.setString(5, c.getFecha_fin());
            cs.setDouble(6, c.getPrecio());
            cs.setString(7, c.getEstado());

            cs.execute();
            int err = cs.getInt(8);

            if (err == -1) {
                throw new SQLException();
            }
            else if (err == -2) {
                throw new NullPointerException();
            }
            else if (err == -3) {
                throw new IndexOutOfBoundsException();
            }
            else if (err == -4) {
                throw new IllegalArgumentException();
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
        catch (IllegalArgumentException e) {
            return -4;
        }
        
    }

    public static int eliminar(Connection con, int id) {
        try {
            String sql = "CALL sp_del_contrato(?, ?)";
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
