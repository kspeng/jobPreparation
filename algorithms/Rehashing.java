/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
     
    int hashcode(int key, int capacity) {
        //return key % capacity;
        //Note key could be negative
        return (key % capacity + capacity) % capacity;
    }


    public ListNode[] rehashing(ListNode[] hashTable) {
        if(hashTable.length < 1){
            return hashTable;
        }
       
        int newCapacity = 2 * hashTable.length;
        
        System.out.println(hashTable.length);
        System.out.println(newCapacity);
         
        ListNode[] newTable = new ListNode[newCapacity];
        
        for(int i = 0; i < hashTable.length; i++){
            while(hashTable[i] != null){
                
                int newIndex = hashcode(hashTable[i].val, newCapacity);
                //
                if(newTable[newIndex] == null){
                    ListNode newNode = new ListNode(hashTable[i].val);
                    newTable[newIndex] = newNode;
                } else {
                    
                    ListNode currnet = newTable[newIndex];
                    while(currnet.next != null){
                        currnet = currnet.next;
                    }
                    currnet.next = new ListNode(hashTable[i].val);
                }
                // rehashing to next node
                hashTable[i] = hashTable[i].next;
                
            }
        }
        return newTable;
        
    }
};
