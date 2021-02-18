package Master_DS_Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Sample {

    public static void main(String[] args){
        List<String> listStr = new ArrayList<>();
        listStr.add("Nemo");

        String[] list100Str = new String[100000];
        Arrays.fill(list100Str, "Nemo");

        listStr.stream().forEach(i->
        {   if(i.equals("Nemo"))
                System.out.println(i);
        });

        long time1 = new Date().getTime();
        int count = 0;
        for(String s: list100Str){
            if(s.equals("Nemo")){
                System.out.print("Found");
                count++;
            }
        }
        long time2 = new Date().getTime();

        System.out.println("Count = " + count + " time taken " + (time2-time1));
    }
    
}
