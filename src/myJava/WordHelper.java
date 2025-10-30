package myJava;

import java.util.ArrayList;
import java.util.Set;

public class WordHelper {

    private static boolean foundWords = false;

    public static boolean checkInputsAreEmpty(int wordLength, String letters) {
        return wordLength > 0 && !letters.isEmpty();
    }

    /**
     * This method takes a dictionary (list of valid English words), a word length and a set of letters.
     * It checks if we have enough letters to form a word from the given set of letters.
     * If a valid square word is formed returns true, otherwise false
     * param {Set<String>, int, String}
     * @return boolean
     */
    public static boolean findValidWordList(Set<String> dictionary, int wordLength, String letters) {

        buildValidWordList(extractValidWords(dictionary, wordLength), wordLength, new StringBuilder(letters), new ArrayList<>());

        if(!foundWords) System.out.println("There are no valid words");
        return foundWords;
    }

    /**
     * This method searches each word in the dictionary and checks if there are enough letters to form it.
     * The search uses recursion to check every possible outcome.
     * param {Set<String>, int, StringBuilder, String}
     */
    private static void buildValidWordList(ArrayList<String> dictionary, int wordLength, StringBuilder letters, ArrayList<String> wordList) {

        // If our word list size matches n (word length, then we have formed a word square
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

    /**
     * This method handles removing letters from the given set of letters
     * so that we track remaining letters.
     * param {StringBuilder, String}
     * @return ArrayList<Character>
     */
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

    /**
     * This method handles prefixing so that the next search looks for a word starting with
     * letter(s) of previous word(s)
     * param {ArrayList<String>, int}
     * @return ArrayList<String>
     */
    private static String prefixBuilder(ArrayList<String> wordList, int WordListSize) {
        StringBuilder prefix = new StringBuilder();

        // Get prefix from the current words in the list
        for(String word : wordList) {
            prefix.append(word.charAt(WordListSize));
        }
        return prefix.toString();
    }

    /**
     * This method checks if current word can be formed from the given set of letters
     * param {String, StringBuilder}
     * @return boolean
     */
    private static boolean canFormWord(String word, StringBuilder letters) {
        // Check each letter exists in the pool
        for(char c : word.toCharArray()) {
            if(letters.indexOf(String.valueOf(c)) == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method extracts words that match the word length provided in the input
     * param {Set<String>, int}
     * @return ArrayList<String>
     */
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
