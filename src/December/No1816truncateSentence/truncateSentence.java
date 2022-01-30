package December.No1816truncateSentence;

//        句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
//
//        例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
//        给你一个句子 s 和一个整数 k ，请你将 s 截断，使截断后的句子仅含 前 k 个单词。返回 截断 s 后得到的句子。
//
//        示例 1：
//        输入：s = "Hello how are you Contestant", k = 4
//        输出："Hello how are you"
//        解释：
//        s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
//        前 4 个单词为 ["Hello", "how", "are", "you"]
//        因此，应当返回 "Hello how are you"
//
//        示例 2：
//        输入：s = "What is the solution to this problem", k = 4
//        输出："What is the solution"
//        解释：
//        s 中的单词为 ["What", "is" "the", "solution", "to", "this", "problem"]
//        前 4 个单词为 ["What", "is", "the", "solution"]
//        因此，应当返回 "What is the solution"
//
//        示例 3：
//        输入：s = "chopper is not a tanuki", k = 5
//        输出："chopper is not a tanuki"

public class truncateSentence {
//    执行用时：5 ms, 在所有 Java 提交中击败了14.91%的用户
//    内存消耗：38.4 MB, 在所有 Java 提交中击败了12.47%的用户
    public static String truncateSentence(String s, int k) {
        if (k<=0){
            return "";
        }
        String res = "";
        String[] arr = s.split(" ");
        res = arr[0];
        for (int i=1;i<k;i++){
            res = res + " " + arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String test = "What is the solution to this problem";
        String[] arrstr = test.split(" ");
        System.out.println(truncateSentence(test,4));
    }
}
