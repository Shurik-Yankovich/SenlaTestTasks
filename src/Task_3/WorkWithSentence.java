package Task_3;

//Создать программу, которая будет:
//- подсчитывать количество слов в предложении
//- выводить их в отсортированном виде
//- делать первую букву каждого слова заглавной.
//Предложение вводится вручную. (Разделитель пробел (“ ”)).

import java.util.Scanner;

public class WorkWithSentence {

    public static void main(String[] args) {
        String sentence;
        String[] words;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите предложение:");
        sentence = scanner.nextLine();

        howMuchWordsInSentence(sentence);
        printSortingWords(sentence);
        sentence = toUpperCaseTheFirstLetterWordsInSentence(sentence);
        System.out.println("Предложение с заглавной буквой каждого слова:");
        System.out.println(sentence);

    }

    public static void howMuchWordsInSentence(String sentence) {
        int countWords;
        countWords = sentence.split(" ").length;
        System.out.print("Количество слов в предложении: " + countWords + "\n");
    }

    public static void printSortingWords(String sentence) {
        String[] words;
        words = sentence.split(" ");

        sortWords(words);

        System.out.println("Предложение в отсортированном виде: ");
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();
    }

    private static void sortWords(String[] words) {
        String word;
        for (int i = 1; i < words.length; i++) {
            if (words[i].compareToIgnoreCase(words[i - 1]) < 0) {
                word = words[i];
                words[i] = words[i - 1];
                words[i - 1] = word;
                i = 0;
            }
        }
    }

    public static String toUpperCaseTheFirstLetterWordsInSentence(String sentence) {
        String resultSentence = "";
        String[] words = sentence.split(" ");
        for (String word : words) {
            resultSentence += toUpperCaseTheFirstLetterInWord(word) + " ";
        }
        return resultSentence.substring(0, resultSentence.length() - 1);
    }

    private static String toUpperCaseTheFirstLetterInWord(String word) {
        if (word.length() > 1) {
            String symbol = word.substring(0, 1).toUpperCase();
            word = symbol + word.substring(1);
        }
        else
            word = word.toUpperCase();
        return word;
    }
}
