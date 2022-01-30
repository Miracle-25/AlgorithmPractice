package Interview.SortAndIndex.wiggleSort;

public class wiggleSort {
    public static void wiggleSort(int[] nums) {
        for (int i=nums.length;i>0;i--){
            for (int j=0;j<i-1;j++){
                if (nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        int[] res = new int[nums.length];
        int left = nums.length/2,right = nums.length-1;
        if (nums.length%2==0){
            for (int i=0;left>0;left--,right--){
                res[i]=nums[left-1];
                i++;
                res[i]=nums[right];
                i++;
            }
        }else{
            for (int i=0;left>0;left--,right--){
                res[i]=nums[left];
                i++;
                res[i]=nums[right];
                i++;
            }
            res[res.length-1]=nums[0];
        }
        for (int i=0;i<nums.length;i++){
            nums[i]=res[i];
        }

    }

    public static void main(String[] args) {
        int[] test = new int[]{1,1,2,1,2,2,1};
        wiggleSort(test);
        System.out.println("wiggleSort(test)");
    }
}
