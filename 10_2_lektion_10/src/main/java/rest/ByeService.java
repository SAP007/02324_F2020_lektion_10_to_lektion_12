package main.java.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("bye")
public class ByeService {

    @POST
    public String getBye(String name){
        return "bye " + name;
    }
}