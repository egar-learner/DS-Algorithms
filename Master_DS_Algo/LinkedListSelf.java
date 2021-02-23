package Master_DS_Algo;

import java.util.ArrayList;
import java.util.List;

public class LinkedListSelf {

    static Object head = null;
    static Object tail = null;

    LinkedListSelf(){

    }

    public static void addElementAtEnd(String value) { 
        //Creating a new node
        Node newNode = new Node(value);

        if(null == head){
            head = newNode;
            tail = newNode;
        } else { 
            Node lastElement = (Node) tail;
            lastElement.next = newNode;
            tail = newNode;
        }
    }

    public static void prependElementAtStart(String value){
        Node newNode = new Node(value);

        if(null == head){
            newNode.next = head;
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
            
        }

    }

    public static void insertInMiddleOfLinkedList(String value, String insertAfter) {
        Node newNode = new Node(value);

        if(null == head){
            head = newNode;
            tail = newNode;
        } else {

            Object iteratorInsert = head;

            while(null != iteratorInsert){
                if(((Node)iteratorInsert).value == insertAfter){
                    Object temp = ((Node)iteratorInsert).next;
                    ((Node)iteratorInsert).next = newNode;
                    newNode.next = temp;
                    break;
                } else{
                    iteratorInsert = ((Node)iteratorInsert).next;
                }
            }
        }
    }

    public static void removeItemWithValue(String value){

        Object iteratorInsert = head;
        Object previous = head;
        int count = 0;

        while(null != iteratorInsert){
            if(((Node)iteratorInsert).value == value){
                break;
            } else{
                if(count>0)
                    previous = iteratorInsert;
                else
                    count++;
                iteratorInsert = ((Node)iteratorInsert).next;
            }
        }

        if(iteratorInsert == head){
            head = ((Node)iteratorInsert).next;
        } else if( iteratorInsert == tail){
            tail = previous;
            ((Node)tail).next = null;
        } else {
            ((Node)previous).next = ((Node)iteratorInsert).next;
        }   

    }

    //brute force solution with all the extra fields and just what comes in the mind in the first go
    public static LinkedListSelf reverseAnylinkedList(LinkedListSelf linkedList) {

        Object iterator = head;
        List<String> valuesOfLinkedList = new ArrayList<>();
        LinkedListSelf returnLinkedList = new LinkedListSelf();
        while(null != iterator){
            valuesOfLinkedList.add((String)(((Node)iterator).value));
            iterator = ((Node)iterator).next;
        }

        for(int i = valuesOfLinkedList.size()-1;i>=0;i--){
            returnLinkedList.addElementAtEnd(valuesOfLinkedList.get(i));
        }

        return returnLinkedList;

    }

    public static void reverse(){

        boolean flag = false;

        if(head == tail || null == head){
            return;
        } else {
            Object first = head;
            tail = head;
            Object second = ((Node)head).next;
            while(null != second){
                Object third = ((Node)second).next;
                ((Node)second).next = first;
                first = second;
                second = third;
            }
            ((Node)head).next = null;
            head = first;
        }

    }


    public static void main(String[] args){

        LinkedListSelf linkedListSelf = new LinkedListSelf();

        linkedListSelf.addElementAtEnd("FirstNode");
        linkedListSelf.addElementAtEnd("SecondElement");
        linkedListSelf.addElementAtEnd("ThirdValue");

        System.out.println("After appending at the end-------------------");
        Object iterator = head;
        while(null != iterator){
            System.out.println(((Node)iterator).value);
            iterator = ((Node)iterator).next;
        }


        linkedListSelf.prependElementAtStart("BeforeFirstNode");
        linkedListSelf.prependElementAtStart("BeforeFirstNodeBefore");

        System.out.println("After prepending at the beginning------------");
        iterator = head;
        while(null != iterator){
            System.out.println(((Node)iterator).value);
            iterator = ((Node)iterator).next;
        }

        linkedListSelf.insertInMiddleOfLinkedList("BetweenSecondThird", "SecondElement");
        linkedListSelf.insertInMiddleOfLinkedList("BetweenBeforeFirstAndFirst", "BeforeFirstNode");

        System.out.println("After insertion in between--------------------");
        iterator = head;
        while(null != iterator){
            System.out.println(((Node)iterator).value);
            iterator = ((Node)iterator).next;
        }

        linkedListSelf.removeItemWithValue("ThirdValue");
        linkedListSelf.removeItemWithValue("BeforeFirstNodeBefore");
        linkedListSelf.removeItemWithValue("SecondElement");


        System.out.println("After removal of 3 elements one from starting one from ending and one from middle");

        iterator = head;
        while(null != iterator){
            System.out.println(((Node)iterator).value);
            iterator = ((Node)iterator).next;
        }

        System.out.println("After reversing the linked List-------------------------");

        //brute force method call
        //This will work good when not done with static 
        //because of static it is taking a single copy of head and tail that's why it it printing 
        //in both order and reversed way.
        //LinkedListSelf reversed = reverseAnylinkedList(linkedListSelf);

        System.out.println("------------------------------------------------------");
        
        reverse();
        iterator = head;
        while(null != iterator){
            System.out.println(((Node)iterator).value);
            iterator = ((Node)iterator).next;
        }

    }
    
}



