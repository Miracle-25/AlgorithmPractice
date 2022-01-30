package Practice.No517findMinMoves;

//        假设有 n台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
//        在每一步操作中，你可以选择任意 m (1 <= m <= n) 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
//        给定一个整数数组machines 代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的 最少的操作步数 。如果不能使每台洗衣机中衣物的数量相等，则返回 -1 。
//
//        示例 1：
//        输入：machines = [1,0,5]
//        输出：3
//        解释：
//        第一步:    1     0 <-- 5    =>    1     1     4
//        第二步:    1 <-- 1 <-- 4    =>    2     1     3
//        第三步:    2     1 <-- 3    =>    2     2     2
//
//        示例 2：
//        输入：machines = [0,3,0]
//        输出：2
//        解释：
//        第一步:    0 <-- 3     0    =>    1     2     0
//        第二步:    1     2 --> 0    =>    1     1     1
//
//        示例 3：
//        输入：machines = [0,2,0]
//        输出：-1
//        解释：
//        不可能让所有三个洗衣机同时剩下相同数量的衣物。


public class findMinMoves {
    public static int findMinMoves1(int[] machines) {
        int sum = sum1(machines);
        if (sum%machines.length!=0){
            return -1;
        }
        int res = 0;
        int bigger = 0;
        int average = sum/ machines.length;
        for (int i=0;i< machines.length;i++){
            if (machines[i]<average){
                res = res+average-machines[i];
            }else if (machines[i]>average){
                bigger++;
            }
        }
        try {
        if (res%bigger==0){
            return res/bigger;
        }else {
        return res/bigger+1;
        }
        }catch (Exception e){
            return 0;
        }
    }
    public static int sum1(int[] num){
        int res = 0;
        for (int i=0;i< num.length;i++){
            res = res+ num[i];
        }
        return res;
    }

//    执行用时：1 ms, 在所有 Java 提交中击败了87.24%的用户
//    内存消耗：39 MB, 在所有 Java 提交中击败了57.65%的用户
    public static int findMinMoves2(int[] machines) {
        int res = 0;
        int all = sum2(machines);
        if (all%machines.length!=0){
            return -1;
        }
        int average = all/ machines.length;
        int sum = 0;
        for (int num:machines){
            num = num-average;
            sum = sum+num;
            res = Math.max(res,Math.max(Math.abs(sum),num));
        }
        return res;
    }
    public static int sum2(int[] num){
        int res = 0;
        for (int i=0;i< num.length;i++){
            res = res+ num[i];
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] test1 = new int[]{1,0,5};
//        int[] test2 = new int[]{0,3,0};
//        int[] test3 = new int[]{0,2,2};
//        int[] test4 = new int[]{0,0,11,5};
//        System.out.println(findMinMoves2(test1));
//        System.out.println(findMinMoves2(test2));
//        System.out.println(findMinMoves2(test3));
//        System.out.println(findMinMoves2(test4));
        int[] test5 = new int[]{1,2,3,4,5,6,7};
        System.out.println(findMinMoves2(test5));
    }

}
