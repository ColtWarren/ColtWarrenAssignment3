package com.coderscampus;
public class UserService {
    private User[] users;

    public void initializeUsers(String fileName) {
        FileService fileService = new FileService();
        String[] rows = fileService.read(fileName);
        int numberOfUsers = rows.length;
        users = new User[numberOfUsers];
        int index = 0;
        for (String row : rows) {
            String[] parts = row.split(",");
            if (parts.length == 3) {
                users[index++] = new User(parts[0], parts[1], parts[2]);
            }
        }
    }

    public User validateUser(String username, String password) {
        for (User user : users) {
            if (user != null && user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
