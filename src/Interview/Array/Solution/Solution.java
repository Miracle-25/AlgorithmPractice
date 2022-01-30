package Interview.Array.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        int[] res = new int[nums.length];
        for (int i:nums){
            list.add(i);
        }
        int j=0;
        while (list.size()>0){
            int temp = random.nextInt(list.size());
            res[j]=list.get(temp);
            list.remove(temp);
            j++;
        }
        return res;

    }
}
