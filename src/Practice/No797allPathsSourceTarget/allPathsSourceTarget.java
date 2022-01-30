package Practice.No797allPathsSourceTarget;

import java.util.ArrayList;
import java.util.List;
//给你一个有n个节点的 有向无环图（DAG），请你找出所有从节点 0到节点 n-1的路径并输出（不要求按特定顺序）
//二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
//译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
//
//示例 1：
//输入：graph = [[1,2],[3],[3],[]]
//输出：[[0,1,3],[0,2,3]]
//解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
//
//示例 2：
//输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
//输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
//
//示例 3：
//输入：graph = [[1],[]]
//输出：[[0,1]]
//
//示例 4：
//输入：graph = [[1,2,3],[2],[3],[]]
//输出：[[0,1,2,3],[0,2,3],[0,3]]
//
//示例 5：
//输入：graph = [[1,3],[2],[3],[]]
//输出：[[0,1,2,3],[0,3]]

public class allPathsSourceTarget {

    //    执行用时：2 ms, 在所有 Java 提交中击败了87.09%的用户
//    内存消耗：40.2 MB, 在所有 Java 提交中击败了45.51%的用户
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> node = new ArrayList<>();
    public static List<List<Integer>> allPathsSourceTarget5(int[][] graph){
        List<Integer> node = new ArrayList<>();
        node.add(0);
        dfs5(graph,0,0,node);
        return res;
    }
    public static void dfs5(int[][] graph,int i,int j,List<Integer> node){
        if (node.get(node.size()-1)==graph.length-1){
            res.add(new ArrayList<>(node));
            return;
        }
        for (int y=j;y<graph[i].length;y++){
            node.add(graph[i][y]);
            dfs5(graph,graph[i][y],0,node);
            node.remove(node.size()-1);
        }
    }



    public List<List<Integer>> allPathsSourceTarget1(int[][] graph) {
    boolean[] visit = new boolean[graph.length];
    List<List<Integer>> res = null;

    for (int i=0;i< graph.length;i++){
        if (visit[i]){
           // int[] temp = graph[i];
            List<Integer> node = null;
            dfs1(graph,graph[i][0],0,node);
            res.add(node);
        }
    }
    return res;
    }
    public static void dfs1(int[][] graph,int value,int i,List<Integer> node){
        for (int j = i;j<graph[i].length;j++) {
            if (graph[value].length > 0) {
                node.add(graph[value][j]);
                dfs1(graph,graph[value][j],j,node);
            }
        }
    }

    public static List<List<Integer>> allPathsSourceTarget2(int[][] graph){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i=0;i<graph.length;i++){
                if ( graph[i].length != 0) {
                    List<Integer> node = new ArrayList<Integer>();
                    Integer x = i;
                    while (true) {
                        node.add(x);
                        if (graph[x].length == 0) {
                            break;
                        }
                        x = graph[x][0];
                    }
                    res.add(node);
                }
        }
        return res;
    }
    public static void dfs2(int i,int[][] graph,List<Integer> node){
        Integer x = i;
        while (true) {
            node.add(x);
            if (graph[x].length == 0) {
                break;
            }
            x = graph[x][0];
        }
    }

    public static List<List<Integer>> allPathsSourceTarget3(int[][] graph){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> node = new ArrayList<>();
        node.add(0);
        for (int i=0;i<graph.length;i++){
        dfs3(graph,0,0,node);
        res.add(node);
        }

        return res;
    }
    public static void dfs3(int[][] graph,int i,int j,List<Integer> node){
        if(i<graph.length) {
            node.add(graph[i][j]);
            i = graph[i][j];
            j = 0;
            dfs1(graph, i, j, node);
        }
    }

    public static List<List<Integer>> allPathsSourceTarget4(int[][] graph){
        List<List<Integer>> res = new ArrayList<>();

        for (int i=0;i< graph.length;i++){

        }


        return res;
    }



    public static void main(String[] args) {
        int[][] test = new int[][]{{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget5(test));
    }
}
