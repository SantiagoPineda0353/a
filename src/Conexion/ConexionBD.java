/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBD {

    
       //SE UTILIZA UN CONSTRUCTOR PRIVADO PARA ASEGURAR LA IMPLEMENTACION DEL PATRON SINGLETON
    private ConexionBD() {
        
        
    }
    
    //SE GUARDA EL ESTADO DE LA CONEXION A LA BD
    private static Connection conexion;
    
    //LA VARIABLE QUE SE INSTANCIA SOLO UNA VEZ (SINGLETON)
    private static ConexionBD instancia;
    
    private static final String URL = "jdbc:mysql://localhost:3306/tienda"; 
    private static final String USERNAME = "root"; 
     private static final String PASSWORD = "";
    
    public Connection conectar(){
         try{
             
             Class.forName("com.mysql.cj.jdbc.Driver");
             conexion= DriverManager.getConnection(URL,USERNAME,PASSWORD);
             
             return conexion;
         }catch(ClassNotFoundException | SQLException e){
             System.out.println(e);
         }
        return conexion;
    }
    
    
    //PATRON DE DISEÑO SINGLETON
    
    public static ConexionBD getInstance(){
        if(instancia == null){
            instancia = new ConexionBD();
        }
        return instancia;
    
    }

}
