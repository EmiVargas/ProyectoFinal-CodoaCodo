package data;

import static data.Conexion.*;
import java.sql.*;
import java.util.*;
import model.Tienda;

public class CelularesDAO {
    private static final String SQL_CREATE="INSERT INTO celulares(modelo, marca, memoria, precio, stock) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_READ="SELECT * FROM celulares";
    private static final String SQL_READ_BY_ID= "SELECT * FROM celulares WHERE idcelulares= ?";
    private static final String SQL_UPDATE_PRECIO="UPDATE celulares SET precio = ? WHERE idcelulares = ?";
    private static final String SQL_UPDATE_STOCK="UPDATE celulares SET stock = ? WHERE idcelulares = ?";
     private static final String SQL_UPDATE="UPDATE celulares SET modelo = ?, marca = ?, memoria = ?, precio = ?,stock = ? WHERE idcelulares = ?";
    private static final String SQL_DELETE="DELETE FROM celulares WHERE idcelulares = ?";
    
    
    public List<Tienda> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tienda celular ;
        List<Tienda> celulares = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int idcelulares = rs.getInt(1);
                String modelo = rs.getString(2);
                String marca = rs.getString(3);
                int memoria = rs.getInt(4);
                double precio = rs.getDouble(5);
                int stock = rs.getInt(6);

                celular = new Tienda(idcelulares, modelo, marca,memoria,precio,stock);

                celulares.add(celular);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return celulares;
    }
    
    public Tienda findById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tienda celular = null;
        
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ_BY_ID);
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                 int idcelulares = rs.getInt(1);
                String modelo = rs.getString(2);
                String marca = rs.getString(3);
                int memoria = rs.getInt(4);
                double precio = rs.getDouble(5);
                int stock = rs.getInt(6);
                
                celular = new Tienda(idcelulares, modelo, marca,memoria,precio,stock);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return celular;
    }
    
    
    
    public int insert(Tienda celular){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1, celular.getModelo());
            stmt.setString(2, celular.getMarca());
            stmt.setInt(3, celular.getMemoria());
            stmt.setDouble(4, celular.getPrecio());
            stmt.setInt(5, celular.getStock());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int updatePrecio(Tienda celular){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_PRECIO);
            stmt.setDouble(1, celular.getPrecio());
            stmt.setInt(2, celular.getIdcelular());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int updateStock(Tienda celular){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_STOCK);
            stmt.setInt(1, celular.getStock());
            stmt.setInt(2, celular.getIdcelular());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
     public int update(Tienda celular){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, celular.getModelo());
            stmt.setString(2, celular.getMarca());
            stmt.setInt(3, celular.getMemoria());
            stmt.setDouble(4, celular.getPrecio());
            stmt.setInt(5, celular.getStock());
            stmt.setInt(6, celular.getIdcelular());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    
    public int deleteCelular(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
