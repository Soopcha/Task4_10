package Classes;

import java.util.ArrayList;
import java.util.List;


public class Mytest {

    public static void main(String[] args) {
        String text = "это текст из нескольких слов, с точками и запятыми; и еще со скобками (вот так)";

        String[] words = text.split("[\\s\\p{Punct}]+"); // разделяем текст по пробелам и знакам препинания
        List<String> pairs = new ArrayList<String>();

        for (String word : words) {
            for (int i = 0; i < word.length() - 1; i++) {
                String pair = word.substring(i, i + 2);
                if (!pair.contains(" ")) {
                    pairs.add(pair);
                }
            }
        }

        System.out.println(pairs);
    }
}


