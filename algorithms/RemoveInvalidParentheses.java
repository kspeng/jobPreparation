public class Solution {
    /**
     * @param s: The input string
     * @return: Return all possible results
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList<String>();       
        int[] result = getLeftRightCount(s);
        dfs(s, 0, result[0], result[1], results);
        return results;
    }
    
    private void dfs(String s, int startIndex, int leftCount, int rightCount, List<String> results) {
        if(leftCount == 0 && rightCount == 0 && isStringValid(s)) {
            results.add(s);
            return;
        }
        
        for(int i = startIndex; i < s.length(); i++) {
            if(i > startIndex && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            
            if(leftCount > 0 && s.charAt(i) == '(') {
                // remove leftCounter
                String removeLeft = s.substring(0, i) + s.substring(i + 1); 
                dfs(removeLeft, i, leftCount - 1, rightCount, results);
            }
         
            if(rightCount > 0 && s.charAt(i) == ')') {
                //remove right counter 
                String removeRight = s.substring(0, i) + s.substring(i + 1); 
                dfs(removeRight, i, leftCount, rightCount - 1, results);
            }
        }
    }
    
    private boolean isStringValid(String s) {
        int[] result = getLeftRightCount(s);
        return result[0] == 0 && result[1] == 0;
    }
    
    private int[] getLeftRightCount(String s) {
        int[] count = new int[]{0, 0};
        for(char c : s.toCharArray()) {
            if(c == '(') {
                count[0]++;
            }    
            if(c == ')') {
                if(count[0] > 0) {
                    count[0]--;
                } else {
                    count[1]++; // ) first, invalid, we have more right counter
                }
            }
        }
        return count;
    }
}