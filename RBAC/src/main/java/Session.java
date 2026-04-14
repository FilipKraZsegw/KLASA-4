public class Session {
    private static String loggedUser;
    private static String role;

    public static void login(String user, String userRole) {
        loggedUser = user;
        role = userRole;
    }

    public static String getUser() {
        return loggedUser;
    }

    public static String getRole() {
        return role;
    }

    public static void logout() {
        loggedUser = null;
        role = null;
    }
}