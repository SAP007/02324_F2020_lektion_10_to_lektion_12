package main.java.data;

import java.util.ArrayList;
import java.util.List;

public class TodoDAO {

    private static TodoDAO instance;
    private List<TodoDTO> list;

    public TodoDAO() {

        list = new ArrayList<TodoDTO>();

        //dummy objekter
        list.add(new TodoDTO(1,"Skole"));
        list.add(new TodoDTO(2,"Aftensmad"));
        list.add(new TodoDTO(3,"Sport"));
    }

    //henter statisk instance
    public static TodoDAO getInstance() {
        if (instance == null)
            instance = new TodoDAO();
        return instance;
    }

    //debugging
    public String getTodoById(int id) {
        for (TodoDTO curr : list) {

            if (curr.getId() == id)
                return curr.getTodo();

        }

        return "ID eksisterer ikke i listen";
    }

    //tilføjer et element til listen
    public void addElement(TodoDTO elem) {
        list.add(elem);
    }

    //henter listen
    public List<TodoDTO> getList() {
        return list;
    }

    // listen som en streng
    public String getListAsString() {
        String totalString = "";

        for (TodoDTO elem : list) {
            totalString = totalString + "{" + elem.getId() + "," + elem.getTodo() + "}";
        }

        return totalString;
    }

}