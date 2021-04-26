import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;


public class FindThePath {

    static Scanner sc = new Scanner(System.in);

    static class InputClass {
        static int[][] content;
        static HashMap<String, List<Integer>> paths;
    }

    public static void getContentInput(){
        int[] inputArr = new int[2];

        for(int i=0;i<inputArr.length;i++){
            inputArr[i] = sc.nextInt();
        }
        int r = inputArr[0];
        int c = inputArr[1];

        int[][] contentMap = new int[r][c];
        for(int i=0;i<contentMap.length;i++){
            String line = sc.next();
            for(int j=0;j<line.length();j++){
                contentMap[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        InputClass.content = contentMap;
    }

    public static void getPaths() {

        HashMap<String, List<Integer>> hmap = new HashMap<>();

        int paths = sc.nextInt();

        for(int k = 0,j=1;k<paths;k++){
            List<Integer> startCoordinate = new ArrayList<>(2);
            List<Integer> endCoordinate = new ArrayList<>(2);
            for(int i=0;i<4;i++){
                int num = sc.nextInt();
                if(i<=1)
                    startCoordinate.add(num);
                else
                    endCoordinate.add(num);
                
                if(i==1)
                    hmap.put("start"+j++, startCoordinate);
                if(i==3)
                    hmap.put("start"+j++, endCoordinate);   
            }
        }

        InputClass.paths = hmap;
    }

    public static void getInput(){

        getContentInput();

        getPaths();

    }

    public static boolean isMoveable(int x,int y, int checkVal){
        return x>=0 && x<InputClass.content.length 
                && y>=0 && y<InputClass.content[0].length 
                && InputClass.content[x][y] == checkVal? true: false;
    }

    public static boolean doesPathExist(int a, int b, int x, int y, int checkVal) {
        //Boundary Conditions first
        //Base condition
        //Since the starting and the ending point will be same
        if((a==x && b==y))
            return true;
        //if((a==0 || b==0))
        //    return false;

        if(isMoveable(a,b,checkVal)){

            //If moving row-wise can give result
            if(doesPathExist(a+1, b, x, y,checkVal))
                return true;
            //If moving column-wise can give result
            if(doesPathExist(a, b+1, x, y,checkVal))
                return true;

            if(doesPathExist(a-1, b, x, y, checkVal))
                return true;
            
            if(doesPathExist(a, b-1, x, y, checkVal))
                return true;

        }

        //This will only be executed if the above 2 recursive calls are failed
        return false;

    }

    public static void findSolution(){

        for(int i=0;i<InputClass.paths.size();i+=2){
            int startIndex_X = (InputClass.paths.get("start"+(i+1))).get(0)-1;
            int startIndex_Y = (InputClass.paths.get("start"+(i+1))).get(1)-1;
        

            int endIndex_X = (InputClass.paths.get("start"+(i+2))).get(0)-1;
            int endIndex_Y = (InputClass.paths.get("start"+(i+2))).get(1)-1;
    
            int pathValue = InputClass.content[startIndex_X][startIndex_Y];
            
            if(InputClass.content[startIndex_X][startIndex_Y] == InputClass.content[endIndex_X][endIndex_Y]){
                boolean result = false;
                if(startIndex_X != endIndex_X && startIndex_Y != endIndex_Y)
                    result = doesPathExist(startIndex_X, startIndex_Y, endIndex_X, endIndex_Y,
                             pathValue);
                else
                    result = true;
            
            System.out.println(result? pathValue==0?"binary":"decimal":"neither");
            } else
                System.out.println("neither");
            
        }
    }

    public static void main(String[] args) {
        
        TreeSet<String> set = new TreeSet<>();
        set.add("Manish");
        set.add("Anish");
        System.out.println(set);

        //1. Getting the input
        getInput();

        //Modularising code
        findSolution();
        
    }

}
