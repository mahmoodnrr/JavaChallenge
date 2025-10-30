package myJava;

import java.util.Set;

public class WordController {

    private final int wordLength;
    private final String letters;

    public WordController(int wordLength, String letters, Set<String> dictionary)
    {
        this.wordLength = wordLength;
        this.letters = letters;

        findWords(dictionary);
    }

    /**
     * Validates Inputs
     * @return boolean
     */
    private boolean validateInputs()
    {
        return WordHelper.checkInputsAreEmpty(wordLength, letters);
    }

    /**
     * Find valid English words from a set of letters.
     * @return boolean
     */
    private boolean findWords(Set<String> dictionary)
    {
        if(!validateInputs()){
            System.out.println("Invalid inputs.");
            return false;
        }

        return WordHelper.findValidWordList(dictionary, wordLength, letters);
    }


}