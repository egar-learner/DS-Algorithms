package Master_DS_Algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashTableSelf {

    static Map<Long, Map<String, Integer>> mp = null;

    HashTableSelf(){
        this.mp = new HashMap<>(50);
    }

    public static void main(String[] args) {
        HashTableSelf hashTableSelf = new HashTableSelf();
        hashTableSelf.put("apple", 5);
    }

    //This method is to calculate the hash code for each string
    public static long _hash(String key){
        long hash = 0;
        for( int i =0; i<key.length();i++){
            hash = (hash + key.codePointAt(i)*i) % 50;
        }
        return hash;
    }

    public static void put(String key, Integer value){

        long address = _hash(key);
        Map<String, Integer> m = new HashMap<>();
        m.put(key, value);
        mp.put(address, m);
        System.out.println(mp);
    }
    
}
