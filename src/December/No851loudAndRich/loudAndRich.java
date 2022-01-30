package December.No851loudAndRich;

//        有一组 n 个人作为实验对象，从 0 到 n - 1 编号，其中每个人都有不同数目的钱，以及不同程度的安静值（quietness）。为了方便起见，我们将编号为x的人简称为 "person x"。
//        给你一个数组 richer ，其中 richer[i] = [ai, bi] 表示 person ai比 person bi更有钱。另给你一个整数数组 quiet ，其中quiet[i] 是 person i 的安静值。richer 中所给出的数据 逻辑自恰（也就是说，在 person x 比 person y 更有钱的同时，不会出现 person y 比 person x 更有钱的情况 ）。
//        现在，返回一个整数数组 answer 作为答案，其中answer[x] = y的前提是，在所有拥有的钱肯定不少于person x的人中，person y是最安静的人（也就是安静值quiet[y]最小的人）。
//
//        示例 1：
//        输入：richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
//        输出：[5,5,2,5,4,5,6,7]
//        解释：
//        answer[0] = 5，
//        person 5 比 person 3 有更多的钱，person 3 比 person 1 有更多的钱，person 1 比 person 0 有更多的钱。
//        唯一较为安静（有较低的安静值 quiet[x]）的人是 person 7，
//        但是目前还不清楚他是否比 person 0 更有钱。
//        answer[7] = 7，
//        在所有拥有的钱肯定不少于 person 7 的人中（这可能包括 person 3，4，5，6 以及 7），
//        最安静（有较低安静值 quiet[x]）的人是 person 7。
//        其他的答案也可以用类似的推理来解释。
//
//        示例 2：
//        输入：richer = [], quiet = [0]
//        输出：[0]


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class loudAndRich {
    public static int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] res = new int[quiet.length];
        Map<Integer,Queue<Integer>> map = new HashMap<>();
        //遍历richer数组，生成<int,queue>
        for (int[] i:richer){
            int key = i[1];
            if (!map.containsKey(key)){
                map.put(key,createQueue(key,richer));
            }
        }

        //根据每个<int,queue>查找各个int对应的最小quiet
        for (int i=0;i< res.length;i++){
            if (map.containsKey(i)){
                res[i] = getMin(map.get(i),quiet);
            }else {
                res[i] = i;
            }
        }

        return res;
    }
    public static int getMin(Queue<Integer> queue,int[] quiet){
        int res = Integer.MAX_VALUE;
        int resLocation=0;
        while (!queue.isEmpty()){
            int temp=queue.poll();
            if (res>quiet[temp]){
                res = quiet[temp];
                resLocation = temp;
            }
        }
        return resLocation;
    }
    public static Queue<Integer> createQueue(int key,int[][] richer){
        Queue<Integer> res = new ArrayDeque<>();
        Queue<Integer> temp = new ArrayDeque<>();
        temp.add(key);
        while (!temp.isEmpty()){
            int i = temp.poll();
            res.add(i);
            for (int[] j:richer){
                if (j[1]==i){
                    temp.add(j[0]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] richer = new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = new int[]{3,2,5,4,6,1,7,0};
//        for (int i=0;i<8;i++){
        System.out.println(loudAndRich(richer,quiet));
//        }
    }
}
