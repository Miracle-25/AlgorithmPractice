package Interview.LinkList.reverseList;

import java.util.Stack;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val,ListNode next){this.val = val;this.next = next;}
}

public class reverseList {
    public ListNode reverseList1(ListNode head) {
        if (head == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            ListNode node = new ListNode(head.val);
            stack.push(node);
            head = head.next;
        }
        ListNode res = new ListNode(-1);
        ListNode first = stack.pop();
        res.next = first;
        while (!stack.isEmpty()){
            first.next = stack.pop();
            first = first.next;
        }
        return res.next;
    }

    ListNode res;
    public ListNode reverseList2(ListNode head){
//        if (head == null){
//            return null;
//        }
//        if (head.next.next == null){
//            res = new ListNode(-1,head.next);
//            head.next.next=head;
//            return head.next;
//        }
//        ListNode temp = reverseList2(head.next);
//        temp = head;
//        return head.next;

        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    /**
     * 1,2,3,4
     *  two = one.next >> compute(one) return two
     *  one.next = null
     *
     *  three = two.next >> compute(two) return three
     *  two.next = one
     *
     *  four = three.next >> compute(three) return four
     *  three.next = two
     *
     *  four.next = three >>compute(four)
    * */
}
