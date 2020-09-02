package Queue;

/*
* Implementation of Queue data struct
* Elements that are added first are first to be removed
* New elements are added to the back of the queue
*
*
 */
public class Queue {

    //Size of queue
    private int Size;
    // Array for queue
    private int[] queueArr;
    // Front of queue
    private int front;
    //Back of queue
    private int back;
    //How many items are in queue
    private int nItems;
    //Constructor
    public Queue(int size){
        Size = size;
        queueArr = new int[size];
        front =0;
        back =-1;
        nItems = 0;
    }

    public Boolean insert(int x){
        if(isFull())
        {
            System.out.println("Queue is full");
            return false;
        }
        if(back == Size-1)
            back =-1;
        back++;
        queueArr[back]=x;
        nItems++;
        return true;
    }

    public int remove(){
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int temp = queueArr[front];
        front++;
        if(front ==Size)
            front =0;
        nItems--;
        return temp;
    }

    public int peekFront(){
        return queueArr[front];
    }

    public int peekBack(){
        return queueArr[back];
    }

    public Boolean isFull(){
        if(Size==nItems)
            return true;
        else
            return false;
    }

    public Boolean isEmpty(){
        if(nItems==0)
            return true;
        else
            return false;
    }

    public int getSize(){ return nItems;}

}


