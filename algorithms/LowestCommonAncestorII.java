/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */


public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        List<ParentTreeNode> pathA = findPath2Root(A);
        List<ParentTreeNode> pathB = findPath2Root(B);
        
        
        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;
        ParentTreeNode lca = null;
        // loop backwards
        while(indexA >= 0 && indexB >= 0){
            // compare from root
            // 5,7,4
            // 6,7,4
            if(pathA.get(indexA) != pathB.get(indexB)){
                break;
            }
            // keep pre before break
            lca = pathA.get(indexA);        
            indexA--;
            indexB--;
            
        }
        
        return lca;
        
    }

    private List<ParentTreeNode> findPath2Root(ParentTreeNode node){
        List<ParentTreeNode> paths = new ArrayList<>();
        while(node != null){
            paths.add(node);
            node = node.parent;
        }
        
        return paths;
        
    }
}