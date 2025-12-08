public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            /*
            new MainFrame().setVisible(true);
            */
            UzytkownikModel model = new UzytkownikModel();
            GlownyView view = new GlownyView();
            GlownyController controller = new GlownyController(model, view);

            view.setVisible(true);
        });
    }
}
