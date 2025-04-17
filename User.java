public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String username, String password) {
        System.out.println("Comparing Username: " + this.username + " with " + username);
        System.out.println("Comparing Password: " + this.password + " with " + password);
        return this.username.equals(username) && this.password.equals(password);
    }

}
