package Practice.No223computeArea;

//        给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
//        每个矩形由其 左下 顶点和 右上 顶点坐标表示：
//        第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
//        第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
//
//        示例 1：
//        输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
//        输出：45
//
//        示例 2：
//        输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
//        输出：16

public class computeArea {
//    执行用时：3 ms, 在所有 Java 提交中击败了57.47%的用户
//    内存消耗：37.6 MB, 在所有 Java 提交中击败了87.18%的用户
    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //不相交
        if(ax2<bx1 || bx2<ax1 || ay2<by1 || by2<ay1){
            return (ax2-ax1)*(ay2-ay1)+(bx2-bx1)*(by2-by1);
        }
        //包含
        if (ax1<bx1 && ay1<by1 && ax2>bx2 && ay2>by2){
            return (ax2-ax1)*(ay2-ay1);
        }
        if (bx1<ax1 && by1<ay1 && bx2>ax2 && by2>ay2){
            return (bx2-bx1)*(by2-by1);
        }
        //相交
        else{
            return (ax2-ax1)*(ay2-ay1)
                    +(bx2-bx1)*(by2-by1)
                    -
                    (Math.abs(Math.min(ay2,by2)-Math.max(ay1,by1))
                            *Math.abs(Math.min(ax2,bx2)-Math.max(bx1,ax1)));
        }
    }

    public static void main(String[] args) {
//        System.out.println(computeArea(-3,0,3,4,0,-1,9,2));
        System.out.println(computeArea(-2,-2,2,2,3,3,4,4));
    }
}
