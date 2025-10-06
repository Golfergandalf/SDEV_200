/* Module 4: Assignment 3
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/8/25
File:   TwoWayLinkedList.java
*/

/* 24.3 (Implement a doubly linked list)
The MyLinkedList class used in LiveExample 24.5 is a one-way directional linked list that enables one-way traversal of the list.
Modify the Node class to add the new data field name previous to refer to the previous node in the list, as follows:

Implement a new class named TwoWayLinkedList that uses a doubly linked list to store elements. Define TwoWayLinkedList to implements MyList.
You need to implement all the methods defined in MyLinkedList as well as the methods listIterator() and listIterator(int index).
Both return an instance of java.util.ListIterator<E> (see Figure 20.4).
The former sets the cursor to the head of the list and the latter to the element at the specified index.
Test your new class using this code from https://liveexample.pearsoncmg.com/test/Exercise24_03_13e.txt.
*/

// Imports
import java.util.ListIterator;
import java.util.NoSuchElementException;

// Simplified version of MyList<E> interface
interface MyList<E> extends Iterable<E> {
    void add(E e);
    void add(int index, E e);
    void clear();
    boolean contains(E e);
    E get(int index);
    int indexOf(E e);
    boolean isEmpty();
    int lastIndexOf(E e);
    boolean remove(E e);
    E remove(int index);
    Object set(int index, E e);
    int size();
}

// Doubly linked list implementation
public class TwoWayLinkedList<E> implements MyList<E> {
    private Node<E> head, tail;
    private int size = 0;

    // Doubly linked node
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E element) {
            this.element = element;
        }
    }

    public TwoWayLinkedList() {}

    @Override
    public void add(E e) {
        add(size, e);
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        Node<E> newNode = new Node<>(e);

        if (size == 0) {
            head = tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        } else {
            Node<E> current = getNode(index);
            newNode.previous = current.previous;
            newNode.next = current;
            current.previous.next = newNode;
            current.previous = newNode;
        }

        size++;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<E> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.previous;
        }
        return current;
    }

    @Override
    public int indexOf(E e) {
        int index = 0;
        for (Node<E> current = head; current != null; current = current.next) {
            if (e.equals(current.element)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        int index = size - 1;
        for (Node<E> current = tail; current != null; current = current.previous) {
            if (e.equals(current.element)) return index;
            index--;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(E e) {
        int index = indexOf(e);
        if (index == -1) return false;
        remove(index);
        return true;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<E> removed;
        if (index == 0) {
            removed = head;
            head = head.next;
            if (head != null) head.previous = null;
            else tail = null;
        } else if (index == size - 1) {
            removed = tail;
            tail = tail.previous;
            tail.next = null;
        } else {
            removed = getNode(index);
            removed.previous.next = removed.next;
            removed.next.previous = removed.previous;
        }
        size--;
        return removed.element;
    }

    @Override
    public Object set(int index, E e) {
        Node<E> node = getNode(index);
        E old = node.element;
        node.element = e;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    // Return a list iterator starting from the head
    public ListIterator<E> listIterator() {
        return new TwoWayListIterator(0);
    }

    // Return a list iterator starting from a given index
    public ListIterator<E> listIterator(int index) {
        return new TwoWayListIterator(index);
    }

    // Implementation of a two-way list iterator
    private class TwoWayListIterator implements ListIterator<E> {
        private Node<E> nextNode;
        private Node<E> lastReturned = null;
        private int nextIndex;

        public TwoWayListIterator(int index) {
            if (index < 0 || index > size) throw new IndexOutOfBoundsException();
            nextIndex = index;
            nextNode = (index == size) ? null : getNode(index);
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastReturned = nextNode;
            nextNode = nextNode.next;
            nextIndex++;
            return lastReturned.element;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            if (nextNode == null) nextNode = tail;
            else nextNode = nextNode.previous;
            lastReturned = nextNode;
            nextIndex--;
            return lastReturned.element;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            if (lastReturned == null) throw new IllegalStateException();
            lastReturned.element = e;
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return listIterator();
    }
}
