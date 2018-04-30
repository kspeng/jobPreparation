public class Solution {
    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */

    /*

    TimeComplexity O(lg(n))
    */
    public double myPow(double x, int n) {
        boolean isNegative = false;
        
        if(n < 0){
            isNegative = true;
            x = 1/x;
            n = -(n + 1); // avoid over flow, but need make up
        }
        double ans = 1;
        double temp = x;
        
        /*
         
         2^3 = 8
         
         1. n == 3
            ans = 2, temp = 2
            temp = temp * temp = 4;
         2. n == 1
            ans = 8, temp = 4
            
        */
        while (n != 0){
            if (n % 2 == 1){
                ans = ans * temp;
            }
            
            temp = temp * temp;
            n = n/2;
        }
        
        if(isNegative){
           ans = ans * x; 
        }
        
        return ans;
    }
}