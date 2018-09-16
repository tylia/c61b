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
        if (isEmpty()){
            resize();
        }
        deque[nextFirst] = item;
        size += 1;
        nextFirst = movePointer(nextFirst, deque.length, -1);
    }

    public void addLast(T item) {
        if (isEmpty()){
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

    public boolean isEmpty() {
        if (size == deque.length) {
            return true;
        }
        return false;
    }

    private void resize() {
        T[] copy = (T[]) new Object[deque.length * 2];

        if (nextFirst == -1){
            System.arraycopy(deque, 0, copy, 0, nextLast - 1);
        } else {
            System.arraycopy(deque, nextFirst + 1, copy, 0, deque.length - 1 - nextFirst);
            System.arraycopy(deque, 0, copy, deque.length - 1 - nextFirst, nextLast);
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

        if (nextFirst == deque.length - 1) {
            return deque[index];
        }

        int posZero = nextFirst + 1;

        if (posZero + index >= deque.length) {
            return deque[(posZero + index)%deque.length - 1];
        }
        else {
            return deque[posZero + index];
        }
    }

    public T removeFirst() {
        if (size > 0) {
            nextFirst = movePointer(nextFirst, deque.length, 1);
            T firstValue = deque[nextFirst];
            deque[nextFirst] = null;
            size -= 1;
            if (size%deque.length > 0.25 && deque.length >= 16) {
                downsize();
            }
            return firstValue;
        } else {
            return null;
        }
    }

    public T removeLast() {
        nextLast = movePointer(nextLast, deque.length, -1);
        T lastValue = deque[nextLast];
        deque[nextLast] = null;
        size -= 1;
        if (size%deque.length < 0.25 && deque.length >= 16) {
            downsize();
        }
        return lastValue;
    }

    private void downsize() {
        T[] copy = (T[]) new Object[deque.length * 3/4];
        for (int i = movePointer(nextFirst, deque.length, 1), index = 0; i <= size; i++, index++) {
            copy[index] = deque[i];
        }
        deque = copy;
        nextLast = size;
        nextFirst = deque.length - 1;
    }
}
