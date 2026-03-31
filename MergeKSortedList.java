import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-Heap based on node values
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 1. Add the head of each non-empty list to the heap
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // 2. While the heap is not empty
        while (!pq.isEmpty()) {
            // Get the smallest node
            ListNode smallest = pq.poll();
            tail.next = smallest;
            tail = tail.next;

            // 3. If the extracted node has a next node, add it to the heap
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
    }
}
//hard