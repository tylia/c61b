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
        int size = deque.size();
        while (i <= size / 2) {
            if (size % 2 == 1 && i == size / 2) {
                return true;
            }
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
            i++;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            return false;
        }
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }

        Deque<Character> deque = wordToDeque(word);
        int i = 0;
        int size = deque.size();
        while (i < size / 2) {
            if (size % 2 == 1 && i == size / 2) {
                return true;
            }
            if (!cc.equalChars(deque.removeFirst(), deque.removeLast())) {
                return false;
            }
            i++;
        }
        return true;
    }
}
