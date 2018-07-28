public class Solution {
    /**
     * @param num: An integer
     * @return: true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
           while (num >= 2 && num % 2 == 0) {
                num /= 2;
            }
            while (num >= 3 && num % 3 == 0) {
                num /= 3;
            }
            while (num >= 5 && num % 5 == 0) {
                num /= 5;
            }

            return num == 1;
    }
}