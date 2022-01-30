package Practice.No118generate;

//        给定一个非负整数numRows，生成「杨辉三角」的前numRows行。
//        在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//
//        示例 1:
//        输入: numRows = 5
//        输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//
//        示例2:
//        输入: numRows = 1
//        输出: [[1]]


import java.util.ArrayList;
import java.util.List;

public class generate {
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：36.4 MB, 在所有 Java 提交中击败了14.48%的用户
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        for (int i=1;i<numRows+1;i++){
            res.add(temp);
            temp = change(temp);
        }
        return res;
    }
    public static List<Integer> change(List<Integer> list){
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int j=0;j<list.size()-1;j++){
            res.add(list.get(j)+list.get(j+1));
        }
        res.add(1);
        return res;
    }

    public static void main(String[] args) {
        List test = new ArrayList();
        System.out.println(generate(5));
    }
}
