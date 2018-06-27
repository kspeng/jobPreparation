public class Solution {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */

    /*
    O (n* n!)
    */
    int count = 0;
    public int totalNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if(n < 0){
            return 0;
        }
        List<Integer> result = new ArrayList<>();
        helper(results,result,n);
        
        return count;
    }
    
    private void helper(List<List<String>> results,List<Integer> result,int n){
        if(result.size() == n){
            count++;
        }
        
        for(int colIndex = 0; colIndex < n; colIndex++){
            if(isValid(result, colIndex) == false){
                continue;
            }
            
            result.add(colIndex);
            helper(results,result, n);
            result.remove(result.size() - 1);
        }
    }
    
    private boolean isValid(List<Integer> result, int col){
        int row = result.size();
        for(int r = 0 ; r < row; r++){
            if(col == result.get(r)){
                return false;
            }
            if(r + result.get(r) == row + col ){
                return false;
            }
             if(r - result.get(r) == row - col ){
                return false;
            }
        }
        
        return true;
    }
  
}