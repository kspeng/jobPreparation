import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the stockmax function below.
    static Long stockmax(int[] prices) {
        Long result = 0L;
        if(prices == null || prices.length < 2){
            return result;
        }
        int size = prices.length;
        Long maxPrice = (long)prices[size - 1];
        // 1 2 100
        for(int i = size - 2; i >= 0; i--){
            if(prices[i] > maxPrice){
                maxPrice = (long)prices[i] ;
            }    
            result = result + maxPrice - prices[i];
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] prices = new int[n];

            String[] pricesItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int pricesItem = Integer.parseInt(pricesItems[i]);
                prices[i] = pricesItem;
            }

            Long result = stockmax(prices);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
