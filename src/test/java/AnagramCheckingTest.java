import com.student_work.AnagramChecking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Assignment 3 examples.
 * ONLY tests Example 1 and Example 2 from the README.
 */
class AnagramCheckingExamplesTest {

    /**
     * Example 1:
     * "Eleven plus two" vs "Twelve PLUS one"
     * Expected counts:
     * [0,0,0,0,3,0,0,0,0,0,0,2,0,1,1,1,0,0,1,1,1,1,1,0,0,0]
     */
    @Test
    void example1_elevenPlusTwo_vs_twelvePlusOne() {
        String s1 = "Eleven plus two";
        String s2 = "Twelve PLUS one";

        int[] expected = {0,0,0,0,3,0,0,0,0,0,0,2,0,1,1,1,0,0,1,1,1,1,1,0,0,0};

        int[] c1 = new int[26];
        int[] c2 = new int[26];
        AnagramChecking.getCountsOfAlphabets(s1, c1);
        AnagramChecking.getCountsOfAlphabets(s2, c2);

        assertArrayEquals(expected, c1, "Example 1: counts for first string mismatch");
        assertArrayEquals(expected, c2, "Example 1: counts for second string mismatch");

        assertTrue(AnagramChecking.nonRecursiveCountCheck(c1, c2),
                "Example 1: non-recursive check should be true");
        assertTrue(AnagramChecking.recursiveCountCheck(c1, c2, 0),
                "Example 1: recursive check should be true");
    }

    /**
     * Example 2:
     * "Rats and mice" vs "In cat’s dream"
     * (uses curly apostrophe U+2019 in “cat’s”)
     * Expected counts:
     * [2,0,1,1,1,0,0,0,1,0,0,0,1,1,0,0,0,1,1,1,0,0,0,0,0,0]
     */
    @Test
    void example2_ratsAndMice_vs_inCatsDream() {
        String s1 = "Rats and mice";
        String s2 = "In cat's dream"; // U+2019

        int[] expected = {2,0,1,1,1,0,0,0,1,0,0,0,1,1,0,0,0,1,1,1,0,0,0,0,0,0};

        int[] c1 = new int[26];
        int[] c2 = new int[26];
        AnagramChecking.getCountsOfAlphabets(s1, c1);
        AnagramChecking.getCountsOfAlphabets(s2, c2);

        assertArrayEquals(expected, c1, "Example 2: counts for first string mismatch");
        assertArrayEquals(expected, c2, "Example 2: counts for second string mismatch");

        assertTrue(AnagramChecking.nonRecursiveCountCheck(c1, c2),
                "Example 2: non-recursive check should be true");
        assertTrue(AnagramChecking.recursiveCountCheck(c1, c2, 0),
                "Example 2: recursive check should be true");
    }
}
