package com.fire.resources;

import com.fire.model.Car;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cars")
public class CarResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> list() { return  Car.listAll();}

    @POST
    @Transactional
    public Car create(Car car){
        car.persist();
        return car;
    }

    @PUT
    @Transactional
    @Path("{id}")
    public Car update(@PathParam("id") Long id, Car car){
        Car carDatabase = Car.findById(id);
        carDatabase.name = car.name;
        carDatabase.brand = car.brand;
        return carDatabase;
    }

    @DELETE
    @Transactional
    @Path("{id}")
    public void delete(@PathParam("id") Long id){
        Car.deleteById(id);
    }
}