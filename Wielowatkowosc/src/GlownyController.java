import javax.swing.*;

public class GlownyController {

    private final UzytkownikModel model;
    private final GlownyView view;

    public GlownyController(UzytkownikModel model, GlownyView view) {
        this.model = model;
        this.view = view;

        view.getLoginButton().addActionListener(e -> zaloguj());
    }

    private void zaloguj() {

        String login = view.getLogin();
        String haslo = view.getHaslo();

        SwingWorker<Boolean, Void> worker = new SwingWorker<>() {

            @Override
            protected Boolean doInBackground() {

                view.getLoginButton().setEnabled(false);
                view.ustawStatus("Trwa weryfikacja danych...");

                return model.walidujLogowanie(login, haslo);
            }

            @Override
            protected void done() {
                view.getLoginButton().setEnabled(true);

                try {
                    boolean poprawne = get();

                    if (poprawne) {
                        view.ustawStatus("Logowanie pomyślne!");
                    } else {
                        view.ustawStatus("Błędny login lub hasło!");
                    }

                } catch (Exception e) {
                    view.ustawStatus("Błąd logowania: " + e.getMessage());
                }
            }
        };

        worker.execute();
    }
}
