import java.util.*;

public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> users;

    public AuthenticationService() {
        users = new ArrayList<>();
        users.add(new User("admin", "admin123"));
    }

    @Override
    public User signUp(String username, String password) {
        if (username.length() > 0) {
            for (User user : users) {
                if (username.equals(user.getUsername())) {
                    return null;
                }
            }
            User credentials = new User(username, password);
            users.add(credentials);
            return credentials;
        }
        return null;
    }

    @Override
    public User logIn(String username, String password) {
        for (User user : users) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}