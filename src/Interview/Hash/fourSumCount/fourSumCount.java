package Interview.Hash.fourSumCount;

public class fourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int res = 0;
        for (int a=0;a<n;a++){
            for (int b=0;b<n;b++){
                for (int c=0;c<n;c++){
                    for (int d=0;d<n;d++){
                        if (nums1[a]+nums2[b]+nums3[c]+nums4[d]==0){
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
