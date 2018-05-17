public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */

    /*
    Time (n)
    Space (1)
    */
    public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1){
            return new int [0];
        }
        int size = nums.length + 1 - k;
        int results = int [size];
        int sum = 0;
        int resultCount = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            // i = 2, k = 3 -1
            if(i >= k-1){
                results[resultCount] = sum;
                resultCount++;
                sum = sum - nums[resultCount - 1];
            }
        }
        return results;
    }

    public int[] winSum2(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length < k || k <= 0)
            return new int[0];

        int[] sums = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++)
            sums[0] += nums[i]; // first sum
        // - pre + later
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] - nums[i - 1] + nums[i + k-1];
        }
        return sums;
    }
}