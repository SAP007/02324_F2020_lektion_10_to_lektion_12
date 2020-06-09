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
    
}