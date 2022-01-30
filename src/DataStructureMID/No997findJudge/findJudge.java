package DataStructureMID.No997findJudge;

//        在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。
//
//        如果小镇的法官真的存在，那么：
//        小镇的法官不相信任何人。
//        每个人（除了小镇法官外）都信任小镇的法官。
//        只有一个人同时满足条件 1 和条件 2 。
//        给定数组trust，该数组由信任对 trust[i] = [a, b]组成，表示编号为 a 的人信任编号为 b 的人。
//
//        如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。
//
//        示例 1：
//        输入：n = 2, trust = [[1,2]]
//        输出：2
//
//        示例 2：
//        输入：n = 3, trust = [[1,3],[2,3]]
//        输出：3
//
//        示例 3：
//        输入：n = 3, trust = [[1,3],[2,3],[3,1]]
//        输出：-1
//
//        示例 4：
//        输入：n = 3, trust = [[1,2],[2,3]]
//        输出：-1
//
//        示例 5：
//        输入：n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
//        输出：3

public class findJudge {
//    执行用时：2 ms, 在所有 Java 提交中击败了99.05%的用户
//    内存消耗：45.9 MB, 在所有 Java 提交中击败了59.38%的用户
    public static int findJudge(int n, int[][] trust) {
        int[]  temp = new int[n];
        for (int i=0;i<trust.length;i++){
            temp[trust[i][1]-1]++;
        }
        for (int i=0;i<temp.length;i++){
            if (temp[i]==n-1){
                if (judge(trust,i+1)){
                    return i+1;
                }else {
                    return -1;
                }
            }
        }
        return -1;
    }

    public static boolean judge(int[][] trust,int n){
        for (int i=0;i<trust.length;i++){
            if (trust[i][0]==n){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}};
        System.out.println(findJudge(4,test));
    }
}
