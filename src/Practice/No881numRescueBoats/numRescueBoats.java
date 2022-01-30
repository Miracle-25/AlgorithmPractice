package Practice.No881numRescueBoats;
//第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。
//每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
//返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
//
//示例 1：
//输入：people = [1,2], limit = 3
//输出：1
//解释：1 艘船载 (1, 2)
//
//示例 2：
//输入：people = [3,2,2,1], limit = 3
//输出：3
//解释：3 艘船分别载 (1, 2), (2) 和 (3)
//
//示例 3：
//输入：people = [3,5,3,4], limit = 5
//输出：4
//解释：4 艘船分别载 (3), (3), (4), (5)

import java.util.HashMap;
import java.util.Map;

public class numRescueBoats {
    public static int numRescueBoats1(int[] people, int limit) {
        int res=0;

        people = sort(people);
        for (int l=0,r=people.length-1;r>=l;){
            if (people[r]==limit){
                res++;
                r--;
            }else if (limit-people[r]>=people[l]){
                res++;
                r--;
                l++;
            }else if (limit-people[r]<people[l]){
                res++;
                r--;
            }
        }
        return res;
    }
    public static int[] sort(int[] arr){
        int temp = 0;
        for (int j=arr.length;j>0;j--) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int numRescueBoats2(int[] people, int limit){
        int res = 0;
        Map<Integer,Integer> above = new HashMap();
        Map<Integer,Integer> below = new HashMap();
        int x=0;
        for (int i=0;i< people.length;i++){
            if (people[i]==limit){
                res++;
            }else if(people[i]<=limit/2){
                if (below.containsKey(people[i])){
                    below.put(people[i],below.get(people[i])+1);
                }else {
                below.put(people[i],1);
                }
            }else if(people[i]>limit/2){
                if (above.containsKey(people[i])){
                    above.put(people[i],above.get(people[i])+1);
                }else {
                    above.put(people[i],1);
                }
            }
        }

        for (int j=0;j<above.size();){
            if (below.isEmpty()){
                res = res+above.size();
            }
            for (x=0;x<below.size();){
                if (below.get(x)+above.get(j)<=limit){
                    res++;
                    below.put(people[x],below.get(people[x])-1);
                    above.put(people[x],above.get(people[x])-1);
                    if (below.get(x)==0){
                        below.remove(x);
                    }
                    break;
                }else {
                    x++;
                }
            }
            if(x==below.size()-1){
                res++;
                above.put(people[x],above.get(people[x])-1);
            }
            if (above.get(j)==0){
                above.remove(j);
            }

        }
    if (!below.isEmpty()){
        if (below.size()%2==0){
        res =res + below.size()/2;
        }else {
            res =res + below.size()/2+1;
        }
    }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{3,5,3,4};
        System.out.println(numRescueBoats2(test,5));
    }
}
