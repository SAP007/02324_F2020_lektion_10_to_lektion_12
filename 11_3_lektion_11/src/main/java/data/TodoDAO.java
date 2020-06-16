package main.java.data;

import java.util.ArrayList;
import java.util.List;

public class TodoDAO {

    private static TodoDAO instance;
    private List<TodoDTO> list;

    public TodoDAO() {
        list = new ArrayList<TodoDTO>();
        //dummy objekter
        list.add(new TodoDTO(1,"handel"));
        list.add(new TodoDTO(5,"skole"));
    }

    //henter statisk instance
    public static TodoDAO getInstance() {
        if (instance == null)
            instance = new TodoDAO();
        return instance;
    }

    //For debugging
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

    //tjekker om id findes i listen
    public boolean isDuplicate(int id) {
        for (TodoDTO todo : list) {
            if (todo.getId() == id)
                return true;
        }
        return false;
    }

    //henter listen
    public List<TodoDTO> getList() {
        return list;
    }

    //fjerner element med det givne id fra listen
    public void remove(int id) {
        for (TodoDTO todo : list) {
            if (id == todo.getId()) {
                list.remove(todo);
                return;
            }
        }
    }

    //Opdaterer task på elementet med det givne id
    public String updateTodo(int id, String name) {
        for (TodoDTO curr : list) {

            if (curr.getId() == id) {
                curr.setTodo(name);
                return "Element med id "+ id + " opdateret";
            }
        }
        return "ID eksisterer ikke i listen";
    }

    //debugging
    public String getListAsString() {
        String totalString = "";
        int len = list.size();
        int i = 1;
        for (TodoDTO elem : list) {
            totalString = totalString + "{" + elem.getId() + "," + elem.getTodo() + "}";
            i++;
            if (i < len)
                totalString += ",";

        }
        return "[" +totalString + "]";
    }

}