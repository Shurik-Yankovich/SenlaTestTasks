package Task_2;

//Создать программу, которая будет вычислять и выводить на экран НОК (наименьшее общее кратное)
//и НОД (наибольший общий делитель) двух целых чисел, введенных пользователем.
//Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int firstNumber;
        int secondNumber;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите два целых числа:");
            firstNumber = scanner.nextInt();
            secondNumber = scanner.nextInt();
            System.out.println("НОК чисел " + firstNumber + " и " + secondNumber + " равен " + leastCommonMultiple(firstNumber, secondNumber));
            System.out.println("НОД чисел " + firstNumber + " и " + secondNumber + " равен " + greatestCommonDivisor(firstNumber, secondNumber));
        } catch (InputMismatchException e) {
            System.out.println("Неверно введены числа!");
        } catch (ArithmeticException e) {
            System.out.println("Ноль не является корректным числом!");
        }
    }

    public static int leastCommonMultiple(int firstNumber, int secondNumber) {
        return Math.abs(firstNumber * secondNumber) / greatestCommonDivisor(firstNumber, secondNumber);
    }

    public static int greatestCommonDivisor(int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber)
            return euclideanAlgorithm(firstNumber, secondNumber);
        else
            return euclideanAlgorithm(secondNumber, firstNumber);
    }

    public static int euclideanAlgorithm(int bigNumber, int smallNumber) {
        int remainder = bigNumber % smallNumber;

        if (remainder > 0)
            return euclideanAlgorithm(smallNumber, remainder);
        else
            return Math.abs(smallNumber);
    }

}
