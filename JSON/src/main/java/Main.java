public class Main {
    public static void main(String[] args) {
        new MainFrame();
    }
}

// Odpowiedzi na pytania
// 1.Dlaczego format JSON jest lepszy od zwykłego pliku tekstowego .txt przy zapisywaniu obiektów?
// Ponieważ przechowuje dane w formie klucz-wartość więc są łatwe do odczytania i jest powrzechnie używany przez programistów

// 2.Co się stanie, jeśli w klasie Student zabraknie pustego konstruktora podczas próby deserializacji przez bibliotekę Jackson?
// Jackson nie będzie mógł utworzyć objektu podczas deserializacji

//3. Do czego służy słowo kluczowe transient w kontekście serializacji?
//  Jest używany do np. haseł żeby nie był zapisywane do pliku JSON oraz do plików tymczasowych