/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.PeliculaDao;
import Model.Pelicula;
import Visual.ActualizarPelicula;
import Visual.AgregarInventario;
import Visual.BuscarInventario;
import Visual.Inventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author simclub01
 */
public class ControladorPelicula implements ActionListener {
    Pelicula pelicula1=null;
    Pelicula pelicula;
    PeliculaDao dao= new PeliculaDao();
    Inventario vistaInventario=new Inventario();
    DefaultTableModel modelo=new DefaultTableModel();
    AgregarInventario vistaAgregar=new AgregarInventario();
    BuscarInventario vistaBuscar=new BuscarInventario();
    ActualizarPelicula vistaActualizar=new ActualizarPelicula(0);
    
    public ControladorPelicula(Inventario v){
        
        this.vistaInventario=v;
        this.vistaInventario.botonEliminar.addActionListener(this);
        mostrarTabla(vistaInventario.tablaInventario);
    }
    
    public ControladorPelicula(AgregarInventario v){
        
        this.vistaAgregar=v;
        this.vistaAgregar.bAgregar.addActionListener(this);
    }
    
    public ControladorPelicula(BuscarInventario v){
        
        this.vistaBuscar=v;
        this.vistaBuscar.buscarb.addActionListener(this);
        this.vistaBuscar.bActualizar.addActionListener(this);
    }
    
    public ControladorPelicula(ActualizarPelicula v){
        
        this.vistaActualizar=v;
        this.vistaActualizar.actualizarb.addActionListener(this);
        
    }
    
    
    public void eliminar(){
        int fila=vistaInventario.tablaInventario.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(null, "Primero debe seleccionar la pelicula que quiere eliminar");
        }else{
          int id=Integer.parseInt((String)vistaInventario.tablaInventario.getValueAt(fila, 0).toString());
          int respuesta= JOptionPane.showConfirmDialog(null, "¿Esta seguro de elimiar la pelicula?", "Eliminar", JOptionPane.YES_NO_OPTION);
              if(respuesta==JOptionPane.YES_OPTION){
                  dao.eleminar(id);
                  JOptionPane.showMessageDialog(null, "Se elimino la pelicula seleccionado");
                }  
        }
      
  
        
    }
    
    public void limpiarTabla(){
        for(int i=0;i<vistaInventario.tablaInventario.getRowCount();i++){
            modelo.removeRow(i);
            i=i-1;
        }
    }  
    public void mostrarTabla(JTable tabla) {
        modelo=(DefaultTableModel)tabla.getModel();
        ArrayList<Pelicula>lista=dao.buscarTodo();
        Object[]object= new Object[5];
        for(int i=0;i<lista.size();i++){
            object[0]=lista.get(i).getIdPelicula();
            object[1]=lista.get(i).getCategoria();
            object[2]=lista.get(i).getNombre();
            object[3]=lista.get(i).getCantidad();
            object[4]=lista.get(i).getPrecio();
            modelo.addRow(object);
        }
        vistaInventario.tablaInventario.setModel(modelo);
    }
    public void agregar(){
        String nombre=vistaAgregar.nombretxt.getText();
        String categoria=(String) vistaAgregar.consolatxt.getSelectedItem();
        int cantidad=Integer.valueOf(vistaAgregar.cantidadtxt.getText());
        int precio=Integer.valueOf(vistaAgregar.preciotxt.getText());
   
        
        Pelicula pelicula = new Pelicula(nombre,categoria,cantidad,precio);
                   
                  
        dao.crear(pelicula);
        JOptionPane.showMessageDialog(null, "Registro exitoso");
        
        vistaAgregar.nombretxt.setText("");
        vistaAgregar.cantidadtxt.setText("");
        vistaAgregar.preciotxt.setText("");
        
    }
    
     public void buscar(){
        
        String nombre=vistaBuscar.nombretxt.getText();
        String categoria=(String) vistaBuscar.consolatxt.getSelectedItem();
        
        if(vistaBuscar.nombretxt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la pelicula");
        
        }else{
   
        
        Pelicula pelicula = new Pelicula(nombre,categoria);
                   
                  
        pelicula1=dao.buscar(pelicula);
        
       
        if(pelicula1==null){
           JOptionPane.showMessageDialog(null, "No se encontro ninguno pelicula");
        }else {
            
        vistaBuscar.videojuegotxt.setText(pelicula1.getNombre()+" "+ pelicula1.getCategoria()+
                " "+ pelicula1.getPrecio()+
                " "+pelicula1.getCantidad()
        
        );
        vistaBuscar.idtxt.setText(String.valueOf(pelicula1.getIdPelicula()));
        }
       
    }
        
        vistaBuscar.nombretxt.setText("");
        
    }
     
     public void actualizar(){
         
         int cantidad=Integer.valueOf(vistaActualizar.cantidadtxt.getText());
        int precio=Integer.valueOf(vistaActualizar.preciotxt.getText());
         Pelicula pelicula2 = new Pelicula(vistaActualizar.id,cantidad,precio);
        dao.actualizar(pelicula2);
        JOptionPane.showMessageDialog(null, "Se actualizo el pelicula");
     }
     
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vistaInventario.botonEliminar){
           eliminar();
           limpiarTabla();
           mostrarTabla(vistaInventario.tablaInventario);
        }
        if(e.getSource()==vistaAgregar.bAgregar){
            agregar();
        }
        if(e.getSource()==vistaBuscar.buscarb){
            buscar();
        }
        if(e.getSource()==vistaActualizar.actualizarb){
            actualizar();
        }
        
        
    }
}
