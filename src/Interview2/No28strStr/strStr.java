package Interview2.No28strStr;

public class strStr {
    public static int strStr(String haystack, String needle) {
        if (haystack.equals("")){
            return -1;
        }
        if (needle.equals("") || haystack.equals(needle)){
            return 0;
        }
        for (int left=0;left<haystack.length()-needle.length()+1;left++){
            if (haystack.charAt(left)==needle.charAt(0)){
                int right;
                for (right=0;right<needle.length();right++){
                    if (haystack.charAt(left+right)==needle.charAt(right)){
                        continue;
                    }else {
                        break;
                    }
                }
                if (right==needle.length()){
                    return left;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("abo","o"));
    }
}
