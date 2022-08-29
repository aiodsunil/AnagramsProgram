import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AnagramsProgramTest {

    @Test
    void groupByAnagrams() {
        var words= Arrays.asList("abc","cba","bac","hi","ih");
         assertEquals(3,AnagramsProgram.groupByAnagrams(words).get("abc").size());
    }

    @Test
    void sortWord() {
        assertEquals("abc",AnagramsProgram.sortWord("cab"));
    }

    @Test
    void readWordsFromFile() throws IOException {
        var listOfWords=AnagramsProgram.readWordsFromFile("test.txt");
        assertNotNull(listOfWords);
        assertEquals(3,AnagramsProgram.groupByAnagrams(listOfWords).get("abc").size());

    }
}