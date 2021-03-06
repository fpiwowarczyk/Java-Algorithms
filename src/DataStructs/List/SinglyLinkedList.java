package DataStructs.List;

/*
* My implementation of SinglyLinkedList, im using
* class Node to store values of list and pointer to the next node.
* I will store head and tail pointers to make it faster.
*
* I will define it for a int but i can be defined easy for object
*
* I understand list as : Front> 1st item -> 2nd item -> Back
 */
public class SinglyLinkedList {

    private Node head;
    private int nItems;

    public SinglyLinkedList(){
        head=new Node();
        nItems=0;
    }
    public SinglyLinkedList(Node head,int size){
        this.head = head;
        nItems = 0;
    }
    public int size(){return nItems;} // Return size of LinkedList
    public boolean isEmpty(){ return nItems==0;} // Return true if list is empty

    //Return value of item at given index, -1 there is no element
    public int valueAt(int index){
        Node current = head;
        int position = 0;

        if(index<=nItems) {
            while (position <= index) {
                current = current.next;
            }
            return current.value;
        }
         else {
            return -1;
        }

    }
    // Add new node at the front of LinkedList
    public void pushBack(int value){
        if(head.next==null){
            head.next=new Node(value);

        } else {
            Node current= findEnd();
            current.next=new Node(value);
        }
        nItems++;
    }
    //Remove front item and return its value return -1 and print "DataStructs.List is empty" if LinkedList is empty
    public int popBack(){
        Node secondLast = head;
        if(isEmpty()){
            System.out.println("DataStructs.List is empty");
            return -1;
        }
        Node current=findEnd();
        while(secondLast.next != current){
            secondLast = secondLast.next;
        }
        int item = secondLast.next.value;
        secondLast.next=null;
        nItems--;
        return item;
    }
    // Add item at the end
    public void pushFront(int value){
        Node newNode = new Node(value);
        newNode.next = head.next;
        head.next = newNode;
        nItems++;
    }
    //Removes first item in linkedList and return its value or return -1 and print "DataStructs.List is empty" if its empty
    public int popFront(){
        if(isEmpty()){
            System.out.println("Linked list is Empty");
            return -1;
        }
        int item = head.next.value;
        head.next = head.next.next;
        nItems--;
        return item;
    }

    public int front(){
        return head.next.value;
    }

    public int back(){
        Node current=findEnd();
        return current.value;
    }
    //Insert element at given index, item that was on that index goes to index+1
    public void insert(int index,int value){
        if(index>nItems){
            System.out.println("Index out of bounds");
        } else {
            Node current = goToIndex(index);
            Node oneBeforeCurrent = goToIndex(index - 1);
            Node newNode = new Node(value);
            // Before: oneBeforeCurrent->newNode
            // After: oneBeforeCurrent->newNode->current
            newNode.next = current;
            oneBeforeCurrent.next = newNode;
            nItems++;
        }
    }
    // Removes item from given index
    public void erase(int index){
        if(index>nItems){
            System.out.println("Index out of bounds");
        } else {
            //Before: before -> current -> next
            //After: before -> next
            Node oneBefore = goToIndex(index-1);
            oneBefore.next=oneBefore.next.next;
            nItems--;
        }
    }
    // Returns value of node nth positions from the end , 1 is end of LinkedList
    public int valueNthFromEnd(int n){
        if(n>nItems){
            System.out.println("n is bigger than size of array");
            return -1;
        }else {
            int index = nItems-n;
            Node current = goToIndex(index);
            return current.value;
        }
    }
    // reverse the list
    public void reverse(){
        Node current=head;
        Node prev=null;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head = prev;

    }
    // Remove first item with this value return true if it finds that value
    public boolean removeValue(int valueToRemove){
        Node current = head.next;
        for(int i=0;i<size();i++){

            if(current.value==valueToRemove){
                // Before : oneBefore-> Current -> next
                // After : oneBefore -> next
                Node oneBefore = goToIndex(i-1);
                System.out.println(oneBefore.value);
                oneBefore.next=current.next;
                nItems--;
                return true;
            } else {
                current= current.next;
            }
        }
        return false;
    }

    public void printLinkedList(){
        Node current = head.next;
        System.out.println("Size:"+size());
        while(current!=null){
            System.out.print(current.value+"->");
            current=current.next;
        }
        System.out.println();
    }
    private Node findEnd(){
        Node current = head;
        while(current.next!=null){
            current=current.next;
        }
        return current;
    }

    private Node goToIndex(int index){
        Node current = head;
        int position = 0;
        while(position<=index){
            current = current.next;
            position++;
        }
        return current;
    }
    class Node {
        public int value;
        public Node next;
        public Node(){

        }
        public Node(int value){
            this(value,null);
        }
        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
        public int getValue() {
            return value;
        }
    }// Class Node
}
