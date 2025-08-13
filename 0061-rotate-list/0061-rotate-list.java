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
    public ListNode findkthnode(ListNode head,int p){
        int cnt=1;
        ListNode temp=head;
        while(temp.next!=null){
            if(cnt==p){
                return temp;
            }
            else{
                temp=temp.next;
                cnt++;
            }
        }
        return null;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int len=1;
        ListNode tail=head;
        while(tail.next!=null){
            len++;
            tail=tail.next;
        }
        tail.next=head;
        ListNode kthnode=findkthnode(head,len-k);
        head=kthnode.next;
        kthnode.next=null;
        return head;
    }
}   