class Solution {
    /*
        Solution 0:
            Only check isDigit() and isLetter()
        Time Complexity: O(n)
        Space  Complexity: O(1)

    */
        public boolean isPalindrome(String s) {
            if(s == null) {
                return false;
            }
             
            if(s.length() == 0) {
                return true;
            }
     
            
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                if(isValidChar(s.charAt(left)) == false){
                    left++;
                    continue;
                }

                if(isValidChar(s.charAt(right)) == false){
                    right--;
                    continue;
                }

                char leftChar = s.charAt(left);
                char rightChar = s.charAt(right);
                
                if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

        private boolean isValidChar(char c){
            return Character.isLetter(c) || Character.isDigit(c);
        }



    /*  
        Solution 1:
        Time Complexity: O(n)
        Space  Complexity: O(1)
    */
    public boolean isPalindrome(String s) {
        if(s == null) {
            return false;
        }
         
        if(s.length() == 0) {
            return true;
        }
        
        
        s = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while (left < right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(leftChar != rightChar){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}