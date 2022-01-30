package Practice.No46permute;

//        给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//        示例 1：
//        输入：nums = [1,2,3]
//        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//        示例 2：
//        输入：nums = [0,1]
//        输出：[[0,1],[1,0]]
//
//        示例 3：
//        输入：nums = [1]
//        输出：[[1]]

import java.util.ArrayList;
import java.util.List;

public class permute {
//    执行用时：1 ms, 在所有 Java 提交中击败了82.60%的用户
//    内存消耗：38.9 MB, 在所有 Java 提交中击败了5.23%的用户
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return res;
    }
    public void dfs(int[] num){
        if (num.length<=0){
            return;
        }
        if (num.length==1){
            temp.add(num[0]);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
        }

        for (int i=0;i<num.length;i++){
            temp.add(num[i]);
            dfs(changeArr(num,i));
            temp.remove(temp.size()-1);
        }
    }
    public int[] changeArr(int[] orgin,int i){
        int[] newer = new int[orgin.length-1];
        for (int x=0,y=0;x< orgin.length-1;x++,y++){
            newer[x]=orgin[y];
            if (y==i){
                x--;
            }else {
                newer[x]=orgin[y];
            }
        }
        return newer;
    }
}
