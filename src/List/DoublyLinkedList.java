package List;

import java.awt.*;

/*
* My implementation of DoublyLinkedList.
*
* It's holds values.
* There are links between previous and next node
* List do not have any indexes.
* U don't need to predetermine size
 */
public class DoublyLinkedList {
    private Link head;

    private Link tail;

    public DoublyLinkedList(){
        head = null;
        tail = null;
    }

    public DoublyLinkedList(int[] array){
        if(array == null){
            throw new NullPointerException();
        }
        for(int i: array){
            insertTail(i);
        }
    }

    public void insertHead(int x){
        Link newLink = new Link(x);
        if(isEmpty()){
            tail = newLink;
        } else {
            head.previous = newLink;
        }
            newLink.next = head;
            head = newLink;
    }

    public void insertTail(int x){
        Link newLink = new Link(x);
        newLink.next = null;
        if(isEmpty()){
            tail = newLink;
            head = tail;
        } else {
            tail.next = newLink;
            newLink.previous = tail;
            tail = newLink;
        }
    }

    public Link deleteHead(){
        Link temp = head;
        head = head.next;
        head.previous = null;
        if(head == null){
            tail = null;
        }
        return temp;
    }

    public Link deleteTail(){
        Link temp = tail;
        tail = tail.previous;
        tail.next = null;
        if(tail == null){
            head = null;
        }
        return temp;
    }

    public void delete(int x){ // Delete element of value "x" from list
        Link current = head;

        while(current.value != x){
            if(current != tail){
                current = current.next;
            } else {// If element doesnt exist
                throw new RuntimeException("The element does not exist");
            }
        }
        if(current == head){
            deleteHead();
        } else if(current == tail){
            deleteTail();
        } else {
            current.previous.next = current.next; //Before 1<->2(current)<->3 After: 1->3
            current.next.previous = current.previous;//Before 1->3 (2 is current but it's hard to draw) After: 1<->3
        }
    }

    public void insertOrdered(int x) {
        Link toInsert = new Link(x);
        Link current = head;
        while (current != null && x > current.value) { //Find pos to insert
        current= current.next;
        }

        if(current == head){
            insertHead(x);
        } else if(current==null){
            insertTail(x);
        } else { //Before : 1<-> 2(current) <-> 3
            toInsert.previous = current.previous; //1<- toInsert
            current.previous.next = toInsert; // 1<->toInsert
            toInsert.next = current; // 1<-> toInsert -> 2(current) <->3
            current.previous = toInsert; // 1<-> toInsert <-> 2(current)<-> 3
        }
    }
    public Boolean isEmpty(){
        if(head == null){
            return true;
        } else {
            return false;
        }
    }

    public void display() {
        Link current = head;
        while(current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}
class Link {
    public int value;

    public Link next;

    public Link previous;

    public Link(int value){
        this.value = value;
    }
    public void displayLink(){
        System.out.print(value+" ");
    }

}