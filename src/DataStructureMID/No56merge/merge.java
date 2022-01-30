package DataStructureMID.No56merge;

//        以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//
//        示例 1：
//        输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//        输出：[[1,6],[8,10],[15,18]]
//        解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//        示例2：
//        输入：intervals = [[1,4],[4,5]]
//        输出：[[1,5]]
//        解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。

import java.util.ArrayList;
import java.util.List;

public class merge {
//    执行用时：165 ms, 在所有 Java 提交中击败了6.66%的用户
//    内存消耗：40.7 MB, 在所有 Java 提交中击败了83.97%的用户
    public static int[][] merge(int[][] intervals) {
        sort(intervals);
        int[] temp = null;
        List<int[]> list = new ArrayList<>();
        for (int i=0;i<intervals.length;){
            if (temp==null){
                temp = intervals[i];
                i++;
            }else {
                if (intervals[i][0]>temp[1]){
                    list.add(temp);
                    temp=null;
                }else {
                    if (intervals[i][1]>temp[1]){
                    temp[1]=intervals[i][1];
                    }
                    i++;
                }
            }
        }
        list.add(temp);

        int[][] res = new int[list.size()][2];
        for (int i=0;i< res.length;i++){
            res[i]=list.get(i);
        }
        return res;
    }
    public static void sort(int[][] nums){
        int len = nums.length;
        for (int i=0;i<len-1;){
            for (int j=0;j<len-1;j++){
                if (nums[j][0]>nums[j+1][0]){
                    int[] temp = nums[j+1];
                    nums[j+1]=nums[j];
                    nums[j]=temp;
                }
            }
            len--;
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,3},{0,3}};
        System.out.println(merge(test));
    }
}
