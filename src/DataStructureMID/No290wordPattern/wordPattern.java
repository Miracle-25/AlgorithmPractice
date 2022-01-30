package DataStructureMID.No290wordPattern;

//        给定一种规律 pattern和一个字符串str，判断 str 是否遵循相同的规律。
//        这里的遵循指完全匹配，例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应规律。
//
//        示例1:
//        输入: pattern = "abba", str = "dog cat cat dog"
//        输出: true
//
//        示例 2:
//        输入:pattern = "abba", str = "dog cat cat fish"
//        输出: false
//
//        示例 3:
//        输入: pattern = "aaaa", str = "dog cat cat dog"
//        输出: false
//
//        示例4:
//        输入: pattern = "abba", str = "dog dog dog dog"
//        输出: false
//        说明:
//        你可以假设pattern只包含小写字母，str包含了由单个空格分隔的小写字母。


import java.util.HashSet;
import java.util.Set;

public class wordPattern {
//    执行用时：1 ms, 在所有 Java 提交中击败了90.21%的用户
//    内存消耗：36.2 MB, 在所有 Java 提交中击败了64.98%的用户
    public static boolean wordPattern(String pattern, String s) {
        Set<Character> c=new HashSet<>();
        Set<String> str=new HashSet<>();
        String[] temp=s.split(" ");
        if (temp.length!=pattern.length()){
            return false;
        }
        int r=pattern.length()-1;
        int l=0;
        while (r>l){
            c.add(pattern.charAt(r));
            c.add(pattern.charAt(l));
            str.add(temp[r]);
            str.add(temp[l]);
            if ((pattern.charAt(r)==pattern.charAt(l))!=(temp[r].equals(temp[l]))){
                return false;
            }
            if ((pattern.charAt(r)==pattern.charAt(r-1))!=(temp[r].equals(temp[r-1]))){
                return false;
            }
            if ((pattern.charAt(l+1)==pattern.charAt(l))!=(temp[l+1].equals(temp[l]))){
                return false;
            }
            r--;
            l++;
        }
        return c.size()==str.size();
    }

    public static void main(String[] args) {
        String test1 = "abba";
        String test2 = "dog dog dog dog";
        System.out.println(wordPattern(test1,test2));
    }
}
