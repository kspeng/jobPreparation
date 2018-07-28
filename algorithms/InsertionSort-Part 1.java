import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    /*
        5
        2 4 6 8 3
        ***********
        2 4 6 8 8 
        2 4 6 6 8 
        2 4 4 6 8 
        2 3 4 6 8 
        
        
        5
        1 2 4 5 0
    */
    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        // corner case
        if(arr == null || arr.length == 0 || arr.length != n){
            return;
        }
        
        int temp = arr[n-1];
        for (int i = n - 2, j = n - 1 ; i >= 0; i--,j--){
            int data = arr[i];
            if(temp < data){
                // pull back
                arr[j] = data;
                printArray(arr);
            } else {
                // insert
                arr[j] = temp;
                printArray(arr);
                break;
            }
        }
        // corner case
        if(temp < arr[0]){
            arr[0] = temp;
            printArray(arr);
        }
        
        

    }
    private static void printArray(int[] arr){
        for(int i : arr){
          System.out.print(""+i+" ");
        }
        System.out.println();
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}
