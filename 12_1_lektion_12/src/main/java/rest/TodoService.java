package main.java.rest;

import main.java.data.TodoDAO;
import main.java.data.TodoDTO;

import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoService {

    @GET
    public List<TodoDTO> getTodoList() {
        TodoDAO todo = TodoDAO.getInstance();
        return todo.getList();

    }


    @POST
    public String getTodoFromId(@FormParam("getid") String id) {
        TodoDAO todo = TodoDAO.getInstance();
        for (TodoDTO elem : todo.getList()) {
            if (elem.getId() == Integer.parseInt(id)) {
                return elem.toString();
            }
        }
        return "Element with id: " + id + "does not exist";
    }


    @POST
    @Path("form")
    public Response addTodo(String obj)
    {
        JSONObject jsonObject = new JSONObject(obj);
        int id = jsonObject.getInt("id");
        String todo = jsonObject.getString("todo");

        TodoDTO ingredient = new TodoDTO(id, todo);

        if (!TodoDAO.getInstance().isDuplicate(id)) {
            TodoDAO.getInstance().addElement(ingredient);
            return Response.status(201).entity("Element oprettet").build();
        }

        return Response.status(400).entity("Element med id " + id +" findes allerede").build();

    }

    @POST
    @Path("query")
    public String addTodoQuery(@QueryParam("id") String id, @QueryParam("name") String name) {
        TodoDTO todo = new TodoDTO(Integer.parseInt(id), name);
        TodoDAO.getInstance().addElement(todo);

        return "Todo added";
    }

    @POST
    @Path("{id}/{name}")
    public String addTodoPath(@PathParam("id") String id, @PathParam("name") String name) {
        TodoDTO todo = new TodoDTO(Integer.parseInt(id), name);
        TodoDAO.getInstance().addElement(todo);

        return "Todo added";
    }

    @DELETE
    @Path("{id}")
    public void deleteElement(@PathParam("id") String id) {
        System.out.println("id iis = " + id);
        TodoDAO.getInstance().remove(Integer.parseInt(id));

    }

    @PUT
    @Path("{id}/{name}")
    public void updateElement(@PathParam("id") int id, @PathParam("name") String name) {
        TodoDAO.getInstance().updateTodo(id, name);

    }

}
