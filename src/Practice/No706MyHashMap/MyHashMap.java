package Practice.No706MyHashMap;

//        不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
//
//        实现 MyHashMap 类：
//        MyHashMap() 用空映射初始化对象
//        void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
//        int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
//        void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
//
//
//        示例：
//        输入：
//        ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
//        [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
//        输出：
//        [null, null, null, 1, -1, null, 1, null, -1]
//
//        解释：
//        MyHashMap myHashMap = new MyHashMap();
//        myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
//        myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
//        myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
//        myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
//        myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
//        myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
//        myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
//        myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]

import java.util.ArrayList;
import java.util.List;

//        执行用时：512 ms, 在所有 Java 提交中击败了5.05%的用户
//        内存消耗：43.8 MB, 在所有 Java 提交中击败了77.64%的用户
public class MyHashMap {
    int[] node;
    List<int[]> list;
    public MyHashMap() {
        node = new int[2];
        list = new ArrayList<int[]>();
    }

    public void put(int key, int value) {
        for (int[] l:list){
            if (l[0]==key){
                list.add(new int[]{key,value});
                list.remove(l);
                return;
            }
        }
        node = new int[2];
        node[0] = key;
        node[1] = value;
        list.add(node);
    }

    public int get(int key) {
        for (int[] l:list){
            if (l[0]==key){
                return l[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        for (int[] l:list){
            if (l[0]==key){
                list.remove(l);
                break;
            }
        }
    }
}
class solution{
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,1);
        map.put(2,2);
        map.get(1);
        map.get(3);
        map.put(2,1);
        map.get(2);
        System.out.println(map);
        map.remove(2);
        System.out.println(map);
    }
}
