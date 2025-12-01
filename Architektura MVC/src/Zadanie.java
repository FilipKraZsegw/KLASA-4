public class Zadanie {
    private int id;
    private String tresc;
    private boolean wykonane;

    public Zadanie(int id, String tresc, boolean wykonane) {
        this.id = id;
        this.tresc = tresc;
        this.wykonane = wykonane;
    }

    public int getId() { return id; }
    public String getTresc() { return tresc; }
    public boolean isWykonane() { return wykonane; }

    @Override
    public String toString() {
        return (wykonane ? "[X] " : "[ ] ") + tresc;
    }
}
