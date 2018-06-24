public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    /**
     * BFS solution. Similar to the previous solution, we are still performing a BFS on a graph. The difference
     * is that here we find the neighbors(next words) on the go with getNextWords() function. One thing to note is that
     * this approach will generally faster than the previous one since normally n >> L.
     * 
     * Time complexity: O(n * L^2), L for the length of each word
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null) {
            return 0;
        }

        if (start.equals(end)) {
            return 1;
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> hash = new HashSet<>();
        
        dict.add(start);
        dict.add(end);
        
        queue.offer(start);
        hash.add(start);
        int level = 1;
        while(queue.isEmpty() == false){
         level++;
         int size = queue.size();
         for(int i = 0 ; i < size; i++){
            String key = queue.poll();
            for(String word : getNextWords(key, dict)){
                if(hash.contains(word)){
                    continue;
                }
                if(word.equals(end)){
                    return level;
                }
                hash.add(word);
                queue.offer(word);
            }
          }
        }
        
        return 0;
    }
    

    // L * 25 * L
    List<String> getNextWords(String startWords, Set<String> dict){
       List<String> words = new ArrayList<>();
       // L
       for(int i = 0; i < startWords.length(); i++){
           // 25
           for (char c ='a' ; c <='z'; c++ ) {
                if (c == startWords.charAt(i)) {
                    continue;
                }
                // L
               String check = replaceChar(startWords, i, c);
               // L
               if(dict.contains(check)){
                   words.add(check);
               }
           }
               
       }
       return words;
       
    }
    
    String replaceChar(String startWords, int index, char c){
        char [] chars = startWords.toCharArray();
        chars[index] = c;
        
        return  new String(chars);
    }
}