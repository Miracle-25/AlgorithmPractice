package DataStructureMID.No82deleteDuplicates;

//        存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
//        返回同样按升序排列的结果链表。
//
//        示例 1：
//        输入：head = [1,2,3,3,4,4,5]
//        输出：[1,2,5]
//
//        示例 2：
//        输入：head = [1,1,1,2,3]
//        输出：[2,3]

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class deleteDuplicates {
//    执行用时：20 ms, 在所有 Java 提交中击败了13.74%的用户
//    内存消耗：38.3 MB, 在所有 Java 提交中击败了5.17%的用户
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode res = new ListNode(-1,head);
        ListNode resfin = res;
        int temp = 0;

        while (res.next!=null && res.next.next!=null){
            if ( res.next.val == res.next.next.val ){
                temp = res.next.val;
                res.next = res.next.next;
                try{
                    while (res.next.val==temp){
                        res.next = res.next.next;
                        System.out.println(res.next.val);
                    }
                }catch(Exception e){
                    res.next=null;
                    break;
                }
            }else {
                res = res.next;
            }
        }
        if(res.next==null){
            return resfin.next;
        }
        if (res.next.val == temp){
            res.next = null;
        }
        return resfin.next;
    }
}
