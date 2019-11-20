import java.util.Scanner;

public class Palindrome {
    int l, h;
    String word;
    Scanner scan = new Scanner(System.in);

    public boolean isPalindrome(String word) {
        l = 0;
        h = word.length()-1;

        while(h>l) {
            if (word.charAt(l) != word.charAt(h)) {
                return false;
            }

            l++;
            h--;
        }

        return true;
    }

    public Palindrome() {
        word = scan.nextLine();

        if (isPalindrome(word)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }

}
