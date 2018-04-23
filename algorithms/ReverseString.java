class Solution {
    /*

        In memory swap
        
        Time Complecity: O(n)

    */

    public String reverseString(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        int left = 0;
        int right = s.length() - 1;
        char [] newS = s.toCharArray();
        while(left < right){
            char temp = s.charAt(right);
            newS[right] = s.charAt(left);
            newS[left] = temp;
            left++;
            right--;
        }
        
        return new String(newS);
        
    }
}