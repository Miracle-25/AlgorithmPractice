package Practice.No206reverseList;

//        给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//        示例 1：
//        输入：head = [1,2,3,4,5]
//        输出：[5,4,3,2,1]
//
//        示例 2：
//        输入：head = [1,2]
//        输出：[2,1]
//
//        示例 3：
//        输入：head = []
//        输出：[]

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class reverseList {
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：38.2 MB, 在所有 Java 提交中击败了48.02%的用户
    public ListNode reverseList1(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
        }
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：38.5 MB, 在所有 Java 提交中击败了11.02%的用户
    public ListNode reverseList2(ListNode head){
        if (head == null || head.next==null){
            return head;
        }
        ListNode tempHead = reverseList2(head.next);
        head.next.next=head;
        head.next=null;
        return tempHead;
    }

//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：38.6 MB, 在所有 Java 提交中击败了5.15%的用户
    public static ListNode reverseList3(ListNode head){
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode node = reverseList3(head.next);
        head.next.next = head;
        head.next=null;
        return node;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        System.out.println(reverseList3(node));
    }
}

