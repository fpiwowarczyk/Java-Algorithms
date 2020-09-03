package Queue;

/*
* A priority queue adds element into position based on their priority
* Most important el are placed at the front
* I should not have fixed size but in these implementation it will
*
 */


public class PriorityQueue {

    private int Size;

    private int[] queueArr;

    private int nItems;

    public PriorityQueue(int size){
        Size=size;
        queueArr = new int[size];
        nItems=0;
    }

    public Boolean insert(int value){
        if(isFull()){
            System.out.println("Queue is full");
            return false;
        }
        if(nItems==0){
            queueArr[0]= value;
        } else {
            int j=nItems;
            while (j>0&& queueArr[j-1]>value){
                queueArr[j]=queueArr[j-1];
                j--;
            }
            queueArr[j]=value;
        }
        nItems++;
        return true;
    }

    public int remove(){
        return queueArr[--nItems];
    }

    public int peek(){
        return queueArr[nItems-1];
    }

    public Boolean isFull(){
        return nItems==Size;
    }

    public Boolean isEmpty(){
        return nItems==0;
    }

    public int getSize(){
        return nItems;
    }

    public void printQueue(){
        int i=0;
        while(i<getSize()){
            System.out.print(queueArr[i]+"  ");
            i++;
        }

    }

}
