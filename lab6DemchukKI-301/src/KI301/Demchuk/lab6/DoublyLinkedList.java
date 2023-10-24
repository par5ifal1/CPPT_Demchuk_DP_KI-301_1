package KI301.Demchuk.lab6;

import java.util.ArrayList;

/**
 * The `DoublyLinkedList` class represents a generic doubly linked list data structure.
 * It allows adding, removing, and accessing elements of type T, which must be comparable.
 * It also provides methods to retrieve the size of the list and find the maximum element.
 *
 * @param <T> The type of elements stored in the list, which must be comparable.
 */
public class DoublyLinkedList<T extends Comparable<T>> {
    private Node<T> start = null;
    private Node<T> end = null;
    private int size = 0;

    /**
     * Adds an element to the end of the doubly linked list.
     *
     * @param el The element to be added.
     */
    public void add(T el) {
        Node<T> newNode = new Node<>(el);

        if (end == null) {
            start = newNode;
        } else {
            end.next = newNode;
            newNode.prev = end;
        }

        end = newNode;
        size++;
    }
    /**
     * Retrieves the element at the specified index in the doubly linked list.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index, or null if the index is out of bounds.
     */
    public T get(int index){
        if (size <= 0 || index > size)
            return null;

        return move(index).data;
    }
    /**
     * Removes the element at the specified index from the doubly linked list.
     *
     * @param index The index of the element to remove.
     * @return True if the element was removed, false if the index is out of bounds.
     */
    public boolean remove(int index){

        if (size > 0 && size >= index) {
            Node<T> node = move(index);

            if (node.prev != null)
                node.prev.next = node.next;
            else
                start = node.next;

            if (node.next != null)
                node.next.prev = node.prev;
            else
                end = node.prev;

            size--;
            return true;
        }
        return false;
    }
    /**
     * Moves to the element at the specified index in the doubly linked list.
     *
     * @param index The index of the element to move to.
     * @return The Node at the specified index, or null if the index is out of bounds.
     */
    private Node<T> move(int index){
        Node<T> currentNode;
        int count;

        if (size / 2 >= index) {
            count = 0;

            do  {
                currentNode = start.next;
                count++;
            }
            while (count != index);
        }else {
            count = size;

            do {
                currentNode = end.prev;
                count--;
            }
            while (count != index);
        }

        return currentNode;
    }
    /**
     * Retrieves the number of elements in the doubly linked list.
     *
     * @return The size of the doubly linked list.
     */
    public int size(){
        return size;
    }
    /**
     * Retrieves all elements from the doubly linked list as an ArrayList.
     *
     * @return An ArrayList containing all elements in the doubly linked list, or null if the list is empty.
     */
    public ArrayList<T> getAll(){
        if (size != 0) {
            ArrayList<T> arr = new ArrayList<>();
            Node<T> currentNode = start;
            int count = 0;

            while (count != size) {
                arr.add(currentNode.data);
                currentNode = currentNode.next;
                count++;
            }
            return arr;
        }
        return null;
    }
    /**
     * Finds and returns the maximum element in the doubly linked list.
     *
     * @return The maximum element in the list, or null if the list is empty.
     */
    public T findMaxElement(){
        return getAll().stream().max(Comparable::compareTo).orElse(null);
    }
    // Inner Node class to represent elements in the doubly linked list.
    /**
     * Inner class representing a node in the doubly linked list.
     *
     * @param <T> The type of data stored in the node.
     */
    private static class Node<T> {
        private final T data;  // Data stored in the node
        private Node<T> prev;   // Reference to the previous node
        private Node<T> next;   // Reference to the next node

        /**
         * Constructs a new node with the specified data.
         *
         * @param data The data to be stored in the node.
         */
        public Node(T data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }
}