public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */


     /*

    搜索的时间复杂度：O(答案总数 * 构造每个答案的时间)
    Subsets问题，求所有的子集。子集个数一共 2^n，每个集合的平均长度是 O(n) 的，所以时间复杂度为 O(n * 2^n)，
        
        子集个数 = 2^3 = 8
        每个集合的平均长度 = 3

        For example:
        [1,2,3]

        [
          [3],
          [1],
          [2],
          [1,2,3],
          [1,3],
          [2,3],
          [1,2],
          []
        ]
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null){
            return results;
        }
        // []
        if(nums.length == 0){
            results.add(new ArrayList<>());
            return results;
        }
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        
        helper(nums, results, subset, 0);
        return results;
    }
    
    void helper(int[] nums,List<List<Integer>> results, List<Integer> subset, int startIndex){
        // deep copy
        results.add(new ArrayList(subset));

        for(int i = startIndex; i < nums.length; i++){
            subset.add(nums[i]);
            helper(nums,results,subset,i+1);
            // back track
            subset.remove(subset.size() - 1);
        }
        
    }
    
    
}