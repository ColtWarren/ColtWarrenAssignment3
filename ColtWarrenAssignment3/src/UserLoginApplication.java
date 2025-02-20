import java.util.Scanner;

public class UserLoginApplication {
    public static void main(String[] args) {
        User[] users = FileService.readUsers("data.txt");
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        final int MAX_ATTEMPTS = 5;

        while (attempts < MAX_ATTEMPTS) {
            System.out.println("Enter your email: ");
            String username = scanner.nextLine();
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();

            User user = UserService.validateUser(username, password, users);
            if (user != null) {
                System.out.println("Welcome " + user.getName());
                scanner.close();
                return;
            } else {
                attempts++;
                if (attempts < MAX_ATTEMPTS) {
                    System.out.println("Invalid login, please try again.");
                }
            }
        }
        System.out.println("Too many failed login attempts, you are now locked out.");
        scanner.close();
    }
}



