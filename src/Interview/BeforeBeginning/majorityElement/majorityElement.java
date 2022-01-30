package Interview.BeforeBeginning.majorityElement;

import java.util.HashMap;
import java.util.Map;

public class majorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> temp = new HashMap<>();
        int half = nums.length/2;
        for (int i=0;i< nums.length;i++){
            if (temp.containsKey(nums[i])){
                temp.replace(nums[i],temp.get(nums[i])+1);
            }else {
                temp.put(nums[i],1);
            }
        }
        for (int key: temp.keySet()){
            if (temp.get(key)> half){
                return key;
            }
        }
        return 0;

    }
}
