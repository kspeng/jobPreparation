public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */

    /*

    The number of recursive calls, T(n) satisfies 
    the recurrence T(n) = T(n - 1) + T(n - 2) + ... + T(1) + T(0), which solves to T(n) = O(2^n). 
    Since we spend O(n) time within a call, the time complexity is O(n * 2^n);

    http://www.1point3acres.com/bbs/thread-117602-1-1.html
    
    */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if(num == null){
            return results;
        }
        List<Integer> result = new ArrayList<>();
        Arrays.sort(num);
        helper(num, target, 0, result, results);
        return results;
    }
    
    
    private void helper(int[] num, 
                        int target,
                        int startIndex, 
                        List<Integer> result,
                        List<List<Integer>> results){
        if(target == 0){
            results.add(new ArrayList<>(result));
            return;
        }
        
        for(int i = startIndex; i < num.length; i++){
            if(num[i] > target){
                return;
            }
            // start with 1'
            if(i != startIndex && num[i-1] == num[i] ){
                continue;
            }
            result.add(num[i]);
            int reminder = target - num[i];
            helper(num, reminder, i + 1, result, results);
            result.remove(result.size() - 1);
            
        }
        
    }
}