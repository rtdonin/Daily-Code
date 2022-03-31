/**
 * Taken from: https://leetcode.com/problems/add-two-numbers/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        boolean carryOne = false;
        ListNode head = new ListNode();
        ListNode answer = head;
        
        while (l1 != null || l2 != null || carryOne) {
            
            int sum = 0;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum  += l2.val;
                l2 = l2.next;
            }
            
            if(carryOne){
                sum++;
            }
            
            carryOne = sum > 9;
            
            if (carryOne) {
                sum -= 10;
            }
            
            answer.next = new ListNode(sum);;
            answer = answer.next;
            
        }
        
        return head.next;
    }

}