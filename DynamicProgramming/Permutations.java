public class Permutations {

    public static void printArr(int[] a){
        for(int i: a)
            System.out.print(i+ " ");
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void permutate(int[] arr,int cur){
        if(cur == arr.length-1){
            printArr(arr);
            return;
        } else{
            for(int i=cur;i<arr.length;i++){
                System.out.println();
                swap(arr,i,cur);
                permutate(arr, cur+1);
                swap(arr,i,cur);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        permutate(arr, 0);
    }
    
}
