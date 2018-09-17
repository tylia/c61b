import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue("a and b", offByOne.equalChars('a', 'b'));
        assertTrue("r and q", offByOne.equalChars('r', 'q'));
        assertTrue("q and r", offByOne.equalChars('q', 'r'));

        assertFalse("a and e", offByOne.equalChars('a', 'e'));
        assertFalse("z and a", offByOne.equalChars('z', 'a'));
        assertFalse("a and a", offByOne.equalChars('a', 'a'));
    }
}
