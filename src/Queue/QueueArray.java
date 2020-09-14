package Queue;

/*
* Implementation of FIFO queue with fixed size array
* there are read and write values and depending on them you will
* read from first place and write on last place
*
 */
public class QueueArray implements Queue {
    int[] array;
    int size;
    int nItems=0;
    int read = 0;
    int write = 0;
    public QueueArray(int size){
        this.size = size;
        array = new int[size+1]; // I made these because i don't want to read and write meet
    }

    @Override
    public void enqueue(Integer value) {
        if(!isFull()){
            array[write] = value;
            nItems++;
            write = Increment(write);
        } else {
            System.out.println("Queue is full, didn't add element");

        }

    }

    @Override
    public Integer dequeue() {
        if(!isEmpty()){
            int item = array[read];
            read = Increment(read);
            nItems--;
            return item;
        } else {
            System.out.println("Queue is empty, didn't remove element");
            return -1;
        }

    }

    @Override
    public int size() {
        return nItems;
    }

    public int capacity(){return size;}

    @Override
    public boolean isEmpty() {
        return nItems==0;
    }
    public boolean isFull(){
        return nItems==size;
    }

    private int Increment(int value){
        if(value>=size+1) {
            value = 0;
        } else {
            value++;
        }
        return value;
    }
}
