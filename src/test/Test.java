package test;

import List.DoublyLinkedList;
import List.SinglyLinkedList;
import Queue.Queue;

public class Test {

    public void testSinglyLinkedList(){
        System.out.println("Testing Singly Linked List");
        SinglyLinkedList myList = new SinglyLinkedList();
        myList.insertHead(5);
        myList.insertHead(10);
        myList.insertHead(99);

        myList.display();

        myList.deleteHead();

        myList.display();

        myList.insertNth(30,2);

        myList.display();

        myList.deleteNth(2);

        myList.display();
    }

    public void testDoublyLinkedList(){
        System.out.println("Testing Doubly Linked List");
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.insertHead(1);
        myList.insertHead(2);
        myList.insertHead(3);
        myList.display();

        myList.insertTail(0);
        myList.display();

        myList.deleteTail();
        myList.display();

        myList.delete(2);
        myList.display();


        myList.insertOrdered(14);
        myList.insertOrdered(12);
        myList.insertOrdered(10);
        myList.display();
    }

    public void testQueue(){
        Queue myQueue = new Queue(4);

        myQueue.insert(10);
        myQueue.insert(4);
        myQueue.insert(1);
        myQueue.insert(99);
        // [10(first to remove),4,1,99(last to remove)]
        System.out.println(myQueue.isFull()); // True

        System.out.println(myQueue.peekFront()); // 10 Should be front
        System.out.println(myQueue.remove()); // Print 10 and remove 10
        System.out.println(myQueue.peekFront()); // Now 4 will be front
        System.out.println(myQueue.peekBack()); // 99 Should be back
        myQueue.insert(13); //new back is 13
        System.out.println(myQueue.peekBack()); // Print 13

        System.out.println(myQueue.isEmpty()); // False isn't empty
        myQueue.remove();
        myQueue.remove();
        myQueue.remove();
        myQueue.remove();
        System.out.println(myQueue.isEmpty()); // True is empty



    }
}
