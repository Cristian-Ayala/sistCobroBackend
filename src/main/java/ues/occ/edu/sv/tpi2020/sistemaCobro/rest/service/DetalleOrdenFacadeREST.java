/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi2020.sistemaCobro.rest.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ues.occ.edu.sv.tpi2020.sistemaCobro.entities.DetalleOrden;
import ues.occ.edu.sv.tpi2020.sistemaCobro.entities.DetalleOrdenPK;
import ues.occ.edu.sv.tpi2020.sistemaCobro.facades.DetalleOrdenFacade;

@Stateless
@Path("detalleOrden")
public class DetalleOrdenFacadeREST implements Serializable {

    @Inject
    DetalleOrdenFacade detOrdenFacade;

    @PersistenceContext(unitName = "ues.occ.edu.sv.tpi2020_sistema-cobro_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    //Working
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(String jsonString) {
        JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();
        if (detOrdenFacade.create(new DetalleOrden(new DetalleOrdenPK(json.get("idOrden").getAsString(), json.get("upc").getAsString()), json.get("cantidadProd").getAsInt(), json.get("precioUnit").getAsInt(), json.get("descuento").getAsInt()))) {
            return Response.status(Response.Status.OK).header("mensaje", "se creo con exito").build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("mensaje", "Sin exito").build();
        }
    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void edit(@PathParam("id") PathSegment id, DetalleOrden entity) {
////        JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();
////        json.get("totalOrden").getAsFloat();
//        detOrdenFacade.edit(entity);
//    }
//
//    @DELETE
//    @Path("remove/{idOrden}/{upc}")
//    public void remove(@PathParam("idOrden") String idOrden, @PathParam("upc") String upc) {
//        detOrdenFacade.edit(detOrdenFacade.find(new DetalleOrdenPK(idOrden, upc)));
//    }

    //Working
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetalleOrden> findAll() {
        return detOrdenFacade.findAll();
    }

    //Working
    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetalleOrden> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return detOrdenFacade.findRange(from, to);
    }

    //Working
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(detOrdenFacade.count());
    }
}
