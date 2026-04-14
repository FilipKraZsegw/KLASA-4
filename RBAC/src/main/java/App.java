import javax.swing.*;

public class App {
    public static void main(String[] args) {

        JFrame dummy = new JFrame();
        LoginDialog login = new LoginDialog(dummy);
        login.setVisible(true);

        if(Session.getUser() != null) {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        } else {
            System.exit(0);
        }
    }
}