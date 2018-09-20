public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        if (Character.isUpperCase(x) || Character.isUpperCase(y)) {
            char lowerX = toLowerIfUpper(x);
            if(byOne(lowerX, y)) {
                return true;
            }

            char lowerY = toLowerIfUpper(y);
            if(byOne(lowerY, y)) {
                return true;
            }
        }

        if (Math.abs(x - y) == 1) {
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

    private boolean byOne(char x, char y) {
        if (Math.abs(x - y) == 1) {
            return true;
        }
        return false;
    }
}
