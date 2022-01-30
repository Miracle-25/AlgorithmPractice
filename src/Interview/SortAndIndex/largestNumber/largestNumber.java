package Interview.SortAndIndex.largestNumber;

import java.util.Arrays;

public class largestNumber {
    public static String largestNumber1(int[] nums) {
        if (nums.length==1){
            return ""+nums[0];
        }
        String[] temp = new String[nums.length];
        int maxLen = 0;
        for (int i=0;i<nums.length;i++){
            temp[i]=""+nums[i];
            maxLen = Math.max(maxLen,temp[i].length());
        }
        for (int i=maxLen-1;i>=0;i--){
            for (int x=nums.length-1;x>-1;x--){
                for (int y=0;y<x;y++){
                    char self,next;
                    if (maxLen-i>temp[y].length()){
                        self = temp[y].charAt(0);
                    }else {
                        self = temp[y].charAt(temp[y].length()+i-maxLen);
                    }
                    if (maxLen-i>temp[y+1].length()){
                        next = temp[y+1].charAt(0);
                    }else {
                        next = temp[y+1].charAt(temp[y+1].length()+i-maxLen);
                    }

                    if (self<next){
                        String str = temp[y];
                        temp[y]=temp[y+1];
                        temp[y+1]=str;
                    }
                }
            }
        }
        String res = "";
        for (int i=0;i<temp.length;i++){
            res = res+temp[i];
        }
        return res;
    }

    public static String largestNumber2(int[] nums){
        String[] temp = new String[nums.length];
        int maxLen = 0;
        for (int i=0;i<nums.length;i++){
            temp[i]=""+nums[i];
            maxLen = Math.max(maxLen,temp[i].length());
        }
        for (int i=nums.length-1;i>-1;i--){
            for (int j=0;j<i;j++){
                if (Long.parseLong(temp[j]+temp[j+1]) < Long.parseLong(temp[j+1]+temp[j])){
                    String str = temp[j];
                    temp[j]=temp[j+1];
                    temp[j+1]=str;
                }
            }
        }
        String res = "";
        for (int i=0;i<temp.length;i++){
            res = res+temp[i];
        }
        if (res.charAt(0)=='0'){
            return "0";
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{31,302,34,5,93};
        System.out.println(largestNumber2(test));
    }
}
