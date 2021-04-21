package com.aj.dropwizardmongodb.resource;

import com.aj.dropwizardmongodb.domain.User;
import com.aj.dropwizardmongodb.service.MongoService;
import com.codahale.metrics.annotation.Timed;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.wordnik.swagger.annotations.Api;
import org.bson.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/users/register")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "user", description = "User Resource for performing CRUD operations on user Collection")
public class UserResource {

    private MongoCollection<Document> collection;
    private final MongoService mongoService;

    public UserResource(MongoCollection<Document> collection, MongoService mongoService) {
        this.collection = collection;
        this.mongoService = mongoService;
    }

    @POST
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(@NotNull @Valid final User user) {
        Gson gson = new Gson();
        String json = gson.toJson(user);
        //System.out.println(user.toString());
        System.out.println(json);
        mongoService.insertOne(collection, new Document(BasicDBObject.parse(json)));
        Map<String, String> response = new HashMap<>();
        response.put("message", "User Got registered successfully");
        return Response.ok(response).build();
    }

    @POST
    @Timed
    @Path("/createMultipleUsers")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUsers(@NotNull final List<User> users) {
        List<Document> userDocuments = new ArrayList<>();
        Gson gson = new Gson();
        String json;
        for (User user : users) {
            json = gson.toJson(user);
            userDocuments.add(new Document(BasicDBObject.parse(json)));
        }
        mongoService.insertMany(collection, userDocuments);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Multiple users data entered successfully");
        return Response.ok(response).build();
    }

    @GET
    @Timed
    public Response getUsers() {
        List<Document> documents = mongoService.find(collection);
        return Response.ok(documents).build();
    }

    @GET
    @Timed
    @Path("{firstname}")
    public Response getUser(@PathParam("firstname") final String firstname) {
        List<Document> documents = mongoService.findByKey(collection, "firstname", firstname);
        return Response.ok(documents).build();
    }

//    @GET
//    @Timed
//    @Path("/salary/sort")
//    public Response getEmployee() {
//        List<Document> documents = mongoService.findByCriteria(collection, "salary",
//                25000, 1000, 1);
//        return Response.ok(documents).build();
//    }

    @PUT
    @Timed
    public Response editUser(@NotNull @Valid final User user) {
        mongoService.updateOneUser(collection, "firstname", "lastname", "email", "password", user);
        Map<String, String> response = new HashMap<>();
        response.put("message", "User with Name: " + user.getFirstname() + " updated successfully");
        return Response.ok(response).build();
    }

    @DELETE
    @Timed
    @Path("{firstname}")
    public Response deleteUser(@PathParam("firstname") final String firstname) {
        mongoService.deleteOne(collection, "firstname", firstname);
        Map<String, String> response = new HashMap<>();
        response.put("message", "User with Name: " + firstname + " deleted successfully");
        return Response.ok(response).build();
    }
}
