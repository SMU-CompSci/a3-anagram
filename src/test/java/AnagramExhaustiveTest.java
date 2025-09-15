import com.student_work.AnagramChecking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Exhaustive unit tests for AnagramChecking class.
 * Tests all methods with various edge cases, boundary conditions, and typical scenarios.
 */
class AnagramExhaustiveTest {

    private int[] counts1;
    private int[] counts2;

    @BeforeEach
    void setUp() {
        counts1 = new int[26];
        counts2 = new int[26];
    }

    // ==================== Tests for getCountsOfAlphabets ====================

    /**
     * Test basic functionality with simple lowercase string
     */
    @Test
    void testGetCountsOfAlphabets_simpleLowercase() {
        String input = "abc";
        int[] expected = new int[26];
        expected[0] = 1; // a
        expected[1] = 1; // b
        expected[2] = 1; // c

        AnagramChecking.getCountsOfAlphabets(input, counts1);
        assertArrayEquals(expected, counts1, "Simple lowercase string count mismatch");
    }

    /**
     * Test basic functionality with simple uppercase string
     */
    @Test
    void testGetCountsOfAlphabets_simpleUppercase() {
        String input = "ABC";
        int[] expected = new int[26];
        expected[0] = 1; // A -> a
        expected[1] = 1; // B -> b
        expected[2] = 1; // C -> c

        AnagramChecking.getCountsOfAlphabets(input, counts1);
        assertArrayEquals(expected, counts1, "Simple uppercase string count mismatch");
    }

    /**
     * Test mixed case handling
     */
    @Test
    void testGetCountsOfAlphabets_mixedCase() {
        String input = "AaBbCc";
        int[] expected = new int[26];
        expected[0] = 2; // A,a
        expected[1] = 2; // B,b
        expected[2] = 2; // C,c

        AnagramChecking.getCountsOfAlphabets(input, counts1);
        assertArrayEquals(expected, counts1, "Mixed case string count mismatch");
    }

    /**
     * Test handling of spaces
     */
    @Test
    void testGetCountsOfAlphabets_withSpaces() {
        String input = "a b c";
        int[] expected = new int[26];
        expected[0] = 1; // a
        expected[1] = 1; // b
        expected[2] = 1; // c

        AnagramChecking.getCountsOfAlphabets(input, counts1);
        assertArrayEquals(expected, counts1, "String with spaces count mismatch");
    }

    /**
     * Test handling of numbers
     */
    @Test
    void testGetCountsOfAlphabets_withNumbers() {
        String input = "a1b2c3";
        int[] expected = new int[26];
        expected[0] = 1; // a
        expected[1] = 1; // b
        expected[2] = 1; // c

        AnagramChecking.getCountsOfAlphabets(input, counts1);
        assertArrayEquals(expected, counts1, "String with numbers count mismatch");
    }

    /**
     * Test handling of special characters and punctuation
     */
    @Test
    void testGetCountsOfAlphabets_withSpecialChars() {
        String input = "a!b@c#d$e%f^g&h*i(j)k-l=m+n[o]p{q}r;s:t'u\"v,w.x/y?z~";
        int[] expected = new int[26];
        for (int i = 0; i < 26; i++) {
            expected[i] = 1;
        }

        AnagramChecking.getCountsOfAlphabets(input, counts1);
        assertArrayEquals(expected, counts1, "String with special characters count mismatch");
    }

    /**
     * Test repeated characters
     */
    @Test
    void testGetCountsOfAlphabets_repeatedChars() {
        String input = "aaaaabbbccd";
        int[] expected = new int[26];
        expected[0] = 5; // a
        expected[1] = 3; // b
        expected[2] = 2; // c
        expected[3] = 1; // d

        AnagramChecking.getCountsOfAlphabets(input, counts1);
        assertArrayEquals(expected, counts1, "Repeated characters count mismatch");
    }

    /**
     * Test string with only non-alphabetic characters
     */
    @Test
    void testGetCountsOfAlphabets_onlyNonAlpha() {
        String input = "123 !@# $%^ &*()";
        int[] expected = new int[26]; // All zeros

        AnagramChecking.getCountsOfAlphabets(input, counts1);
        assertArrayEquals(expected, counts1, "Non-alphabetic only string should produce all zeros");
    }

    /**
     * Test single character strings
     */
    @ParameterizedTest
    @ValueSource(strings = {"a", "A", "z", "Z"})
    void testGetCountsOfAlphabets_singleChar(String input) {
        int[] expected = new int[26];
        char c = Character.toLowerCase(input.charAt(0));
        expected[c - 'a'] = 1;

        AnagramChecking.getCountsOfAlphabets(input, counts1);
        assertArrayEquals(expected, counts1, "Single character count mismatch for: " + input);
    }

    /**
     * Test handling of Unicode characters (should be ignored)
     */
    @Test
    void testGetCountsOfAlphabets_unicodeChars() {
        String input = "café naïve résumé"; // Contains é, ï, é
        int[] expected = new int[26];
        expected[0] = 2; // a (2 times)
        expected[2] = 1; // c
        expected[4] = 1; // e
        expected[5] = 1; // f
        expected[12] = 1; // m
        expected[13] = 1; // n
        expected[17] = 1; // r
        expected[18] = 1; // s
        expected[20] = 1; // u
        expected[21] = 1; // v

        AnagramChecking.getCountsOfAlphabets(input, counts1);
        assertArrayEquals(expected, counts1, "Unicode characters should be ignored");
    }

    /**
     * Test the curly apostrophe case from Example 2
     */
    @Test
    void testGetCountsOfAlphabets_curlyApostrophe() {
        String input = "cat's"; // Using regular apostrophe
        String input2 = "cat's"; // Using curly apostrophe U+2019
        int[] expected = new int[26];
        expected[0] = 1; // a
        expected[2] = 1; // c
        expected[18] = 1; // s
        expected[19] = 1; // t

        AnagramChecking.getCountsOfAlphabets(input, counts1);
        AnagramChecking.getCountsOfAlphabets(input2, counts2);

        assertArrayEquals(expected, counts1, "Regular apostrophe handling");
        assertArrayEquals(expected, counts2, "Curly apostrophe handling");
    }

    /**
     * Test all 26 letters present
     */
    @Test
    void testGetCountsOfAlphabets_allLetters() {
        String input = "The quick brown fox jumps over the lazy dog";
        int[] expected = {1,1,1,1,3,1,1,2,1,1,1,1,1,1,4,1,1,2,1,2,2,1,1,1,1,1};

        AnagramChecking.getCountsOfAlphabets(input, counts1);
        assertArrayEquals(expected, counts1, "Pangram count mismatch");
    }

    // ==================== Tests for nonRecursiveCountCheck ====================

    /**
     * Test identical arrays
     */
    @Test
    void testNonRecursiveCountCheck_identicalArrays() {
        int[] arr1 = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] arr2 = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        assertTrue(AnagramChecking.nonRecursiveCountCheck(arr1, arr2),
                "Identical arrays should return true");
    }

    /**
     * Test arrays with all zeros
     */
    @Test
    void testNonRecursiveCountCheck_allZeros() {
        assertTrue(AnagramChecking.nonRecursiveCountCheck(counts1, counts2),
                "Arrays with all zeros should return true");
    }

    /**
     * Test arrays with one difference
     */
    @Test
    void testNonRecursiveCountCheck_oneDifference() {
        counts1[0] = 1;
        counts2[0] = 2;

        assertFalse(AnagramChecking.nonRecursiveCountCheck(counts1, counts2),
                "Arrays with one difference should return false");
    }

    /**
     * Test arrays with multiple differences
     */
    @Test
    void testNonRecursiveCountCheck_multipleDifferences() {
        for (int i = 0; i < 26; i++) {
            counts1[i] = i;
            counts2[i] = 25 - i;
        }

        assertFalse(AnagramChecking.nonRecursiveCountCheck(counts1, counts2),
                "Arrays with multiple differences should return false");
    }

    /**
     * Test arrays of different lengths (edge case)
     */
    @Test
    void testNonRecursiveCountCheck_differentLengths() {
        int[] arr1 = new int[26];
        int[] arr2 = new int[25];

        assertFalse(AnagramChecking.nonRecursiveCountCheck(arr1, arr2),
                "Arrays of different lengths should return false");
    }

    /**
     * Test with maximum values
     */
    @Test
    void testNonRecursiveCountCheck_maxValues() {
        for (int i = 0; i < 26; i++) {
            counts1[i] = Integer.MAX_VALUE;
            counts2[i] = Integer.MAX_VALUE;
        }

        assertTrue(AnagramChecking.nonRecursiveCountCheck(counts1, counts2),
                "Arrays with max values should match");
    }

    // ==================== Tests for recursiveCountCheck ====================

    /**
     * Test identical arrays with recursion
     */
    @Test
    void testRecursiveCountCheck_identicalArrays() {
        int[] arr1 = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] arr2 = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        assertTrue(AnagramChecking.recursiveCountCheck(arr1, arr2, 0),
                "Recursive: Identical arrays should return true");
    }

    /**
     * Test arrays with all zeros recursively
     */
    @Test
    void testRecursiveCountCheck_allZeros() {
        assertTrue(AnagramChecking.recursiveCountCheck(counts1, counts2, 0),
                "Recursive: Arrays with all zeros should return true");
    }

    /**
     * Test arrays with one difference recursively
     */
    @Test
    void testRecursiveCountCheck_oneDifference() {
        counts1[25] = 1; // Difference at the end
        counts2[25] = 2;

        assertFalse(AnagramChecking.recursiveCountCheck(counts1, counts2, 0),
                "Recursive: Arrays with one difference should return false");
    }

    /**
     * Test difference at the beginning
     */
    @Test
    void testRecursiveCountCheck_differenceAtStart() {
        counts1[0] = 1;
        counts2[0] = 2;

        assertFalse(AnagramChecking.recursiveCountCheck(counts1, counts2, 0),
                "Recursive: Difference at start should return false immediately");
    }

    /**
     * Test arrays of different lengths (edge case)
     */
    @Test
    void testRecursiveCountCheck_differentLengths() {
        int[] arr1 = new int[26];
        int[] arr2 = new int[25];

        assertFalse(AnagramChecking.recursiveCountCheck(arr1, arr2, 0),
                "Recursive: Arrays of different lengths should return false");
    }

    /**
     * Test starting from non-zero index
     */
    @Test
    void testRecursiveCountCheck_nonZeroStart() {
        for (int i = 0; i < 26; i++) {
            counts1[i] = i;
            counts2[i] = i;
        }

        // Starting from index 10 should still return true for identical arrays
        assertTrue(AnagramChecking.recursiveCountCheck(counts1, counts2, 10),
                "Recursive: Starting from non-zero index with identical arrays should return true");
    }

    // ==================== Integration Tests (Full Anagram Checking) ====================

    /**
     * Test Example 1 from README
     */
    @Test
    void testFullAnagram_example1() {
        String s1 = "Eleven plus two";
        String s2 = "Twelve PLUS one";

        AnagramChecking.getCountsOfAlphabets(s1, counts1);
        AnagramChecking.getCountsOfAlphabets(s2, counts2);

        assertTrue(AnagramChecking.nonRecursiveCountCheck(counts1, counts2),
                "Example 1: Non-recursive check failed");
        assertTrue(AnagramChecking.recursiveCountCheck(counts1, counts2, 0),
                "Example 1: Recursive check failed");
    }

    /**
     * Test Example 2 from README
     */
    @Test
    void testFullAnagram_example2() {
        String s1 = "Rats and mice";
        String s2 = "In cat's dream";

        AnagramChecking.getCountsOfAlphabets(s1, counts1);
        AnagramChecking.getCountsOfAlphabets(s2, counts2);

        assertTrue(AnagramChecking.nonRecursiveCountCheck(counts1, counts2),
                "Example 2: Non-recursive check failed");
        assertTrue(AnagramChecking.recursiveCountCheck(counts1, counts2, 0),
                "Example 2: Recursive check failed");
    }

    /**
     * Parameterized test for various anagram pairs
     */
    @ParameterizedTest
    @CsvSource({
            "listen, silent",
            "evil, vile",
            "a gentleman, elegant man",
            "conversation, voices rant on",
            "astronomer, moon starer",
            "the eyes, they see",
            "funeral, real fun",
            "DORMITORY, dirty room",
            "THE MORSE CODE, Here come dots",
            "Slot machines, Cash lost in me"
    })
    void testFullAnagram_validAnagrams(String s1, String s2) {
        AnagramChecking.getCountsOfAlphabets(s1, counts1);
        AnagramChecking.getCountsOfAlphabets(s2, counts2);

        assertTrue(AnagramChecking.nonRecursiveCountCheck(counts1, counts2),
                "Valid anagram pair failed non-recursive: " + s1 + " vs " + s2);
        assertTrue(AnagramChecking.recursiveCountCheck(counts1, counts2, 0),
                "Valid anagram pair failed recursive: " + s1 + " vs " + s2);
    }

    /**
     * Parameterized test for non-anagram pairs
     */
    @ParameterizedTest
    @CsvSource({
            "hello, world",
            "test, best",
            "java, python",
            "anagram, grammar",
            "different, lengths",
            "abc, abcd",
            "AAA, BBB",
            "123abc, 456def"
    })
    void testFullAnagram_invalidAnagrams(String s1, String s2) {
        AnagramChecking.getCountsOfAlphabets(s1, counts1);
        AnagramChecking.getCountsOfAlphabets(s2, counts2);

        assertFalse(AnagramChecking.nonRecursiveCountCheck(counts1, counts2),
                "Invalid anagram pair passed non-recursive: " + s1 + " vs " + s2);
        assertFalse(AnagramChecking.recursiveCountCheck(counts1, counts2, 0),
                "Invalid anagram pair passed recursive: " + s1 + " vs " + s2);
    }

    /**
     * Test strings that become empty after removing non-alphabetic characters
     */
    @Test
    void testFullAnagram_onlyNonAlpha() {
        String s1 = "123!@#";
        String s2 = "456$%^";

        AnagramChecking.getCountsOfAlphabets(s1, counts1);
        AnagramChecking.getCountsOfAlphabets(s2, counts2);

        assertTrue(AnagramChecking.nonRecursiveCountCheck(counts1, counts2),
                "Strings with only non-alpha should be anagrams (both empty)");
        assertTrue(AnagramChecking.recursiveCountCheck(counts1, counts2, 0),
                "Strings with only non-alpha should be anagrams (both empty)");
    }

    /**
     * Test single character anagrams
     */
    @Test
    void testFullAnagram_singleChar() {
        String s1 = "A";
        String s2 = "a";

        AnagramChecking.getCountsOfAlphabets(s1, counts1);
        AnagramChecking.getCountsOfAlphabets(s2, counts2);

        assertTrue(AnagramChecking.nonRecursiveCountCheck(counts1, counts2),
                "Single character anagrams should match");
        assertTrue(AnagramChecking.recursiveCountCheck(counts1, counts2, 0),
                "Single character anagrams should match");
    }

    /**
     * Test very long strings
     */
    @Test
    void testFullAnagram_longStrings() {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // Create long anagrams
        for (int i = 0; i < 1000; i++) {
            sb1.append("abcdefghijklmnopqrstuvwxyz");
            sb2.append("zyxwvutsrqponmlkjihgfedcba");
        }

        AnagramChecking.getCountsOfAlphabets(sb1.toString(), counts1);
        AnagramChecking.getCountsOfAlphabets(sb2.toString(), counts2);

        assertTrue(AnagramChecking.nonRecursiveCountCheck(counts1, counts2),
                "Long anagram strings should match");
        assertTrue(AnagramChecking.recursiveCountCheck(counts1, counts2, 0),
                "Long anagram strings should match");
    }

    /**
     * Test strings with lots of spaces and punctuation
     */
    @Test
    void testFullAnagram_lotsOfNonAlpha() {
        String s1 = "a...b...c...d...e";
        String s2 = "e   d   c   b   a";

        AnagramChecking.getCountsOfAlphabets(s1, counts1);
        AnagramChecking.getCountsOfAlphabets(s2, counts2);

        assertTrue(AnagramChecking.nonRecursiveCountCheck(counts1, counts2),
                "Strings with lots of non-alpha characters should still work");
        assertTrue(AnagramChecking.recursiveCountCheck(counts1, counts2, 0),
                "Strings with lots of non-alpha characters should still work");
    }

    /**
     * Test palindrome that is also an anagram of itself
     */
    @Test
    void testFullAnagram_palindrome() {
        String s1 = "Madam";
        String s2 = "madaM";

        AnagramChecking.getCountsOfAlphabets(s1, counts1);
        AnagramChecking.getCountsOfAlphabets(s2, counts2);

        assertTrue(AnagramChecking.nonRecursiveCountCheck(counts1, counts2),
                "Palindrome should be anagram of itself");
        assertTrue(AnagramChecking.recursiveCountCheck(counts1, counts2, 0),
                "Palindrome should be anagram of itself");
    }

    /**
     * Test consistency between recursive and non-recursive methods
     */
    @Test
    void testConsistency_recursiveVsNonRecursive() {
        // Test with random counts
        for (int test = 0; test < 100; test++) {
            for (int i = 0; i < 26; i++) {
                counts1[i] = (int)(Math.random() * 10);
                counts2[i] = (int)(Math.random() * 10);
            }

            boolean nonRecursive = AnagramChecking.nonRecursiveCountCheck(counts1, counts2);
            boolean recursive = AnagramChecking.recursiveCountCheck(counts1, counts2, 0);

            assertEquals(nonRecursive, recursive,
                    "Recursive and non-recursive methods should always agree");
        }
    }
}