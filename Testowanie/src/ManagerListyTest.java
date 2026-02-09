import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerListyTest {

    private ManagerListy managerListy;

    @BeforeEach
    void setUp() {
        managerListy = new ManagerListy();
    }

    @Test
    void testPustaListaNaPoczatku() {
        int rozmiar = managerListy.pobierzRozmiar();

        assertEquals(0, rozmiar, "Lista powinna być pusta na początku");
    }

    @Test
    void testDodajElementPoprawnie() {
        managerListy.dodajElement("Pierwszy");
        managerListy.dodajElement("Drugi");
        managerListy.dodajElement("Trzeci");

        int rozmiar = managerListy.pobierzRozmiar();

        assertEquals(3, rozmiar, "Po dodaniu 3 elementów rozmiar listy powinien wynosić 3");
    }
}
