public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        int n = word.length();
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < n; i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    private boolean isPalindrome(Deque<Character> deque, int start, int end) {
        if (end - start <= 1) {
            return true;
        }
        return (deque.get(start) == deque.get(end - 1)) && isPalindrome(deque, start + 1, end - 1);
    }

    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        int start = 0;
        int end = word.length();
        return isPalindrome(wordDeque, start, end);
    }

    private boolean isPalindrome(Deque<Character> d, CharacterComparator cc, int start, int end) {
        if (end - start <= 1) {
            return true;
        }
        boolean condition1 = cc.equalChars(d.get(start), d.get(end - 1));
        boolean condition2 = isPalindrome(d, cc, start + 1, end - 1);
        return condition1 && condition2;

    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);
        int start = 0;
        int end = word.length();
        return isPalindrome(wordDeque, cc, start, end);
    }


}
