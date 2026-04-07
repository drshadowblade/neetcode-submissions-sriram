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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode prev=null,curr=slow.next;
        slow.next=null;
        while(curr!=null)
        {
            ListNode nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }

        ListNode head2=prev;

        ListNode p1=head,p2=head2;
        while(p2!=null)
        {
            ListNode n1=p1.next,n2=p2.next;
            p1.next=p2;
            p2.next=n1;
            p1=n1;
            p2=n2;
        }
        
        
    }
}
