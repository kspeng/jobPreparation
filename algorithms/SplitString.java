public class Solution {
/*

    Time(solution# *  solution time)
    2^(n-1) * n
*/
    public List<List<String>> splitString(String s) {
         List<List<String>> results = new ArrayList<>();
         if(s == null){
             return results;
         }else if (s.length() == 0) {
            results.add(new ArrayList<>());
            return results;
        }
        
         List<String> result = new ArrayList<>();
         dfs(results, result, 0, s);
         return results;
    }
    
    private void dfs(List<List<String>> results, 
                     List<String> result, 
                     int index, 
                     String s){
        if(index == s.length()){
            results.add(new ArrayList<>(result));
            return;
        }
        //  one character or two characters.
        for (int i = index; i < index + 2 && i < s.length(); i++) {
                String check = s.substring(index, i + 1);
                result.add(check);
                dfs(results, result, i + 1, s);  
                result.remove(result.size() - 1);
        }
        
   
        
    }
}