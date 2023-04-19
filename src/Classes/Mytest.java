package Classes;

import java.util.ArrayList;
import java.util.List;

public class Mytest {


    public static void main(String[] args) {
        String text = "Пример текста, который мы будем использовать.";

        // Удаляем пробелы и другие знаки из текста
        String cleanedText = text.replaceAll("[^a-zA-Zа-яА-Я]", "");

        // Создаем список пар символов
        List<String> pairs = new ArrayList<>();
        for (int i = 0; i < cleanedText.length() - 1; i++) {
            String pair = "" + cleanedText.charAt(i) + cleanedText.charAt(i + 1);
            pairs.add(pair);
        }

        // Выводим список пар символов на экран
        for (String pair : pairs) {
            System.out.println(pair);
        }
    }


}
