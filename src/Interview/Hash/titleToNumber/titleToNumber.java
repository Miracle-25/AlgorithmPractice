package Interview.Hash.titleToNumber;

import java.util.HashMap;
import java.util.Map;

public class titleToNumber {
    public static int titleToNumber(String columnTitle) {
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;
        int len = columnTitle.length()-1;
        for (int i=65;i<91;i++){
            map.put((char) i,i-65+1);
        }

        for (int i=columnTitle.length()-1;i>=0;i--){
            res = (int) (res+map.get(columnTitle.charAt(i))* Math.pow(26,(double) len-i));
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("FXSHRXW"));
    }
}
