public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    /*
        Basic Binary Search
        Time = O(lg(n) )

    */
    public int lastPosition(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                // keep checking right
                start = mid;
            } else if(nums[mid] > target) {
                end = mid;
            } else  {
                start = mid;
            }
        }
        // check last first
        if(nums[end] == target){
            return end;
        }
        if(nums[start] == target){
            return start;
        } 
      
        return -1;
    }
}