/*This approach takes 2 linked lists at a time, merges them and them again merges it with the thirf iteratively


/**
 * Definition for singly-linked list
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode ll = new ListNode(0);
        ListNode temphead = ll;
        while(head1!=null && head2!= null)
        {
            if(head1.val < head2.val)
            {   
                
                temphead.next = head1;
                head1= head1.next;
            }
            else 
            {   
                temphead.next = head2;  
                head2=head2.next;
             }
            temphead = temphead.next;
            
        }
        if(head1!=null)
        {
            temphead.next = head1;
        }
        else {temphead.next=head2;}
        return ll.next;
    }
        
    }
//---------------------------------------------------------------------------------------------------------------------------------------------//

//ANOTHER APPROACH

//compare elements one by one and keep on adding the minimun in the linked list.

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
    public ListNode mergeKLists(ListNode[] lists) {
        
        ArrayList<Integer> list = new ArrayList();
        
        for(ListNode ln : lists)
        {
            while(ln!=null)
            {
                list.add(ln.val);
                ln = ln.next;
            }
            
        }
        
        Collections.sort(list);
        
        ListNode node = new ListNode(0);
        ListNode head = node;
        
        for(int i : list)
        {
            ListNode t = new ListNode(i);
            node.next = t;
            node = node.next;
        }
        node.next = null;
        return head.next;
        
    }
}
