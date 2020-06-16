package main.java.rest;

public class InvalidIdException extends Exception {


    public InvalidIdException() {
        super("Element med dette id findes allerede");
    }
}