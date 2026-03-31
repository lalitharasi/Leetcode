class Solution {
    public ListNode swapPairs(ListNode head) {
        // Dummy node acts as the predecessor of the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode point = dummy;

        // Ensure there are at least two nodes to swap
        while (point.next != null && point.next.next != null) {
            // Nodes to be swapped
            ListNode first = point.next;
            ListNode second = point.next.next;

            // 1. Point the previous node to the second node
            point.next = second;
            // 2. Point the first node to the third node (the rest of the list)
            first.next = second.next;
            // 3. Point the second node back to the first node
            second.next = first;

            // Move the pointer two nodes ahead for the next pair
            point = first;
        }

        return dummy.next;
    }
}
//mid