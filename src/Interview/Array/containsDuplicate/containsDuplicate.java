package Interview.Array.containsDuplicate;

import java.util.HashMap;
import java.util.Map;

public class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:nums){
            if (map.containsKey(i)){
                return true;
            }else {
                map.put(i,1);
            }
        }
        return false;
    }
}
