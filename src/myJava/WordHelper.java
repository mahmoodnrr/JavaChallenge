package myJava;

import java.util.ArrayList;
import java.util.Set;

public class WordHelper {

    private static boolean foundWords = false;

    public static boolean checkInputsAreEmpty(int wordLength, String letters) {
        return wordLength > 0 && !letters.isEmpty();
    }

    public static boolean findValidWordList(Set<String> dictionary, int wordLength, String letters) {

        StringBuilder letterList = new StringBuilder(letters);
        ArrayList<String> dictionaryList = extractValidWords(dictionary, wordLength);
        ArrayList<String> wordList = new ArrayList<>();

        buildValidWordList(dictionaryList, wordLength, letterList, wordList);

        if(!foundWords) System.out.println("There are no valid words");
        return foundWords;
    }

    private static void buildValidWordList(ArrayList<String> dictionary, int wordLength, StringBuilder letters, ArrayList<String> wordList) {

        if(wordList.size() == wordLength) {
            foundWords = true;
            System.out.println("Word square found: " + wordList);

            for(String s : wordList) {
                System.out.println(s);
            }
            return;
        }

        // Build prefix for next word; by default empty if first word
        String prefix = wordList.isEmpty() ? "" : prefixBuilder(wordList, wordList.size());

        for (String word : dictionary) {

            if (foundWords) return;

            if(wordList.size() == wordLength) break;

            if(!word.startsWith(prefix)) continue;
            if(!canFormWord(word, letters)) continue;

            // Add word to list
            wordList.add(word);

            // Remove letters from list for recursion
            ArrayList<Character> removedLetters = handleRemovingLetters(letters, word);
            //System.out.println("Remaining letters: " + removedLetters);

            // Recurse
            buildValidWordList(dictionary, wordLength, letters, wordList);

            // empty current word from list and restore letters
            wordList.remove(wordList.size() - 1);

            for(char c : removedLetters) {
                letters.append(c);
            }
        }
    }

    private static ArrayList<Character> handleRemovingLetters(StringBuilder letters, String word)
    {
        ArrayList<Character> removedLetters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            int index = letters.indexOf(String.valueOf(c));
            if (index != -1) {
                letters.deleteCharAt(index);
                removedLetters.add(c);
            }
        }
        return removedLetters;
    }

    private static String prefixBuilder(ArrayList<String> wordList, int WordListSize) {
        StringBuilder prefix = new StringBuilder();

        for(String word : wordList) {
            prefix.append(word.charAt(WordListSize));
        }
        return prefix.toString();
    }

    private static boolean canFormWord(String word, StringBuilder letters) {
        // Check each letter exists in the pool
        for(char c : word.toCharArray()) {
            if(letters.indexOf(String.valueOf(c)) == -1) {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<String> extractValidWords(Set<String> dictionary, int wordLength) {
        ArrayList<String> wordList = new ArrayList<>();
        for(String word : dictionary) {
            if(word.length() == wordLength) {
                wordList.add(word);
            }
        }
        return wordList;
    }
}
