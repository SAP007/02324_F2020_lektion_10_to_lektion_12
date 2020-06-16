package main.java.rest;

import main.java.data.TodoDAO;
import main.java.data.TodoDTO;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoService {

    @GET
    //Henter hele to do listen
    public List<TodoDTO> getTodoList() {
        TodoDAO todo = TodoDAO.getInstance();
        return todo.getList();
    }


    @POST
    //henter to do  med id, ellers medeler at det ikke eksistere
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
    //Tilføjer to do element
    public String addTodo(String obj)
    {
        JSONObject jsonObject = new JSONObject(obj);
        int id = jsonObject.getInt("id");
        String todo = jsonObject.getString("todo");

        TodoDTO ingredient = new TodoDTO(id, todo);

        if (!TodoDAO.getInstance().isDuplicate(id)) {
            TodoDAO.getInstance().addElement(ingredient);
            return "Todo added";
        }
        return "Not added Todo!";
    }

    @POST
    @Path("query")
    //Tilføjer to do element med QueryParam
    public String addTodoQuery(@QueryParam("id") String id, @QueryParam("task") String task) {
        TodoDTO todo = new TodoDTO(Integer.parseInt(id), task);
        TodoDAO.getInstance().addElement(todo);
        return "Todo added";
    }

    @POST
    @Path("{id}/{task}")
    //Tilføjer to do element med PathParam
    public String addTodoPath(@PathParam("id") String id, @PathParam("task") String task) {
        TodoDTO todo = new TodoDTO(Integer.parseInt(id), task);
        TodoDAO.getInstance().addElement(todo);
        return "Todo added";
    }

    @DELETE
    @Path("{id}")
    //Sletet to do element med PathParam, tager id fra url
    public void deleteElement(@PathParam("id") String id) {
        TodoDAO.getInstance().remove(Integer.parseInt(id));
    }

    @PUT
    @Path("{id}/{name}")
    // updatere en to do
    public void updateElement(@PathParam("id") int id, @PathParam("name") String name) {
        TodoDAO.getInstance().updateTodo(id, name);
    }

}