import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ZadanieController {

    private ZadanieModel model;
    private ZadanieView view;

    public ZadanieController(ZadanieModel model, ZadanieView view) {
        this.model = model;
        this.view = view;

        view.addDodajListener(new DodajListener());
        view.addUsunListener(new UsunListener());

        odswiezListe();
    }

    private void odswiezListe() {
        try {
            view.wyczyscListe();
            for (Zadanie z : model.pobierzWszystkieZadania()) {
                view.dodajDoListy(z);
            }
        } catch (SQLException e) {
            view.wyswietlBlad("Błąd pobierania danych!");
        }
    }

    class DodajListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tresc = view.getNowaTresc();
            if (tresc.isEmpty()) {
                view.wyswietlBlad("Treść zadania nie może być pusta!");
                return;
            }
            try {
                model.dodajZadanie(tresc);
                odswiezListe();
            } catch (SQLException ex) {
                view.wyswietlBlad("Błąd dodawania zadania!");
            }
        }
    }

    class UsunListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Zadanie z = view.getWybraneZadanie();
            if (z == null) {
                view.wyswietlBlad("Wybierz zadanie do usunięcia!");
                return;
            }
            try {
                model.usunZadanie(z.getId());
                odswiezListe();
            } catch (SQLException ex) {
                view.wyswietlBlad("Błąd usuwania zadania!");
            }
        }
    }
}
