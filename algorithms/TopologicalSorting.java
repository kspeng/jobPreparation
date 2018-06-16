/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    /*
    BFS approach
    Time O(V+E)

    */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // step 1: get indegree
        Map<DirectedGraphNode, Integer> indegreeMap = new HashMap<>();
        
        for(DirectedGraphNode node: graph){
            for(DirectedGraphNode nb: node.neighbors){
                if(indegreeMap.containsKey(nb) == false){
                    indegreeMap.put(nb, 1);
                } else {
                    int indegree = indegreeMap.get(nb);
                    indegreeMap.put(nb, indegree + 1);
                }
            }
            
        }
      
        // step 2: put no dependent nodes into queue as root
       Queue<DirectedGraphNode> queue = new LinkedList<>();
        for(DirectedGraphNode node: graph){
            if(indegreeMap.containsKey(node) == false){
                queue.offer(node); // add roots
            }    
        }
        
        // step 3: bfs
        ArrayList<DirectedGraphNode> results = new ArrayList<DirectedGraphNode> ();
        while (queue.isEmpty() == false){
            DirectedGraphNode cur = queue.poll();
            results.add(cur); // no dependent node
            for(DirectedGraphNode node: cur.neighbors){
                int indegree = indegreeMap.get(node);
                indegreeMap.put(node, indegree - 1);
                if(indegree - 1 == 0){
                    queue.offer(node);
                }
            }
        }
        
        return results;
    }
}








