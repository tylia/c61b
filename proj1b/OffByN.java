public class OffByN implements CharacterComparator {
    private int N;
    public OffByN(int N) {
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (Character.isUpperCase(x) || Character.isUpperCase(y)) {
            char lowerX = toLowerIfUpper(x);
            if(byN(lowerX, y)) {
                return true;
            }

            char lowerY = toLowerIfUpper(y);
            if(byN(lowerY, y)) {
                return true;
            }
        }

        if (Math.abs(x - y) == N) {
            return true;
        }
        return false;
    }

    private char toLowerIfUpper(char x) {
        if (Character.isUpperCase(x)) {
            return Character.toLowerCase(x);
        }
        return x;
    }

    private boolean byN(char x, char y) {
        if (Math.abs(x - y) == N) {
            return true;
        }
        return false;
    }
}
