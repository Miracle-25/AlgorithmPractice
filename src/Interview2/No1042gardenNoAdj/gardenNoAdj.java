package Interview2.No1042gardenNoAdj;

import java.util.*;

public class gardenNoAdj {
    public static int[] gardenNoAdj(int n, int[][] paths) {
        int[] res = new int[n];
        //每个花园可能放的花
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i=1;i<n+1;i++){
            //所有花的可能性
            List<Integer> flowers = new ArrayList<>();
            flowers.add(new Integer(1));
            flowers.add(new Integer(2));
            flowers.add(new Integer(3));
            flowers.add(new Integer(4));
            map.put(i,flowers);
        }
        change(paths);
        Arrays.sort(paths, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        filterFlowers(paths,map);

        for (int i=0;i<res.length;i++){
            res[i]=map.get(i+1).get(0);
        }

        return res;
    }
    public static void change(int[][] path){
        for (int i=0;i< path.length;i++){
            int pre=path[i][0];
            int end=path[i][1];
            if (pre>end){
                path[i][1]=pre;
                path[i][0]=end;
            }
        }
    }
    public static void filterFlowers(int[][] paths,Map<Integer,List<Integer>> map){
        for (int i=0;i<paths.length;i++){
            int garden = paths[i][0];
            Integer flower = map.get(garden).get(0);
            int otherGarden = paths[i][1];
            map.get(otherGarden).remove(flower);
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
        System.out.println(gardenNoAdj(4,test));
    }
}
