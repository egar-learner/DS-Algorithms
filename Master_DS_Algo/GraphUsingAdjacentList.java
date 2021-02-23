package Master_DS_Algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class GraphUsingAdjacentList {

    public static Map<Integer, List<Integer[]>> treeMap = new HashMap<>();

    public static void insertNode(Integer nodeVal){

        if(null == treeMap.get(nodeVal)){
            treeMap.put(nodeVal, new ArrayList<>());
        }
    }

    public static void insertEdge(Integer firstVal, Integer secondVal){

        if(null != treeMap.get(firstVal)){
            Integer[] newList = {firstVal, secondVal};
            Integer[] newListR = {secondVal, firstVal};
            System.out.println(newList);
            treeMap.get(firstVal).add(newList);
            treeMap.get(secondVal).add(newListR);
        }
    }

    public static void showConnections(){

        for(Map.Entry<Integer, List<Integer[]>> entrySet : treeMap.entrySet()){
            System.out.print(entrySet.getKey().intValue() + " : ");
            for(Integer[] li: entrySet.getValue()){
                System.out.print("("+li[0].intValue() + "," + li[1].intValue()+"),");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphUsingAdjacentList graphUsingAdjacentList = new GraphUsingAdjacentList();
        graphUsingAdjacentList.insertNode(0);
        graphUsingAdjacentList.insertNode(1);
        graphUsingAdjacentList.insertNode(2);
        graphUsingAdjacentList.insertNode(3);
        graphUsingAdjacentList.insertNode(4);
        graphUsingAdjacentList.insertNode(5);
        graphUsingAdjacentList.insertNode(6);

        graphUsingAdjacentList.insertEdge(3, 1);
        graphUsingAdjacentList.insertEdge(3, 4);
        graphUsingAdjacentList.insertEdge(4, 2);
        graphUsingAdjacentList.insertEdge(4, 5);
        graphUsingAdjacentList.insertEdge(1, 2);
        graphUsingAdjacentList.insertEdge(1, 0);
        graphUsingAdjacentList.insertEdge(0, 2);
        graphUsingAdjacentList.insertEdge(6, 5);
        graphUsingAdjacentList.showConnections();


    }
    
}
