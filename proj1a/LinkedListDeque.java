public class LinkedListDeque<T> {

    private class DLNode {
        public T item;
        public DLNode next;
        public DLNode previous;

        public DLNode(T item, DLNode next, DLNode previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

    private DLNode sentinel;
    private int size;
    private T t;


    public LinkedListDeque() {
        sentinel = new DLNode(t, null, null);
        size = 0;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void addFirst(T first) {
        if (isEmpty()) {
            sentinel.next = new DLNode(first, sentinel, sentinel);
            sentinel.previous = sentinel.next;
        } else {
            sentinel.next = new DLNode(first, sentinel.next, sentinel);
            sentinel.previous.previous = sentinel.next;
        }
        size += 1;
    }

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

    public void printDeque() {

        DLNode print = sentinel.next;
        while (print != sentinel) {
            System.out.println(print.item.toString());
            print = print.next;
        }
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> test = new LinkedListDeque<>();
        //test.addLast(1010);
        test.addFirst(2);
        test.addFirst(8);
        //test.addLast(6);
        //test.addLast(101);
//        test.addLast(55);
//        test.addFirst(88);
//        System.out.println("remove first: " + test.removeFirst());
//        System.out.println("remove last: " + test.removeLast());
        System.out.println("get index: " + test.getRecursive(1));
        System.out.println("Size: " + test.size());
        test.printDeque();
    }
}