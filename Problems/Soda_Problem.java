import java.util.Scanner;

public class Soda_Problem {

    public static int[] getInput(){
        int[] inputArr = new int[3];
        Scanner sc = new Scanner(System.in);

        //System.out.println("Enter the values for Tim : \n" 
        //+"Empty bottles he has ?,,Empty bottles he will find in the day?,,Empty bottles required to get a new soda can");
        
        int i=0;
        while(i<inputArr.length){
            inputArr[i++] = sc.nextInt();
        }
        
        /*
        inputArr[0]= sc.nextInt();
        System.out.println("Empty bottles he will find in the day?");
        inputArr[1] = sc.nextInt();
        System.out.println("Empty bottles required to get a new soda can");
        inputArr[2] = sc.nextInt();*/

        return inputArr;
    }

    public static int calculateBottlesConsumed(int[] input){

        int initialEmptyBottles = input[0] + input[1];
        int bottlesRequiredForNew = input[2];

        // Corner cases first
        if(initialEmptyBottles == 0 || initialEmptyBottles < input[2])
            return 0;
        else{
            //Total number of bottles consumed by tim will be stored here
            int bottlesConsumedResult = 0;
            //Saving the intial result into another variable for iteration. 
            //So that we don't alter the original values
            int availableBottles = initialEmptyBottles;
            //Iterating till there is something to calculate on
            while(availableBottles >= bottlesRequiredForNew){

                int remainingBottles = availableBottles % bottlesRequiredForNew;
                int bottlesTaken = availableBottles / bottlesRequiredForNew;
                

                bottlesConsumedResult += bottlesTaken;
                availableBottles = bottlesTaken + remainingBottles;
            }

            return bottlesConsumedResult;
        }
    }

    public static void main(String[] args) {
        
        //1. Getting the input
        int[] inputArr = getInput();

        //2. Calculate Tim consumption quantity on a thirsty day
        int bottlesDrank = calculateBottlesConsumed(inputArr);

        //System.out.println("Thirsty Tim drank "+ bottlesDrank + " bottles today.");
        System.out.println(bottlesDrank);
    }
    
}
