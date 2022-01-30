package Yangqianguan;


import java.util.ArrayList;
import java.util.List;
//问题描述给定随机数组 data[]，寻找指定k个数的和为m的所有组合== 示例输入int data[] = {1,2,3,4,5,6,8,10};int k = 2;int m = 7;返回 {{1, 6}, {2, 5}, {3, 4}}
public class Test {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> solution(int[] data,int k,int m){
        int len = data.length;
        for (int i=0;i<len-k;i++){
            temp.add(new Integer(data[i]));
            addList(data,i,k-1,m-data[i]);
            temp.remove(data[i]);
        }
        return res;
    }

    public void addList(int[] data,int begin,int k,int m){
        if (k==0 && m==0){
            List<Integer> list = new ArrayList<>();
            for (int i:temp){
                list.add(i);
            }
            res.add(list);
        }else if (k==0){
            return;
        }
        for (int i=begin+1;i<data.length-k;i++){
            temp.add(new Integer(data[i]));
            addList(data,i,k-1,m-data[i]);
            temp.remove(data[i]);
        }
    }

}
