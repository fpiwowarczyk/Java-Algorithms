package test;

import DataStructs.Hash.HashMapLinearProbing;
import DataStructs.List.ArrayList;
import DataStructs.List.DoublyLinkedList;
import DataStructs.List.SinglyLinkedList;
import DataStructs.Queue.QueueArray;
import DataStructs.Queue.QueueLinkedList;

public class Test {

    public void testSinglyLinkedList(){
        System.out.println("Testing Singly Linked DataStructs.List");
        SinglyLinkedList myList = new SinglyLinkedList();
        for(int i =0;i<=6;i++){
            myList.pushFront(i); // Add items on front of list
        }
        for(int i =6;i>=0;i--){
            myList.pushBack(i); // Add items on back

        }
        myList.printLinkedList();
        System.out.println("Front item of list:"+myList.front());
        System.out.println("Back item of list:"+myList.back());

        for(int i =0;i<=6;i++){
            myList.popFront(); // Add items on front of list
        }
        myList.printLinkedList();
        System.out.println("Last element value was:"+myList.popBack());
        myList.printLinkedList();

        myList.insert(1,10);
        myList.insert(0,10);
        myList.printLinkedList();

        myList.erase(0);
        myList.erase(1);
        myList.printLinkedList();

        System.out.println("3rd value from the end is:"+myList.valueNthFromEnd(3));

        myList.removeValue(3);
        myList.printLinkedList();

        myList.insert(3,3);
        myList.printLinkedList();

        myList.reverse();
        myList.printLinkedList();



    }

    public void testDoublyLinkedList(){
        System.out.println("Testing Doubly Linked DataStructs.List");
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


    public void testArrayList(){
        System.out.println("Testing ArrayList");
        ArrayList myArray = new ArrayList();
        for(int i =0;i<32;i++){ // Test pushing into array
            myArray.push(i);
        }
        //myArray.printArray();
        for(int i =0;i<20;i++){ // Test pop elements and resizing it
            myArray.pop();
        }
        myArray.printArray();

        myArray.delete(3); // Test deleting of index
        myArray.printArray();

        myArray.remove(2); // Remove item
        myArray.printArray();

        System.out.println("Index of item 7 is:"+myArray.find(7));
        myArray.delete(myArray.find(7)-1);
        System.out.println("Index of item 7 is:"+myArray.find(7));

        myArray.prepend(3);  // Test adding element at the start
        myArray.printArray();

        myArray.insert(3,3);// Test inserting element
        myArray.printArray();

    }

    public void testQueueArray(){
        QueueArray myQueue = new QueueArray(5);
        System.out.println("Testing queue");
        assert myQueue.isEmpty() == true;
        assert myQueue.isFull() == false;
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        assert myQueue.isFull()==true;
        assert myQueue.dequeue()==1;
        assert myQueue.dequeue()==2;
        assert myQueue.dequeue()==3;
        assert myQueue.dequeue()==4;
        assert myQueue.dequeue()==5;
        assert myQueue.isEmpty()==true;
        System.out.println("DataStructs.Queue tests done!");


    }

    public void testQueueLinkedList(){
        QueueLinkedList myQueue = new QueueLinkedList();

        System.out.println("Testing QueueLinkedList!");

        assert myQueue.size()==0;
        assert myQueue.isEmpty()==true;
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        assert myQueue.isEmpty()==false;
        assert myQueue.dequeue()==1;
        assert myQueue.dequeue()==2;
        assert myQueue.dequeue()==3;
        assert myQueue.dequeue()==4;
        assert myQueue.dequeue()==5;
        assert myQueue.isEmpty()==true;
        System.out.println("Tests Done!");
    }

    public void testHashMap(){
        HashMapLinearProbing myTable = new HashMapLinearProbing(12);
        myTable.displayHashTable();
        assert myTable.isEmpty()==true;
        assert myTable.isEmpty()==false;
        myTable.checkLoadFactor();
        myTable.insertHash(101);
        myTable.insertHash(999);
        myTable.insertHash(-32);
        myTable.insertHash(12);
        myTable.displayHashTable();

        myTable.deleteHash(-32);
        myTable.displayHashTable();
        myTable.checkLoadFactor();
        System.out.println("Find key of value 101 it is on index:"+ myTable.exist(101));


    }
}
