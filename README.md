# Java Algorithms Implementation
My repo for implementing Algorithms to practice Java coding. Later I will
add other stuff like sorting algorithms implementations.

## What it has?
### Data Structures:
- ArrayList,
- LinkedList,
- Stack,
- Queue,
- Heap, 
- HashMapLinearProbing,
- Bag

### Search:
- BinarySearch


# Data Structures
Description of Data Structures 


## ArrayList/Vector
ArrayList is a dynamic array that means u don't have to pass size of it.

### Functions:
-  Size()- get number of elements in it.
- capacity() - actual size of array (but it will change dynamic).
- isEmpty() - return true if there are 0 elements.
- at(index) - return item at given index.
- push(item) - Add an element at front of array.
- insert(index,item) - inserts item at index.
- prepend(item) - insert item at the back of array.
- pop() - remove element from the front of array.
- delete(index) - delete item at the index.
- remove(item) - finds item and delete him.
- find(item) - return index of first item with that value, -1 if not found.


### Time
* O(1) - to add/remove at the end(if these are  no allocations for more space), index or update
* O(n) - to insert/remove element from middle

## SinglyLinkedList
SinglyLinked list is made from two classes: Node and SinglyLinkedList. Node hold value and pointer to the next 
Node. U can search it only in one direction. I implemented it but heard that
it is better than vector only with like 100k elements, but it was pretty challenging
to implement.

### Functions:
- size() -return size of DList
- isEmpty() - return true if there are no elements
- valueAt(index) - return value at given index
- pushFront() - add an element at front of list
- popFront() - return value of element at front and removes it
- pushBack() - add an element at the back of list
- popBack() - return value of element at back and removes it
- front() - return value of element at front
- back() - return value of element at back
- insert(index,value) - insert element in middle of list
- erase(index) - removes element at given index
- valueNthFromEnd(n)- return value Nth element from end
- reverse() - reverse the list[!It isn't working correctly yet!]
-remove_value(value) - removes first item in the list with value

### Time 

* O(1) - Insert,Delete
* O(n) - Access, Search

## Stack
Stack is a data structure with all operations with complexity of O(1).
You can only add and remove first element in the stack.
 It is implemented with fixed size.A simple stack is super easy in implementation and use.Stack is LIFO - Last in first out.
### Functions:
- pop() - return and remove first element
- push(value) - add new first element of value
- front() - return fist element
- getSize() - return how many elements are in stack
- getCapacity() - return max size of stack
- isFull()- return true if stack is full
- isEmpty() - return true if stack is empty

### Time
*O(1) - Everything

## QueueArray
It is a queue FIFO(first in first out) with fixed size and to implement 
that structure I used Array and two pointers read and write. If you write
something write is incremented as well as read is incremented when you read.

### Functions:
- enqueue() - add element to queue
- dequeue() - remove last element from queue
- size() - return how many items are in queue
- capacity() - return capacity of queue
- isFull() - return true when queue is full
- isEmpty - return true when queue is empty

### Time
O(1) - Everything

## QueueLinkedList
Implementation of queue FIFO with LinkedList. It have dynamic size.

### Functions:
- enqueue() - add element to queue
- dequeue() - remove last element from queue
- size() - return how many items are in queue
- capacity() - return capacity of queue
- isEmpty - return true when queue is empty

## HashMapLinearProbing 
It is Data Structure where values are store in pairs of keys and values. 
You insert key and hashmap produce for it unique value and stores it in array 
at that index. It is super use full.

### Functions:
- HashMapLinearProbing(hSize)- constructor of HashMap with initial size of it
- hashFunction(key) - produces value for key
- insertHash(key) - inert key into array.
- deleteHash(key) - find and delete given key
- displayHashTable() - display every bucket of hashtable. Usefull for testing
- exists(key) - check if key is already in table if it is return its index.
- doubleTable() - doubleSize of Array 
- checkLoadFactor() - check how much table is filled if it is bigger than 0.7
size will be doubled.
- isFull() - check if table is full
- isEmpty() - check if table is empty 
- isTrulyFull() - check if table is full, but it iterates through whole table and check that
- isTrulyEmpty()- check if table is full, but it iterates through whole table and check that


# Search
Description of search

## BinarySearch
To find value you looking for your need to use function find(array,key). Where array need to be 
a sorted array of integers and key need to be in that array. Function will return index of key.
BinarySearch split array and check in which half is our value than do the same job until it find our value.

### Times 
- O(log(n))