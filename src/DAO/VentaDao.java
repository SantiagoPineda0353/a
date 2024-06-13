/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Model.Cliente;
import Model.Pelicula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author simclub01
 */
public class VentaDao implements DaoInterfaceVenta{
     ConexionBD conexion = ConexionBD.getInstance();
    @Override
    public void crear(Pelicula pelicula, Cliente cliente) {
         String sql="INSERT INTO venta(cedula,idPelicula) values (?,?)";
      try{
            Connection conectar = conexion.conectar();
            PreparedStatement insertar = conectar.prepareStatement(sql);
            insertar.setInt(1, (int) cliente.getCedula());
            insertar.setInt(2,pelicula.getIdPelicula());
            insertar.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Error al agegar Pelicula"+e);
        }
    }
    
}
