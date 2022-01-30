package Practice.No786kthSmallestPrimeFraction;

//        给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数 组成，且其中所有整数互不相同。
//
//        对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
//
//        那么第k个最小的分数是多少呢? 以长度为 2 的整数数组返回你的答案, 这里answer[0] == arr[i]且answer[1] == arr[j] 。
//
//        示例 1：
//        输入：arr = [1,2,3,5], k = 3
//        输出：[2,5]
//        解释：已构造好的分数,排序后如下所示:
//        1/5, 1/3, 2/5, 1/2, 3/5, 2/3
//        很明显第三个最小的分数是 2/5
//
//        示例 2：
//        输入：arr = [1,7], k = 1
//        输出：[1,7]


import java.util.HashMap;
import java.util.Map;

public class kthSmallestPrimeFraction {
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int[] res = new int[2];
        Map<Double,int[]> map = new HashMap<>();
        for (int i=0;i<arr.length-1;i++){
            for (int j= arr.length-1;j>i;j--){
                Double num = new Double(arr[i])/arr[j];
                map.put(num,new int[]{arr[i],arr[j]});
            }
        }
        Double smaller = Double.MAX_VALUE;
        for (int i=0;i<k;i++) {
            smaller = Double.MAX_VALUE;
            for (Double d : map.keySet()) {
                smaller = Math.min(smaller, d);
            }
            if (i==k-1){
                break;
            }
            map.remove(smaller);
        }
        return map.get(smaller);
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(2,1);
        map.put(1,1);
        int[] test = new int[]{1,2,3,5};
        System.out.println(kthSmallestPrimeFraction(test,3));
    }
}
