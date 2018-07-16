public class Solution {
    /*
     * @param : A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> results = new ArrayList<>();
        
        if (str == null) {
            return results;
        }
        
        char[] s = str.toCharArray();
        Arrays.sort(s);
        String tmp = new String();
        
        int[] visited = new int[str.length()];

        helper(results, tmp, visited, s);
        return results;
    }
    private void helper(List<String> results, 
                        String tmp, 
                        int[] visited, 
                        char[] s) {
                            
       if (tmp.length() == s.length) {
           results.add(tmp);
           return;
       }
       
       for (int i = 0; i < s.length; i++) {
            if (visited[i] == 1){
                   continue;
            }
            // pick first and cannot pick the second
            if( i != 0 && s[i] == s[i - 1] && visited[i - 1] == 0) {
                   continue;
            }
            // check each char
            visited[i] = 1;
            helper(results, tmp + s[i], visited, s);
            visited[i] = 0;
               
       }
       
    }
};