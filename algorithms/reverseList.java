/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    /*
        Time O(n)
        Space (1)

    */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode prev = null; 
     
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;     
        }
     
        return prev;
        
    }
}