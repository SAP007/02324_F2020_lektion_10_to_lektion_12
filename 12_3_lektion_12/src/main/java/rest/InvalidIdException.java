package main.java.rest;

public class InvalidIdException extends Exception {


    public InvalidIdException(int id) {
        super("Element med id " + id + " findes allerede");
    }
}