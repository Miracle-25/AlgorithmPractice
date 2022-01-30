package DataStructureMID.No707MyLinkedList;

//        设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val和next。val是当前节点的值，next是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性prev以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
//        在链表类中实现这些功能：
//
//        get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
//        addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
//        addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
//        addAtIndex(index,val)：在链表中的第index个节点之前添加值为val的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
//        deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。
//
//        示例：
//        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//        linkedList.get(1);            //返回2
//        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//        linkedList.get(1);            //返回3


import java.util.ArrayList;
import java.util.List;

//        执行用时：14 ms, 在所有 Java 提交中击败了5.79%的用户
//        内存消耗：39.2 MB, 在所有 Java 提交中击败了6.73%的用户
public class MyLinkedList {
    List<Integer> list;

    public MyLinkedList() {
        list = new ArrayList();
    }

    public int get(int index) {
        try {
            return list.get(index);
        }catch (Exception e){
            return -1;
        }
    }

    public void addAtHead(int val) {
        list.add(0,val);
    }

    public void addAtTail(int val) {
        list.add(val);
    }

    public void addAtIndex(int index, int val) {
        if (index == list.size()){
            list.add(val);
        }else if (index > list.size()){
            return;
        }else if (index<0){
            list.add(0,val);
        }else {
            list.add(index,val);
        }

    }

    public void deleteAtIndex(int index) {
        try {
            list.remove(index);
        }catch (Exception e){
            return;
        }

    }
}
