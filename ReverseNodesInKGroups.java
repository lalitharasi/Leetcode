class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prevGroupTail = dummy;
        
        while (true) {
            // Check if there are at least k nodes left to reverse
            ListNode kthNode = getKthNode(prevGroupTail, k);
            if (kthNode == null) break;
            
            ListNode nextGroupHead = kthNode.next;
            
            // Reverse the current group
            ListNode currentGroupHead = prevGroupTail.next;
            // Disconnect the group to reverse it separately
            kthNode.next = null;
            
            // Reconnect reversed group
            prevGroupTail.next = reverse(currentGroupHead);
            
            // Connect the end of reversed group to the next group
            currentGroupHead.next = nextGroupHead;
            
            // Move pointer to the end of the newly reversed group
            prevGroupTail = currentGroupHead;
        }
        
        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
//hard