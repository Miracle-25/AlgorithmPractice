package Interview.LinkList.getIntersectionNode;


import java.util.HashSet;
import java.util.Set;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB!=null){
            if (set.contains(headB)){
                return headB;
            }else {
                headB = headB.next;
            }
        }
        return null;
    }
}
