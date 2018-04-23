class Solution {

    class Solution1{
    /*
        Time Complexity: O(n^2)
        Space Complexity: O(1)
    */
      public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) {
                return null; 
            }
            for(int i = 0; i < nums.length; i++){
                 for(int j = i + 1; j < nums.length; j++){
                     if(nums[i] + nums[j] == target){
                        return new int [] {i,j};
                     }
                 }
            }
            return null;
        }

    }

    /*
        Time Complexity: O(n)
        Space Complexity: O(n)
    */
    class Solution2 {

        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) {
                return null;
            }
            // data, location
            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            for(int i = 0 ; i < nums.length; i++){
                int data = nums[i];
                int need = target - data;
                if(map.containsKey(need)){
                    return new int [] {map.get(need),i};
                } else {
                    map.put(data,i);
                }
            }
            return null;
        }
    }


    //   如果是平方和呢? Math.pow(x,2)
    class FollowUp1 {

        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) {
                return null;
            }
            // data, location
            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            for(int i = 0 ; i < nums.length; i++){
                int data = square(nums[i]);
                int need = square(target) - data;

                if(map.containsKey(need)){
                    return new int [] {map.get(need),i};
                } else {
                    map.put(data,i);
                }
            }
            return null;
        }

        private int square(int x){
            return Math.pow(x,2);
        }
    }

    /*
        follow up: 如果可以排序呢? 
        
        167. Two Sum II - Input array is sorted

        Two pointers
        
        Time Complexity: O(n)
        Space Complexity: O(1)
    */
    class FollowUp2 {

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
                    return new int [] {left,right};
                } else if (sum < target){
                    // left move to bigger
                    left = left * 2;
                } else {
                    // right move to smaller
                    right = right / 2;
                }
            }

            return null;
        }

    }

}




