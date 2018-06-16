/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */

    /*
        BFS approach
        Time O(V+E):

    */
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        
        if(node == null){
            return node;
        }
        // 1. node -> nodes
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        
        // 2. copy nodes,maintain mappings
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for(UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }
        
        // 3. copy neighbors (edges) 
        for (UndirectedGraphNode n : nodes){
            UndirectedGraphNode newNode = mapping.get(n);
            
            for (UndirectedGraphNode neighbor: n.neighbors){
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return mapping.get(node);
    }
    
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<>(); 
        Set<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        
        queue.offer(node);
        set.add(node);
        nodes.add(node);
        while (queue.isEmpty() == false){
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors){
                if(set.contains(neighbor) == false){
                    queue.offer(neighbor);
                    set.add(neighbor);
                    nodes.add(neighbor);
                }
                
            }
        }
        return nodes;
     }
}









