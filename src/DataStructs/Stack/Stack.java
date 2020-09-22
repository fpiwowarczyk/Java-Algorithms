package DataStructs.Stack;

/*
* DataStructs.Stack.DataStructs.Stack is a data struct that lets you only
* put element in the front and you can only remove
* first front element. Its gonna be fixed size stack
* LIFO - Last In First Out 
 */
public class Stack {
    int[] array;
    int size;
    int nItems=0;

    Stack(int size){
        this.size = size;
        array= new int[size];
    }
    public boolean isEmpty(){
        return nItems==0;
    }

    public boolean isFull(){
        return nItems==size;
    }
    public int getCapacity(){
        return size;
    }

    public int getSize(){
        return nItems;
    }

    public void push(int value){
        if(!isFull()){
            array[nItems]=value;
            nItems++;
        } else {
            System.out.println("DataStructs.Stack is full");
        }
    }

    public int front(){
        return array[nItems];
    }
    public int pop(){
        if(!isEmpty()){
            int item = array[nItems-1];
            nItems--;
            return item;
        } else {
            System.out.println("Array is empty");
            return -1;
        }
    }

}
