/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Model.Cliente;

import java.util.ArrayList;


public interface DaoInterfaceCliente {
    public void crear(Cliente cliente);
    public void eliminar(Long cedula);
    public void buscar(Cliente cliente);
    public ArrayList<Cliente> MostrarTodo();
}