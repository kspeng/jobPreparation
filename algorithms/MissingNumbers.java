import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {
        // corner case
        if(arr == null || brr == null){
            return null;
        }
        int[] results  = null;
        int size = brr.length - arr.length;
        // corner case
        if(size == 0){
            results = new int[0];
            return results;
        }
        
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for(int b: brr){
            if(mp.containsKey(b) == false){
                mp.put(b,1);
            } else {
                int count = mp.get(b) + 1;
                mp.put(b,count);
            }
        }
        
        for (int a: arr){
            if(mp.containsKey(a)){
                int count = mp.get(a) - 1;
                if(count == 0){
                   mp.remove(a);   
                } else {
                   mp.put(a,count);     
                } 
            }
        }
       int i = 0;
       results = new int[mp.size()];
       for (Map.Entry<Integer, Integer> entry : mp.entrySet()){
            Integer key = entry.getKey(); 
            results[i] = key;
            i++;
        } 
        
        Arrays.sort(results);
        return results;
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
