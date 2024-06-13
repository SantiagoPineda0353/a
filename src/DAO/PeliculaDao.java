/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Model.Pelicula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author simclub01
 */
public class PeliculaDao implements DaoInterfacePelicula {
    ConexionBD conexion = ConexionBD.getInstance();
     ResultSet rs=null;
     
     
     
    @Override
    public void actualizar(Pelicula pelicula) {
        String sql = "update pelicula set cantidad = ?, precio = ? where idPelicula = ?";
       
        try{
            Connection conectar = conexion.conectar();
            PreparedStatement insertar = conectar.prepareStatement(sql);
            insertar.setInt(1,pelicula.getCantidad());
            insertar.setInt(2,pelicula.getPrecio());
            insertar.setInt(3,pelicula.getIdPelicula());
            insertar.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Error al actualizar Pelicula"+e);
        }
        }

    @Override
    public void crear(Pelicula pelicula) {
        String sql="INSERT INTO pelicula(nombre,categoria,cantidad,precio) values (?,?,?,?)";
      try{
            Connection conectar = conexion.conectar();
            PreparedStatement insertar = conectar.prepareStatement(sql);
            insertar.setString(1,pelicula.getNombre());
            insertar.setString(2,pelicula.getCategoria());
            insertar.setInt(3,pelicula.getCantidad());
            insertar.setInt(4,pelicula.getPrecio());
            insertar.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Error al agegar pelicula"+e);
        }
    }
    @Override
    public void eleminar(int idPelicula) {
          String sql = "delete from pelicula where idPelicula = ?";
        try{
            Connection conectar = conexion.conectar();
            PreparedStatement insertar = conectar.prepareStatement(sql);
             insertar.setString(1, idPelicula + "");
            insertar.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Error al eliminar Pelicula"+e);
        }
    }

    @Override
    public Pelicula buscar(Pelicula pelicula) {
        Pelicula peliculaso=null;
        String sql = "Select* from pelicula where nombre = ? AND categoria = ? ";
         try{
            Connection conectar = conexion.conectar();
            PreparedStatement insertar = conectar.prepareStatement(sql);
             insertar.setString(1, pelicula.getNombre()+ "");
             insertar.setString(2, pelicula.getCategoria()+ "");
             rs=insertar.executeQuery();
                if (rs.next()){
                peliculaso = new Pelicula(
                   rs.getInt("idPelicula"),
                   rs.getString("nombre"),
                   rs.getString("categoria"),
                   rs.getInt("cantidad"),
                   rs.getInt("precio"));
            }
            
            rs.close();
            conectar.close();
            
        }catch(SQLException e){
            System.out.println("Error al buscar Pelicula"+e);
        }
        
        return peliculaso;
    }
    
   

    @Override
    public ArrayList<Pelicula> buscarTodo() {
        ArrayList<Pelicula> lista = new ArrayList<>();
         String sql = "Select* from pelicula ";
       try {
           
           Connection conectar = conexion.conectar();
           PreparedStatement insertar = conectar.prepareStatement(sql);
            ResultSet resultSet;
            rs = insertar.executeQuery(sql);
        
            while (rs.next()) {
                 Pelicula videojuego = new Pelicula(
                   rs.getInt("idPelicula"),
                   rs.getString("nombre"),
                   rs.getString("categoria"),
                   rs.getInt("cantidad"),
                   rs.getInt("precio"));
                lista.add(videojuego);
            }
            
            rs.close();
            conectar.close();
    
          
        } catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
        return lista;
    }

    /*@Override
    public int disponibilidad(Pelicula videojuego) {
         Pelicula videojuego1=null;
        String sql = "Select * from videojuego where nombre = ? AND consola = ? AND cantidad>=? ";
         try{
            Connection conectar = conexion.conectar();
            PreparedStatement insertar = conectar.prepareStatement(sql);
             insertar.setString(1, videojuego.getNombre()+ "");
             insertar.setString(2, videojuego.getConsola()+ "");
             rs=insertar.executeQuery();
                if (rs.next()){
                videojuego1 = new Pelicula(
                   rs.getInt("idVideojuego"),
                   rs.getString("nombre"),
                   rs.getString("consola"),
                   rs.getInt("cantidad"),
                   rs.getInt("precio"));
            }
            
            rs.close();
            conectar.close();
            
        }catch(SQLException e){
            System.out.println("Error al buscar Pelicula"+e);
        }
        
        return videojuego1.getCantidad();
    }*/

    @Override
    public void actualizarCantidad(Pelicula pelicula) {
        String sql = "update pelicula set cantidad = ?  where nombre = ? AND categoria = ? ";
       
        try{
            Connection conectar = conexion.conectar();
            PreparedStatement insertar = conectar.prepareStatement(sql);
            insertar.setInt(1,pelicula.getCantidad());
            insertar.setString(2,pelicula.getNombre());
            insertar.setString(3,pelicula.getCategoria());
            insertar.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Error al actualizar Pelicula"+e);
        }
    }
    
}
