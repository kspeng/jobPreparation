class Solution {
    public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) {
                return null;
            }
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                int leftData = nums[left];
                int rightData = nums[right];
                int sum = leftData + rightData;
                if (sum == target){
                    return new int [] {left + 1,right + 1};
                } else if (sum < target){
                    left++;
                } else {
                    right--;
                }
            }

            return null;
    }
}