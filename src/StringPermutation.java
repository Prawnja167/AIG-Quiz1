public class StringPermutation {
    String word;

    public String swap (String word, int l, int r) {
        char temp = word.charAt(l);
        word = word.substring(0,l) + word.charAt(r) + word.substring(l+1);
        word = word.substring(0,r) + temp + word.substring(r+1);
        return word;
    }

    public void doPermutation(String word, int l, int r) {
        if (l==r) {
            System.out.println(word);
        } else {
            for (int i=l; i<=r; i++) {
                word = swap(word, l, i);
                doPermutation(word, l+1 , r);
                word = swap(word, l, i);
            }
        }
    }

    public StringPermutation() {
        word = "ABC";
        doPermutation(word, 0, word.length()-1);
    }

}
