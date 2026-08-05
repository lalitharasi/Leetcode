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
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Step 1: Handle base cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        // Step 2: Compute list length and locate tail node
        ListNode oldTail = head;
        int length = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            length++;
        }
        
        // Connect tail to head to form a circular ring
        oldTail.next = head;
        
        // Step 3: Handle cases where k >= length
        k = k % length;
        
        // Step 4: Find the new tail node (at position length - k)
        int stepsToNewTail = length - k;
        ListNode newTail = oldTail; // Start from oldTail to step smoothly
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }
        
        // Step 5: Break the circular ring
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}
