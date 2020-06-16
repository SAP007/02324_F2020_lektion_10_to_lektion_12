package main.java.rest;

import javax.ws.rs.*;
import java.util.Map;
import java.util.HashMap;


@Path("todo")
public class TodoService {
    private static int i = 4;
    //create map to store data in
    private static Map<Integer, String> map = new HashMap<>();

    static {

        //dummy objekter
        map.put(1,"skole");
        map.put(2, "aftensmad");
        map.put(3, "Sport");
    }

    @GET
    //Henter mappet som streng
    public String getMap(){
        return map.toString();
    }

    @POST
    @Path("/add/{task}")
    //tilføjer en task til mappet
    public String addName(@PathParam("task") String task){
        map.put(i, task);
        System.out.println("id = " + i + "value = " + map.get(i));
        i++;

        return "added" + task;
    }

    @DELETE
    @Path("/delete/{id}")
    //Sletter det givet id fra mappet
    public String deleteFromMap(@PathParam("id") int id){
        map.remove(id);
        return "Element " + id + " deleted.";
    }

    @PUT
    @Path("/update/{id}/{task}")
    //Opdatere navnet på en task
    public String changeName(@PathParam("id") int id, @PathParam("task") String task){
        if(map.containsKey(id)){
            map.put(id, task);
            return "updated task " + id;
        }
            return "Element " + id + " does not exist";
    }
}

