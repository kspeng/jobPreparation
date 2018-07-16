public class Solution {
   /*
    Time = num of soluton * solution time
     这个跟排序有关, n! => (n-1) * (n-2) .... to the k
   
   */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        if(n < 1 || k < 1){
            return results;
        }
        
        List<Integer> result = new ArrayList<>();
        dfs(n, k, 1 ,  result, results);
        return results;
    }
    
    private void dfs(int n, int k, int index,   List<Integer> result,  List<List<Integer>> results){
        
        if(result.size() == k){
            results.add(new ArrayList(result));
            return;
        }
        
        for (int i = index; i <= n; i++){
            
            result.add(i);
            dfs(n, k, i + 1 , result, results);
            result.remove(result.size() - 1);
        }
    }
}