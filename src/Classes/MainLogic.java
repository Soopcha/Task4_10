package Classes;
//28. даши Выбрать из текста все слова, в которых встречаются, как русские, так и
//        латинские буквы. Словом считается непрерывная последовательность символов (строчных и
//        прописных) А-Я, A-Z и цифр.

/*
4 таск
10. Реализовать программу, которая для произвольного текста (любого размера) построит
список из паросочетаний букв (2 буквы, которые стоят в слове друг за другом),
упорядочив их в порядке встречаемости от наиболее встречающихся комбинаций к
менее встречающимся.
 */


import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class MainLogic {
    public static String getAnswerCombinationsOfPairs(String str) {

        str = str.replaceAll("\\d+", " "); // Заменяем цифры из текста на пробельчики

        String[] words = str.split("[\\s\\p{Punct}]+"); // разделяем текст по пробелам и знакам препинания
        //Через \p{} обозначаются символьные классы. в данном случае это всякие *-/) и тд
        List<String> pairs = new ArrayList<String>();

        for (String word : words) {
            for (int i = 0; i < word.length() - 1; i++) {
                String pair = word.substring(i, i + 2);
                if (!pair.contains(" ")) {
                    pairs.add(pair);
                }
            }
        }


        // Создаем список паросочетаний букв
        Map<String, Integer> frequency = new HashMap<>();
        for (int i = 0; i < pairs.size(); i++) {
            frequency.put(pairs.get(i), frequency.getOrDefault(pairs.get(i), 0) + 1);
        }

        /*// Сортируем список паросочетаний по частоте встречаемости
        List<Map.Entry<String, Integer>> sortedPairs = new ArrayList<>(pairsWithFrequency.entrySet());
        sortedPairs.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
         */

        // Сортируем список паросочетаний пузырьком по частоте встречаемости
        List<Map.Entry<String, Integer>> sortedPairs = new ArrayList<>(frequency.entrySet());
        for (int i = 0; i < sortedPairs.size() - 1; i++) {
            for (int j = i + 1; j < sortedPairs.size(); j++) {
                if (sortedPairs.get(i).getValue() < sortedPairs.get(j).getValue()) {
                    Collections.swap(sortedPairs, i, j);
                }
            }
        }

        String pairsStr = null;
        // Выводим список паросочетаний на экран
        for (Map.Entry<String, Integer> pair : sortedPairs) {
            System.out.println(pair.getKey() + ": " + pair.getValue());
            pairsStr += pair.getKey() + " ";
        }
        String pairsStr2 = pairsStr.substring(4); // а то чёт null выводится зараза в начале
        return pairsStr2;
    }

    //    .\input.txt .\output.txt
    public static void readAndWriteMethod(InputArgs inputArgs) throws IOException {
        String str = ClassesForInAndOut.readFile(inputArgs.getInputFile());
        String answer = MainLogic.getAnswerCombinationsOfPairs(str);
        ClassesForInAndOut.writeFile(inputArgs.getOutputFile(), answer);
    }

    public static void printSuccessMessage(int num) {
        if (num == 0) {
            System.out.println("Основная программа выполнена.");
        } else {
            System.out.println("Тест " + num + " выполнен успешно.");
        }
        System.out.println();
    }
}
