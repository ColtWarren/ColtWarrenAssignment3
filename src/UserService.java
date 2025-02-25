public class UserService {
    private User[] users;

    public void initializeUsers(String[] userInput) {
        users = new User[userInput.length];
        for (int i = 0; i < userInput.length; i++) {
            String[] parts = userInput[i].split(",");
            if (parts.length == 3) {
                users[i] = new User(parts[0], parts[1], parts[2]);
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
