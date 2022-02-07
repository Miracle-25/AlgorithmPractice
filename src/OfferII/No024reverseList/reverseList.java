package OfferII.No024reverseList;

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }
    public ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class reverseList {
    //双指针
    public static ListNode reverseList(ListNode head) {
        ListNode left = null;
        ListNode right = head;

        while(right!=null){
            ListNode next = right.next;
            right.next = left;
            left = right;
            right = next;
        }
        return left;
    }
    //递归
    static ListNode res = new ListNode(1);
    public static ListNode reverseList2(ListNode head){
        ListNode temp = compute(head);
        return res;
    }
    public static ListNode compute(ListNode head){
        if (head.next==null){
            res = head;
            return head;
        }
        reverseList2(head.next).next = head;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        System.out.println(reverseList(head));
    }

}
