/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.vainiyasoft.agendaweb.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import mx.vainiyasoft.agendaweb.entities.Contacto;

/**
 *
 * @author alejandro
 */
@Stateless
@Path("contacto")
public class ContactoFacadeREST extends AbstractFacade<Contacto> {
    
    // Tomcat ignora esta inyección de recursos
    // @PersistenceContext(unitName = "mx.vainiyasoft_agendaweb_war_1.0PU")
    private EntityManager em;

    public ContactoFacadeREST() {
        super(Contacto.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(Contacto entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Integer id, Contacto entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Contacto find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Contacto> findAll() {
        return super.findAll();
    }
    
    @GET
    @Override
    @Path("propietario/{owner}")
    @Produces({"application/json"})
    public List<Contacto> findAllByOwner(@PathParam("owner") String owner) {
        return super.findAllByOwner(owner);
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Contacto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        if( em == null ) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("mx.vainiyasoft_agendaweb_war_1.0PU");
            em = factory.createEntityManager();
        }
        return em;
    }
    
}
