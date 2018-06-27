public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */


    /*

    Time complexity: O(# of solutions * time complexity for each solution). 
    # of solutions is at most # of subsets * which is 2^n. 

    Time complexity for each solution is greatly determined by target, for instance, it takes at least
     * 1000 loops if given candidates [1] and target 1000. Some

    The number of recursive calls, T(n) satisfies 
    the recurrence T(n) = T(n - 1) + T(n - 2) + ... + T(1) + T(0), which solves to T(n) = O(2^n). 
    Since we spend O(n) time within a call, the time complexity is O(n*2^n);
    
    Discussions:
    http://www.1point3acres.com/bbs/thread-117602-1-1.html

    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //1. duplicate => de dup / sort -> 2* 2 3* 3 4 5 6
        //2. sum = target =？ curSum == target or target - cursum = 0
        //3. 数可以重复使用 startIndex => i
        
        List<List<Integer>> results = new ArrayList<>();
        if(candidates == null){
            return results;
        }
        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<>();
        int startIndex = 0;
        helper(candidates, startIndex, combination, target, results);
        
        return results;
    }
    // 递归的定义
    private void helper(int[] candidates, 
                        int startIndex, 
                        List<Integer> combination, 
                        int remindSum, 
                        List<List<Integer>> results) {
        // 递归的出口
        if(remindSum == 0){
            // deep copy
            results.add(new ArrayList<Integer>(combination));
            return;
        }
        // 拆解[] -> [1], [2], [3] .... 
        for(int i = startIndex; i < candidates.length; i++){
            // 去重
            if(i != 0 && candidates[i] == candidates[i-1] ){
                continue;
            }
            if(candidates[i] > remindSum){
                break;
            }
            // [] => [1]
            combination.add( candidates[i] );
            // i = startIndex ，可以有重复的combination
            helper(candidates, i, combination, remindSum - candidates[i], results );
            // 回溯
            combination.remove(combination.size() - 1);
        }
        
    } 
}















