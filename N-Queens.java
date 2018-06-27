public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */

    /*
    This is a permutation like questions

    Time O(答案总数 * 构造每个答案的时间) = n! * n

    */
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> results = new ArrayList<>();
       if(n <= 0){
           return results;
       }
       List<Integer> cols  = new ArrayList<>();
       search(results, cols, n);
       
       return results;
       
    }
    
    private void search(List<List<String>>results, 
                        List<Integer> cols,
                        int n) {
        if(cols.size() == n){
            results.add(drawChessboard(cols));
            return;
        }
        for(int colIndex = 0; colIndex < n; colIndex++ ){
            if(isValid(cols, colIndex) == false){
                continue;
            }
            cols.add(colIndex);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
        }
    }
    private boolean isValid(List<Integer> cols, int column){
        int row = cols.size();
        for(int rowIndex = 0; rowIndex < row; rowIndex++){
            // y1 == y2
            if(cols.get(rowIndex) == column){
                return false;
            }
            // x1 + y1 = x2 + y2
            if(rowIndex + cols.get(rowIndex)  == row + column){
                return false;
            }
            // x1 - y1 = x2 - y2
            if(rowIndex - cols.get(rowIndex)  == row - column){
                return false;
            }
        }
        
        return true;
    }

    private List<String> drawChessboard(List<Integer> result){
        List<String> board = new ArrayList<>();
        for(int row  = 0; row < result.size(); row ++){
            StringBuilder sb = new StringBuilder();
            for(int col = 0; col < result.size(); col++){
                if(result.get(row) == col){
                    sb.append('Q');
                } else {
                    sb.append('.'); 
                }
            }
            board.add(sb.toString());
        }
        
        return board;
    }
    
    
}