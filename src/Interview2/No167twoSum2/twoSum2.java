package Interview2.No167twoSum2;

public class twoSum2 {
    public static int[] twoSum(int[] numbers, int target){
        int[] res = new int[2];
        for (int i=0;i<numbers.length-1;i++){
            int temp = target-numbers[i];
            res[1]=search(i+1, numbers.length-1, numbers,temp)+1;
            if (res[1]!=1002){
                res[0]=i+1;
                return res;
            }
        }
        return res;
    }

    public static int search(int begin,int end,int[] arr,int target){
        if (arr[begin]==target){
            return begin;
        }else if (end<=begin){
            return 1001;
        }else {
            int mid = (begin+end)/2;
            if (target==arr[mid]){
                return mid;
            }else if (target>arr[mid]){
                return search(mid+1,end,arr,target);
            }else {
                return search(begin,mid-1,arr,target);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{5,25,75},100));
    }
}
