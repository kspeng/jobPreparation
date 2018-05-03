/*

Calculate the an % b where a, b and n are all 32bit integers.


For 231 % 3 = 2
For 1001000 % 1000 = 0

*/

public class Solution {
    /*
		No Recursion:

			1.Time Compleixty: O(log(n))
			(A * B) mod C = (A mod C * B mod C) mod C

        a^(1010)2 = a^(1000)2 ∗ a^(10)2
		
    */
    public int Solution1_fastPower(int a, int b, int n) {
    
        boolean isNegative = false;
        if(n < 0) {
            isNegative = true;
            a = 1/a;
            n = -(n+1);
        }
  
        long ans = 1, temp = a;
        
        while(n != 0) {
            if (n%2 == 1){
                ans = (ans * temp) % b;    
            }
            temp = (temp * temp) % b;
            n = n /2;
        }
  
        if(isNegative) {
           ans = ans * a;
        }
        return (int) (ans%b);
    }

    /*
        Recursion Solution

    */

     public int Solution1_fastPower(int a, int b, int n) {

        if(n == 1){

        }

        if(n == 0){

        }

        
     }

}











