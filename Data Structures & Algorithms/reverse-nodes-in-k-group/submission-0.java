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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prevNode=dummy;
        ListNode curr=head;
        int length=0;
        while(curr!=null)
        {
            length++;
            curr=curr.next;
        }
        curr=head;
        while(length>=k)
        {
            ListNode prev=null;
            ListNode tail=curr;
            for(int i=0;i<k;i++)
            {
                ListNode node=curr.next;
                curr.next=prev;
                prev=curr;
                curr=node;
            }
            prevNode.next=prev;
            tail.next=curr;
            prevNode=tail;
            length=length-k;
        }
        return dummy.next;
    }
}
