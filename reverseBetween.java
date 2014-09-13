//Reverse a linked list from m to n
//Aug 24 Bug Free
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        int step = n - m;

        if (step == 0){
            return dummyNode.next;
        }else{
            ListNode prevX = dummyNode;
            
            while (m - 1> 0) {
                prevX = prevX.next;
                m = m - 1;
            }

            ListNode startPoint = prevX.next;
            ListNode prev = prevX.next;
            ListNode curr = prev.next;

            while (step > 0) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
                step = step - 1;
            }

            prevX.next = prev;
            startPoint.next = curr;

            return dummyNode.next;
        }
    }
}