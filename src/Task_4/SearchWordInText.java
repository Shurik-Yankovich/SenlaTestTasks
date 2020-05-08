package Task_4;

//Создать программу, которая подсчитывает сколько раз употребляется слово в тексте (без учета регистра).
//Текст и слово вводится вручную.

import java.util.Scanner;

public class SearchWordInText {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;
        String word;

        System.out.println("Введите текст:");
        text = scanner.nextLine();
        System.out.println("Введите слово для поиска:");
        word = scanner.nextLine();

        howMuchThisWordInTheText(word.toLowerCase(), text.toLowerCase());
    }

    public static void howMuchThisWordInTheText(String word, String text){
        int countNotStrictMatch;
        int countStrictMatch;
        countNotStrictMatch = notStrictWordMatchInText(word, text);
        System.out.println(String.format("В тексте:\n%s\nне строгих совпадений слова %s найдено %d.", text, word, countNotStrictMatch));
        countStrictMatch = strictWordMatchInText(word, text);
        System.out.println(String.format("В тексте:\n%s\nстрогих совпадений слова %s найдено %d.", text, word, countStrictMatch));
    }

    public static int notStrictWordMatchInText(String word, String text) {
        int count;
        count = text.split(word, -1).length - 1;
        return count;
    }

    public static int strictWordMatchInText(String word, String text) {
        int count = 0;
        String[] words = text.split(" ");
        for (String wordInText : words) {
            if (word.equals(wordInText))
                count++;
        }
        return count;
    }
}
