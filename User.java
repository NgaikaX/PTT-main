import java.util.ArrayList;

public class User {
    private int userId;
    private String password;
    private String role;

    public User(int userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    /*public static void createUser(int id, String password, String role) {
        if ("Administrator".equalsIgnoreCase(role)) {
            new Administrator(id, password);
        } else if ("Teacher".equalsIgnoreCase(role)) {
            new Teacher(id, password);
        } else if ("Director".equalsIgnoreCase(role)) {
            new Director(id, password);
        } else {
            new User(id, password);
        }
    }*/

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
