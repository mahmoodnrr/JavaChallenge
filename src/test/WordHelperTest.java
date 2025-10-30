package test;

import myJava.WordHelper;
import myJava.WordsUtil;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class WordHelperTest {

    private final Set<String> MY_DICTIONARY = new WordsUtil().getDictionary();

    @Test
    public void checkInputs_whenLengthIsZero_returnsFalse()
    {
        boolean result = WordHelper.checkInputsAreEmpty(0, "eeeeddoonnnsssrv");
        assertFalse(result, "Should be false when word length is zero");
    }

    @Test
    public void checkInputs_whenLengthIsNotZero_returnsTrue()
    {
        boolean result = WordHelper.checkInputsAreEmpty(4, "eeeeddoonnnsssrv");
        assertTrue(result, "Should be true when word length is bigger than zero");
    }

    @Test
    public void checkInputs_whenStringIsEmpty_returnsFalse()
    {
        boolean result = WordHelper.checkInputsAreEmpty(4, "");
        assertFalse(result, "Should be false when letters string is empty");
    }

    @Test
    public void checkInputs_whenStringIsNotEmpty_returnsTrue()
    {
        boolean result = WordHelper.checkInputsAreEmpty(4, "eeeeddoonnnsssrv");
        assertTrue(result, "Should be true when letters string is not empty");
    }

    @Test
    public void checkInputIsWordSquare_4x4_returnsTrue()
    {
        boolean result = WordHelper.findValidWordList(MY_DICTIONARY, 4, "aaccdeeeemmnnnoo");
        assertTrue(result, "Should be true when word square is found");
    }

    @Test
    public void checkInputIsWordSquare_5x5_returnsTrue()
    {
        boolean result = WordHelper.findValidWordList(MY_DICTIONARY, 5, "aaaeeeefhhmoonssrrrrttttw");
        assertTrue(result, "Should be true when word square is found");
    }

    @Test
    public void checkInputIsWordSquare2_5x5_returnsTrue()
    {
        boolean result = WordHelper.findValidWordList(MY_DICTIONARY, 5, "aabbeeeeeeeehmosrrrruttvv");
        assertTrue(result, "Should be true when word square is found");
    }

    @Test
    public void checkInputIsWordSquare_7x7_returnsTrue()
    {
        boolean result = WordHelper.findValidWordList(MY_DICTIONARY, 7, "aaaaaaaaabbeeeeeeedddddggmmlloooonnssssrrrruvvyyy");
        assertTrue(result, "Should be true when word square is found");
    }

    @Test
    public void checkInputIsWordSquare_whenNoWordsFound_returnsFalse()
    {
        boolean result = WordHelper.findValidWordList(MY_DICTIONARY, 4, "aacceeeemmnnnoo");
        assertFalse(result, "Should be false when word square is not found");
    }
}
