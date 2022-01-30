package Interview.LinkList.copyRandomList;

import java.util.ArrayList;
import java.util.List;

class Node{
    int val;
    Node next;
    Node random;

    public Node(int val){
        this.val = val;
        this.next=null;
        this.random = null;
    }

}

public class copyRandomList {
    public Node copyRandomList(Node head) {
        if (head==null){
            return null;
        }
        List<Node> list = new ArrayList<>();

        Node r = new Node(-1);

        Node res = new Node(head.val);
        r.next = res;
        list.add(res);
        Node temphead = head.next;
        while (temphead!=null){
            Node temp = new Node(temphead.val);
            list.add(temp);
            res.next = temp;
            res = res.next;
            temphead = temphead.next;
        }

        Node tempFinal = new Node(-1);
        tempFinal.next = r.next;
        Node always = new Node(-1);
        always.next = head;
        while (head!=null){
            if (head.random==null){
                r.next.random = null;
            }else {
                System.out.println(r.next.val);
                r.next.random = list.get(find(always,head.random)-1);
            }
            head = head.next;
            r.next = r.next.next;
        }
        return tempFinal.next;
    }

    public int find(Node head,Node target){
        int i=0;
        while (head!=null){
            if (head == target){
                break;
            }else {
                head = head.next;
                i++;
            }
        }
        return i;
    }
}
