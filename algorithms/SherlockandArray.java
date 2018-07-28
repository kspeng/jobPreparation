import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String solve(int[] a){
        String result = "NO";
        if(a == null){
            return result;
        }
        // corner case
        if(a.length == 1){
            return "YES";
        }
        int leftSum = 0;
        int rightSum = 0;
        for(int i = 1; i < a.length; i++){
            int mid = i;
            int left = mid - 1;
            int right = mid + 1;
            
            leftSum = leftSum + a[left];
          // corner case
            if(rightSum == 0){
                while(right < a.length){
                    rightSum = rightSum + a[right];
                    right++;
                }
            } else {
                    rightSum = rightSum - a[mid];
            }
            
            if(rightSum == leftSum){
                 result = "YES";
                 break;
            }
        }
         return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(a);
            System.out.println(result);
        }
    }
}