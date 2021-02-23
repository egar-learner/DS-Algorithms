package Master_DS_Algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstRecuringNumber {

    public static void main(String[] args){

       
        int result = returnRecuringNumber(Arrays.asList(1,6,9,1,9,1,20));
        System.out.println("Recurring Integer" + result);
    }

    public static int returnRecuringNumber(List<Integer> li1)  {

        Set<Integer> mp = new HashSet();

        for( Integer i: li1){
            if(mp.contains(i))
                return i;
            else
                mp.add(i);
        }

        return 0;
    }  
    
}
