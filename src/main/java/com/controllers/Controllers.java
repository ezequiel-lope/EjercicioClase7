
package com.controllers;

import com.models.Administrador;
import com.models.Cliente;
import com.models.Contacto;
import com.models.Contrato;
import com.models.Profesional;
import com.models.Servicio;
import com.models.Tarea;
import java.util.ArrayList;

public class Controllers {
    
    PersistenceControllers control = new  PersistenceControllers();
    
    
    public void crearAdministrador(Administrador admi)
    {
        control.crearAdministrador(admi);
    }
    
    public void eliminarAdministrador(int id)
    {
        control.eliminarAdministrador(id);
    }
    
    public void editarAdministrador(Administrador admi)
    {
        control.editarAdministrador(admi);
    }
    
    public Administrador buscarAdministrador(long id)
    {
        Administrador admi = new Administrador();
       admi = control.buscarAdministrador(id);
        return admi;
    }
    
    public ArrayList<Administrador> listaAdministradores()
    {
        ArrayList<Administrador> administrador = new ArrayList();
        administrador = control.listaAdministrador();
        return administrador;
    }
    
    
    public void crearCliente(Cliente cli)
    {
        control.crearCliente(cli);
    }
    
    public void eliminarCliente(int id)
    {
        control.eliminarCliente(id);
    }
    
    public void editarCliente(Cliente cli)
    {
        control.editarCliente(cli);
    }
    
    public Cliente buscarCliente(long id)
    {
        Cliente cli = new Cliente();
       cli = control.buscarCliente(id);
        return cli;
    }
    
    public ArrayList<Cliente> listaClientes()
    {
        ArrayList<Cliente> cli = new ArrayList();
        cli = control.listaCliente();
        return cli;
    }
    
    public void crearContacto(Contacto con)
    {
        control.crearContacto(con);
    }
    
    public void eliminarContacto(int id)
    {
        control.eliminarContacto(id);
    }
    
    public void editarContacto(Contacto con)
    {
        control.editarContacto(con);
    }
    
    public Contacto buscarContacto(long id)
    {
        Contacto con = new Contacto();
       con = control.buscarContacto(id);
        return con;
    }
    
    public ArrayList<Contacto> listaContacto()
    {
        ArrayList<Contacto> con = new ArrayList();
        con = control.listaContacto();
        return con;
    }
    
    public void crearContrato(Contrato contra)
    {
        control.crearContrato(contra);
    }
    
    public void eliminarContrato(int id)
    {
        control.eliminarContrato(id);
    }
    
    public void editarcontrato(Contrato contra)
    {
        control.editarContrato(contra);
    }
    
    public Contrato buscarContrato(long id)
    {
        Contrato contra = new Contrato();
       contra = control.buscarContrato(id);
        return contra;
    }
    
    public ArrayList<Contrato> listaContratos()
    {
        ArrayList<Contrato> contra = new ArrayList();
        contra = control.listaContrato();
        return contra;
    }
    
    public void crearProfesional(Profesional prof)
    {
        control.crearProfesional(prof);
    }
    
    public void eliminarProfesional(int id)
    {
        control.eliminarProfesional(id);
    }
    
    public void editarProfesional(Profesional prof)
    {
        control.editarProfesional(prof);
    }
    
    public Profesional buscarProfesional(long id)
    {
        Profesional prof = new Profesional();
      prof = control.buscarProfesional(id);
        return prof;
    }
    
    public ArrayList<Profesional> listaProfesional()
    {
        ArrayList<Profesional> prof = new ArrayList();
       prof = control.listaProfesional();
        return prof;
    }
    
    public void crearServicio(Servicio servi)
    {
        control.crearServicio(servi);
    }
    
    public void eliminarServicio(int id)
    {
        control.eliminarServicio(id);
    }
    
    public void editarServicio(Servicio servi)
    {
        control.editarServicio(servi);
    }
    
    public Servicio buscarServicio(long id)
    {
        Servicio servi = new Servicio();
     servi = control.buscarServicio(id);
        return servi;
    }
    
    public ArrayList<Servicio> listaServicios()
    {
        ArrayList<Servicio> servi = new ArrayList();
        servi = control.listaServicio();
        return servi;
    }
    
    public void crearTarea(Tarea ta)
    {
        control.crearTarea(ta);
    }
    
    public void eliminarTarea(int id)
    {
        control.eliminarTarea(id);
    }
    
    public void editarTarea(Tarea ta)
    {
        control.editarTarea(ta);
    }
    
    public Tarea buscarTarea(long id)
    {
        Tarea ta = new Tarea();
     ta = control.buscarTarea(id);
        return ta;
    }
    
    public ArrayList<Tarea> listaTarea()
    {
        ArrayList<Tarea> ta = new ArrayList();
        ta = control.listaTarea();
        return ta;
    }
    
}
