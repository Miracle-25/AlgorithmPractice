package Interview.Array.majorityElement;

import java.util.HashMap;
import java.util.Map;

public class majorityElement {
    public int majorityElement(int[] nums) {
        int[] temp = new int[]{0,0};
        for (int i:nums){
            if (temp[1]==0){
                temp[0]=i;
                temp[1]=1;
            } else if (temp[0]==i){
                temp[1]++;
            }else if (temp[0]!=i){
                temp[1]--;
            }
        }
        return temp[0];
    }
}
