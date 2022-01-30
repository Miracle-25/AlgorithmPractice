package Practice.No725splitListToParts;

//        给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
//        每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
//        这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
//        返回一个由上述 k 部分组成的数组。
//
//        示例 1：
//                1->2->3
//        输入：head = [1,2,3], k = 5
//        输出：[[1],[2],[3],[],[]]
//        解释：
//        第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
//        最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
//
//        示例 2：
//                1->2->3->4->5->6->7->8->9->10
//        输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
//        输出：[[1,2,3,4],[5,6,7],[8,9,10]]
//        解释：
//        输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。

public class splitListToParts {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：38.7 MB, 在所有 Java 提交中击败了11.93%的用户
    public ListNode[] splitListToParts(ListNode head, int k) {
    ListNode[] res = new ListNode[k];
    int num = 0;
    ListNode temp = head;
    while (temp!=null){
        num++;
        temp=temp.next;
    }

    int num_remainder = num%k;
    int num_answer = num/k;

    ListNode curr = head;
    for (int res_k = 0;curr!=null && res_k<k;res_k++) {
        res[res_k] = curr;
        int partsize = num_answer + (res_k<num_remainder?1:0);
        for (int i = 0; i < partsize; i++) {
            curr = curr.next;
        }
//        if (num_remainder != 0) {
//            curr = curr.next;
//            num_remainder--;
//        }
        ListNode next = curr.next;
        curr.next = null;
        curr = next;
    }
    return res;
    }
    public static void main(String[] args) {

    }

}

