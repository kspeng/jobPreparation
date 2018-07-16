public class Solution {
    /*  INPUTS:

        "lintcode"
        ["de","ding","co","code","lint"] 
        
        OUTPUTS: ["lint co de","lint code"]
    
    */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String,List<String>> done = new HashMap<>();
        done.put("",new ArrayList<>());
        done.get("").add("");
        
    
        return dfs(s,wordDict,done);
    }
    private List<String> dfs(String s, Set<String> wordDict,   Map<String,List<String>> done){
        if (done.containsKey(s)) {
            return done.get(s);
        }
        
        List<String> ans = new ArrayList<>();
        
        for (int len = 1; len <= s.length(); len++) {  //将s 分割成s1 s2  其中s1长度为len
            String s1 = s.substring(0, len);
            String s2 = s.substring(len); // last will be ""
            // divide and conquer
            if (wordDict.contains(s1)) {
                // dfs 分解
                List<String> s2_res = dfs(s2, wordDict, done);
                for (String item : s2_res) {
                    if (item == "") // is this the last one like "de" or "code"
                    {
                        ans.add(s1);
                    } else {
                        ans.add(s1 + " " + item);
                    }
                }
            }
             
        }
         
        done.put(s, ans);
        return ans;
    }
    
}