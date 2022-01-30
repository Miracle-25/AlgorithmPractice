package Practice.No1894chalkReplacer;

//        一个班级里有n个学生，编号为 0到 n - 1。每个学生会依次回答问题，编号为 0的学生先回答，然后是编号为 1的学生，以此类推，直到编号为 n - 1的学生，然后老师会重复这个过程，重新从编号为 0的学生开始回答问题。
//        给你一个长度为 n且下标从 0开始的整数数组chalk和一个整数k。一开始粉笔盒里总共有k支粉笔。当编号为i的学生回答问题时，他会消耗 chalk[i]支粉笔。如果剩余粉笔数量严格小于chalk[i]，那么学生 i需要补充粉笔。
//        请你返回需要补充粉笔的学生编号。
//
//        示例 1：
//        输入：chalk = [5,1,5], k = 22
//        输出：0
//        解释：学生消耗粉笔情况如下：
//        - 编号为 0 的学生使用 5 支粉笔，然后 k = 17 。
//        - 编号为 1 的学生使用 1 支粉笔，然后 k = 16 。
//        - 编号为 2 的学生使用 5 支粉笔，然后 k = 11 。
//        - 编号为 0 的学生使用 5 支粉笔，然后 k = 6 。
//        - 编号为 1 的学生使用 1 支粉笔，然后 k = 5 。
//        - 编号为 2 的学生使用 5 支粉笔，然后 k = 0 。
//        编号为 0 的学生没有足够的粉笔，所以他需要补充粉笔。
//
//        示例 2：
//        输入：chalk = [3,4,1,2], k = 25
//        输出：1
//        解释：学生消耗粉笔情况如下：
//        - 编号为 0 的学生使用 3 支粉笔，然后 k = 22 。
//        - 编号为 1 的学生使用 4 支粉笔，然后 k = 18 。
//        - 编号为 2 的学生使用 1 支粉笔，然后 k = 17 。
//        - 编号为 3 的学生使用 2 支粉笔，然后 k = 15 。
//        - 编号为 0 的学生使用 3 支粉笔，然后 k = 12 。
//        - 编号为 1 的学生使用 4 支粉笔，然后 k = 8 。
//        - 编号为 2 的学生使用 1 支粉笔，然后 k = 7 。
//        - 编号为 3 的学生使用 2 支粉笔，然后 k = 5 。
//        - 编号为 0 的学生使用 3 支粉笔，然后 k = 2 。
//        编号为 1 的学生没有足够的粉笔，所以他需要补充粉笔。

public class chalkReplacer {
//    执行用时：2 ms, 在所有 Java 提交中击败了84.92%的用户
//    内存消耗：54.4 MB, 在所有 Java 提交中击败了50.47%的用户
    public static int chalkReplacer(int[] chalk, int k) {
        int res = 0;

        int num = chalk.length;
        long sum = 0;
        for (int i=0;i<num;i++){
            sum = chalk[i]+sum;
        }
        long temp = k%sum;
        for (int i=0;i<num;i++){
            if (chalk[i]>temp){
                res = i;
                break;
            }else {
                temp = temp-chalk[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{5,1,5};
        int[] test2 = new int[]{3,4,1,2};
        System.out.println(chalkReplacer(test1,22));
        System.out.println(chalkReplacer(test2,25));
//        int[] test = new int[]{};
//        System.out.println(chalkReplacer(,539095482));
    }
}
