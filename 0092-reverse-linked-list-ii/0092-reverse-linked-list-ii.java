class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Move prev to the node before 'left'
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse from left to right
        ListNode curr = prev.next;
        ListNode nextNode = null;
        ListNode prevNode = null;

        for (int i = 0; i <= right - left; i++) {
            nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextNode;
        }

        // Step 3: Reconnect
        prev.next.next = curr; // tail of reversed part connects to the rest
        prev.next = prevNode;  // prev connects to new head of reversed part

        return dummy.next;
    }
}
