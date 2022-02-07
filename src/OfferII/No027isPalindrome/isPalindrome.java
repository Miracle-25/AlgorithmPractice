package OfferII.No027isPalindrome;

import java.util.ArrayList;
import java.util.List;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head==null || head.next==null){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        int num = list.size();
        for (int i=0;i<list.size()/2;i++){
            if (list.get(i).equals(list.get(num-1-i))){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}
