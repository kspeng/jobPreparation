public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null){
            return results;
        } 
        List<Integer> result  = new ArrayList<>();
        Set<Integer> hash  = new HashSet<>();
        Arrays.sort(nums);
        helper(nums,hash,result,results);
        
        return results;
    }
    
    private void helper(int[] nums, 
                        Set<Integer> hash,
                        List<Integer> result,
                        List<List<Integer>> results){
        if(result.size() == nums.length){
            // deep copy
            results.add(new ArrayList<>(result));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(hash.contains(nums[i])){
                continue;
            }
            hash.add(nums[i]);
            result.add(nums[i]);
            helper(nums,hash,result,results);
            hash.remove(nums[i]);
            result.remove(result.size() - 1);
        }
    }
}