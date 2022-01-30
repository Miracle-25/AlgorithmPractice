package Practice.No557reverseWords;

//        给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//        示例：
//        输入："Let's take LeetCode contest"
//        输出："s'teL ekat edoCteeL tsetnoc"


public class reverseWords {
//    执行用时：18 ms, 在所有 Java 提交中击败了14.67%的用户
//    内存消耗：39.7 MB, 在所有 Java 提交中击败了5.03%的用户
    public static String reverseWords(String s) {
        String[] temp = s.split(" ");
        String res = new String();
        for (int i=0;i<temp.length-1;i++){
            res =res + reverse(temp[i])+" ";
        }
        return res+reverse(temp[temp.length-1]);
    }
    public static String reverse(String s){
        char[] arr = s.toCharArray();
        int l=0,r=s.length()-1;
        while (l<r){
            char temp = arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String test = "Let's take LeetCode contest";
        System.out.println(reverseWords(test));
    }
}
