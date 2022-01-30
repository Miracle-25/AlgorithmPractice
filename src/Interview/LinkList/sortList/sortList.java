package Interview.LinkList.sortList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val){this.val = val;}
    ListNode(int val,ListNode next){this.val=val;this.next=next; }

}

public class sortList {
    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = new ListNode();
        temp.next = head;
        while (temp.next!=null){
            list.add(new ListNode(temp.next.val));
            temp = temp.next;
        }
        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val> o2.val){
                    return 1;
                }else if(o1.val== o2.val){
                    return 0;
                }else {
                    return -1;
                }
            }
        });
        ListNode res = new ListNode();
        ListNode tempNode = new ListNode();
        res.next = tempNode;
        for (ListNode node:list){
            tempNode.next = node;
            tempNode = tempNode.next;
        }

        return res.next.next;
    }
}
