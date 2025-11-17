public class Product {
    private String nazwa;
    private double cena;
    private int ilosc;

    public Product(String nazwa, double cena, int ilosc) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.ilosc = ilosc;
    }

    public String getNazwa() { return nazwa; }
    public double getCena() { return cena; }
    public int getIlosc() { return ilosc; }
}
