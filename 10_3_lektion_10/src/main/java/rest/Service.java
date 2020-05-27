package main.java.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.HashMap;


@Path("power")
public class Service {
    private static int i = 4;
    //create map to store data in
    private static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(1,"skole");
        map.put(2, "aftensmad");
        map.put(3, "Sport");
    }


    @GET
    public String getMap(){
        return map.toString();
    }

    @POST
    public String addName(String name){
        map.put(i, name);
        System.out.println("id = " + i + "value = " + map.get(i));
        i++;

        return "added";
    }

    @DELETE
    @Path("/delete/{id}")
    public void deleteFromMap(@PathParam("id") int id){
        map.remove(id);
        System.out.println(map.toString());
    }


    @PUT
    @Path("/update/{id}/{name}")
    public String changeName(@PathParam("id") int id, @PathParam("name") String name){
        if(map.containsKey(id)){
            map.put(id, name);
            return "updated name";
        }
            return "cannot update";
    }
}

