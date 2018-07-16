public class Solution {
    /*

    Time O(4^n)
    */
    public List<String> letterCombinations(String digits) {
        
        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        
        dfs(0, digits.length(), "", digits, phone, ans);
        return ans;
    }
    
    private void dfs(int index, int l,  String str, String digits, String phone[], List<String> ans){
        if(index == l){
          ans.add(str);  
            return;
        }
        
        int d = digits.charAt(x) - '0';
        for (char c : phone[d].toCharArray()){
            dfs(index + 1, l, str+c, digits, phone, ans);
        }
        
        
    }
}