/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import com.controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.models.Administrador;
import com.models.Contacto;
import java.util.ArrayList;
import java.util.List;
import com.models.Contrato;
import com.models.Profesional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ezelc
 */
public class ProfesionalJpaController implements Serializable {

    public ProfesionalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ProfesionalJpaController() {
         emf = Persistence.createEntityManagerFactory("clase6JPAPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Profesional profesional) {
        if (profesional.getContactos() == null) {
            profesional.setContactos(new ArrayList<Contacto>());
        }
        if (profesional.getContratos() == null) {
            profesional.setContratos(new ArrayList<Contrato>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administrador administrador = profesional.getAdministrador();
            if (administrador != null) {
                administrador = em.getReference(administrador.getClass(), administrador.getId());
                profesional.setAdministrador(administrador);
            }
            List<Contacto> attachedContactos = new ArrayList<Contacto>();
            for (Contacto contactosContactoToAttach : profesional.getContactos()) {
                contactosContactoToAttach = em.getReference(contactosContactoToAttach.getClass(), contactosContactoToAttach.getId());
                attachedContactos.add(contactosContactoToAttach);
            }
            profesional.setContactos(attachedContactos);
            List<Contrato> attachedContratos = new ArrayList<Contrato>();
            for (Contrato contratosContratoToAttach : profesional.getContratos()) {
                contratosContratoToAttach = em.getReference(contratosContratoToAttach.getClass(), contratosContratoToAttach.getId());
                attachedContratos.add(contratosContratoToAttach);
            }
            profesional.setContratos(attachedContratos);
            em.persist(profesional);
            if (administrador != null) {
                administrador.getProfesionales().add(profesional);
                administrador = em.merge(administrador);
            }
            for (Contacto contactosContacto : profesional.getContactos()) {
                Profesional oldProfesionalOfContactosContacto = contactosContacto.getProfesional();
                contactosContacto.setProfesional(profesional);
                contactosContacto = em.merge(contactosContacto);
                if (oldProfesionalOfContactosContacto != null) {
                    oldProfesionalOfContactosContacto.getContactos().remove(contactosContacto);
                    oldProfesionalOfContactosContacto = em.merge(oldProfesionalOfContactosContacto);
                }
            }
            for (Contrato contratosContrato : profesional.getContratos()) {
                Profesional oldProfesionalOfContratosContrato = contratosContrato.getProfesional();
                contratosContrato.setProfesional(profesional);
                contratosContrato = em.merge(contratosContrato);
                if (oldProfesionalOfContratosContrato != null) {
                    oldProfesionalOfContratosContrato.getContratos().remove(contratosContrato);
                    oldProfesionalOfContratosContrato = em.merge(oldProfesionalOfContratosContrato);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Profesional profesional) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Profesional persistentProfesional = em.find(Profesional.class, profesional.getId());
            Administrador administradorOld = persistentProfesional.getAdministrador();
            Administrador administradorNew = profesional.getAdministrador();
            List<Contacto> contactosOld = persistentProfesional.getContactos();
            List<Contacto> contactosNew = profesional.getContactos();
            List<Contrato> contratosOld = persistentProfesional.getContratos();
            List<Contrato> contratosNew = profesional.getContratos();
            if (administradorNew != null) {
                administradorNew = em.getReference(administradorNew.getClass(), administradorNew.getId());
                profesional.setAdministrador(administradorNew);
            }
            List<Contacto> attachedContactosNew = new ArrayList<Contacto>();
            for (Contacto contactosNewContactoToAttach : contactosNew) {
                contactosNewContactoToAttach = em.getReference(contactosNewContactoToAttach.getClass(), contactosNewContactoToAttach.getId());
                attachedContactosNew.add(contactosNewContactoToAttach);
            }
            contactosNew = attachedContactosNew;
            profesional.setContactos(contactosNew);
            List<Contrato> attachedContratosNew = new ArrayList<Contrato>();
            for (Contrato contratosNewContratoToAttach : contratosNew) {
                contratosNewContratoToAttach = em.getReference(contratosNewContratoToAttach.getClass(), contratosNewContratoToAttach.getId());
                attachedContratosNew.add(contratosNewContratoToAttach);
            }
            contratosNew = attachedContratosNew;
            profesional.setContratos(contratosNew);
            profesional = em.merge(profesional);
            if (administradorOld != null && !administradorOld.equals(administradorNew)) {
                administradorOld.getProfesionales().remove(profesional);
                administradorOld = em.merge(administradorOld);
            }
            if (administradorNew != null && !administradorNew.equals(administradorOld)) {
                administradorNew.getProfesionales().add(profesional);
                administradorNew = em.merge(administradorNew);
            }
            for (Contacto contactosOldContacto : contactosOld) {
                if (!contactosNew.contains(contactosOldContacto)) {
                    contactosOldContacto.setProfesional(null);
                    contactosOldContacto = em.merge(contactosOldContacto);
                }
            }
            for (Contacto contactosNewContacto : contactosNew) {
                if (!contactosOld.contains(contactosNewContacto)) {
                    Profesional oldProfesionalOfContactosNewContacto = contactosNewContacto.getProfesional();
                    contactosNewContacto.setProfesional(profesional);
                    contactosNewContacto = em.merge(contactosNewContacto);
                    if (oldProfesionalOfContactosNewContacto != null && !oldProfesionalOfContactosNewContacto.equals(profesional)) {
                        oldProfesionalOfContactosNewContacto.getContactos().remove(contactosNewContacto);
                        oldProfesionalOfContactosNewContacto = em.merge(oldProfesionalOfContactosNewContacto);
                    }
                }
            }
            for (Contrato contratosOldContrato : contratosOld) {
                if (!contratosNew.contains(contratosOldContrato)) {
                    contratosOldContrato.setProfesional(null);
                    contratosOldContrato = em.merge(contratosOldContrato);
                }
            }
            for (Contrato contratosNewContrato : contratosNew) {
                if (!contratosOld.contains(contratosNewContrato)) {
                    Profesional oldProfesionalOfContratosNewContrato = contratosNewContrato.getProfesional();
                    contratosNewContrato.setProfesional(profesional);
                    contratosNewContrato = em.merge(contratosNewContrato);
                    if (oldProfesionalOfContratosNewContrato != null && !oldProfesionalOfContratosNewContrato.equals(profesional)) {
                        oldProfesionalOfContratosNewContrato.getContratos().remove(contratosNewContrato);
                        oldProfesionalOfContratosNewContrato = em.merge(oldProfesionalOfContratosNewContrato);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = profesional.getId();
                if (findProfesional(id) == null) {
                    throw new NonexistentEntityException("The profesional with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Profesional profesional;
            try {
                profesional = em.getReference(Profesional.class, id);
                profesional.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The profesional with id " + id + " no longer exists.", enfe);
            }
            Administrador administrador = profesional.getAdministrador();
            if (administrador != null) {
                administrador.getProfesionales().remove(profesional);
                administrador = em.merge(administrador);
            }
            List<Contacto> contactos = profesional.getContactos();
            for (Contacto contactosContacto : contactos) {
                contactosContacto.setProfesional(null);
                contactosContacto = em.merge(contactosContacto);
            }
            List<Contrato> contratos = profesional.getContratos();
            for (Contrato contratosContrato : contratos) {
                contratosContrato.setProfesional(null);
                contratosContrato = em.merge(contratosContrato);
            }
            em.remove(profesional);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Profesional> findProfesionalEntities() {
        return findProfesionalEntities(true, -1, -1);
    }

    public List<Profesional> findProfesionalEntities(int maxResults, int firstResult) {
        return findProfesionalEntities(false, maxResults, firstResult);
    }

    private List<Profesional> findProfesionalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Profesional.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Profesional findProfesional(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Profesional.class, id);
        } finally {
            em.close();
        }
    }

    public int getProfesionalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Profesional> rt = cq.from(Profesional.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
