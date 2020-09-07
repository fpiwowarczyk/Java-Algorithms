package Bag;


import java.util.Iterator;
import java.util.NoSuchElementException;

/*
* A collection that let's you only add elements and iterate them
* and dont let you remove them
*
*
 */
public class Bag<Element> implements Iterable<Element> {

    private Node<Element> firstElement; //first element of the bag
    private int size; //size of bag

    private static class Node<Element> {
        private Element value;
        private Node<Element> nextElement;
    }

    public Bag(){
        firstElement = null;
        size = 0;
    }

    public boolean isEmpty(){
        return firstElement==null;
    }
    public int size() {
        return size;
    }
    public void add(Element element){
        Node<Element> oldFirst = firstElement;
        firstElement=new Node<>();
        firstElement.value = element;
        firstElement.nextElement = oldFirst;
        size++;
    }

    public boolean contains(Element element){
        Iterator<Element> iterator = this.iterator();
        while(iterator.hasNext()){
            if(iterator.next().equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Element> iterator() {
        return new ListIterator<>(firstElement);
    }

    @SuppressWarnings("hiding")
    private class ListIterator<Element> implements Iterator<Element>{

        private Node<Element> currentElement;

        public ListIterator(Node<Element> firstElement){
            currentElement = firstElement;
        }

        @Override
        public boolean hasNext() {
            return currentElement != null;
        }

        @Override
        public Element next() {
            if(!hasNext())
                throw new NoSuchElementException();
            Element element = currentElement.value;
            currentElement = currentElement.nextElement;
            return element;
        }
    }
}
