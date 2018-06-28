public class Solution {
    /**
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        return num == reverse(num);
    }
    
    int reverse(int num){
        int result = 0;
        while(num > 0){
            result = result*10 + num%10;
            num = num /10;
        }
        
        return result;
    }
}
