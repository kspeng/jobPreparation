import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        // corner case, null, empty, single digit, and start with 0
        if (s == null || s.length() < 2 || s.charAt(0) == '0'){
            System.out.println("NO");
            return;
        }
        //1234
        //split
        long min = -1;
        for(int i = 1; 2* i <= s.length(); i++){
            String testString = s.substring(0,i);
            long testLong = Long.valueOf(testString);
            // keep the min
            min = testLong;
            StringBuilder sb = new StringBuilder(); 
            while(sb.length() < s.length()){
                sb.append(testLong);
                testLong++;
            }
            if(sb.toString().equals(s)){
                System.out.println("YES "+min);
                return;
            }
          
        }        
     
        System.out.println("NO");
        return;
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
