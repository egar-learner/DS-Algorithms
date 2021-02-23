package Master_DS_Algo;

import java.util.HashMap;
import java.util.Hashtable;

//In this class we try to solve the below problem
// If we have a common elements between 2 strings or not?
// O/p: True , if common elements exists
//      False, if no common elements exist

public class UsingHashTablesToRemoveN2 {

    public static void main(String[] args){
        String[] str1 = {"Manish", "Ramesh", "Suresh", "Ramu"};
        String[] str2 = {"Raju", "Ram", "Shyam", "Rahul", "Chintu", "Manish"};

        bruteForceSolution(str1, str2);
        betterThanBruteSolution(str1, str2);

    }

    //Method taking 2 String arrays and trying to find if they have any common elements among them
    public static void bruteForceSolution(String[] strArr1, String[] strArr2){

        boolean flag = false;
        for( String s: strArr1)         // if n = size of strArr1
            for( String s2: strArr2){   // if m = size of strArr2
                if(s.equals(s2)){
                    System.out.println("TRUE");
                    flag = true;
                    break;
                }
            }
        
        if(!flag)
            System.out.println("FALSE");
        
        // Time complexity of this program  = ( n * m )
    }

    //Method taking 2 String arrays and trying to find if they have any common elements among them
    public static void betterThanBruteSolution(String[] strArr1, String[] strArr2){

        HashMap<String, Boolean> strExist = new HashMap<>();
        boolean flag = false;

        for( String s: strArr1){         // if n = size of strArr1
            if(null == strExist.get(s))
                strExist.put(s, true);
        }

        System.out.println(strExist);

        for( String s2: strArr2){   // if m = size of strArr2
            if(null != strExist.get(s2)){
                System.out.println("TRUE");
                flag = true;
                break;
            }
        }
        
        if(!flag)
            System.out.println("FALSE");
        
        // Time complexity of this program  = ( n + m )
    }
    
}
