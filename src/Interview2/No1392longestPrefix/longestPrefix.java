package Interview2.No1392longestPrefix;

public class longestPrefix {
    public static String longestPrefix(String s) {
        String res="";
        int n=s.length();
        if (n==1){
            return res;
        }
        char begin = s.charAt(0);
        char end =s.charAt(n-1);
        for (int i=0;i<n-1;i++){
            char left = s.charAt(i);
            char right = s.charAt(s.length()-1-i);
            if (left==end && right==begin){
                if (s.substring(0,i+1).equals(s.substring(n-1-i))){
                    res = s.substring(0,i+1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//       System.out.println(longestPrefix("leetcodeleet"));
        System.out.println();

    }
}
