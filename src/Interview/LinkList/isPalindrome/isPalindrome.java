package Interview.LinkList.isPalindrome;

import java.util.ArrayList;
import java.util.List;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val,ListNode next){this.val=val;this.next=next;}
}

public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        for (int i=0;i<list.size()/2;i++){
            if (list.get(i)!=list.get(list.size()-1-i)){
                return false;
            }
        }
        return true;
    }
}
