public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */

/*
 * In order to solve this problem, we must first give the definition of a tree. In graph theory, a tree is basically
 * an acyclic connected graph. Which implies 2 things when graph G is a tree:
 * 
 * 1. G is connected
 * 2. G has n-1 edges
 * 
 * or
 * 
 * 1. G has no simple cycles
 * 2. G has n01 edges
 * 
 * https://en.wikipedia.org/wiki/Tree_(graph_theory)
 */

   /*

        Time complexity: O(V + E), when there are V vertices and E edges
    */
    public boolean validTree1(int n, int[][] edges) {
        if (n == 0){
            return false;
        }
        // valid tree condition 1 : node == edges - 1
        if (n - 1 != edges.length){
            return false;
        }
        
        Map<Integer, Set<Integer>> graph = buildGraph(n, edges);
        
        // bfs to check all connected
        Queue <Integer> queue = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();
        
        queue.offer(0);
        hash.add(0);
        while(queue.isEmpty() == false){
            int node = queue.poll();
            for(Integer neighbor : graph.get(node) ){
                if(hash.contains(neighbor)){
                    continue;
                }
                queue.offer(neighbor);
                hash.add(neighbor);
            }
        }
        
        
        // valid tree condition 2 :all node has to be connected
        return hash.size() == n;
    }
    
     Map<Integer, Set<Integer>> buildGraph(int n, int[][] edges){
         Map<Integer, Set<Integer>> graph = new HashMap<>();
         for(int i = 0; i < n ; i++){
             graph.put(i, new HashSet<Integer>());
         }
         
         for(int i = 0; i < edges.length; i++){
             int a = edges[i][0];
             int b = edges[i][1];
             graph.get(a).add(b);
             graph.get(b).add(a);
         }
         return graph;
     }
}








