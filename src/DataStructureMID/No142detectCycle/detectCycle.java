package DataStructureMID.No142detectCycle;

//        给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
//        如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//        不允许修改 链表。
//
//        示例 1：
//        输入：head = [3,2,0,-4], pos = 1
//        输出：返回索引为 1 的链表节点
//        解释：链表中有一个环，其尾部连接到第二个节点。
//
//        示例2：
//        输入：head = [1,2], pos = 0
//        输出：返回索引为 0 的链表节点
//        解释：链表中有一个环，其尾部连接到第一个节点。
//
//        示例 3：
//        输入：head = [1], pos = -1
//        输出：返回 null
//        解释：链表中没有环。

import java.util.HashSet;
import java.util.Set;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class detectCycle {
//    执行用时：4 ms, 在所有 Java 提交中击败了12.37%的用户
//    内存消耗：39.2 MB, 在所有 Java 提交中击败了14.64%的用户
    public ListNode detectCycle(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast!=null){
//            slow = slow.next;
//            fast = fast.next.next;
//            if (slow == fast){
//                return slow;
//            }
//        }
//        return new ListNode(-1);
        ListNode temp = head;
        Set<ListNode> set = new HashSet<>();
        int len = set.size();
        while (temp!=null){
            set.add(temp);
            if (set.size()!=len){
                len=set.size();
                temp=temp.next;
            }else {
                return temp;
            }
        }
        return new ListNode(-1);
    }
}
