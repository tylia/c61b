public class LinkedListDeque<T> implements Deque<T>{

    private DLNode sentinel;
    private int size;
    private T t;
    public LinkedListDeque() {
        sentinel = new DLNode(t, null, null);
        size = 0;
    }

//    public static void main(String[] args) {
//        ArrayDeque<Integer> ArrayDeque = new ArrayDeque();
////        deque.addLast(1);
////        deque.addLast(5);
////        deque.addFirst(8);
////        deque.addFirst(2);
////        deque.addFirst(4);
////        deque.addFirst(5);
////        deque.addFirst(10);
////        deque.addFirst(55);
////        deque.addLast(23);
//////        System.out.println(deque.get(4));
//////        System.out.println(deque.get(5));
//////        System.out.println(deque.get(0));
////        System.out.println(deque.removeFirst());
////        System.out.println(deque.removeFirst());
////        System.out.println(deque.removeFirst());
////        System.out.println(deque.removeFirst());
////        System.out.println(deque.removeFirst());
////        System.out.println(deque.removeFirst());
////        System.out.println(deque.removeFirst());
///*        ArrayDeque.addFirst(0);
//        ArrayDeque.removeFirst();
//        ArrayDeque.addFirst(2);
//        ArrayDeque.addLast(3);
//        System.out.println(ArrayDeque.get(0));
//        ArrayDeque.addLast(5);
//        System.out.println(ArrayDeque.get(0));
//        System.out.println(ArrayDeque.get(2));
//        System.out.println(ArrayDeque.get(1));
//        System.out.println(ArrayDeque.get(0));
//        ArrayDeque.addLast(10);
//        ArrayDeque.addLast(11);
//        ArrayDeque.removeFirst();
//        System.out.println(ArrayDeque.get(0));
//        System.out.println(ArrayDeque.get(3));
//        ArrayDeque.removeFirst();
//        ArrayDeque.addFirst(16);
//        ArrayDeque.addLast(17);
//        System.out.println(ArrayDeque.get(4));*/
//
//
//        ArrayDeque.addLast(0);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(5);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(9);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(3);
//        ArrayDeque.addLast(11);
//        System.out.println(ArrayDeque.get(0));
//
//    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(T first) {
        if (isEmpty()) {
            sentinel.next = new DLNode(first, sentinel, sentinel);
            sentinel.previous = sentinel.next;
        } else {
            sentinel.next = new DLNode(first, sentinel.next, sentinel);
            //sentinel.previous.previous = sentinel.next;
            //sentinel.next.previous = sentinel;
            sentinel.next.next.previous = sentinel.next;
        }
        size += 1;
    }

    @Override
    public void addLast(T last) {
        if (isEmpty()) {
            sentinel.next = new DLNode(last, sentinel, sentinel);
            sentinel.previous = sentinel.next;
        } else {
            //sentinel.previous = new DLNode(last, sentinel, sentinel.previous);
            sentinel.previous.next = new DLNode(last, sentinel, sentinel.previous);
            sentinel.previous = sentinel.previous.next;
        }

        size += 1;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        size -= 1;

        T firstItem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.previous = sentinel;
        return firstItem;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        size -= 1;
        T lastItem = sentinel.previous.item;
        sentinel.previous.previous.next = sentinel;
        sentinel.previous = sentinel.previous.previous;
        return lastItem;
    }

    @Override
    public T get(int index) {
        if (isEmpty() || size() < index) {
            return null;
        }
        int ind = 0;
        DLNode last = sentinel.next;
        while (ind != index) {
            last = last.next;
            ind++;
        }
        return last.item;
    }

    public T getRecursive(int index) {
        if (isEmpty() || size() < index) {
            return null;
        }

        DLNode last = sentinel.next;
        if (index == 0) {
            return last.item;
        }
        last = last.next;
        getRecursive(index - 1);
        return last.item;
    }

    @Override
    public void printDeque() {
        DLNode print = sentinel.next;
        while (print != sentinel) {
            System.out.println(print.item.toString());
            print = print.next;
        }
    }

    private class DLNode {
        private T item;
        private DLNode next;
        private DLNode previous;

        public DLNode(T item, DLNode next, DLNode previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }
}
