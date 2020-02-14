import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
/**
 * @author edwardclark
 **/

public class ChalangeTest {
    @Test
    public void test1() {
        assertTrue(Palindrome.palindromeDescendant(11211230));
    }

    @Test
    public void test2() {
        assertTrue(Palindrome.palindromeDescendant(13001120));
    }

    @Test
    public void test3() {
        assertTrue(Palindrome.palindromeDescendant(23336014) );
    }

    @Test
    public void test4() {
        assertTrue(Palindrome.palindromeDescendant(11));
    }

    @Test
    public void test5() {
        assertTrue(Palindrome.palindromeDescendant(1122));
    }

    @Test
    public void test6() {
        assertTrue(Palindrome.palindromeDescendant(332233));
    }

    @Test
    public void test7() {
        assertTrue(Palindrome.palindromeDescendant(10210112));
    }

    @Test
    public void test8() {
        assertFalse(Palindrome.palindromeDescendant(9735));
    }

    @Test
    public void test9() {
        assertFalse(Palindrome.palindromeDescendant(97358817));
    }
}