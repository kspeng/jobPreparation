/*
Time O(n^2)
Space O(n)
*/
class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        if( s.length() == 1){
            return 1;
        }
        int solution = 0;
        for(int i = 0; i < s.length(); i++){
            if(solution > s.length() - i){
                break;
            }
            Set<Character> map = new HashSet<>();
            for(int j = i; j < s.length(); j++){
                 Character c = s.charAt(j);
                 if(map.contains(c) == false){
                     map.add(c);
                 } else {
                     break;
                 }
            }
            if(map.size() > solution){
                solution = map.size();
            }
        }

        return solution;

    }

}
/*
    Time O(n)
    Space O(1)
*/
class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        int[] cnt = new int[256];
        char[] sc = s.toCharArray();
        
        int ans = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            cnt[sc[r]]++;
            // when r has more than 1, then we have duplicate
            while (cnt[sc[r]] > 1) {
                // move left pointer, until only have no duplicate
                cnt[sc[l]]--;
                l++; // move left char
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}