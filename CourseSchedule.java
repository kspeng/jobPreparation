public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
     
     /*
     Time( O(V+E) )
     
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //1. build graph 
        Map<Integer, Set<Integer>> graph = buildGraph(numCourses, prerequisites);
        //2. find out indegree
        Map<Integer, Integer> indegree = getIndegree(graph);
        //3. find roots to start
        Queue<Integer> startRoots = getRoots(indegree, graph);
        //4. bfs
        List<Integer> results = runBFS(startRoots, indegree, graph);
        
        if(numCourses == results.size()){
               return true;  
        }
        return false;
    }
    List<Integer> runBFS( Queue<Integer> startRoots, Map<Integer, Integer> indegree,  Map<Integer, Set<Integer>> graph) {
        // add no dependency nodes 
        List<Integer> results = new ArrayList(startRoots);
        while(startRoots.isEmpty() == false){
            int fromNode = startRoots.poll();
            
            for(int nb: graph.get(fromNode)) {
                int newCount = indegree.get(nb) - 1; // unlock toNode
                indegree.put(nb, newCount);
                if(newCount == 0){
                   results.add(nb); 
                   startRoots.offer(nb);
                }
            }
        }
        
        return results;
        
        
    }
    Queue<Integer> getRoots( Map<Integer, Integer>indegree,  Map<Integer, Set<Integer>> graph){
        Queue<Integer> startRoots = new LinkedList<>();
        for(int node: graph.keySet()){
            if(indegree.get(node) == 0){
                startRoots.offer(node);
            }
        }
        
        return startRoots;
        
    }
    Map<Integer, Integer> getIndegree (Map<Integer, Set<Integer>> graph){
           Map<Integer, Integer> indegree = new HashMap<>();
           for(int fromNode : graph.keySet()){
               indegree.put(fromNode, 0);
           }
           for(int fromNode : graph.keySet()){
                for(int toNode :graph.get(fromNode)){
                    indegree.put(toNode, indegree.get(toNode)+1 );
                }
          }
          
          return indegree;
        
    }
   Map<Integer, Set<Integer>>  buildGraph(int numCourses, int[][] prerequisites){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0 ; i < numCourses; i++){
            graph.put(i, new HashSet<>());
        }
        
        for(int[] p : prerequisites){
            graph.get(p[1]).add(p[0]); // from 1 to 0
        }
        return graph;
   }
   
    
}