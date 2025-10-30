package myJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WordsUtil {

    private final Set<String> dictionary = new HashSet<>();

    public WordsUtil() {
        try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                dictionary.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    public Set<String> getDictionary() {
        return dictionary;
    }
}
