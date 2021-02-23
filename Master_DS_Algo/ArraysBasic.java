package Master_DS_Algo;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArraysBasic {

    public static void main(String[] args) {

        doBasicsOnStaticArray();
    }

    //This method is to perform basic checks on Arrays and their complexities
    public static void doBasicsOnStaticArray() {

        List<String> listStr = new ArrayList<>(List.of("Manish", "Rahul", "Ballu", "Lallu"));

        int i = 2;
        System.out.println(i+(i>>1));
        //Acess Random location
        System.out.println(listStr.get(2));         // O(1)


        //Insert @ End
        listStr.add("Tillu");   // O(1)

        //Insert @ Start
        listStr.add(0, "Papu");     // O(n), Since there will be a shift operation performed on the list to accomodate the new element at the first index

        //Insert Inbetween
        listStr.add(3, "Bablu");    // O(n), As we ignore the constants O(n/2) = O(n) 

        System.out.println(listStr);


    }
    
}
