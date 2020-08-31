package test;

import List.DoublyLinkedList;
import List.SinglyLinkedList;

public class Test {

    public void testSinglyLinkedList(){
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
}
