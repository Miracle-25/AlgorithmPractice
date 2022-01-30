package DataStructureMID.No143reorderList;

//        给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//        L0 → L1 → … → Ln - 1 → Ln
//        请将其重新排列后变为：
//        L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//        不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//        示例 1：
//        输入：head = [1,2,3,4]
//        输出：[1,4,2,3]
//
//        示例 2：
//        输入：head = [1,2,3,4,5]
//        输出：[1,5,2,4,3]

import java.util.Stack;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class reorderList {
//    执行用时：2 ms, 在所有 Java 提交中击败了51.64%的用户
//    内存消耗：41 MB, 在所有 Java 提交中击败了55.42%的用户
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        int num=0;
        while (temp!=null){
            stack.push(temp);
            temp = temp.next;
            num++;
        }
        for(int i=0;i<num/2;i++){
            ListNode node = head.next;
            head.next = stack.pop();
            head.next.next = node;
            head = head.next.next;
        }
        if (num%2==0){
            head.next = null;
        }else {
            head.next = stack.pop();
            head.next.next = null;
        }

    }
}
