package Hash;

import java.util.Arrays;

/**
 * HashMap is a data structure to store data
 * in a pairs of keys and values. These implementation
 * stores only int values and have fixed size.
 *
 * It isn't optimal implementation it is only for me
 * to better understand how it works.
 *
 *
 */
public class HashMapLinearProbing {

    private int hSize; // size od table
    private Integer[] buckets; //array representing the table
    private Integer AVAILABLE;
    private int size; // amount of elements in the hash table;


    public HashMapLinearProbing(int hSize){
    this.buckets = new Integer[hSize];
    this.hSize = hSize;
    this.AVAILABLE = Integer.MIN_VALUE;
    this.size = 0;
    }

    // Most simple hash function
    public int hashFunction(int key){
        int hash = key % hSize;
        if(hash <0){
            hash += hSize;
        }
        return hash;
    }

    public void insertHash(int key){
        Integer item = key;
        int hash = hashFunction(key);

        if(isFull()){
            System.out.println("Table is full");
            return;
        }

        for (int i =0;i<hSize;++i){
            if(buckets[hash]==null || buckets[hash]==AVAILABLE){
                buckets[hash] = item;
                size++;
                return;
            }
            if(hash+1<hSize){
                hash++;
            } else {
                hash =0;
            }
        }
    }

    public void deleteHash(int key){
        Integer item = key;
        int hash = hashFunction(key);
        if(isEmpty()){
            System.out.println("Table is empty");
            return;
        }

        for(int i=0;i<hSize;++i){
            if(buckets[hash]!= null && buckets[hash].equals(item)){
                buckets[hash]=AVAILABLE;
                size--;
                return;
            }

            if(hash+1 <hSize){
                hash++;
            } else {
                hash = 0;
            }
        }

        System.out.println("Key:"+item+" not found");
    }

    public void displayHashTable(){
        System.out.println("=====================");
        for(int i = 0; i<hSize;i++){
            if(buckets[i]==null || buckets[i]== AVAILABLE){
                System.out.println("Bucket "+i+": Empty");
            } else {
                System.out.println("Bucket "+i+": "+buckets[i].toString());
            }
        }
        System.out.println("=====================");
    }

    public int exist(int key){
        Integer item = key;
        int hash = hashFunction(key);

        if(isEmpty()){
            System.out.println("Table is empty");
            return -1;
        }

        for(int i=0; i<hSize;++i){
            if(buckets[i]!=null&&buckets[i]!=AVAILABLE){
                if(buckets[i].equals(item)){
                    return i;
                }
            }


            if(hash+1<hSize){
                hash++;
            } else {
                hash=0;
            }
        }
        System.out.println("Key "+key+" not found");
        return -1;
    }

    private void doubleTable(){
        buckets = Arrays.copyOf(buckets,hSize*2);
        hSize*=2;
        System.out.println("Table size is now:"+hSize);
    }
    // Check how much table is filled if it is bigger than 0.7 size will be doubled automatically
    public void checkLoadFactor(){
        double factor = (double)size/hSize;
        if(factor>0.7){
            System.out.println("Load factor is "+factor+", doubling size of table");
        } else {
            System.out.println("Load factor is "+factor);
        }
    }

    // Checking if it is full only looking at variables
    public boolean isFull(){
        return hSize==size;
    }
    // Checking if it is empty only looking at variables
    public boolean isEmpty(){
        return size==0;
    }
    // Iterating trough whole table to see if any element isn't empty
    public boolean isTrulyFull(){
        for(int i =0;i<hSize;++i){
            if(buckets[i]==null||buckets[i]==AVAILABLE){
                return false;
            }
        }
        return true;
    }
    // Iterating trough whole table to see if any element is empty
    public boolean isTrulyEmpty(){
        for(int i =0;i<hSize;++i){
            if(buckets[i]!=null){
                return false;
            }
        }
        return true;
    }
}
