package Queue;

import java.util.LinkedList;


/*
* FIFO(First in first out) with linkedList
* You add always last element are removes first.
 */
public class QueueLinkedList implements Queue {
    private LinkedList<Integer> List= new LinkedList();
    private Integer nItems=0;

    @Override
    public void enqueue(Integer value){
        List.addLast(value);
        nItems++;
    }
    @Override
    public Integer dequeue(){
        nItems--;
        return List.removeFirst();

    }
    @Override
    public int size(){
        return nItems;
    }
    @Override
    public boolean isEmpty(){
        return nItems==0;
    }

}
