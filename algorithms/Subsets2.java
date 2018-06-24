public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */

     /*

      time = n * 2^n


      For example:

      [1,2',2'']

      [
        [2'],
        [1],
        [1,2',2''],
        [2',2''],
        [1,2'],
        []
      ]

      Note there are no [1,2''] or [2''] or [2'',2']
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> results = new ArrayList<>();
      if(nums == null){
          return results;
      }
      if(nums.length == 0){
          results.add(new ArrayList<Integer>());
          return results;
      }
      // sort for remove duplicate
      Arrays.sort(nums);
      List<Integer> subset = new ArrayList<Integer>();
      
      helper(nums,0,results, subset);
      
      return results;
    }
    
    void helper(int[] nums, int startIndex, List<List<Integer>> results,List<Integer> subset ){
         //deep copy
         results.add(new ArrayList<Integer>(subset));

         // 构造每个答案的时间 = n
         for(int i = startIndex; i < nums.length; i++){
               // remove duplicates
               if(i != startIndex && nums[i-1] == nums[i]){
                  continue;
               }

               subset.add(nums[i]);
               helper(nums, i + 1,results, subset);
               
               // backtrace
               subset.remove(subset.size() - 1);
         }   
    }
}