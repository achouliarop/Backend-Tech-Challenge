package com.tradeshift.resources;

import javax.ws.rs.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tradeshift.model.Content;
import com.tradeshift.model.Message;
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
    public Message insertNameToDB(@PathParam("name") String name) {

        String content;

        if (name == null) {
            throw new BadRequestException("Name can not be empty");
        } else {
            content = helloWorldService.getHelloWorldMessage(name);
            helloWorldService.insert(name);
        }
        return new Message(new Content(content));
    }

    @GET
    @Path("recent")
    @Produces("application/json")
    public RecentModel getMessages() {
        return helloWorldService.getMessages(10);
    }
}