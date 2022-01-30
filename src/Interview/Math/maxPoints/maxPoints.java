package Interview.Math.maxPoints;

import java.util.*;

public class maxPoints {

    static Map<Integer,Set<int[]>> col = new HashMap();
    public static int maxPoints(int[][] points) {
        Map<Double, Set<int[]>> map = new HashMap<>();
        Set<int[]> set = new HashSet<>();
        set.add(points[0]);
        set.add(points[1]);
        map.put(Slope(points[0],points[1]),set);

        for (int i=2;i<points.length;i++){
            int[] tempArr = points[i];
            for (double j:map.keySet()){
                Set<int[]> tempset = map.get(j);
                for (int[] x:tempset){
                    double tempslop = Slope(x,tempArr);
                    if (tempslop==Double.MAX_VALUE){
                        continue;
                    } else if (tempslop==j){
                        map.get(j).add(tempArr);
                        break;
                    }else {
                        if (map.containsKey(tempslop)){
                            map.get(tempslop).add(tempArr);
                        }else {
                            Set<int[]> temp = new HashSet<>();
                            temp.add(tempArr);
                            temp.add(x);
                            map.put(tempslop,temp);
                        }
                    }
                }
            }
        }
        int res = 0;
        for (double key: map.keySet()){
            res = Math.max(res,map.get(key).size());
        }
        return res;
    }
    public static double Slope(int[] arr1,int[] arr2){
        if (arr1[1]==arr2[1]){
            if (col.containsKey(arr1[1])){
                col.get(arr1[1]).add(arr1);
                col.get(arr1[1]).add(arr2);
            }else {
                Set<int[]> set = new HashSet<>();
                set.add(arr1);
                set.add(arr2);
                col.put(arr1[1],set);
            }
            return Double.MAX_VALUE;
        }
        return (double) (arr1[0]-arr2[0])/(double) (arr1[1]-arr2[1]);
    }

    public static void main(String[] args) {
        int[][] test = new int[][]
//                {{1, 1}, {2, 2}, {3, 3}};
                {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println(maxPoints(test));

    }
}
