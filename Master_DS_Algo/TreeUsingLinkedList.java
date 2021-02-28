package Master_DS_Algo;

public class TreeUsingLinkedList {

    public static Object root = null;
    
    public static void insertNode(Integer value){

        TreeNode newNode = new TreeNode(value);

        if(null == root){
            root = newNode;
        } else {

            Object iteratorPointer = root;
            while(null != ((TreeNode)iteratorPointer).left && null != ((TreeNode)iteratorPointer).right){

                if(value > ((TreeNode)iteratorPointer).value){
                    iteratorPointer = ((TreeNode)iteratorPointer).right;
                } else{
                    iteratorPointer = ((TreeNode)iteratorPointer).left;
                }
            }

            if(value < ((TreeNode)iteratorPointer).value){
                ((TreeNode)iteratorPointer).left = newNode;
            } else {
                ((TreeNode)iteratorPointer).right = newNode;
            }

        }
    }

    public static Integer lookup(Integer value){

        if(null == root){
            return -1;
        } else {

            Object iteratorPointer = root;
            while(null != iteratorPointer){

                if(value < ((TreeNode)iteratorPointer).value){
                    iteratorPointer = ((TreeNode)iteratorPointer).left;
                } else if (value > ((TreeNode)iteratorPointer).value){
                    iteratorPointer = ((TreeNode)iteratorPointer).right;
                } else if (value == ((TreeNode)iteratorPointer).value){
                    return 1;
                }
            }
        }

        return -1;
    }


    
    public static Integer deleteNode(Integer value){

        if(null == root){
            return -1;
        } else if(null != ((TreeNode)root).left && null != ((TreeNode)root).right) {
            Integer temp = ((TreeNode)root).value;
            root = null;
            return temp;
        }
        else{

            Object iteratorPointer = root;
            Object previousRef = null;
            while(null != ((TreeNode)iteratorPointer).left || null != ((TreeNode)iteratorPointer).right){

                previousRef = iteratorPointer;

                if(value > ((TreeNode)iteratorPointer).value){
                    iteratorPointer = ((TreeNode)iteratorPointer).right;
                } else if (value < ((TreeNode)iteratorPointer).value){
                    iteratorPointer = ((TreeNode)iteratorPointer).left;
                } else if (value == ((TreeNode)iteratorPointer).value){
                    break;
                }
            }

            if(null == ((TreeNode)iteratorPointer).left && null == ((TreeNode)iteratorPointer).right){
                if( ((TreeNode) ((TreeNode)previousRef).left).value == value ){
                    Integer retVal = ((TreeNode)((TreeNode)previousRef).left).value;
                    ((TreeNode)previousRef).left = null;
                    return retVal;
                }
                else{
                    Integer retVal = ((TreeNode)((TreeNode)previousRef).right).value;
                    ((TreeNode)previousRef).right = null;
                    return retVal;
                }
            } else {
                Object previousOfSuccesor = iteratorPointer;
                Object successor = findSuccessor(iteratorPointer, previousOfSuccesor);
                
                if( ((TreeNode) ((TreeNode)previousRef).left).value == value )
                    ((TreeNode)previousRef).left = successor;
                else
                    ((TreeNode)previousRef).right = successor;
                
                ((TreeNode)successor).left = ((TreeNode)iteratorPointer).left;
                ((TreeNode)successor).right = ((TreeNode)iteratorPointer).right;
                
                if(null != ((TreeNode)previousOfSuccesor).right){
                    Integer retVal = ((TreeNode)((TreeNode)previousRef).right).value;
                    ((TreeNode)previousOfSuccesor).right = null;
                    return retVal;
                }
                else{
                    Integer retVal = ((TreeNode)((TreeNode)previousRef).left).value;
                    ((TreeNode)previousOfSuccesor).left =null;
                    return retVal;
                }
            }   

        }
        
    } 

    public static Object findSuccessor(Object currentNodePassed, Object previousNode){

        Object currentNode = currentNodePassed;
        while(null != ((TreeNode)currentNode).left || null != ((TreeNode)currentNode).right){
            previousNode = currentNode;
            if(null != ((TreeNode)currentNode).right)
                currentNode = ((TreeNode)currentNode).right;
            else if (null != ((TreeNode)currentNode).left)
                currentNode = ((TreeNode)currentNode).left;
        }

        return currentNode;
    }

    public static void main(String[] args) {
        
        TreeUsingLinkedList treeUsingLinkedList = new TreeUsingLinkedList();

        treeUsingLinkedList.insertNode(9);
        treeUsingLinkedList.insertNode(11);

        System.out.println(treeUsingLinkedList.lookup(9));
        System.out.println(treeUsingLinkedList.lookup(11));

        System.out.println(treeUsingLinkedList);
    }
    
}
