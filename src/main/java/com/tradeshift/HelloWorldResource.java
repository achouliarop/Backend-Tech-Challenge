package com.tradeshift;

import java.net.HttpURLConnection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.tradeshift.model.MessageModel;
import com.tradeshift.model.ResultModel;
import com.tradeshift.service.HelloWorldService;


@Path("/")
@Controller
public class HelloWorldResource {

    private HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldResource(HelloWorldService helloWorld) {
        this.helloWorldService = helloWorld;
    }

    @GET
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
        MessageModel messageModel = new MessageModel();
        //set the name
        messageModel.setContent(helloWorldService.getHelloWorldMessage(name));

        //init
        ResultModel output = new ResultModel();
        //set name
        output.setMessage(messageModel);

        return output;
    }

}