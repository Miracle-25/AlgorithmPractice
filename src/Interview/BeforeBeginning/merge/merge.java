package Interview.BeforeBeginning.merge;

public class merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int x=0,y=0;
        for (int i=0;i<nums1.length && y<n ;i++){
            if (x==m){
                nums1[i]=nums2[y];
                y++;
            }else {
                if (nums1[i] <= nums2[y]) {
                    x++;
                    continue;
                } else if (nums1[i] > nums2[y]) {
                    moveOne(nums1, i);
                    nums1[i] = nums2[y];
                    y++;
                }
            }
        }
    }
    public static void moveOne(int[] num,int i){
        for (int j= num.length-1;i<j;j--){
            num[j] = num[j-1];
        }
    }

    public static void main(String[] args) {
        int[] test1=new int[]{1,2,3,0,0,0};
        int[] test2 = new int[]{2,5,6};
        merge(test1,3,test2,3);
    }
}
