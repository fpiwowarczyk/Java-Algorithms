# Java Data Structures
My repo for implementing Data Structures to practice Java coding. Later i will
add other stuff like sorting algorithms implementations.

## What it has?
That repo has my own implementations of Data Structures in Java. Currently, it has:
- ArrayList,
- LinkedList,
- Queue,
- Heap,
- Stack

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
- size() -return size of List
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
 It is implemented with fixed size.A simple stack is super easy in implementation and use.

### Functions:
- pop() - return and remove first element
- push(value) - add new first element of value
- front() - return fist element
- getSize() - return how many elements are in stack
- getCapacity() - return max size of stack
- isFull()- return true if stack is full
- isEmplty() - return true if stack is emplty

### Time
*O(1) - Everything