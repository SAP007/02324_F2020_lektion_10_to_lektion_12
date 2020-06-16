package main.java.data;

import java.util.ArrayList;
import java.util.List;

public class TodoDAO {

    private static TodoDAO instance;
    private List<TodoDTO> list;

    public TodoDAO() {
        list = new ArrayList<TodoDTO>();

        //dummy objekter til GET
        list.add(new TodoDTO(1,"Skole"));
        list.add(new TodoDTO(2,"Aftensmad"));
        list.add(new TodoDTO(3,"Sport"));
    }

    public static TodoDAO getInstance() {
        if (instance == null)
            instance = new TodoDAO();
        return instance;
    }

    public String getListAsString() {
        String totalString = "";

        for (TodoDTO elem : list) {
            totalString = totalString + "{" + elem.getId() + "," + elem.getTodo() + "}";
        }

        return totalString;
    }

}