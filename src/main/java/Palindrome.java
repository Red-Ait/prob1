import java.util.ArrayList;
import java.util.List;

public class Palindrome {

    public static void main(String[] args) {
    }

    public static boolean palindromeDescendant(int n) {
        while (!isPalindrome(n) && n > 9){
            List<Integer> digits  = new ArrayList<>();
            int m = n;
            while (m > 0) {
                digits.add(m%10);
                m /= 10;
            }
            n = 0;
            int j = 0;
            for(int i = 1; i < digits.size() ; i += 2 , j ++) {
                n += (digits.get(i - 1) + digits.get(i )) * Math.pow(10, j);
            }
            System.out.println(n);
        }
        return n > 10;
    }
    public static boolean isPalindrome(int n) {

        if (n < 10) return false;
        List<Integer> digits  = new ArrayList<>();
        while (n > 0) {
            digits.add(n%10);
            n /= 10;
        }
        for(int i = 0 ; i < digits.size() /2 ; i ++) {
            if (digits.get(i) != digits.get(digits.size() - 1 - i))
                return false;
        }
        return true;
    }

}
