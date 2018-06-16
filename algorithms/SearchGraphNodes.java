/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */


public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * @param values: a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node: an Undirected graph node
     * @param target: An integer
     * @return: a node
     */

    /*
      Time O(v + e)

    */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // BFS
        
        Set<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        set.add(node);

          while(queue.isEmpty() == false){
            int size = queue.size();
            for(int i = 0 ;i < size; i++){
                UndirectedGraphNode cur = queue.poll();
                if(values.get(cur) == target){
                    return cur;
                }
            
                for (UndirectedGraphNode nb: cur.neighbors){
                        
                    if(set.contains(nb) == false){
                        queue.offer(nb);
                        set.add(nb);
                    }
                }
                
            }  
          }
                    
        
        return null;
        
        
        
        
        
        
        
    }
}