package DataStructureMID.No119getRow;

//        给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex行。
//        在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//
//        示例 1:
//        输入: rowIndex = 3
//        输出: [1,3,3,1]
//
//        示例 2:
//        输入: rowIndex = 0
//        输出: [1]
//
//        示例 3:
//        输入: rowIndex = 1
//        输出: [1,1]

import java.util.ArrayList;
import java.util.List;

public class getRow {
//    执行用时：1 ms, 在所有 Java 提交中击败了78.49%的用户
//    内存消耗：36.5 MB, 在所有 Java 提交中击败了5.14%的用户
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if (rowIndex==0){
            return res;
        }
        res.add(1);
        if (rowIndex==1){
            return res;
        }
        for (int i=1;i<rowIndex;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j=1;j<res.size();j++){
                temp.add(res.get(j-1)+res.get(j));
            }
            temp.add(1);
            res=temp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getRow(4));
    }
}
