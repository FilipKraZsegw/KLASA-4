public class UzytkownikModel {

    public boolean walidujLogowanie(String user, String pass) {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {}

        return "admin".equals(user) && "haslo123".equals(pass);
    }
}
