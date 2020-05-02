package main.java.rest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("hello")
public class HelloService {

    @GET
    public String sayHello(){
        return "hello";
    }

    @POST
    @Path("/getname")
    public String getName(String name){
        return "hello " + name; }
}