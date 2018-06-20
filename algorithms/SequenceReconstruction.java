public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */

    /**
     * A BFS solution uses topological sort, the key steps are:
     * 
     * 1. use seqs to build the graph
     * 2. check if there is only one possible topological sort
     * 
     * Note that there are a lot of boundary checks in between to handle exceptions.
     */


    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if(org == null || seqs == null){
            return false;
        }
        
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> indegree = new HashMap<>();
        Map<Integer,Integer> order = new HashMap<>();
        int j = 0;
        for(int i : org){
            graph.put(i, new HashSet<>());
            order.put(i,j++);
            indegree.put(i,0);
        }
        int size = 0;
        for(int[] seq: seqs){
            size = size + seq.length;
            
            for(int node : seq){
                if(node > org.length){
                    return false;
                }
            }
            for(int i = 0 ; i < seq.length -1 ; i++){
                
                int from = seq[i];
                int to = seq[i+1];
                // 每次判断seqs中相对位置是否和org一致！！
                // check case for reverse order, org = [1,2,3] seqs = [[3,2][2,1]]
                if(order.get(from) > order.get(to)){
                    return false;
                }
                if(graph.get(from).contains(to) == false){
                    indegree.put(to, indegree.get(to) + 1);
                    graph.get(from).add(to);
                }
            }
            
        }
        // corner case  [1], []
        if (org.length > size) {
                return false;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int node : org){
            if(indegree.get(node) == 0){
                queue.offer(node);
            }
        }
        
        while(queue.isEmpty() == false){
            if(queue.size() > 1){
                return false;
            }
            
            int node = queue.poll();
         
            for(int nb: graph.get(node)){
                int count = indegree.get(nb) - 1;
                indegree.put(nb,count);
                if(count == 0){
                    queue.offer(nb);
                }
            }
            
        }
        
        return true;
        
    }
}