public class Solution {
    
    /*

        Memory O(1)
        Time O(n)

    */
    public int findMissing(int[] nums) {
        int n = nums.length;
        /*
            N = 3
            total = 0 + 1 + 2 + 3 = 6
            total = (1 * 3) * 3 / 2 = 6
        */
        // find the total suppose be
        int total = (1 + n) * n / 2;
        for (int i = 0; i  < n ; i++){
            total = total - nums[i];
        }
        return total;
    }
}