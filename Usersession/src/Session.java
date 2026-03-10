public class Session {

    private static String login;
    private static String role;

    public static void login(String user, String userRole) {
        login = user;
        role = userRole;
    }

    public static String getLogin() {
        return login;
    }

    public static String getRole() {
        return role;
    }

    public static void logout() {
        login = null;
        role = null;
    }
}