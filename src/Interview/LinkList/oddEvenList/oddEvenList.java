package Interview.LinkList.oddEvenList;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        boolean target = true;
        ListNode odd = head;
        ListNode even = head.next;

        ListNode begin_odd = new ListNode(-1,odd);
        ListNode begin_even = new ListNode(-1,even);

        head = head.next.next;
        while (head!=null){
            if (target){
            odd.next = head;
            target = false;
            }else {
                even.next = head;
                target = true;
            }
            head=head.next;
        }
        odd.next=begin_even.next;

        return begin_odd.next;
    }
}
