package DataStructureMID.No435eraseOverlapIntervals;

//        给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//        注意:
//        可以认为区间的终点总是大于它的起点。
//        区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
//
//        示例 1:
//        输入: [ [1,2], [2,3], [3,4], [1,3] ]
//        输出: 1
//        解释: 移除 [1,3] 后，剩下的区间没有重叠。
//
//        示例 2:
//        输入: [ [1,2], [1,2], [1,2] ]
//        输出: 2
//        解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
//
//        示例 3:
//        输入: [ [1,2], [2,3] ]
//        输出: 0
//        解释: 你不需要移除任何区间，因为它们已经是无重叠的了。


import java.util.Arrays;
import java.util.Comparator;

public class eraseOverlapIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        sort(intervals);
        for (int i=0;i<intervals.length;i++){
            int temp=0;
            int bottom=Integer.MIN_VALUE;
            for (int j=i;j<intervals.length;j++){
                if (bottom<=intervals[j][0]){
                    temp++;
                    bottom=intervals[j][1];
                }
            }
            res=Math.max(temp,res);
        }
        return intervals.length-res;
    }
    public static void sort(int[][] arr){
        for (int j=0;j<arr.length-1;j++){
        for (int i=0;i<arr.length-1;i++){
            int[] temp = new int[2];
            if (arr[i][1]>arr[i+1][1]){
                temp=arr[i+1];
                arr[i+1]=arr[i];
                arr[i]=temp;
            }else if (arr[i][1]==arr[i+1][1]){
                if (arr[i][0]>arr[i+1][0]){
                    temp=arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        }
    }


    public static int eraseOverlapIntervalsTest(int[][] intervals){
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                System.out.println("["+intervals[i][0]+":"+intervals[i][1]+"]");
                right = intervals[i][1];
            }
        }
        return n - ans;
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{{-3035, 30075}, {1937, 6906},{11834, 20971},{44578, 45600},
        {28565,37578},{19621,34415},{32985,36313},{-8144,1080},{-15279,21851},{-27140,-14703},
        {-12098,16264},{-36057,-16287},{47939,48626},{-15129,-5773},{10508,46685},{-35323,-26257}};
//        sort(test1);
//        System.out.println(eraseOverlapIntervals(test1));

        int[][] test2 = new int[][]{{1,2},{2,3},{3,4},{-100,-2},{5,7}};
        System.out.println(eraseOverlapIntervals(test1));
//        System.out.println(eraseOverlapIntervalsTest(test1));
    }

//    1,2
//    2,3
//    3,4
//    -100,-2
//    5,7
}
