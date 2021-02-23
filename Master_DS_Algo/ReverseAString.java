package Master_DS_Algo;

public class ReverseAString {

    public static void main(String[] args){
        
        String reversedStr = reverseAStringBruteForce("Manish is good boy");

        String reversedStrSame = reverseAStringbetterThanBruteForce("Manish is good boy");
    }

    //This is a brute force approach to reverse a string
    public static String reverseAStringBruteForce(String str){

        //New char[] was getting created, more space
        // O(n), Since we have a loop

        char[] charArray = str.toCharArray();
        System.out.println(charArray);
        char[] retArray = new char[charArray.length];

        for(int i = charArray.length-1, j=0;i>=0;i--,j++)
            retArray[j] = charArray[i];

        System.out.println(retArray);

        return retArray.toString();
    }


    //This is a brute force approach to reverse a string
    public static String reverseAStringbetterThanBruteForce(String str){

        //No extra char[] to reverse
        // O(n/2) = O(n) , better than the previous
        
        char[] charArray = str.toCharArray();
        System.out.println(charArray);

        for(int i = charArray.length-1, j=0;j<i;i--,j++){
            char c = charArray[j];
            charArray[j] = charArray[i];
            charArray[i] = c;
        }

        System.out.println(charArray);

        return charArray.toString();
    }
    
}
