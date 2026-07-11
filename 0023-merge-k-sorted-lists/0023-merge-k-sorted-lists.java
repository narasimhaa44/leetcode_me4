class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
                new PriorityQueue<>((a,b)->a.val-b.val);

        // Insert the head of every list
        for(ListNode node : lists){

            if(node != null)
                pq.offer(node);
        }

        ListNode dummy = new ListNode(-1);

        ListNode tail = dummy;

        while(!pq.isEmpty()){

            ListNode curr = pq.poll();

            tail.next = curr;

            tail = tail.next;

            // Insert next node of same list
            if(curr.next != null){

                pq.offer(curr.next);
            }
        }

        return dummy.next;
    }
}