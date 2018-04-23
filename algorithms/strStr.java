class Solution {
    /*

        Time Complexity O(n^2)
        Space Complexity O(1)
    */
    public int strStr(String source, String target) {
        if(source == null || target == null){
            return 0;
        }
       
        for(int sIndex = 0; sIndex < source.length() - target.length() + 1; sIndex++){
            int tIndex; 
            for(tIndex = 0; tIndex < target.length(); tIndex++){
                if(source.charAt(sIndex + tIndex) != target.charAt(tIndex)){
                    break;
                }
            }
           if(tIndex == target.length()){
                     return sIndex;
            }
        }
        
        return -1;
    }
}