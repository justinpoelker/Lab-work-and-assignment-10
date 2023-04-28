package com.mycompany.dllists_stacks_queues;

/**
 *
 * @author MoaathAlrajab
 */
class Node {

    public int data;
    public Node next;
    public Node previous;

    public Node(int initialData) {
        data = initialData;
        next = null;
        previous = null;
    }
}

public class DoublyLinkedList {

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void append(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public void prepend(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public int sumOfLast(int m) {
        Node node = tail;
        int sum = 0;
        while (node != null && m > 0) {
            sum += node.data;
            m--;
            node = node.previous;
        }
        return sum;
    }

    public void insertAfter(Node currentNode, Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (currentNode == tail) {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        } else {
            Node successor = currentNode.next;
            newNode.next = successor;
            newNode.previous = currentNode;
            currentNode.next = newNode;
            successor.previous = newNode;
        }
    }

    public void remove(Node currentNode) {
        Node successor = currentNode.next;
        Node predecessor = currentNode.previous;

        if (successor != null) {
            successor.previous = predecessor;
        }

        if (predecessor != null) {
            predecessor.next = successor;
        }

        if (currentNode == head) {
            head = successor;
        }

        if (currentNode == tail) {
            tail = predecessor;
        }
    }

    public static String reverseString(String str) {
        DoublyLinkedList list = new DoublyLinkedList();
        for (char c : str.toCharArray()) {
            list.append(new Node((int) c));
        }
        Node previousNode = null;
        Node currentNode = list.head;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        list.head = previousNode;

        StringBuilder sb = new StringBuilder();
        Node node = list.head;
        while (node != null) {
            sb.append((char) node.data);
            node = node.next;
        }
        return sb.toString();
    }

    
    
    //START LAB 10
    public int[] toArray() {
        
        //Create new array
        int[] array = new int[size()];
        
        //Set default variables
        int index = 0;
        
        //Look through the list 
        Node newNode = head;
        while (newNode != null) {
            //Store data in current node at the same index
            array[index] = newNode.data;
            
            //Increase 1
            index++;
            
            //Next node
            newNode = newNode.next;
        }
        return array;
    }

    public int indexOf(Object object) {
        //Set default variables
        int index = 0;
        
        //Look through list
        Node node = head;
        while (node != null) {
            
            //If current node has the requested data, return
            if (object.equals(node.data)) {
                return index;
            }
        }
        return 0;
    }

    public int size() {
        
        //Check if list is empty
        if (head == null) {
            return 0;
        }
        
        //Set variables to defaults
        int size = 0;
        
        //Look through list, increment for each node
        Node node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        
        //Return list size
        return size;
    }
}
