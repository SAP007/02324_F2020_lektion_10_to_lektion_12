package main.java.data;

public class TodoDTO {

    private int id;
    private String todo;

    public TodoDTO(int id, String todo) {
        this.id = id;
        this.todo = todo;
    }

    public String getTodo() {
        return todo;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "{" + id + "," + todo + "}";
    }
}