package Task_5;

//Создать программу, которая в последовательности от 0 до N, находит все числа-палиндромы (зеркальное значение равно оригинальному).
//Длина последовательности N вводится вручную и не должна превышать 100.

import java.util.Scanner;

public class SearchPalindromes {

    private static final int MAXIMUM_SEQUENCE_LIMIT = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxNumber;
        boolean status;
        do {
            System.out.println(String.format("Введите число окончания последовательности чисел (не более %d):", MAXIMUM_SEQUENCE_LIMIT));
            maxNumber = scanner.nextInt();
            if (maxNumber > MAXIMUM_SEQUENCE_LIMIT || maxNumber <= 0) {
                System.out.println("Неверно введено максимальное значение последовательности!");
                status = false;
            } else
                status = true;
        } while (!status);
        printPalindromes(maxNumber);
    }

    public static void printPalindromes(int maxNumber) {
        System.out.println(String.format("В последовательности [0; %d] палиндромами являются числа:", maxNumber));
        for (int i = 0; i < maxNumber + 1; i++) {
            if (i < 10) {
                System.out.println(i);
            } else if (i == reverseNumber(i)) {
                System.out.println(i);
            }
        }
    }

    private static int reverseNumber(int number) {
        int reverse = 0;
        do {
            reverse = reverse * 10 + number % 10;
            number /= 10;
        } while (number >= 10);
        return reverse * 10 + number;
    }
}
