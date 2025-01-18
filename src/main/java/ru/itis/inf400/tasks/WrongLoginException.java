package ru.itis.inf400.tasks;

public class WrongLoginException extends Exception {
    public WrongLoginException(String message) {
        super(message);
    }

    public WrongLoginException () {
        super("Некорректный логин");
    }
}
