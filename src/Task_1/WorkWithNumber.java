package Task_1;

//Создать программу, которая будет сообщать, является ли целое число, введенное пользователем, чётным или нечётным, простым или составным.
// Если пользователь введёт не целое число, то сообщать ему об ошибке.

import java.util.InputMismatchException;
import java.util.Scanner;

public class WorkWithNumber {

    public static void main(String[] args) {
        int number;
        boolean status = false;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите целое число:");
                number = scanner.nextInt();
                parityOfNumber(number);
                simpleOrCompositeNumber(number);
                status = true;
            } catch (InputMismatchException e) {
                System.out.println("Неверно введено число!");
            }
        } while (!status);
    }

    public static void parityOfNumber (int number) {
        if (number % 2 == 0)
            System.out.println("Число " + number + " является четным.");
        else
            System.out.println("Число " + number + " является нечетным.");
    }

    public static void simpleOrCompositeNumber (int number) {
        boolean simple = true;

        if (number == 1 || number == -1 || number == 0) {
            System.out.println("Число не является ни простым ни составным.");
        } else {
            for (int i = 2; i <= Math.sqrt(Math.abs(number)); i++) {
                if (number % i == 0) {
                    simple = false;
                    break;
                }
            }

            if (simple)
                System.out.println("Число " + number + " является простым.");
            else
                System.out.println("Число " + number + " является составным.");
        }
    }
}
