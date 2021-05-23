import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class to print the sum of all root to leaf paths
 */
public class RootToLeafPaths {

    Node root = null;
    Node head = null;
    List<Integer> paths = new ArrayList<>();
    List<Integer> numbers = new ArrayList<>();

    public List<Integer> getPaths(){
        return this.paths;
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }


    //Node class create node
    class Node {
        Integer value;
        Node left;
        Node right;

        Node(Integer value){
            this.value = value;
            this.left = this.right = null;
        }
    }

    /**
     * Method to print the inorder traversal 
     * taking the root of the tree used for testing the 
     * input
     * @param root
     */
    public void printInOrder(Node root){
        if(root == null)
            return;
        
        printInOrder(root.left);
        System.out.println(root.value);
        printInOrder(root.right);

    }

    /**
     * Method to add all paths after conversion from String to Integer 
     * so that later can be summed up to get the final paths
     * @param path
     * @param len
     */
    void addToArray(int path[], int len) 
    {
        int i;
        StringBuilder str = new StringBuilder();
        for (i = 0; i < len; i++) 
            str.append(path[i]);
        this.getNumbers().add(Integer.parseInt(str.toString()));
    }

    /**
     * Method to print all paths from root to leaf node
     * @param root
     * @param path
     * @param pathLen
     */
    void printPaths(Node root, int path[], int pathLen) 
    {
        if (root == null)
            return;
   
        path[pathLen] = root.value;
        pathLen++;
   
        if (root.left == null && root.right == null)
            addToArray(path, pathLen);
        else
            { 
            
            printPaths(root.left, path, pathLen);
            printPaths(root.right, path, pathLen);
        }
    }

    /**
     * Method to create a new node
     * @param value
     * @return
     */
    public Node getNewNode(Integer value){
        return new Node(value);
    }


    /**
     * Method to specify the input order explicitly 
     * Input : Takes one by one element and fill the
     *          tree from left to right
     * @return root node
     */
    public Node createTree(){

        Scanner sc = new Scanner(System.in);
        Node node = null;
        System.out.println("Enter value of the current elements as arrays");

        int value = sc.nextInt();

        if(value ==-1)
            return null;

        node = this.getNewNode(value);
        System.out.println("Enter value of the left current elements as arrays" + value);
        node.left = createTree();
        System.out.println("Enter value of the right current elements as arrays" + value);
        node.right = createTree();

        return node;
    }


    public int[] getInput(){

        var sc = new Scanner(System.in);
        System.out.println("Enter tree elements as arrays, Elements can be between 0-9\n Any format eg.  1,2,3,4  or  1 2 3 4  or  1234");
        String inputString = sc.nextLine();
        sc.close();

        if(inputString.contains(" ")){

        return getInputWithSpaces(inputString);

        } else if(inputString.contains(",")){

        return getInputWithComma(inputString);

        } else{

        return getInputWithDeliminator(inputString);

        }
        
    }

    private int[] getInputWithSpaces(String inputString) {
        String[] intStrings = inputString.split(" ");
        int[] inputs = new int[intStrings.length];
        var i = 0;
        for(String s: intStrings){
            inputs[i++] = Integer.valueOf(s);
        }
        return inputs;
    }

    private int[] getInputWithComma(String inputString) {
        String[] intStrings = inputString.split(",");
        int[] inputs = new int[intStrings.length];
        var i = 0;
        for(String s: intStrings){
            inputs[i++] = Integer.valueOf(s);
        }
        return inputs;
    }

    private int[] getInputWithDeliminator(String inputString) {
        int[] inputs = new int[inputString.length()];
        for(var i=0;i<inputString.length();i++){
            inputs[i] = Integer.valueOf(String.valueOf(inputString.charAt(i)));
        }
        return inputs;
    }

    public void insertValueInSameOrder(int[] input){

        List<Node> treeNodes = new ArrayList<>();
        if(input.length>0){
            treeNodes.add(this.getNewNode(input[0]));
            this.root = treeNodes.get(0);
        }
        
        for(int i = 1,j=0;i<input.length;){
            Node current = treeNodes.get(j);
            Node leftChild = this.getNewNode(input[i]);

            current.left = leftChild;
            treeNodes.add(leftChild);
            i++;

            if(i<input.length){
                Node rightChild = this.getNewNode(input[i]);
                current.right = rightChild;
                treeNodes.add(rightChild);
            }
            i++;
            j++;
        }
    }

    public int doTreeOperations(){

        //1. Getting the input
        int[] input = this.getInput();

        
        //2. Insert values into tree
        this.insertValueInSameOrder(input);

        //4. Adds paths to the array
        int path[] = new int[1000];
        this.printPaths(this.root,path,0);

        //5. Printing result
        return this.getNumbers().stream().reduce(0, (a,b)->a+b);
        
    }

    public static void main(String[] args) {
        
        RootToLeafPaths rootClass = new RootToLeafPaths();

        int sum = rootClass.doTreeOperations();
        System.out.println("Total sum of all paths = "+ sum);
    }
    
}
