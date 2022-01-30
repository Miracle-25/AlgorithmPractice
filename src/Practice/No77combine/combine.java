package Practice.No77combine;

import java.util.ArrayList;
import java.util.List;
//        给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//        你可以按 任何顺序 返回答案。
//
//        示例 1：
//
//        输入：n = 4, k = 2
//        输出：
//        [
//        [2,4],
//        [3,4],
//        [2,3],
//        [1,2],
//        [1,3],
//        [1,4],
//        ]
//
//        示例 2：
//        输入：n = 1, k = 1
//        输出：[[1]]


public class combine {
//    执行用时：1 ms, 在所有 Java 提交中击败了99.96%的用户
//    内存消耗：39.8 MB, 在所有 Java 提交中击败了28.78%的用户
     List<Integer> temp = new ArrayList<>();
     List<List<Integer>> res = new ArrayList<>();
    public  List<List<Integer>> combine(int n, int k) {
        dfs(n,k,1);
        return res;
    }

    public  void dfs(int n,int k,int begin){
        if (k==0){
            return;
        }
        if (k==1){
            for (int i=begin;i<=n;i++){
                temp.add(i);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
            return;
        }
        for (int i=begin;i<=n-k+1;i++){
            temp.add(i);
            dfs(n,k-1,i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
//        System.out.println(combine(4,2));
    }

}

