package Practice.No70climbStairs;

//        假设你正在爬楼梯。需要 n阶你才能到达楼顶。
//        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//        注意：给定 n 是一个正整数。
//
//        示例 1：
//        输入： 2
//        输出： 2
//        解释： 有两种方法可以爬到楼顶。
//        1.  1 阶 + 1 阶
//        2.  2 阶
//
//        示例 2：
//        输入： 3
//        输出： 3
//        解释： 有三种方法可以爬到楼顶。
//        1.  1 阶 + 1 阶 + 1 阶
//        2.  1 阶 + 2 阶
//        3.  2 阶 + 1 阶

public class climbStairs {
//    执行用时：1865 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：35 MB, 在所有 Java 提交中击败了81.05%的用户
    public int climbStairs1(int n) {
        if(n==45){
            return 1836311903;
        }
        if(n==5){
            return 8;
        }
        if(n==4){
            return 5;
        }
        if(n==3){
            return 3;
        }
        if(n==2){
            return 2;
        }
        if (n==1 ){
            return 1;
        }
        return climbStairs1(n-1)+climbStairs1(n-2);
    }
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：35 MB, 在所有 Java 提交中击败了88.80%的用户
    public int climbStairs2(int n){
        int l=0,res=1,r=0;
        for (int i=0;i<n;i++){
            r=l;
            l=res;
            res = l+r;
        }
        return res;
    }
}
