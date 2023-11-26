
package com.controllers;

import com.controllers.exceptions.NonexistentEntityException;
import com.models.Administrador;
import com.models.Cliente;
import com.models.Contacto;
import com.models.Contrato;
import com.models.Profesional;
import com.models.Servicio;
import com.models.Tarea;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenceControllers {
    
    AdministradorJpaController admiJpa = new AdministradorJpaController();
    ClienteJpaController clienteJpa = new ClienteJpaController();
    ContactoJpaController contactoJpa = new ContactoJpaController();
    ContratoJpaController contratoJpa = new ContratoJpaController();
    ProfesionalJpaController profesionalJpa = new ProfesionalJpaController();
    ServicioJpaController servicioJpa = new ServicioJpaController();
    TareaJpaController tareaJpa = new TareaJpaController(); 

    void crearAdministrador(Administrador admi) {
       admiJpa.create(admi);
    }

    ArrayList<Administrador> listaAdministrador() {
       List <Administrador> listaTemp = admiJpa.findAdministradorEntities();
        ArrayList<Administrador> lista = new ArrayList(listaTemp);
        return lista;
    }

    Administrador buscarAdministrador(long id) {
        return admiJpa.findAdministrador(id);
    }

    void editarAdministrador(Administrador admi) {
         try {
            admiJpa.edit(admi);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    void eliminarAdministrador(long id) {
        
        try {
            admiJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    void eliminarCliente(int id) {
        try {
            clienteJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Cliente buscarCliente(long id) {
        return clienteJpa.findAdministrador(id);
    }

    void editarCliente(Cliente cli) {
        try {
            clienteJpa.edit(cli);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void crearCliente(Cliente cli) {
        clienteJpa.create(cli);
    }

    ArrayList<Cliente> listaCliente() {
        List <Cliente> listaTemp = clienteJpa.findClienteEntities();
        ArrayList<Cliente> lista = new ArrayList(listaTemp);
        return lista;
    }

    void crearContacto(Contacto con) {
        contactoJpa.create(con);
    }

    void eliminarContacto(int id) {
        try {
            contactoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void editarContacto(Contacto con) {
        try {
            contactoJpa.edit(con);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Contacto buscarContacto(long id) {
        return contactoJpa.findContacto(id);
    }

    ArrayList<Contacto> listaContacto() {
        List <Contacto> listaTemp = contactoJpa.findContactoEntities();
        ArrayList<Contacto> lista = new ArrayList(listaTemp);
        return lista;
    }

    void crearContrato(Contrato contra) {
        contratoJpa.create(contra);
    }

    void eliminarContrato(int id) {
        try {
            contratoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void editarContrato(Contrato contra) {
        try {
            contratoJpa.edit(contra);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Contrato buscarContrato(long id) {
        return contratoJpa.findContrato(id);
    }

    ArrayList<Contrato> listaContrato() {
        List <Contrato> listaTemp = contratoJpa.findContratoEntities();
        ArrayList<Contrato> lista = new ArrayList(listaTemp);
        return lista;
    }

    void crearProfesional(Profesional prof) {
        profesionalJpa.create(prof);
    }

    void eliminarProfesional(long id) {
         try {
            profesionalJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void editarProfesional(Profesional prof) {
        try {
            profesionalJpa.edit(prof);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Profesional buscarProfesional(long id) {
        return profesionalJpa.findProfesional(id);
    }

    ArrayList<Profesional> listaProfesional() {
        List <Profesional> listaTemp = profesionalJpa.findProfesionalEntities();
        ArrayList<Profesional> lista = new ArrayList(listaTemp);
        return lista;
    }


    void crearServicio(Servicio servi) {
        servicioJpa.create(servi);
    }

    void eliminarServicio(long id) {
        try {
            servicioJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void editarServicio(Servicio servi) {
        try {
            servicioJpa.edit(servi);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Servicio buscarServicio(long id) {
        return servicioJpa.findServicio(id);
    }

    ArrayList<Servicio> listaServicio() {
        List <Servicio> listaTemp = servicioJpa.findServicioEntities();
        ArrayList<Servicio> lista = new ArrayList(listaTemp);
        return lista;
    }

    ArrayList<Tarea> listaTarea() {
        List <Tarea> listaTemp = tareaJpa.findTareaEntities();
        ArrayList<Tarea> lista = new ArrayList(listaTemp);
        return lista;
    }

    Tarea buscarTarea(long id) {
        return tareaJpa.findTarea(id);
    }

    void editarTarea(Tarea ta) {
        try {
            tareaJpa.edit(ta);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void eliminarTarea(long id) {
       try {
           tareaJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void crearTarea(Tarea ta) {
        tareaJpa.create(ta);
    }
   
    
    
}
