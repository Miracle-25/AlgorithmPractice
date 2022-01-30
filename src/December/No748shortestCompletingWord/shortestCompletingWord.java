package December.No748shortestCompletingWord;

//        给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
//        补全词 是一个包含 licensePlate 中所有的字母的单词。在所有补全词中，最短的那个就是 最短补全词 。
//        在匹配 licensePlate 中的字母时：
//        忽略licensePlate 中的 数字和空格 。
//        不区分大小写。
//        如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
//        例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 有 "abccdef"、"caaacab" 以及 "cbca" 。
//
//        请你找出并返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取 words 中 最靠前的 那个。
//
//        示例 1：
//        输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
//        输出："steps"
//        解释：最短补全词应该包括 "s"、"p"、"s"（忽略大小写） 以及 "t"。
//        "step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
//        "steps" 包含 "t"、"p" 和两个 "s"。
//        "stripe" 缺一个 "s"。
//        "stepple" 缺一个 "s"。
//        因此，"steps" 是唯一一个包含所有字母的单词，也是本例的答案。
//
//        示例 2：
//        输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
//        输出："pest"
//        解释：licensePlate 只包含字母 "s" 。所有的单词都包含字母 "s" ，其中 "pest"、"stew"、和 "show" 三者最短。答案是 "pest" ，因为它是三个单词中在 words 里最靠前的那个。
//
//        示例 3：
//        输入：licensePlate = "Ah71752", words = ["suggest","letter","of","husband","easy","education","drug","prevent","writer","old"]
//        输出："husband"
//
//        示例 4：
//        输入：licensePlate = "OgEu755", words = ["enough","these","play","wide","wonder","box","arrive","money","tax","thus"]
//        输出："enough"
//
//        示例 5：
//        输入：licensePlate = "iMSlpe4", words = ["claim","consumer","student","camera","public","never","wonder","simple","thought","use"]
//        输出："simple"

import java.util.HashMap;
import java.util.Map;

public class shortestCompletingWord {
//    执行用时：7 ms, 在所有 Java 提交中击败了29.62%的用户
//    内存消耗：38.3 MB, 在所有 Java 提交中击败了98.24%的用户
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        int shorter = Integer.MAX_VALUE;
        String temp = "";
        for (int i=0;i<words.length;i++){
            Map<Character,Integer> initMap = init(licensePlate);
            if (isCompleting(words[i],initMap)){
                if (words[i].length()<shorter){
                    temp = words[i];
                    shorter = temp.length();
                }
            }
        }
        return temp;
    }
    public static boolean isCompleting(String word,Map<Character,Integer> map){
        for (int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if (c<=90 && c>=65){
                c = (char) (c+32);
            }
            if (map.containsKey(c)){
                if (map.get(c)==1){
                    map.remove(c);
                }else {
                    map.replace(c,map.get(c)-1);
                }
            }
        }
        return map.isEmpty();
    }
    public static Map<Character,Integer> init(String str){
        Map<Character,Integer> res = new HashMap<>();

        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (c<=90 && c>=65){
                c = (char) (c+32);
            }
            if (res.containsKey(c)){
                res.replace(c,res.get(c)+1);
            }else if (c<=122 && c>=97){
                res.put(c,1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] test = new String[]{"looks", "pest", "stew", "show"};
        System.out.println(shortestCompletingWord("1s3 456",test));

        test = new String[]{"suggest","letter","of","husband","easy","education","drug","prevent","writer","old"};
        System.out.println(shortestCompletingWord("Ah71752",test));

        test = new String[]{"enough","these","play","wide","wonder","box","arrive","money","tax","thus"};
        System.out.println(shortestCompletingWord("OgEu755",test));

        test = new String[]{"claim","consumer","student","camera","public","never","wonder","simple","thought","use"};
        System.out.println(shortestCompletingWord("iMSlpe4",test));

        test = new String[]{"step", "steps", "stripe", "stepple"};
        System.out.println(shortestCompletingWord("1s3 PSt",test));
    }
}
