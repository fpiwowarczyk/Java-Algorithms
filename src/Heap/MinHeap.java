package Heap;

import java.util.ArrayList;
import java.util.List;

/*
* Implementation of MinHeap
* Elements are stored like in tree
* Each node has maximum two children and one parent node
* In Minheap key is higher or equal to it's parent's and lower than or equal to its children's
*
*
 */
public class MinHeap {
    private final List<Node> minHeap;
    //Constructor
    public MinHeap(List<Node> listNodes){
        minHeap = new ArrayList<>();
        for(Node node :listNodes){
            if(node != null) insertElement(node);
            else System.out.println("Null element. Not added to heap");
        }
        if(minHeap.size()==0) System.out.println("No element has been added, empty heap");
    }

    public Node getElement(int elementIndex){
        if((elementIndex<=0)||(elementIndex>minHeap.size()))
            throw new IndexOutOfBoundsException("Index out of heap range");
        return minHeap.get(elementIndex-1);
    }
    public int getElementKey(int elementIndex){
        return minHeap.get(elementIndex-1).getKey();
    }

    //Swap two elements
    private void swap(int index1, int index2){
        Node tempNode = minHeap.get(index1-1);
        minHeap.set(index1-1,minHeap.get(index2-1));
        minHeap.set(index2-1,tempNode);
    }
    //Put element in right place
    private void toggleUp(int elementIndex){
        int key = minHeap.get(elementIndex-1).getKey();
        while(getElementKey((int)Math.floor(elementIndex/2.0))>key){
            swap(elementIndex,(int)Math.floor(elementIndex/2.0));
            elementIndex = (int) Math.floor(elementIndex/2.0);
        }
    }

    private void toggleDown(int elementIndex){
        int key = minHeap.get(elementIndex-1).getKey();
        boolean wrongOrder = (key > getElementKey(elementIndex*2))||(key > getElementKey(Math.min(elementIndex*2,minHeap.size())));
        while((2*elementIndex<=minHeap.size())&&wrongOrder){
            if((2*elementIndex<minHeap.size())&&(getElementKey(elementIndex*2+1) < getElementKey(elementIndex*2))){
                swap(elementIndex,2*elementIndex+1);
                elementIndex=2*elementIndex+1;
            } else {
                swap(elementIndex,2*elementIndex);
                elementIndex = 2*elementIndex;
            }
            wrongOrder = (key>getElementKey(elementIndex*2))||(key>getElementKey(Math.min(elementIndex*2,minHeap.size())));
        }
    }

    private Node extractMin(){
        Node result = minHeap.get(0);
        deleteElement(0);
        return result;
    }


    public void insertElement(Node node){
        minHeap.add(node);
        toggleUp(minHeap.size());
    }

    public void deleteElement(int elementIndex){
        if(minHeap.isEmpty())
            System.out.println("EmptyHeap");
        if((elementIndex>minHeap.size()) || (elementIndex<=0))
            throw new IndexOutOfBoundsException("Index out of heap range");
        minHeap.set(elementIndex-1,getElement(minHeap.size()));
        minHeap.remove(minHeap.size());
        if(getElementKey(elementIndex)<getElementKey((int)Math.floor(elementIndex/2.0))) toggleUp(elementIndex);
        else if(((2*elementIndex<=minHeap.size())&&(getElementKey(elementIndex)>getElementKey(elementIndex*2))) ||
                ((2*elementIndex<minHeap.size())&&(getElementKey(elementIndex)>getElementKey(elementIndex*2))))
            toggleDown(elementIndex);
    }

    public Node getElement() {
        return extractMin();
    }

    class Node{
        private final int key;

        public Node(Integer key){
            this.key =key;
        }

        public Integer getKey(){
            return key;
        }

        public boolean equals(Object o){
            if(o!=null){
                if(!(o instanceof Node)) return false;
                Node otherNode = (Node) o;
                return(this.key == otherNode.key);
            }
            return false;
        }
    }
}

