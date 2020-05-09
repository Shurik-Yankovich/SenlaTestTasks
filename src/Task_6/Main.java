package Task_6;

//Имеется набор вещей, которые необходимо поместить в рюкзак. Рюкзак обладает заданной грузоподъемностью.
//Вещи в свою очередь обладают двумя параметрами — весом и стоимостью.
//Цель задачи заполнить рюкзак не превысив его грузоподъемность и максимизировать суммарную ценность груза.

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вместимость рюкзака:");
        Backpack backpack = new Backpack(scanner.nextInt());
        System.out.println("Введите кол-во вещей:");
        Thing[] things = menu(scanner.nextInt());

        System.out.println("Список вещей:");
        for (Thing thing : things) {
            System.out.println(thing.toString());
        }

        backpack.fillingBackpack(things);
        System.out.println(backpack.toString());
    }

    public static Thing[] menu(int count) {
        int choice;
        boolean status;
        Thing[] things = new Thing[count];
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Выбирите как заполнить данные по набору вещей:\n1 - случайными данными в заданном диапазоне\n2 - заполнить вручную");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    double minCost, maxCost;
                    int minWeight, maxWeight;
                    Random random = new Random(System.currentTimeMillis());
                    System.out.println("Введите диапазон цены (от .. до):");
                    minCost = scanner.nextDouble();
                    maxCost = scanner.nextDouble();
                    System.out.println("Введите диапазон веса (от .. до):");
                    minWeight = scanner.nextInt();
                    maxWeight = scanner.nextInt();
                    for (int i = 0; i < things.length; i++) {
                        things[i] = new Thing(i + 1, minWeight + random.nextInt(maxWeight - minWeight), minCost + random.nextDouble() * (maxCost - minCost));
                    }
                    status = true;
                    break;
                case 2:
                    for (int i = 0; i < things.length; i++) {
                        System.out.println("Введите вес вещи и его стоимость:");
                        things[i] = new Thing(i + 1, scanner.nextInt(), scanner.nextDouble());
                    }
                    status = true;
                    break;
                default:
                    System.out.println("Неверно выбран пункт меню!");
                    status = false;
            }
        } while (!status);

        return things;
    }
}
