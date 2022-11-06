import java.util.Scanner;

/**
 * решение задачи расчёта серии купюр для выдачи запрошенной суммы в банковском терминале
 */
public class ATM {
    public static void main(String[] args) {
        int sum;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму");
        sum = scanner.nextInt();
        int[] money = count_money(sum);
        if (money == null) {
            System.out.println("Данную сумму терминал выдать не может");
        }
        else {
            System.out.println("Выдать купюры 1000 " + money[0] + "\nкупюры 100 " + money[1] + "\nкупюры 50 " + money[2]);
        }
    }
    // функция расчёта серии номиналов купюр для выдачи
    public static int[] count_money(int sum) {
        // наличие количества купюр в терминале
        int b50 = 2;
        int b100 = 50;
        int b1000 = 10;
        // нулевая инициализация выдачи
        int k50 = 0, k100 = 0, k1000 = 0;
        // расчёт выдачи купюр номиналом 1000
        while(b1000 > 0 && sum >= 1000) {
            k1000++;
            b1000--;
            sum -= 1000;
        }
        // расчёт выдачи купюр номиналом 100
        while(b100 > 0 && sum >= 100) {
            k100++;
            b100--;
            sum -= 100;
        }
        // расчёт выдачи купюр номиналом 50
        while(b50 > 0 && sum >= 50) {
            k50++;
            b50--;
            sum -= 50;
        }
        // просмотр остатка для выдачи
        if (sum > 0) { // если не вся, возвращаем null
            return null;
        }
        // сумма может быть выдана полностью
        int[] money = {k1000, k100, k50};
        return money;
    }
}
