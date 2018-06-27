public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */

    /**
     * A DFS recursive solution. The key here is how to avoid duplicate permutations. Similar to Subsets II and
     * Combination Sum II, we need to select representative. This means when 2 identical element, the later one can only
     * be selected if the previous one is selected as well.
     * 
     * Example:
     * given [a1, a2, b] where a1 and a2 have same value
     * permutation [b, a1, a2] -> OK
     * permutation [b, a2, a1] -> NOT OK since a2 can only come after a1
     * 
     * This way we can ensure that there will be no duplications in result.
     * For example,
     * [1,2,3] have the following permutations:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     *
     * 
     *   O(答案总数 * 构造每个答案的时间) = n! * n =（3 * 2 * 1） * 3
     *   O(n! * n)
     */

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null){
            return results;
        }
        
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums,visited,result,results);
        
        return results;
    }
    
    private void helper(int[] nums, 
                        boolean[] visited ,
                        List<Integer> result,
                        List<List<Integer>> results){
        if(result.size() == nums.length){
            results.add(new ArrayList<>(result));
            return;
        }
        // n
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            // skip duplicates, select first duplicate
            // [1,2',2''] => select 2' , skip 2‘’ 
            if( i != 0  && nums[i] == nums[i-1] && visited[i-1] == false){
                continue;
            }
                visited[i] = true;
                result.add(nums[i]);
                helper(nums,visited,result,results);
                visited[i] = false;
                result.remove(result.size() - 1);
        }
    }
};