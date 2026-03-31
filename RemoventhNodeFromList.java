
//mid
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Use a dummy node to handle edge cases like removing the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // 1. Move fast pointer n + 1 steps ahead
        // This creates a gap of n nodes between fast and slow
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // 2. Move both fast and slow until fast reaches the end
        // When fast reaches null, slow will be at the node BEFORE the one to remove
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // 3. Skip the nth node
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
