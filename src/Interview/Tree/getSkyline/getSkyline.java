package Interview.Tree.getSkyline;

import java.util.ArrayList;
import java.util.List;

public class getSkyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int beginX = buildings[0][0];
        int endX = buildings[0][1];
        int height = 0;
        List<List<Integer>> res = new ArrayList<>();
        while (beginX<Integer.MAX_VALUE) {

            for (; beginX < endX; beginX++) {
                if (height != hasMoreHeight(buildings, beginX, height)) {
                    height = hasMoreHeight(buildings, beginX, height);
                    endX = buildings[beginX][1];
                    List<Integer> temp = new ArrayList<>();
                    temp.add(beginX);
                    temp.add(height);
                    res.add(temp);
                }
            }
        }
        return res;
    }
    public int hasMoreHeight(int[][] buildings,int i,int height){
        for (int j=0;j<buildings.length;j++){
            if (buildings[j][0]<j && buildings[j][1]>j){
                if (buildings[j][2]>height){
                    return buildings[j][2];
                }
            }
        }
        return height;
    }
}
