import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue("ERROR! Wrong answer for - A", palindrome.isPalindrome("A"));
        assertTrue("ERROR! Wrong answer for - ", palindrome.isPalindrome(""));
        assertFalse("ERROR! Wrong answer for - null", palindrome.isPalindrome(null));
        assertFalse("ERROR! Wrong answer for - palindrome", palindrome.isPalindrome("palindrome"));
        assertTrue("ERROR! Wrong answer for - mum", palindrome.isPalindrome("mum"));
        assertFalse("ERROR! Wrong answer for -  mum", palindrome.isPalindrome(" mum"));
        assertFalse("ERROR! Wrong answer for - calpac", palindrome.isPalindrome("calpac"));
        assertFalse("ERROR! Wrong answer for - ba", palindrome.isPalindrome("ba"));
    }

    @Test
    public void testIsPalindrome2() {
        assertFalse("ERROR! Wrong answer for - boo", palindrome.isPalindrome("boo", cc));
        assertTrue("ERROR! Wrong answer for - ", palindrome.isPalindrome("", cc));
        assertFalse("ERROR! Wrong answer for - null", palindrome.isPalindrome(null, cc));
        assertTrue("ERROR! Wrong answer for - flake", palindrome.isPalindrome("flake", cc));
        assertFalse("ERROR! Wrong answer for - mum", palindrome.isPalindrome("mum", cc));
        assertTrue("ERROR! Wrong answer for - ba", palindrome.isPalindrome("ba", cc));
        assertFalse("ERROR! Wrong answer for - calpac", palindrome.isPalindrome("callac", cc));
    }
}
