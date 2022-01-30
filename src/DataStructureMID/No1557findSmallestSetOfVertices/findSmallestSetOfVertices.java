package DataStructureMID.No1557findSmallestSetOfVertices;

//        给你一个 有向无环图， n个节点编号为 0到 n-1，以及一个边数组 edges，其中 edges[i] = [fromi, toi]表示一条从点fromi到点toi的有向边。
//
//        找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。
//
//        你可以以任意顺序返回这些节点编号。
//
//        示例 1：
//        输入：n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
//        输出：[0,3]
//        解释：从单个节点出发无法到达所有节点。从 0 出发我们可以到达 [0,1,2,5] 。从 3 出发我们可以到达 [3,4,2,5] 。所以我们输出 [0,3] 。
//
//        示例 2：
//        输入：n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]]
//        输出：[0,2,3]
//        解释：注意到节点 0，3 和 2 无法从其他节点到达，所以我们必须将它们包含在结果点集中，这些点都能到达节点 1 和 4 。


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class findSmallestSetOfVertices {
//    执行用时：32 ms, 在所有 Java 提交中击败了6.68%的用户
//    内存消耗：87.9 MB, 在所有 Java 提交中击败了5.16%的用户
    public List<Integer> findSmallestSetOfVertices1(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for (List<Integer> temp:edges){
            set.add(temp.get(0));
        }
        for (List<Integer> temp:edges){
            if (set.contains(temp.get(1))){
                set.remove(temp.get(1));
            }
        }
        for (int i=0;i<n;i++){
            if (set.contains(i)){
                res.add(i);
            }
        }

        return res;
    }

    public List<Integer> findSmallestSetOfVertices2(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();

        for (List<Integer> temp:edges){
            if (!res.contains(temp.get(0))){
            res.add(temp.get(0));
            }
        }
        for (List<Integer> temp:edges){
            if (res.contains(temp.get(1))){
                res.remove(temp.get(1));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
