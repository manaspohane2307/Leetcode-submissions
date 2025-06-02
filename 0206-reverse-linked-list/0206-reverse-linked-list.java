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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;

        while(temp!=null){
            ListNode front = temp.next;//store front
            temp.next = prev;//reversal step
            prev = temp;//move prev forward
            temp = front;//move temp forward
        }
        return prev;
    }
}