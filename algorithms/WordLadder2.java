public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */

    /*

         1. use BFS to calculate the distance between each word and endWord (End to Start)
         2. use DFS to find all shortest ladders, while each step must reduce the distance by 1
         (Start to Esnd)
         Time O(n* L^2)
    */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> results = new ArrayList<>();
        Map<String, Integer> distance = new HashMap<>();
        // find the distance between each words with endword
        dict.add(start);
        dict.add(end);
        bfs(end, distance, dict);

        // find all shortest ladders
        List<String> result = new ArrayList<>();
        dfs(start, end, dict, distance, result, results);

        return results;
    }
    // dfs find all combinations
    private void dfs(String current, 
                    String end,
                    Set<String> dict,  
                    Map<String, Integer> distance,
                    List<String> result,
                    List<List<String>> results ){
                        
        result.add(current);   
        // exit
        if(result.get(result.size() - 1).equals(end) ){
            // deep copy
            results.add(new ArrayList<>(result));
        } else {
            for(String nextWord: getNext(current,dict)){
                // closer, key is existed word
                if(distance.containsKey(nextWord) && 
                   distance.get(current) - distance.get(nextWord) == 1){

                    dfs(nextWord, end, dict, distance, result, results);
                }
                
            
            }
        }
        
        result.remove(result.size() - 1);
        
    }
    // get distance from end to start by BFS
    private void bfs(String end, Map<String, Integer> distance, Set<String> dict ){
        Queue<String> queue = new LinkedList<>();
        queue.offer(end);
        distance.put(end, 0);
        int level = 1;
        while(queue.isEmpty() == false){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String s = queue.poll();
                for(String nextWord: getNext(s,dict)){
                    if(distance.containsKey(nextWord)){
                        continue;
                    }
                    queue.offer(nextWord);
                    distance.put(nextWord, level);
                    
                }
            }
            level++;
        }
    }
    
    private List<String> getNext(String word, Set<String> dict){
        List<String> words = new ArrayList<>();
        
        for(int i = 0; i < word.length(); i++){
            for(char c = 'a'; c <= 'z'; c++){
                if(word.charAt(i) == c){
                    continue;
                }
                String newWord = replaceWord(word,i,c);
                if(dict.contains(newWord)){
                    words.add(newWord);
                }
            }
        }
        
        return words;
    }
    
    private String replaceWord(String word, int index, char c){
        char[] chars = word.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
}