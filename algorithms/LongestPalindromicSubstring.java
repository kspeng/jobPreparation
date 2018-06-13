public class Solution {
    /*
     * @param s: input string
     * @return: the longest palindromic substring
     */

    /*
    Solution 1: brute force

    Time O(n^2)

    Idea: the idea of the solution is to use each index as 'center' of a palindrome, then try to expand around the center,
    The key how to handle either one single palindrome or even palindromes.

    */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 2){
            return s;
        }
        String result="";
        int left,right;
        int maxSize = 0;
        int center = 0;
        for (int i = 0; i < s.length(); i++){
            left = i;
            right = i;
            int size = Math.max(expand(s, left,right),expand(s, left,right + 1));
            if(maxSize < size){
                maxSize = size;
                center = i;
            }
        }
        
        // substring([inclusive, exclusive))
        // example: bb
        // center = 0
        // maxSize = 2
        // left =  0 - (2-1)/2 = 0, right 0 + 2/2 + 1 = 2
        // example: bbb
        // center = 1
        // maxSize = 3
        // left =  1 - (3-1)/2 = 0, right 1 + 3/2 + 1 = 3      

        result = s.substring(center - (maxSize - 1) / 2 ,center + maxSize / 2 + 1);
        return result;
    }
    
    private int expand(String s, int left, int right){
        // aaa => left = 0, right = 2
        // out of loop 
        // left = -1, right = 3 => size = 3 - -1 - 1 = 3
        while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}