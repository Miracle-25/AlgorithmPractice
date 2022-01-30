package Practice.No434countSegments;

//        统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
//        请注意，你可以假定字符串里不包括任何不可打印的字符。
//
//        示例:
//        输入: "Hello, my name is John"
//        输出: 5
//        解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。


public class countSegments {
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：35.9 MB, 在所有 Java 提交中击败了96.10%的用户
    public static int countSegments(String s) {
        int res = 0;
        int j=0;
        for (int i=0;i<s.length();i++){
            if (judgeChar(s.charAt(i))){
                for (j=i;j<s.length();j++){
                    if (!judgeChar(s.charAt(j))){
                        break;
                    }
                }
                res++;
                i=j;
            }
        }
        return res;
    }
    public static boolean judgeChar(char c){
//        if ((c>=65 && c<=90) || (c<=122 && c>=97) || c==39 || c==45 || c==44){
        if (c!=32){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
        System.out.println(countSegments(""));
        System.out.println(countSegments(", , , ,        a, eaefa"));
        System.out.println(countSegments("The one-hour drama series Westworld is a dark odyssey about the dawn of artificial consciousness and the evolution of sin. Set at the intersection of the near future and the reimagined past, it explores a world in which every human appetite, no matter how noble or depraved, can be indulged."));
        System.out.println(countSegments(", , , ,        a, eaefa") );
    }
}
