package Master_DS_Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge2SortedArrays {

    public static void main(String[] args){

        merge2SortedArrays(Arrays.asList(1,6,9,12,15,18,20), Arrays.asList(2,5,7,10,16));

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(6);
        list1.add(9);
        list1.add(12);
        list1.add(15);
        list1.add(18);
        list1.add(20);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(5);
        list2.add(7);
        list2.add(10);
        list2.add(16);
        

        merge2SortedArraysBetterThanBrute(list1, list2);
    }
 
    //This method will contain the solution to merge 2 sorted Integer List arrays into 1
    public static void merge2SortedArrays(List<Integer> li1, List<Integer> li2){

        List<Integer> retLi = new ArrayList<>();
        for(int i=0,j=0;(i<li1.size())&&(j<li2.size());){
            if(li1.get(i)<=li2.get(j)){
                retLi.add(li1.get(i));
                i++;
            } 
            else if(li1.get(i)>=li2.get(j)){
                retLi.add(li2.get(j));
                j++;
            }
        }

        if(li1.size()>li2.size()){
            for(int i=li2.size();i<li1.size();i++)
                retLi.add(li1.get(i));
        }
        else if(li1.size()<li2.size()) {
            for(int i=li1.size();i<li2.size();i++)
                retLi.add(li2.get(i));
        }

        else if(li1.size()==li2.size())
            retLi.add(li1.get(li1.size()-1)>li2.get(li2.size()-1)?li1.get(li1.size()-1):li2.get(li2.size()-1));

        System.out.println(retLi);
    }

    //This method will contain the solution to merge 2 sorted Integer List arrays into 1
    //Need to correct the implementation
    public static void merge2SortedArraysBetterThanBrute(List<Integer> li1, List<Integer> li2){

        int i = 0;
        int j = 0;
        List<Integer> retLi = new ArrayList<>();

        while(!li1.isEmpty() || !li2.isEmpty()){
            if(!li1.isEmpty() && !li2.isEmpty()){
                if(li1.get(i)<=li2.get(j)){
                    retLi.add(li1.get(i));
                    li1.remove(i);
                    i++;
                } else {
                    retLi.add(li2.get(j));
                    li2.remove(j);
                    j++;
                }
            } else if(!li1.isEmpty() && li2.isEmpty()){
                retLi.add(li2.get(j));
                li2.remove(j);
                j++;
            } else if( li1.isEmpty() && !li2.isEmpty()){
                retLi.add(li1.get(i));
                li1.remove(i);
                i++;
            }
        }

        System.out.println(retLi);
    }
}
