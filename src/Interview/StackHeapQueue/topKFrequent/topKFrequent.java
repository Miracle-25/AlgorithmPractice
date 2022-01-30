package Interview.StackHeapQueue.topKFrequent;

import java.util.HashMap;
import java.util.Map;

public class topKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer,Integer> map = new HashMap();
        for (int i:nums){
            if (map.containsKey(i)){
                map.replace(i,map.get(i)+1);
            }else {
                map.put(i,1);
            }
        }
        for (int i=0;i<k;i++) {
            int maxKey = 0;
            int maxValue = Integer.MIN_VALUE;
            for (int key : map.keySet()) {
                int max = Math.max(maxValue,map.get(key));
                if (max!=maxValue){
                    maxValue = max;
                    maxKey = key;
                }
            }
            res[i]=maxKey;
            map.remove(maxKey);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,1,1,2,2,3};
        System.out.println(topKFrequent(test,2));
    }
}
