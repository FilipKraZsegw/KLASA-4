public class Main {
    public static void main(String[] args) {

        /*
        KwadratModel model = new KwadratModel();
        KwadratView view = new KwadratView();
        KwadratController controller = new KwadratController(model, view);
        */

        new ZadanieController(new ZadanieModel(), new ZadanieView());
    }
}
