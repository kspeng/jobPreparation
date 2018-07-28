public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char [] arrays = str.toCharArray();
        
        for(char c : arrays) {
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
            } else {
                map.put(c, 1);
            }
        }
        for(char c : arrays){
            if(map.get(c) == 1){
                return c;
            }
        }
        // dummy
        return 'a';
    }
}