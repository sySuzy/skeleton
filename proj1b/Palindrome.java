public class Palindrome {
    public static Deque<Character> wordToDeque(String word) {
        int n = word.length();
        Deque<Character> deque = new LinkedListDeque<>();
        for(int i = 0; i < n; i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    private static boolean isPalindrome(Deque<Character> deque, int start, int end) {
        if( end - start <= 1) {
            return true;
        }
        return (deque.get(start) == deque.get(end-1)) && isPalindrome(deque, start+1, end-1);
    }

    public static boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        int start = 0;
        int end = word.length();
        return isPalindrome(wordDeque, start, end);
    }

    private static boolean isPalindrome(Deque<Character> deque, CharacterComparator cc, int start, int end) {
        if( end - start <= 1) {
            return true;
        }
        return cc.equalChars(deque.get(start), deque.get(end-1)) && isPalindrome(deque, cc, start+1, end-1);

    }

    public static boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);
        int start = 0;
        int end = word.length();
        return isPalindrome(wordDeque, cc, start, end);
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("flake"));
        OffByOne obo = new OffByOne();
        System.out.println(isPalindrome("flake", obo));

    }
}
