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
     * @param head: a ListNode
     * @param val: An integer
     * @return: a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        // dummy node
        dummy.next = head;
        head = dummy;
        
        while(head.next != null){
            if(head.next.val == val){
                // head.next is changed
               head.next = head.next.next;
            } else {
               head = head.next;
            }
            
        }
        
        return  dummy.next;
        
    }
}