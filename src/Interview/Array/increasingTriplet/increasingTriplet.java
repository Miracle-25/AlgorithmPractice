package Interview.Array.increasingTriplet;

public class increasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        for (int x=0;x<nums.length-2;x++){
            for (int y=x+1;y<nums.length-1;y++){
                for (int z=y+1;z<nums.length;z++){
                    if (nums[x]<nums[y] && nums[y]<nums[z]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
