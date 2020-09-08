# Java Data Structures
My repo for implementing Data Structures to practice Java coding. Later i will
add other stuff like sorting algorithms implementations.

## What it has?
That repo has my own implementations of Data Structures in Java. Currently, it has:
- ArrayList,
- LinkedList,
- Queue,
- Heap,
- Tree

# Data Structures
Description of Data Structures 
##ArrayList/Vector
ArrayList is a dynamic array that means u don't have to pass size of it.

Functions in it:
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

###Time
* O(1) - to add/remove at the end(if these are  no allocations for more space), index or update
* O(n) - to insert/remove element from middle
