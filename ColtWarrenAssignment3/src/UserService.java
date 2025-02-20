public class UserService {
    public static User validateUser(String inputUsername, String inputPassword, User[] users) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(inputUsername) && user.getPassword().equals(inputPassword)) {
                return user;
            }
        }
        return null;
    }
}

