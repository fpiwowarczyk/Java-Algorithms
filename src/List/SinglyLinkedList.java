package List;


/*
* My try  to implement SinglyLinked List.
*
* SinglyLinkedList hold values.
* Links in linked list do net have indexes.
* U do not have to predetermine size as it's grows and shrinks.
* Elements can only be added/removes at the head of list.
*
 */
public class SinglyLinkedList {

    private Node head; // front of list

    public void insertHead(int x){
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }

    public void insertNth(int data,int position) {
        if (position < 0 || position > getSize()) {
            throw new RuntimeException("Position is less than zero or more than size of list");
        } else if (position == 0) {
            insertHead(data);
        } else {
            Node current = head;
            Node node = new Node(data);
            for (int i = 1; i < position; ++i) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }
    }

    public void deleteHead() {
        if(isEmpty()){
            throw new RuntimeException("The list is empty!");
        }
        head = head.next;
    }

    public void deleteNth(int position) {
        if(position <0 || position >= getSize()){
            throw new RuntimeException("Position is less than zero or more than size of list ");
        } else if(position ==0){
            deleteHead();
        } else {
            Node current = head;
            for(int i = 1;i< position ;++i){
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    public Boolean isEmpty() {
        if(getSize()==0) {
            return true;
        } else {
            return false;
        }
    }
    public void display(){
        Node current =head;
        while(current != null){
            System.out.println(current.value +" ");
            current=current.next;
        }
        System.out.println();
    }
    public int getSize(){
        if(head == null){
            return 0;
        } else {
            Node current = head;
            int size = 1;
            while(current.next != null){
                current = current.next;
                size++;
            }
            return size;
        }
    }
}

class Node {
    int value; // value od node

    Node next;

    Node(int value){
        this.value = value;
        this.next = null;
    }
}