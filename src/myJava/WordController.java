package myJava;

import java.util.Set;

public class WordController {

    private int wordLength;
    private String letters;

    public WordController(int wordLength, String letters, Set<String> dictionary)
    {
        this.wordLength = wordLength;
        this.letters = letters;

        findWords(dictionary);
    }

    public String getLetters()
    {
        return letters;
    }
    public int getWordLength()
    {
        return wordLength;
    }

    private boolean validateInputs()
    {
        return WordHelper.checkInputsAreEmpty(wordLength, letters);
    }

    private boolean findWords(Set<String> dictionary)
    {
        if(!validateInputs()) return false;

        return WordHelper.findValidWordList(dictionary, wordLength, letters);
    }


}