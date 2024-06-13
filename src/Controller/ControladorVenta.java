/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ClienteDao;
import DAO.VentaDao;
import DAO.PeliculaDao;
import Model.Cliente;
import Model.Pelicula;
import Visual.Venta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author simclub01
 */
public class ControladorVenta implements ActionListener  {
    ClienteDao daoCli=new ClienteDao();
    Cliente cli= new Cliente();
    Pelicula pelicula1=null;
    Pelicula pelicula2;
    Pelicula pelicula;
    PeliculaDao daoVid= new PeliculaDao();
    VentaDao daoVen= new VentaDao();
    Venta vistaVenta=new Venta();
    
     public ControladorVenta(Venta v){
        
        this.vistaVenta=v;
        this.vistaVenta.buscarB.addActionListener(this);
        this.vistaVenta.generarB.addActionListener(this);

    }
    public void generarVenta(){
        
        
        daoVen.crear(pelicula1, cli);
        daoVid.actualizarCantidad(pelicula2);
        JOptionPane.showMessageDialog(null, "Se genero su venta de: "+pelicula1.getNombre());
    }
     
    public void validarVenta(){
        if(vistaVenta.nombretxt.getText().equals("") || vistaVenta.cantidadtxt.getText().equals("") ||vistaVenta.cctxt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese datos validos");
        }
        else if(Integer.valueOf(vistaVenta.cantidadtxt.getText())<=0){
             JOptionPane.showMessageDialog(null, "Ingrese cantidad valida");
        }else{
            String nombre=vistaVenta.nombretxt.getText();
            String categoria=(String) vistaVenta.consolatxt.getSelectedItem();
            pelicula= new Pelicula(nombre,categoria);
            pelicula1=daoVid.buscar(pelicula);
            if(pelicula1==null){
                JOptionPane.showMessageDialog(null, "Pelicula no encontrada");
            }
            else if(pelicula1.getCantidad()<Integer.valueOf(vistaVenta.cantidadtxt.getText())){
                JOptionPane.showMessageDialog(null, "No hay suficiente cantidad disponible");
            }
            else{
                int nuevaCantidad=pelicula1.getCantidad()-Integer.valueOf(vistaVenta.cantidadtxt.getText());
                pelicula2= new Pelicula(pelicula1.getNombre(),pelicula1.getCategoria(),nuevaCantidad);
                generarVenta();
            }
        }
            
        
    }
    
    
     public void buscar(){
    
  
        if(vistaVenta.cctxt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese el numero de cedula");
        
        }else{
         long cc= Long.parseLong(vistaVenta.cctxt.getText()); 
        cli.setCedula(cc);
        daoCli.buscar(cli);
        vistaVenta.cctxt.setText(String.valueOf(cli.getCedula()));
       
        
        }
    }
     
     
     
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vistaVenta.buscarB){
            buscar(); 
        }
        if(e.getSource()==vistaVenta.generarB){
            validarVenta(); 
        }
    }
    
    
    
    
}
