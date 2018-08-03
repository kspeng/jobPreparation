public class LRUCache {
    
    /*
        Use 2 dummy nodes 
        head -> oldest -> 2nd oldest -> ... -> newest -> tail
    
    Follow up:
        Could you do both operations in O(1) time complexity?
        
        1. O(1) 从中间拿出一个数，插入到尾巴上
        2. O(1) 的时间，在尾巴上放一个新的数
        3. O(1) 删除最老的节点
        
        
        Linked List + Hash Table 
        
        
    */
    private class Node {
        Node pre;
        Node next;
        
        int key;
        int value;
        
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    
    private final int CAPACITY;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    
    /*
    * @param capacity: An integer
    */public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        this.map = new HashMap<Integer, Node>();
        
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.pre = head;
    }
    
    private void appendToTail(Node current){
        // handle current node 
        current.pre = tail.pre;
        current.next = tail;
        
        //handle tail
        tail.pre = current;
        // handle pre
        current.pre.next = current;
        
    }
    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if(map.containsKey(key) == false){
            return -1;
        }
        //remove current node position and append to tail
        Node current = map.get(key);
        current.pre.next = current.next;
        current.next.pre = current.pre;
        
        // append to tail
        appendToTail(current);
        
        return current.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // new, new node is updated to tail
        if (get(key) != -1){
            // update to the new value
            map.get(key).value = value;
            return;
        }
        
        // need to remove oldest node
        if(map.size() == CAPACITY){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
        
        Node newNode = new Node(key,value);
        map.put(key, newNode);
        appendToTail(newNode);
    }
}





