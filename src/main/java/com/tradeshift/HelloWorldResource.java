package com.tradeshift;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tradeshift.model.Message;
import com.tradeshift.model.ResultModel;
import com.tradeshift.service.HelloWorldService;
import com.tradeshift.service.MessagesDAO;


@Path("messages")
@Controller
public class HelloWorldResource {

    private HelloWorldService helloWorldService;

    @Autowired
    private MessagesDAO messagesDAO;

    @Autowired
    public HelloWorldResource(HelloWorldService helloWorld) {
        this.helloWorldService = helloWorld;
    }

    // /messages/names/$name
    // /messages/recent
    @POST
    @Path("/names/{name}")
    @Produces("application/json")
    @Consumes({"text/plain,text/html"})
    public ResultModel insertNameToDB(@PathParam("name") String name) {
        Message message = new Message();
        message.setContent("hello " + name);
        messagesDAO.insert(message);

        ResultModel output = new ResultModel();
        output.setMessage(message);
        return output;
    }

    @GET
    @Path("recent")
    @Produces("application/json")
    public List<ResultModel> getMessages() {
        return messagesDAO.getMessages(10);
    }

    /*@GET
    @Path("hello")
    @Produces("application/json")
    public ResultModel getMsg(@QueryParam("name") String name) {

        if (name == null) {
            throw new WebApplicationException(
                    Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
                            .entity("name parameter is mandatory")
                            .build()
            );
        }


        //init
        Message messageModel = new Message();
        //set the name
        messageModel.setContent(helloWorldService.getHelloWorldMessage(name));

        //init
        ResultModel output = new ResultModel();
        //set name
        output.setMessage(messageModel);

        return output;
    }*/

}