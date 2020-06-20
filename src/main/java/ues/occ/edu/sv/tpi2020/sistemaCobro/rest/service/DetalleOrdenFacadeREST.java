///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package ues.occ.edu.sv.tpi2020.sistemaCobro.rest.service;
//
//import java.io.Serializable;
//import java.util.List;
//import javax.ejb.Stateless;
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.PathSegment;
//import ues.occ.edu.sv.tpi2020.sistemaCobro.entities.DetalleOrden;
//import ues.occ.edu.sv.tpi2020.sistemaCobro.facades.DetalleOrdenFacade;
//
//@Stateless
//@Path("detalleOrden")
//public class DetalleOrdenFacadeREST implements Serializable {
//    
//    @Inject
//    DetalleOrdenFacade detOrdenFacade;
//
//    @PersistenceContext(unitName = "ues.occ.edu.sv.tpi2020_sistema-cobro_war_1.0-SNAPSHOTPU")
//    private EntityManager em;
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void create(DetalleOrden entity) {
//        detOrdenFacade.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void edit(@PathParam("id") PathSegment id, DetalleOrden entity) {
//        detOrdenFacade.edit(entity);
//    }
//
//    @DELETE
//    @Path("{id}")
//    public void remove(@PathParam("id") PathSegment id) {
//        detOrdenFacade.remove(detOrdenFacade.find(id));
//    }
//
//    @GET
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public DetalleOrden find(@PathParam("id") PathSegment id) {
//        return detOrdenFacade.find(id);
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<DetalleOrden> findAll() {
//        return detOrdenFacade.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<DetalleOrden> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return detOrdenFacade.findRange(from, to);
//    }
//
//    @GET
//    @Path("count")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String countREST() {
//        return String.valueOf(detOrdenFacade.count());
//    }    
//}
