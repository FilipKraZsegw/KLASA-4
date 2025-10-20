import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PolaTekstowe extends JFrame {
    public PolaTekstowe() {
        super("Siemano kumplu");
        LoginListener listener = new LoginListener(this);
        JPanel loginPanel = new LoginPanel(listener);
        add(loginPanel);

        setPreferredSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    private class UserValidator {
        private static final String name = "FilipKrasik";
        private static final String password = "PzH2000";

        public static boolean authenticate(String name, String password) {
            if(UserValidator.name.equals(name) & UserValidator.password.equals(password))
                return true;
            else
                return false;
        }
    }
    private class HTMLPanel extends JPanel {
        //pole do wpisywania kodu html
        private final JTextArea textArea = new JTextArea();
        //pole z wygenerowanym kodem
        private final JEditorPane editorPane = new JEditorPane();

        public HTMLPanel() {
            super();
            setLayout(new BorderLayout());
            createPanels();
        }

        private void createPanels() {
            //nie chcemy, aby można było edytować wygenerowany html
            editorPane.setEditable(false);
            //ustawiamy nasz editorPane, aby rozpoznawa znaczniki html
            editorPane.setContentType("text/html");
            //przycisk generowania podglądu
            JButton actionButton = new JButton("Podgląd");
            actionButton.addActionListener(new ConvertListener());
            //panel pomocniczy do rozkładu elementów
            JPanel helpPanel = new JPanel();
            helpPanel.setLayout(new GridLayout(1, 2));
            textArea.setBackground(Color.lightGray);
            //dodajemy komponenty tekstowe do pomocniczego panelu
            helpPanel.add(textArea);
            helpPanel.add(editorPane);
            //dodajemy wszystko do głównego panelu
            this.add(helpPanel, BorderLayout.CENTER);
            this.add(actionButton, BorderLayout.SOUTH);
        }

        class ConvertListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {
                //zmiany wyglądu wywołujemy w wątku dystrybucji zdarzeń
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        String text = textArea.getText();
                        editorPane.setText(text);
                        editorPane.revalidate();
                    }
                });
            }
        }
    }
    public class LoginListener implements ActionListener {
        //Główna ramka programu
        private final JFrame frame;
        //Panel logowania, potrzebny do pobrania loginu i hasła
        private LoginPanel loginPanel;

        public void setPanel(LoginPanel loginPanel) {
            this.loginPanel = loginPanel;
        }

        public LoginListener(JFrame frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            String name = loginPanel.getName();
            String password = loginPanel.getPassword();
            if (UserValidator.authenticate(name, password)) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // panel z edytorem html
                        JPanel htmlPanel = new HTMLPanel();
                        // usuwamy panel logowania
                        frame.getContentPane().removeAll();
                        // dodajemy panel html i odświeżamy widok
                        frame.add(htmlPanel);
                        frame.validate();
                    }
                });
            }
        }
    }
    public class LoginPanel extends JPanel {
        private JTextField nameField; //pole na nazwę
        private JPasswordField passField; //pole na hasło
        private JButton loginButton; //przycisk logowania
        private LoginListener listener; //słuchacz przycisku

        /**
         * @return wprowadzona nazwa użytkownika
         */
        public String getName() {
            return nameField.getText();
        }

        /**
         * @return wprowadzone przez użytkownika hasło
         */
        public String getPassword() {
            String password = "";
            char[] pass = passField.getPassword();
            for(int i=0; i<pass.length; i++) {
                password += pass[i];
            }
            return password;
        }

        public LoginPanel(LoginListener listener) {
            super();
            // ustawiamy layout
            GridBagLayout gridBag = new GridBagLayout();
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.CENTER;
            gridBag.setConstraints(this, constraints);
            setLayout(gridBag);
            // tworzymy komponenty logowania
            this.listener = listener;
            this.listener.setPanel(this);
            createComponents();
        }

        /**
         * Metoda, która tworzy etykiety i pola do wprowadzania danych.
         */
        private void createComponents() {
            JLabel name = new JLabel("Name: ");
            JLabel password = new JLabel("Password: ");
            nameField = new JTextField();
            passField = new JPasswordField();

            //pomocniczy panel do wprowadzania danych
            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new GridLayout(2, 2));
            inputPanel.add(name);
            inputPanel.add(nameField);
            inputPanel.add(password);
            inputPanel.add(passField);
            //tworzymy przycisk logowania
            loginButton = new JButton("Zaloguj");
            loginButton.addActionListener(listener);

            //pomocniczy panel do wyśrodkowania elementów
            JPanel parentPanel = new JPanel();
            parentPanel.setLayout(new BorderLayout());
            parentPanel.add(inputPanel, BorderLayout.CENTER);
            parentPanel.add(loginButton, BorderLayout.SOUTH);

            // dodajemy do głównego panelu
            this.add(parentPanel);
        }
    }

}