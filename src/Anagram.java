import java.util.Scanner;

public class Anagram {
    String word1;
    String word2;
    Scanner scan = new Scanner(System.in);

    public boolean isAnagram(String word1, String word2) {
        word1.replace(" ", "");
        word2.replace(" ", "");

        if (word1.length() != word2.length()) {
            return false;
        }

        while(word1.length() > 0) {
            int index = word2.indexOf(word1.charAt(0));

            if(index == -1) {
                return false;
            }

            word1 = word1.substring(1);
            word2 = word2.substring(0, index) + word2.substring(index+1);
        }
        return true;
    }

    public Anagram() {
        word1 = scan.nextLine();
        word2 = scan.nextLine();

        if (isAnagram(word1, word2)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not Anagram");
        }
    }
}
