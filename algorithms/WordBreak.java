public class Solution {
    /*
      Dynamic Programming 
    */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        int maxLength = getMaxLength(dict);
        
        // 长度为n的单词 有n + 1个切割点 比如: _l_i_n_t_
        boolean[] canBreak = new boolean[s.length() + 1];
        // 当s长度为0时
        canBreak[0] = true;
        
        for(int i = 1; i < canBreak.length; i++){
            for(int j = 1; j <= maxLength && j <= i; j++){
              //i - j 表示从 i 点开始往前j个点的位置
              String str = s.substring(i - j,i);
              //如果此str在词典中 并且 str之前的 字符串可以拆分     
              if(dict.contains(str) && canBreak[i - j]){
                  canBreak[i] = true;
                  break;
              }
            }
        }
        
        return canBreak[canBreak.length - 1];// last one
    }
    
    private int getMaxLength(Set<String> dict){
        int max = 0;
        for(String s : dict){
            max = Math.max(max,s.length());
        }
        return max;
    }

}