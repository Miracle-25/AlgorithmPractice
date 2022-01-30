package Practice.Interview1714smallestK;

//        设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
//
//        示例：
//        输入： arr = [1,3,5,7,2,4,6,8], k = 4
//        输出： [1,2,3,4]

import java.util.Arrays;

public class smallestK {

    public static int[] smallestK1(int[] arr, int k) {
        int[] res = new int[k];
        boolean[] target = new boolean[arr.length];
        int t=0;
        for (int i=0;i<k;i++){
            int temp = Integer.MAX_VALUE;
            for (int j=0;j<arr.length;j++){
                if (!target[j]){
                temp = Math.min(temp,arr[j]);
                if (temp == arr[j]){
                    t=j;
                }
                }
            }
            res[i] = temp;
            target[t] = true;
        }
        return res;
    }

    public static int[] smallestK2(int[] arr, int k){
        int[] res = new int[k];



        return res;
    }
    public static void sort(int[] arr,int begin,int end){
        if (begin!=end){
            int ran = (int)(Math.random()*(end-begin)+begin);
            int i=begin,j=end-1;
            for (;i<j;){
                if (arr[i]>arr[ran]){
                    int temp = arr[ran];
                    arr[ran] = arr[i];
                    arr[i] = temp;
                    ran = i;
                }else {
                    i++;
                }
                if (arr[j]<arr[ran]){
                    int temp = arr[ran];
                    arr[ran] = arr[j];
                    arr[j] = temp;
                    ran = j;
                }else {
                    j--;
                }
            }
            sort(arr,begin,i);
            sort(arr,j,end);
        }
    }

    public static int[] smallestK3(int[] arr, int k){
        int[] res = new int[k];
        sort2(arr);
        for (int i=0;i<k;i++){
            res[i] = arr[i];
        }
        return res;
    }
    public static void sort2(int[] arr){
        int num = arr.length;
        for (int i=0;i<num;num--){
            for (int j=i+1;j<num;j++){
                if (arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
                i++;
            }
            i=0;
        }
    }

//    执行用时：7 ms, 在所有 Java 提交中击败了64.09%的用户
//    内存消耗：48.1 MB, 在所有 Java 提交中击败了37.93%的用户
    public static int[] smallestK4(int[] arr, int k){
        int[] res = new int[k];

        Arrays.sort(arr);
        for (int i=0;i<k;i++){
            res[i] = arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = {1,3,5,7,2,4,6,8};
//        System.out.println(smallestK1(test,4));
       // sort(test,0,test.length);
        System.out.println(smallestK3(test,4));
    }
}
