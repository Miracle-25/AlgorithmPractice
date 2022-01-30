package Practice.No68fullJustify;

//        给定一个单词数组和一个长度maxWidth，重新排版单词，使其成为每行恰好有maxWidth个字符，且左右两端对齐的文本。
//        你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格' '填充，使得每行恰好有 maxWidth个字符。
//        要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
//        文本的最后一行应为左对齐，且单词之间不插入额外的空格。
//
//        说明:
//        单词是指由非空格字符组成的字符序列。
//        每个单词的长度大于 0，小于等于maxWidth。
//        输入单词数组 words至少包含一个单词。
//
//        示例:
//        输入:
//        words = ["This", "is", "an", "example", "of", "text", "justification."]
//        maxWidth = 16
//        输出:
//        [
//         "This  is  an",
//         "example of text",
//         "justification. "
//        ]
//
//        示例2:
//        输入:
//        words = ["What","must","be","acknowledgment","shall","be"]
//        maxWidth = 16
//        输出:
//        [
//         "What  must  be",
//         "acknowledgment ",
//         "shall be "
//        ]
//        解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//            因为最后一行应为左对齐，而不是左右两端对齐。
//        第二行同样为左对齐，这是因为这行只包含一个单词。
//
//        示例3:
//
//        输入:
//        words = ["Science","is","what","we","understand","well","enough","to","explain",
//                "to","a","computer.","Art","is","everything","else","we","do"]
//        maxWidth = 20
//        输出:
//        [
//         "Science is what we",
//        "understand   well",
//         "enough to explain to",
//         "a computer. Art is",
//         "everything else we",
//         "do         "
//        ]


import java.util.ArrayList;
import java.util.List;


public class fullJustify {
    //        执行用时：8 ms, 在所有 Java 提交中击败了9.76%的用户
    //        内存消耗：37.2 MB, 在所有 Java 提交中击败了8.78%的用户
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int[] arrNum = new int[words.length];
        for (int i = 0;i<words.length;i++){
            arrNum[i] = words[i].length();
        }
        String temp="";
        int target = maxWidth;
        int begin = 0;
        int end = begin;
        for (int i=0;i<arrNum.length;i++){
            if (target-words[i].length()<0){
                res.add(getString(begin,end,words,target,maxWidth));
                target = maxWidth;
                temp = "";
            }
            if (temp == ""){
                begin = i;
                end = begin;
            }
            if (target>= words[i].length()){
                temp = words[i];
                end++;
                target = target- words[i].length()-1;
            }
        }
        String finalword = "";
        for (int i = begin;i<arrNum.length;i++){
            if (finalword.length()+words[i].length()==maxWidth){
                finalword = finalword+words[i];
            }else {
            finalword = finalword+words[i]+" ";
            }
        }
        if (finalword.length()<maxWidth){
            for (int i=0;i<maxWidth-finalword.length();){
                finalword = finalword+" ";
            }
        }
        res.add(finalword);
        return res;
    }
    public static String getString(int begin,int end,String[] words,int target,int maxWidth){
        String res = "";
        if (end-begin==1){
            res = words[begin];
            for (int i=0;i<target+1;i++){
                res = res + " ";
            }
        }else if (end-begin==2){
            res = words[begin];
            for (int i=0;i<target+2;i++){
                res = res + " ";
            }
            res = res+words[begin+1];
        }else {
            int num = end - begin - 1;
            int average = (target + end - begin) / num;
            int more = (target + end - begin) % num;
            int i=begin;
            while (res.length()<maxWidth) {
                res = res + words[i];
                if (res.length()>=maxWidth){
                    break;
                }
                for (int j = 0; j < average; j++) {
                    res = res + " ";
                }
                if (more > 0) {
                    res = res + " ";
                    more--;
                }
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] test1 = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        String[] test2 = new String[]{"What","must","be","acknowledgment","shall","be"};
        String[] test3 = new String[]{"Science","is","what","we","understand","well","enough","to","explain", "to","a","computer.","Art","is","everything","else","we","do"};
        String[] test4 = new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};

//        System.out.println(fullJustify(test1,16));
//        System.out.println(fullJustify(test2,16));
        System.out.println(fullJustify(test4,16));
    }
//    ["ask   not   what","your country can","do  for  you ask","what  you can do","for your country "]
//    ["ask   not   what","your country can","do  for  you ask","what  you can do","for your country"]
}
