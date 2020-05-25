package main.java.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("hello")
public class HelloService {

    @GET
    public String getHello(){
        return "hello";
    }


    @POST
    public String getBye(String name){
        return "bye " + name;
    }
}

