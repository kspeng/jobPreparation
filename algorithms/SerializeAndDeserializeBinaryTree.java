/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
     String DLIMITER = ",";
     String EMPTY = "#";
    
    /* 
        BFS approach 
        Time Complexity: O(n)
    */
    public String serialize(TreeNode root) {
        if(root == null){
            return "{}";
        }
        // bfs
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        for(int i = 0; i< queue.size(); i++){
            TreeNode node = queue.get(i);
            if(node == null){
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        // remove tailing empty node
        while(queue.get(queue.size() - 1) == null){
           queue.remove(queue.size() - 1);
        }
       
        StringBuilder results = new StringBuilder();
        results.append("{");
        results.append(queue.get(0).val);
        for(int i = 1; i < queue.size(); i++){
            results.append(DLIMITER);
            results.append(queue.get(i) == null ? EMPTY : queue.get(i).val);
        }
        
        results.append("}");
        return results.toString();
        
        
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("{}")){
            return null;
        }
        
        String [] vals = data.substring( 1,data.length() - 1).split(DLIMITER);
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeft = true;
        
        for (int i = 1; i < vals.length; i ++){
            if(vals[i].equals(EMPTY) == false){
                TreeNode node = new TreeNode(Integer.parseInt(vals[i])); 
                if(isLeft){
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            // a set of completed treeNodes
            if(!isLeft){
                index++;
            }
            isLeft = !isLeft;
        }
        
        return root;
        
    }
}
