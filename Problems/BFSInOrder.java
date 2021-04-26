import java.util.LinkedList;
import java.util.Queue;

//Level-Ordered Traversal
public class BFSInOrder {

    TreeNode root;
    int size;

    class TreeNode {
        int value;
        TreeNode left ;
        TreeNode right;

        TreeNode(int val){
            this.value = val;
            this.left = null;
            this.right = null;
        }
    }

    BFSInOrder(){
        this.root = null;
        this.size = 0;
    }

    TreeNode addNode(TreeNode root,int newVal) {

        if(root == null){
            root = new TreeNode(newVal);
            System.out.println(root.value);
            return root;
        }

        if(newVal < root.value){
            this.root.left = addNode(root.left, newVal);
            System.out.println(this.root.left.value);
        }
        
        if(newVal > root.value){
            this.root.right = addNode(root.right, newVal);
            System.out.println(this.root.right.value);
        }

        this.size++;
        return root;

    }

    public void inOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        int[] q = new int[this.size];

        System.out.println(root.value);
        if(null != this.root)
            queue.offer(root);
        int j = 0;
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            q[j++] = currentNode.value;
            
            System.out.println(currentNode.value + " ");

            if(null != currentNode.left)
                queue.offer(currentNode.left);
            
            if(null != currentNode.right)
                queue.offer(currentNode.right);
        }
    }

    void inorderRec(TreeNode root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.value);
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {

        /**
         *                  10
         *            8             12
         *         5      9     11      13
         * 
         */
        
        BFSInOrder bfsTree = new BFSInOrder();

        bfsTree.addNode(bfsTree.root, 10);
        bfsTree.addNode(bfsTree.root, 8);
        bfsTree.addNode(bfsTree.root, 12);
        bfsTree.addNode(bfsTree.root, 5);
        bfsTree.addNode(bfsTree.root, 9);
        bfsTree.addNode(bfsTree.root, 11);
        bfsTree.addNode(bfsTree.root, 13);

        bfsTree.inorderRec(bfsTree.root);

        bfsTree.inOrderTraversal(bfsTree.root);

    }
    
}
