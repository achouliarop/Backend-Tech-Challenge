package com.tradeshift.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tradeshift.model.RecentModel;
import com.tradeshift.service.HelloWorldService;


@Path("messages")
@Controller
public class HelloWorldResource {

    private HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldResource(HelloWorldService helloWorld) {
        this.helloWorldService = helloWorld;
    }

    @POST
    @Path("/names/{name}")
    @Produces("application/json")
    @Consumes({"text/plain,text/html"})
    public void insertNameToDB(@PathParam("name") String name) {
        helloWorldService.insert(name);
    }

    @GET
    @Path("recent")
    @Produces("application/json")
    public RecentModel getMessages() {
        return helloWorldService.getMessages(10);
    }
}