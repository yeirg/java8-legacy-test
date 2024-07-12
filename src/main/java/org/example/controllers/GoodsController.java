package org.example.controllers;

import org.example.domain.Good;
import org.example.domain.IGoodsRepository;
import org.example.dtos.CreateGoodRequest;
import org.example.infrastructure.GoodsRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/goods")
public class GoodsController {
    private IGoodsRepository goodsRepository = new GoodsRepository();

    /*@Inject
    public GoodsController(IGoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }*/
    
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Add(CreateGoodRequest request) {
        // no validation
        Good good = new Good(request.getName(), request.getPrice());
        
        boolean isSuccess = goodsRepository.save(good);
        if (isSuccess) {
            return Response.status(Response.Status.CREATED).build();
        }
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response All() {
        List<Good> goods = goodsRepository.findAll();
        
        return Response.status(Response.Status.OK).entity(goods).build();
    }
}
