class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        
        int center = 0;
        int longest = 0;
        for(int i = 0; i < s.length(); i++){
            // odd and even
            int len = Math.max(expand(s,i,i), expand(s,i,i+1));
           
            if(len > longest){
                center = i;
                longest = len;
            }
        }
        
        return s.substring(center - (longest - 1) / 2 ,center + longest /2  + 1);
    }
    
    private int expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }
}