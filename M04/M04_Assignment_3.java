/* Module 4: Assignment 3
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/8/25
File:   M04_Assignment_3.java
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


public class M04_Assignment_3 {
    public static void main(String[] args) {
        TwoWayLinkedList<String> list = new TwoWayLinkedList<>();
        list.add("Tom");
        list.add("Susan");
        list.add("Kim");
        list.add("Michael");

        System.out.println("Forward traversal:");
        java.util.ListIterator<String> it = list.listIterator();
        while (it.hasNext()) System.out.print(it.next() + " ");
        System.out.println("\nBackward traversal:");
        while (it.hasPrevious()) System.out.print(it.previous() + " ");
    }
}
