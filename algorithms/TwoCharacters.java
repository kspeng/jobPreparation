import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the solve function below.
    static int solve(String s) {
        int result = 0;
        if(s == null || s.length() < 2){
            return result;
        }
        // beabeefeab
        // a,b,e,f
        // remove e,f => babab
        
        Set sets = new HashSet();
        for(char c : s.toCharArray()){
            sets.add(c);
        }
        
        List<Character> lists = new ArrayList<Character>(sets);
        for(int i = 0; i < lists.size(); i++){
            for(int j = i + 1; j < lists.size(); j++){
                // only keep a and b
                String pattern = "[^"+lists.get(i)+lists.get(j)+"]";
                String testData = s.replaceAll(pattern,"");
                boolean testFlag = checkConsecutive(testData);
                if(testFlag){
                    // find max length
                    if(testData.length() > result ){
                        result = testData.length();
                    }
                }
            }
        }
        
        return result;

    }
    
    private static boolean checkConsecutive(String testData){
               char last = ' ';
               for (char c : testData.toCharArray()){
                   if(last == ' '){
                       last = c;
                       continue;
                   }

                   if(last == c){
                       return false;
                   }
                   last = c;
               }
               return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = solve(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
