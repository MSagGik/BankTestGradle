import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {
    // тестирование функции расчёта серии номиналов купюр для выдачи
    @ParameterizedTest
    @CsvSource({"1000,1,0,0", "100,0,1,0","50,0,0,1", // случаи, когда терминал должен выдать одну купюру
            "2500,2,5,0", "3550,3,7,1", "250,0,1,1"}) // случаи, когда терминал должен выдать несколько купюр
    public void testATMCorrect(int amount, int t_1000, int t_100, int t_50) {
        int[] moneyFromATM = ATM.count_money(amount);
        assertEquals(t_1000, moneyFromATM[0]);
        assertEquals(t_100, moneyFromATM[1]);
        assertEquals(t_50, moneyFromATM[2]);
    }

    // тестирование функции расчёта не возможности выдачи всей суммы
    @ParameterizedTest
    @ValueSource(ints = {55, 35000})
    public void testATMNull(int amount) {
        int[] moneyFromATM = ATM.count_money(amount);
        assertNull(moneyFromATM);
    }
}