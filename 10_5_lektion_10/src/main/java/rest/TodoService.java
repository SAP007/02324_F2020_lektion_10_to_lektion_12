package main.java.rest;

import main.java.data.TodoDAO;
import main.java.data.TodoDTO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.*;

@Path("todo")
public class TodoService {

    @GET
    public String getTodoList() {
        TodoDAO todo = TodoDAO.getInstance();
        return todo.getListAsString();
    }

    @POST
    @Path("/getfromid")
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
    @Path("/form")
    public String addTodo(@FormParam("inputId") String idString, @FormParam("task") String task)
    {
        int id = Integer.parseInt(idString);

        TodoDTO ingredient = new TodoDTO(id, task);
        TodoDAO.getInstance().addElement(ingredient);

        return TodoDAO.getInstance().getListAsString();
    }

    @POST
    @Path("query")
    //http://localhost:8080/10_5_lektion_10_war_exploded/rest/todo/query?id=4&task=handle
    public String addTodoQuery(@QueryParam("id") String id, @QueryParam("task") String task) {
        TodoDTO todo = new TodoDTO(Integer.parseInt(id), task);
        TodoDAO.getInstance().addElement(todo);
        return "Todo added";
    }

    @POST
    @Path("{id}/{task}")
    public String addTodoPath(@PathParam("id") String id, @PathParam("task") String task) {
        TodoDTO todo = new TodoDTO(Integer.parseInt(id), task);
        TodoDAO.getInstance().addElement(todo);

        return "Todo added";
    }


}