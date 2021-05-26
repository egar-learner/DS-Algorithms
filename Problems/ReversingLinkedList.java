public class ReversingLinkedList {

    Node head;
    Node tail;

    public ReversingLinkedList(){
        this.head = null;
        this.tail = null;
    }

    class Node{
        Node next;
        int val;

        Node(Integer num){
            this.val = num;
            this.next = null;
        }
    }

    public Node createNode(Integer num){
        return new Node(num);
    }

    public void addNode(Integer num){

        if(this.head == null){
            this.head = this.tail = createNode(num);
            return;
        }

        this.tail.next = createNode(num);
        this.tail = this.tail.next;
    }

    public void printList(){

        Node current = this.head;

        while(current.next != null){
            System.out.print(current.val+"->");
            current = current.next;
        }
        System.out.println(current.val);
    }

    public void reverseList(){
        Node current, previous, after;

        current = this.head;
        this.tail = current;

        after = current.next;

        while(after != null){
            previous = current;
            current = after;
            after = after.next;
            current.next = previous;
        }

        this.head = current;
        this.tail.next = null;

    }


    public static void main(String[] args) {
        ReversingLinkedList reversingLinkedList = new ReversingLinkedList();

        reversingLinkedList.addNode(1);
        reversingLinkedList.addNode(2);
        reversingLinkedList.addNode(3);
        reversingLinkedList.addNode(4);
        reversingLinkedList.addNode(5);

        reversingLinkedList.printList();
        reversingLinkedList.reverseList();
        reversingLinkedList.printList();
    }
    
}
