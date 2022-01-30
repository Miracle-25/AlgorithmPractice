package Practice.No1109corpFlightBookings;

//这里有n个航班，它们分别从 1 到 n 进行编号。
//有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]意味着在从 firsti到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。
//请你返回一个长度为 n 的数组answer，其中 answer[i] 是航班 i 上预订的座位总数。
//
//        示例 1：
//        输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//        输出：[10,55,45,25,25]
//        解释：
//        航班编号        1   2   3   4   5
//        预订记录 1 ：   10  10
//        预订记录 2 ：       20  20
//        预订记录 3 ：       25  25  25  25
//        总座位数：      10  55  45  25  25
//        因此，answer = [10,55,45,25,25]
//
//        示例 2：
//        输入：bookings = [[1,2,10],[2,2,15]], n = 2
//        输出：[10,25]
//        解释：
//        航班编号        1   2
//        预订记录 1 ：   10  10
//        预订记录 2 ：       15
//        总座位数：      10  25
//        因此，answer = [10,25]


public class corpFlightBookings {
//    执行用时：1789 ms, 在所有 Java 提交中击败了5.02%的用户
//    内存消耗：53.6 MB, 在所有 Java 提交中击败了29.46%的用户
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int i=0;i<bookings.length;i++){
            for (int j=bookings[i][0];j<bookings[i][1]+1;j++){
                res[j-1]=res[j-1]+bookings[i][2];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] test1={{1,2,10},{2,2,15}};
        int[][] test2={{1,2,10},{2,3,20},{2,5,25}};
        System.out.println(corpFlightBookings(test2,5));
    }
}
