package ru.itis.inf400.tasks;

public class WrongPasswordException extends Exception {
    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException() {
        super("Некорректный пароль");
    }
}
