package ru.itis.inf400.tasks;

import ru.itis.inf400.theory.NumberEq0Exception;
import ru.itis.inf400.theory.NumberSource;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws exitException {
        String loginRightAdmin = "ThisIsAVeryLongLogin_987-Test";
        String loginRightUser = "SomeRandom-Login_4455@test.com";
        String loginLie = "TooShortLogin_123";
        String passwordRightAdmin = "1234abcd[]";
        String passwordRightUser = "Test&_Test1";
        String passwordLie = "short1";


        User user1 = new User(loginRightAdmin, passwordRightAdmin, UserRole.ADMIN);
        User user2 = new User(loginRightUser, passwordRightUser, UserRole.USER);

        User[] users = {user1, user2};

        System.out.println("Введите логин");
        String login = inputLine(true);

        System.out.println("Введите пароль");
        String password = inputLine(false);

        boolean wasFindUser = false;
        for (User user : users) {
            if (user.userCheck(login, password)) {
                user.printMenu();
                wasFindUser = true;
            }
        }

        if (!wasFindUser) {
            System.out.println("Неверный логин или пароль");
        }
    }

    public static String inputLine(boolean checkLogin) throws exitException{
        boolean notCorrect = true;
        String line = null;
        while (notCorrect) {
            try {
                Scanner scanner = new Scanner(System.in);
                line = scanner.nextLine();
                if (line.equals("exit")) {
                    throw new exitException();
                }

                if (checkLogin) {
                    if (Login.checkCorrect(line)) {
                        return line;
                    }
                } else {
                    if (Password.checkPassword(line)) {
                        return line;
                    }
                }
            } catch (WrongLoginException | WrongPasswordException e) {
                System.out.println(e.getMessage());
            }
        }
        return line;
    }
}
