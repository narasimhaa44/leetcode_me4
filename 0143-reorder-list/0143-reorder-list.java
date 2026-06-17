class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. Find middle
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode prev = null, curr = slow.next;
        slow.next = null; // break list

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3. Merge two lists
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode fNext = first.next;
            ListNode sNext = second.next;

            first.next = second;
            second.next = fNext;

            first = fNext;
            second = sNext;
        }
    }
}