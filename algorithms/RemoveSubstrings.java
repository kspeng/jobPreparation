public class Solution {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
     
     /*
     BFS:
     
     这题的答案用的是bfs，bfs的时间复杂度就是进队的次数也就是所有可能的情况数，举个特殊情况

     input: abcdefg ["a", "b", "c", "d", "e", "f", "g"]
     情况数就是2^n ,n是字符串长度，因为所有的情况里每个字符都有“出现”和“不出现”两种情况

     */
    public int minLength(String s, Set<String> dict) {
        if(s == null || s.length() == 0 || dict.size() == 0){
            return 0;
        }
       int min = s.length();
       
       Queue<String> queue = new LinkedList<>();
       Set<String> set = new HashSet<>();
       queue.offer(s);
       set.add(s);
     
       
       while(queue.isEmpty() == false){
           s = queue.poll();
           for(String sub: dict){
               int found = s.indexOf(sub);
               while(found != -1){
                    String newS = s.substring(0, found) + s.substring(found + sub.length(), s.length());
                   if(!set.contains(newS)){
                       if(min > newS.length()){
                           min = newS.length();
                       }
                       queue.offer(newS);
                       set.add(newS);
                   }
                 found = s.indexOf(sub,found + 1);
               }
           }
       }
       
       
        
      return min;
    }
}