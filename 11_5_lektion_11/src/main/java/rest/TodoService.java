package main.java.rest;

import main.java.data.TodoDAO;
import main.java.data.TodoDTO;

import javax.ws.rs.*;

@Path("todo")
public class TodoService {

    @GET
    public String getTodoList() {
        TodoDAO todo = TodoDAO.getInstance();
        return todo.getListAsString();

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
    @Path("/getname")
    public String getname(String name){return "hello " + name;}


    @POST
    @Path("/form")
    public String addTodo(@FormParam("id") String idString, @FormParam("name") String input)
    {
        int id = Integer.parseInt(idString);

        System.out.println("inde: " + idString + ", " + input);

        TodoDTO ingredient = new TodoDTO(id, input);
        TodoDAO.getInstance().addElement(ingredient);

        return TodoDAO.getInstance().getListAsString();
    }

    @POST
    @Path("query")
    /*Variablerne tages fra URL'en
     * Eksempel på HTTP kald: POST localhost:8080/Lektion10/rest/ingredient/query?id=4&name=sukker&amount=45 */
    public String addIngredientQuery(@QueryParam("id") String id, @QueryParam("name") String name) {
        TodoDTO todo = new TodoDTO(Integer.parseInt(id), name);
        TodoDAO.getInstance().addElement(todo);

        return "Todo added";
    }

    @POST
    @Path("{id}/{name}")
    /*Variablerne tages fra URL'en
     * Eksempel på HTTP kald: POST localhost:8080/Lektion10/rest/ingredient/4/sukker/45 */
    public String addIngredientPath(@PathParam("id") String id, @PathParam("name") String name) {
        TodoDTO todo = new TodoDTO(Integer.parseInt(id), name);
        TodoDAO.getInstance().addElement(todo);

        return "Todo added";
    }

}
