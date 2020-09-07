package test;

import List.ArrayList;
import List.DoublyLinkedList;
import List.SinglyLinkedList;
import Queue.Queue;
import Queue.PriorityQueue;
import Queue.GenericQueue;

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

    public void testPriorityQueue(){
        PriorityQueue myQueue = new PriorityQueue(4);

        myQueue.insert(10);
        myQueue.insert(2);
        myQueue.insert(5);
        myQueue.insert(4);

        myQueue.printQueue(); // 2 4 5 10 Higher numbers have higher priority

        //Priority queue can be used as a sorting algorithm
    }

    public void testGenericQueue(){
        //Also my first try with these type of testing
        GenericQueue<Integer> myQueue = new GenericQueue<Integer>();
        System.out.println("Running...");
        assert myQueue.peek()==null;
        assert myQueue.poll()==null;
        assert myQueue.add(1)==true;
        assert myQueue.peek()==1;
        assert myQueue.add(2)==true;
        assert myQueue.peek()==1;
        assert myQueue.poll()==1;
        assert myQueue.peek()==2;
        assert myQueue.poll()==2;
        assert myQueue.peek()==null;
        assert myQueue.poll()==null;
        System.out.println("Finished");

    }

    public void testArrayList(){
        ArrayList myArray = new ArrayList();
        for(int i =0;i<15;i++){
            myArray.push(2*i);
        }
        myArray.printArray();
        for(int i=0;i<8;i++){
            System.out.println(myArray.pop());
            myArray.printArray();
        }



    }
}
