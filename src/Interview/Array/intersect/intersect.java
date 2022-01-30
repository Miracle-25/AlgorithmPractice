package Interview.Array.intersect;

import java.util.ArrayList;
import java.util.List;

public class intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> n1 = new ArrayList<>();
        for (int i:nums1){
            n1.add(i);
        }
        for (int i=0;i<nums2.length && n1.size()>0;i++){
            if (n1.contains(nums2[i])){
                list.add(nums2[i]);
                n1.remove(new Integer(nums2[i]));
            }else {
                continue;
            }
        }
        int[] res = new int[list.size()];
        for (int i=0;i< res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
