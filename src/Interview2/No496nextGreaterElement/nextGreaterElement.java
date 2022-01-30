package Interview2.No496nextGreaterElement;

import java.util.Stack;

public class nextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        int max=-1;
        int length = nums1.length;
        for (int i:nums1){
            stack.push(i);
        }

        while (!stack.isEmpty()){
            int top = stack.pop();
            max=-1;
            for (int i=0;i<nums2.length;i++){
                int x=nums2[nums2.length-1-i];
                if (x==top){
                    if (i==0){
                        res[length-1]=-1;
                    }else {
                        res[length-1]=max;
                    }
                    length--;
                    break;
                }else if (x>top){
                    max=x;
                }else if (x<top){
                    max=Math.max(max,-1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test1=new int[]{4,1,2};
        int[] test2=new int[]{1,3,4,2};
        System.out.println(nextGreaterElement(test1,test2));
    }
}
