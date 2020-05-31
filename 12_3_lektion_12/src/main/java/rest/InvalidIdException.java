package main.java.rest;

public class InvalidIdException extends Exception {


    public InvalidIdException() {
        super("Element medde dette id findes allerede");
    }
}