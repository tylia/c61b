public class ArrayDeque<T> {
    private T[] deque;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        deque = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    public void addFirst(T item) {
        if (isFull()) {
            resize();
        }
        deque[nextFirst] = item;
        size += 1;
        nextFirst = movePointer(nextFirst, deque.length, -1);
    }

    public void addLast(T item) {
        if (isFull()) {
            resize();
        }
        deque[nextLast] = item;
        nextLast = movePointer(nextLast, deque.length, 1);
        size += 1;
    }

    private int movePointer(int next, int length, int moveDirection) {
        int pointer = next + moveDirection;
        if (pointer == -1) {
            return length - 1;
        }
        if (pointer == length) {
            return 0;
        }
        return pointer;
    }

    private boolean isFull() {
        if (size == deque.length) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    private void resize() {
        T[] copy = (T[]) new Object[deque.length * 2];

        int startingPosition = movePointer(nextFirst, deque.length, 1);
        for (int i = startingPosition, index = 0; index < size; i++, index++) {
            i = movePointer(i, deque.length, 0);
            copy[index] = deque[i];
        }

        nextLast = deque.length;
        deque = copy;
        nextFirst = deque.length - 1;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index >= deque.length) {
            return null;
        }

        if (size == 0) {
            return null;
        }

        if (nextFirst == deque.length - 1) {
            return deque[index];
        }

        int posZero = nextFirst + 1;

        if (posZero + index >= deque.length) {
            return deque[(posZero + index) % deque.length];
        } else {
            return deque[posZero + index];
        }
    }

    public T removeFirst() {
        if (size > 0) {
            nextFirst = movePointer(nextFirst, deque.length, 1);
            T firstValue = deque[nextFirst];
            deque[nextFirst] = null;
            size -= 1;
            if (size / deque.length >= 0.25 && deque.length >= 8) {
                downsize();
            }
            return firstValue;
        }
        return null;
    }

    public T removeLast() {
        if (size > 0) {
            nextLast = movePointer(nextLast, deque.length, -1);
            T lastValue = deque[nextLast];
            deque[nextLast] = null;
            size -= 1;
            if (size / deque.length >= 0.25 && deque.length >= 8) {
                downsize();
            }
            return lastValue;
        }
        return null;
    }

    private void downsize() {
        T[] copy = (T[]) new Object[deque.length / 2];

        int startingPosition = movePointer(nextFirst, deque.length, 1);
        for (int i = startingPosition, index = 0; index < size; i++, index++) {
            i = movePointer(i, deque.length, 0);
            copy[index] = deque[i];
        }

        deque = copy;
        nextLast = size;
        nextFirst = deque.length - 1;
    }

    public void printDeque() {
        for (int i = movePointer(nextFirst, deque.length, 1), index = 0; i <= size; i++, index++) {
            System.out.println(deque[i]);
        }
    }
}
