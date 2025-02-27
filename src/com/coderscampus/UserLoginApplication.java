package com.coderscampus;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {
    public static void main(String[] args) {
        try {
            FileService fileService = new FileService();
            UserService userService = new UserService();
            String[] UserInput = fileService.readUserData("data.txt");
            userService.initializeUsers(UserInput);

            try (Scanner scanner = new Scanner(System.in)) {
                int attempts = 0;
                final int MAX_ATTEMPTS = 5;

                while (attempts < MAX_ATTEMPTS) {
                    System.out.println("Enter your email: ");
                    String username = scanner.nextLine();
                    System.out.println("Enter your password: ");
                    String password = scanner.nextLine();

                    User user = userService.validateUser(username, password);
                    if (user != null) {
                        System.out.println("Welcome " + user.getName());
                        return;
                    }
                        attempts++;

                        if (attempts < MAX_ATTEMPTS) {
                            System.out.println("Invalid login, please try again.");
                        }
                    }
                }
            System.out.println("Too many failed attempts. You're locked out.");
            } catch (IOException e) {
                System.out.println("Error loading user data: " + e.getMessage());
            }
        }
    }

