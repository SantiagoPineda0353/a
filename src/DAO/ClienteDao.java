/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

//import Conexion.ConexionBD;
import Conexion.ConexionBD;
import Model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author simclub01
 */
public class ClienteDao implements DaoInterfaceCliente{
 
    ConexionBD conexion = ConexionBD.getInstance();
    ResultSet rs=null;
    
   /* @Override
    public void actualizar(Cliente cliente) {
        
       
    }
*/
    @Override
    public void crear(Cliente cliente) {
       
        
        try{
            Connection conectar = conexion.conectar();
            PreparedStatement insertar = conectar.prepareStatement("insert into cliente values (?,?,?,?)");
            
            
            ResultSet probar = insertar.executeQuery("select * from cliente where cedula like '"+cliente.getCedula()+"'");
            
            if(probar.next()){
                JOptionPane.showMessageDialog(null, "Cliente ya registrado");
               
            }else{
            insertar.setLong(1,cliente.getCedula());
            insertar.setString(2,cliente.getNombre());
            insertar.setString(3,cliente.getCorreoElectronico());
            insertar.setLong(4,cliente.getTelefono());
            insertar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
           
            }
            
           
            
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
        
       
    }

    @Override
    public void buscar(Cliente cliente) {
        try{
            Connection conectar = conexion.conectar();
            PreparedStatement buscar = conectar.prepareStatement("select * from cliente where cedula= ?");
            buscar.setLong(1, cliente.getCedula());
            ResultSet consulta = buscar.executeQuery();
            
            if(consulta.next()){
              cliente.setCedula(Long.parseLong(consulta.getString("Cedula")));
              cliente.setNombre(consulta.getString("Nombre"));
              cliente.setCorreoElectronico(consulta.getString("correoElectronico"));
              cliente.setTelefono(Long.parseLong(consulta.getString("telefono")));
              JOptionPane.showMessageDialog(null, "Registro encontrado");
            }else{
                
                JOptionPane.showMessageDialog(null, "No se encuentra registrado");
            }
            
            
        }catch(SQLException e){
        
        }
    }
  
    @Override
    public ArrayList<Cliente> MostrarTodo() {
            ArrayList<Cliente> lista1 = new ArrayList<>();
             String sql = "Select * from cliente";
           try {

               Connection conectar = conexion.conectar();
               PreparedStatement insertar = conectar.prepareStatement(sql);
                ResultSet resultSet;
                rs = insertar.executeQuery(sql);

                while (rs.next()) {
                     Cliente cliente1 = new Cliente(
                       rs.getString("nombre"),
                       rs.getString("correoElectronico"),
                       rs.getLong("cedula"),
                       rs.getLong("telefono"));
                    lista1.add(cliente1);
                }

                rs.close();
                conectar.close();


            } catch(SQLException ex){
                System.out.println("Error" + ex.getMessage());
            }
            return lista1;
        }
    
    
    
    


    @Override
    public void eliminar(Long cedula) {
        String sql="delete from cliente where cedula ="+cedula;
        try{
            Connection conectar = conexion.conectar();
               PreparedStatement borrar = conectar.prepareStatement(sql);        
                borrar.executeUpdate();
            
        }catch(Exception e){
        
        }
    }

    
    
      
    
    
   
}
