public class Solution {
    /**
     * @param n: An integer
     * @param str: a string with number from 1-n in random order and miss one number
     * @return: An integer
     */
    public boolean found = false;
    public int ans = 0;
    
    public int findMissing2(int n, String str) {
        boolean[] happen = new boolean[n + 1];
        dfs(0, n, str, happen);
        return ans;
    }
    
    private void dfs(int i, int n, String str,boolean[] happen ){
        //递归的出口
        if(i >= str.length() || found){
            if(found == false){
                // if not found and at the end of the str
                for (int k = 1; k <= n; k++) {
                    if(happen[k] == false){
                        ans = k;
                    }
                }
            }  
            found = true;
            return;
        }
        
        int index = str.charAt(i) - '0';
        int j = i;
        // corner case
        if (index == 0) {
            return;
        }
        // check multiple digits
        while (index <= n) {
            
           if (happen[index] == false) {
               happen[index] = true;
               dfs(j + 1, n, str, happen);
               // backtrack
               happen[index] = false;
           }
           
           j++;
           if(j >= str.length()) {
               break;
           }
           
           int nextDigit = str.charAt(j) - '0';
           // check more digits
           index = index * 10 + nextDigit;
           
        }
        
        
    }
}