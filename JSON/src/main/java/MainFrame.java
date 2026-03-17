import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel container;

    public static final String FORM = "FORM";
    public static final String VIEW = "VIEW";

    public MainFrame() {
        setTitle("System Profilu");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        FormPanel formPanel = new FormPanel(this);
        ViewPanel viewPanel = new ViewPanel(this);

        container.add(formPanel, FORM);
        container.add(viewPanel, VIEW);

        add(container);
        setVisible(true);
    }

    public void showCard(String name) {
        cardLayout.show(container, name);
    }

    public void refreshView() {
        ((ViewPanel) container.getComponent(1)).loadData();
    }
}