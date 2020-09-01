package Tree;

/*
* Binary tree is recursive data struct.
* Each node have most 2 children
* In these case i will only store int values
* It's gonna be binary search tree
* so if new node value is lower than the current node
* we go to the left child
* if the value is greater we go to the right child
* In tree we wont storage same values few times
*
*
*
 */
public class BinaryTree {

    private Node root;

    public BinaryTree(){
        root = null;
    }

    public Node find(int key){
        Node current = root;
        while(current != null){
            if(key <current.value){
                if(current.left==null)
                    return current; // If key we looking for doesnt exist we return parent
                current = current.left;
            } else if(key >current.value){
                if(current.right == null)
                    return current;
                current  = current.right;
            } else {
                return current;
            }
        }
        return null;
    }
    public void put(int value){
        Node newNode = new Node(value);

        if(root== null)
            root = newNode;
        else {
            Node parent = find(value); // We find parent of new node
            if(value<parent.value){ // Assign to the right or left node
                parent.left = newNode;
                parent.left.parent = parent;
            } else {
                parent.right = newNode;
                parent.right.parent = parent;
            }
            return;
        }
    }

    public Boolean remove(int value){
        Node temp = find(value); //Find value
        if(temp.value != value) //if value does not exist
            return false;

        //No children
        if(temp.right == null && temp.left == null) {
            if (temp == root)
                root = null;
            else if (temp.parent.value < temp.value)
                temp.parent.right = null;
            else
                temp.parent.left = null;
            return true;
        } else if(temp.left !=null && temp.right !=null) {
            Node successor = findSuccessor(temp);

            successor.left = temp.left;
            successor.left.parent = successor;

            if (successor.right != null && successor.parent != temp) {
                successor.right.parent = successor.parent;
                successor.parent.left = successor.right;
                successor.right = temp.right;
                successor.right.parent = successor;
            }
            if (temp == root) {
                successor.parent = null;
                root = successor;
            } else {
                successor.parent = temp.parent;

                if (temp.parent.value < temp.value)
                    temp.parent.right = successor;
                else
                    temp.parent.left = successor;
            }
            return true;
        } else { //One child
            if(temp.right!= null){
                if(temp == root){
                    root = temp.right;
                    return true;
                }

                temp.right.parent = temp.parent;

                if(temp.value < temp.parent.value)
                    temp.parent.left = temp.right;
                else
                    temp.parent.right = temp.right;
                return true;
            }
            else {
                if(temp == root){
                    root = temp.left;
                    return true;
                }

                temp.left.parent = temp.parent;

                if(temp.value <temp.parent.value)
                    temp.parent.left = temp.left;
                else
                    temp.parent.right = temp.left;
                return true;
            }
        }
    }

    public Node findSuccessor(Node n){
        if(n.right == null)
            return n;
        Node current = n.right;
        Node parent  = n.right;
        while(current!=null){
            parent = current ;
            current = current.left;
        }
        return parent;
    }

    public Node getRoot() {
        return root;
    }

    // Print leftChild - root - rightChild
    public void inOrder(Node localRoot){
        if(localRoot != null){
            inOrder(localRoot.left);
            System.out.println(localRoot.value+ " ");
            inOrder(localRoot.right);
        }
    }
    // Print root - leftChild - rightChild
    public void preOrder(Node localRoot){
        if(localRoot != null){
            System.out.println(localRoot.value + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    public void postOrder(Node localRoot){
        if(localRoot != null){
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.println(localRoot.value + " ");
        }
    }
    class Node {
        public int value;

        public Node left;
        public Node right;
        public Node parent;

        public Node (int data){
            this.value = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }
}