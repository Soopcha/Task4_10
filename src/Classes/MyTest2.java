package Classes;

import java.util.*;

public class MyTest2 {


    public static void main(String[] args) {
        String text = "Пример текста, который мы будем использовать, кт кт кт кт кт пр пр  к т. 45 45 45 5р 7г ";

        // Удаляем цифры из текста
        text = text.replaceAll("\\d+", " ");

        String[] words = text.split("[(\\s\\p{Punct})&&\\d]+"); // разделяем текст по пробелам и знакам препинания
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
        System.out.println(pairsStr2);
    }


}
