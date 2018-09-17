public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }

        if (word.length() == 0 || word.length() == 1) {
            return true;
        }

        Deque<Character> deque = wordToDeque(word);
        int i = 0;
        while (i <= deque.size() / 2) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
            i++;
        }
        return true;
    }
}
