class Solution {
    /*

        Sample 
            String s = "aabbccdefg";
            String s = "aabbcc";

        Time Complexity O(n);
        Space Complexity O(1); Because the space for our count, as the alphabet size of s is fixed. 
    */
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0 ){
            return 0;
        }
        
        int [] hashData = new int [256];
        
        for (char c : s.toCharArray()){
            hashData[c]++;
        }
        
        int evenPair = 0;
        int oddNum = 0;
        
        for (int i: hashData){
            evenPair = evenPair + i /2;
            oddNum = oddNum + i % 2;
        }
        
        return evenPair * 2 + Math.min(1,oddNum);
    }
}