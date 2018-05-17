public class Solution {
    /*
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication1(int[] nums) {
        /*
            Do it in O(nlogn) time without extra space.

            Time(O) = nlog(n)
            Space(1)
        */
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        Arrays.sort(nums);
        int len = 0;
        for (int left = 0; left < nums.length; left++){
           if(nums[left] != nums[len]){
               nums[++len] =  nums[left]; 
           }
        }
        
        return len + 1;
    }


    /*
        Do it in O(n) time complexity.

        Time(O) = n
        Space(O) = n
    */
    public int deduplication(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Set <Integer> sets = new HashSet<Integer>();
        for (int left = 0; left < nums.length; left++){
            sets.add(nums[left]);
        }
        int left = 0;
        for (Integer data : sets){
            nums[left] = data;
            left++;
        }
       
       
        return sets.size();
    }
}