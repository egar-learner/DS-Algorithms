import java.util.Scanner;

public class Direction_Change {

    public static int[] getInput(){
        int[] inputArr = new int[2];
        Scanner sc = new Scanner(System.in);

        //System.out.println("Input first direction degree");
        inputArr[0] = sc.nextInt();
        //System.out.println("Input the second correct direction degree");
        inputArr[1] = sc.nextInt();

        return inputArr;
    }

    public static int calculateMatchingRotation(int[] input){
        
        int firstDegree = input[0];
        int secondDegree = input[1];

        //Corner cases first
        if(firstDegree == secondDegree)
            return 0;
        else {
            int posRotation = 0;
            
            if(secondDegree > firstDegree && secondDegree<360)
                posRotation = secondDegree - firstDegree;
            else if(secondDegree<firstDegree)
                posRotation = 360-firstDegree+secondDegree;

            return posRotation<=180?posRotation:(posRotation - 360);
        }
    }

    public static void main(String[] args) {
        
        //1. Taking the input parameters
        int[] inputArr = getInput();

        //2. Obtain Rotation
        int res = calculateMatchingRotation(inputArr);

        //System.out.println("My friend has to rotate it to "+ res + " degrees");
        System.out.println(res);
    }
    
}
