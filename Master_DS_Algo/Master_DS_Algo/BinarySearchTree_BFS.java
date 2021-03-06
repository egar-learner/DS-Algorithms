package Master_DS_Algo;

import java.awt.List;
import java.util.ArrayList;

// Java program to demonstrate 
// insert operation in binary
// search tree
class BinarySearchTree_BFS {
 
    /* Class containing left 
       and right child of current node
     * and key value*/
    class Node 
    {
        int key;
        Node left, right;
 
        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }
 
    // Root of BST
    Node root;
 
    // Constructor
    BinarySearchTree_BFS() 
    { 
         root = null; 
    }
 
    // This method mainly calls insertRec()
    void insert(int key) 
    { 
         root = insertRec(root, key); 
    }
 
    /* A recursive function to 
       insert a new key in BST */
    Node insertRec(Node root, int key)
    {
 
        /* If the tree is empty,
           return a new node */
        if (root == null) 
        {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
 
    // This method mainly calls InorderRec()
    void inorder() 
    { 
         inorderRec(root); 
    }
 
    // A utility function to 
    // do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    int[] bfsTraversal(Node root){
        int i = 0;
        Node[] que = new Node[7];

        int j = 0;
        int[] list = new int[7]; 

        Node currentNode = root;
        que[i] = currentNode;

        while(null != que[j]){
            int currentEle = i;
            list[j++] = que[i].key;
            if(null != que[currentEle].left){
                que[i++] = que[currentEle].left;
            } 
            if(null != que[currentEle].right){
                que[i++] = que[currentEle].right;
            }
        }

        return list;

    }
 
    // Driver Code
    public static void main(String[] args)
    {
        BinarySearchTree_BFS tree = new BinarySearchTree_BFS();
 
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
 
        // print inorder traversal of the BST
        tree.inorder();

        int[] li = tree.bfsTraversal(tree.root);
        for(int i: li)
            System.out.print(i+" ");
    }
}
