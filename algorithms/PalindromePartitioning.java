public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */

    /*

    O(答案总数 * 构造每个答案的时间) = O(2^n * n)
    
    优化， 我们可以对 isPalindrome 利用推理的关系做预处理


    */
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if(s == null){
            return results;
        }
        List<String> result = new ArrayList<>();
        helper(s,0,result,results);
        
        return results;
    }
    
    
    private void helper(String s,
                        int startIndex, 
                        List<String> result,
                        List<List<String>> results){
        if(startIndex == s.length()){
            results.add(new ArrayList<>(result));
            return;
        }
        for(int i = startIndex; i < s.length(); i++){
            
            String substring = s.substring(startIndex, i + 1);
            if(isPalindrome(substring) == false){
                continue;
            }
            result.add(substring);
            helper(s, i+1, result, results);
            result.remove(result.size() - 1);
        }
        
    }
    
    
    private boolean isPalindrome(String s) {
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        
        
        return true;
    }

}

/*

Speed Optimization
with pre-compired isPalindrome

2^n
*/

public class Solution2 {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
     
    boolean[][] isPalindrome;
    List<List<String>> results;
     
    public List<List<String>> partition(String s) {
        results = new ArrayList<>();
        if(s == null){
            return results;
        }
        
        getIsPalindrome(s);
         
        List<Integer> result = new ArrayList<>();
        helper(s,0,result);
        
        return results;
    }
    
    private void getIsPalindrome(String s){
        int n = s.length();
        isPalindrome = new boolean[n][n];
        // single char
        /*

           a a b
        a [y, , ]
        a [ ,y, ]
        b [, , y]
        */
        for(int i = 0; i < n ; i++){
            isPalindrome[i][i] = true;
        }
        /*

           a a b
        a [y,y, ]
        a [ ,y,x]
        b [, , y]
        */
        for(int i = 0; i < n - 1 ; i++){
            isPalindrome[i][i+1] = (s.charAt(i) == s.charAt(i+1));
        }
        /*
           a a b
        a [y,y,x]
        a [ ,y,x]
        b [, , y]
        */
        // 类推
        for(int i = n - 3; i >= 0; i--){
            for(int j = i + 2; j < n; j++){
                 // [i+1][j-1] look for down, left
                isPalindrome[i][j] = isPalindrome[i+1][j-1] && 
                    (s.charAt(i) == s.charAt(j));
            }
        }
        
    }
    private void helper(String s,
                        int startIndex, 
                        List<Integer> result){
        if(startIndex == s.length()){
           
            addResult(s, result);
            return;
        }
        for(int i = startIndex; i < s.length(); i++){
            
            // from startIndex to i is isPalindrome?
            if(isPalindrome[startIndex][i]== false){
                continue;
            }
            result.add(i); // record the end point
            helper(s, i+1, result);
            result.remove(result.size() - 1);
        }
        
    }
    
    
    private void addResult(String s, List<Integer> partition){
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        for (int i = 0; i < partition.size(); i++) {
            result.add(s.substring(startIndex, partition.get(i) + 1));
            startIndex = partition.get(i) + 1; // last start point
        }
        results.add(result);
    }
}