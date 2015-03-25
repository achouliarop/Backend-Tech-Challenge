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

import com.tradeshift.service.HelloWorldInterface;


@Path("/")
@Controller
public class  HelloWorld {

    @Autowired
    private HelloWorldInterface helloWorldService;

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

        ResultModel rM = new ResultModel();

        String output = helloWorldService.getHelloMsg(name);

        rM.setMsg(output);

        /*return Response.status(200).entity(output).build();*/
        return rM;
    }

}