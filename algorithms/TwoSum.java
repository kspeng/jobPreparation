class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        // data, location
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < nums.length; i++){
            int data  = nums[i];
            int need = target - data;
            if(map.contains(need)){
                return new int [] {map.get(need),i};
            } else {
                map.put(data,i);
            }
        }
        return null;
    }
}