package ru.itis.inf400.tasks;

public class exitException extends Exception {
    public exitException() {
        super("Вы вышли из программы");
    }

    public exitException(String message) {
        super(message);
    }
}
