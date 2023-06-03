package DataStructures;

/**
 * Sample implementation of a Doubly Linked List
 *
 * @param <T>
 */
public class DoublyLinkedList<T> {
    /**
     * Node to be used in list
     *
     * @param <E>
     */
    class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> previous, E data, Node<E> next) {
            this.data = data;
            this.prev = previous;
            this.next = next;
        }

        public Node(E data) {
            this(null, data, null);
        }
    }

    private Node<T> head;
    private Node<T> tail;

    private int size;

    /**
     * Doubly linked list constructor
     */
    public DoublyLinkedList() {
        size = 0;
    }

    /**
     * Add item to the front of the list
     *
     * @param data
     */
    public void insert(T data) {
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else if (size == 1) {
            head = newNode;
            head.next = tail;
            tail.prev = head;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Add item to the end of the list
     *
     * @param data
     */
    public void append(T data) {
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Remove node at specified index
     *
     * @param index
     * @return Node that was removed
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == 1) {
            head = tail = null;
            size = 0;
        }

        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        if (curr == head) {
            head = head.next;
            head.prev = null;
        } else if (curr == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }

        size--;
        return curr.data;
    }

    /**
     * Removes first instance of node containing
     *
     * @param data
     */
    public void remove(T data) {
        Node<T> temp = head;

        while (temp != null) {
            if (temp.data == data) {
                break;
            }
            temp = temp.next;
        }

        if (temp == head) {
            remove(0);
        } else if (temp == tail) {
            remove(size - 1);
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            size--;
        }
    }

    /**
     * Check if list is empty
     *
     * @return Boolean value indicating if list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get the size of the linked list
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Get the head of the list
     *
     * @return
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Get the tail of the list
     *
     * @return
     */
    public Node<T> getTail() {
        return tail;
    }
}
