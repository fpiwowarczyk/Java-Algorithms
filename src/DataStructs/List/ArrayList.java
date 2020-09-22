package DataStructs.List;

/*
* My implementation of ArrayList
* it should work as Vector or Dynamic Array
* Items are stored in array on indexes.
* U don't have to pass size.
*
 */

public class ArrayList {

    int[] array;
    int size;
    int nItems;
    // Constructor
    public ArrayList(){
        size = 8;
        nItems=0;
        array= new int[size];
    }
    // Return how many items are in array
    public int getSize(){
        return nItems;
    }
    // Return number of items it can hold right now even if it is dynamic
    public int getCapacity(){
        return size;
    }
    public boolean isEmpty(){
        return nItems==0;
    }

    public int at(int index){
        if(index<=nItems)
            return array[index];
        else
            System.out.println("Index bigger than size of array");
        return -1;
    }

    public void insert(int index,int item){
        nItems++;
        shouldBeDoubled();
        moveArrayRight(index);
        array[index]=item;
    }

    public void push(int item){ // Add element at the top of array
        array[nItems]=item;
        nItems++;
        shouldBeDoubled();
    }


    public void prepend(int item){ // Insert item at index 0
        nItems++;
        shouldBeDoubled();
        moveArrayRight(0);
            array[0] = item;
    }

    public int pop(){ // Remove item from the end, return value, if
        int item;
        nItems--;
        item=array[nItems];
        shouldBeSqueezed();
        return item;
    }

    public void delete(int index){ // Delete item at index
        nItems--;
        moveArrayLeft(index);
        shouldBeSqueezed();



    }

    public boolean remove(int item){ // Looks for item and remove him
        for(int i=0;i<nItems;i++){
            if(array[i]==item){
                delete(i);
            }
        }
        return false;
    }
    public int find(int item){ //Looks for item and return index of him or -1 if there is non
        for(int i=0;i<nItems;i++){
            if(array[i]==item){
                return i;
            }
        }
        return -1;
    }

    public void printArray(){
        System.out.println("Size of array:"+size);
        for(int i=0;i<nItems;i++){
            System.out.print(array[i]+"->");
        }
        System.out.println();
    }
    // Move whole array to the right from start el
    private void moveArrayRight(int start){
        int[] temp_arr;
        temp_arr=array.clone();
        for(int i =start;i<nItems;i++){

            array[i+1]=temp_arr[i];
        }
    }

    private void moveArrayLeft(int start){
        for(int i=start;i<nItems;i++){
            array[i]=array[i+1];
        }
    }
    // Checking if array should be doubled in size
    private void shouldBeDoubled(){
        if(nItems>=size){
            array = doubleSizeArray();
        }
    }
    private void shouldBeSqueezed(){
        if(nItems<=size/2)
            array = squeezeSizeArray();
    }

    private int[] doubleSizeArray(){
        int [] new_arr;
        new_arr = new int[size*2];
        for(int i =0;i<size;i++){
            new_arr[i]=array[i];
        }
        size = size*2;
        return new_arr;
    }

    private int[] squeezeSizeArray(){
        int[] new_arr;
        new_arr = new int[size/2];
        for(int i=0;i<nItems;i++){
            new_arr[i]=array[i];
        }
        size = size/2;
        return new_arr;
    }



}
