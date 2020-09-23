package DataStructs.Tree;

public class BinarySearchTree {
   private Node root ;

   public BinarySearchTree(){
       root = null;
   }

   public Node find(int key){
       Node current = root;
       while(current != null){
           if(key < current.value){
               if(current.left == null){
                   return current;
               }
               current = current.left;
           } else if(key > current.value){
               if(current.right==null){
                   return  current;
               }
               current = current.right;
           } else {
               return current;
           }
       }
       return null;
   }

   public void put (Integer value){
       Node newNode = new Node(value);
       if(root == null){
           root = newNode;
       } else {
           Node parent = find(value);

           if(value < parent.value){
               parent.left = newNode;
               parent.left.parent = parent;
           } else {
               parent.right = newNode;
               parent.right.parent = parent;
           }
       }
   }

   public boolean delete(Integer value){
        Node temp = find(value);
        if(temp.value != value){
            return false;
        }

        if(temp.right == null && temp.right == null){ // NO children
            if(temp == root)
                root = null;
            if(temp.parent.value> temp.value)
                temp.parent.right = null;
             else
                temp.parent.left = null;
            return true;
        } else if ( temp.left != null && temp.right != null){
        }

        return false;
   }

   public Node findSuccessor(Node n){
       if(n.right == null)
           return n;
       Node current = n.right;
       Node parent = n.right;
       while(current != null){
           parent = current;
           current = current.left;
       }
       return parent;
   }

    class Node{
        public Integer value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(Integer value){
            this.value = value;
            this.left=null;
            this.right=null;
            this.parent=null;
        }
    }
}
