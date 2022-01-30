package Practice.No528RandomChoosebyWeight;

//给定一个正整数数组w ，其中w[i]代表下标i的权重（下标从0开始），请写一个函数pickIndex，它可以随机地获取下标i，选取下标i的概率与w[i]成正比。
//例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3)= 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3)= 0.75（即，75%）。
//也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
//
//示例 1：
//输入：
//["Solution","pickIndex"]
//[[[1]],[]]
//输出：
//[null,0]
//解释：
//Solution solution = new Solution([1]);
//solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。
//
//示例 2：
//输入：
//["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
//[[[1,3]],[],[],[],[],[]]
//输出：
//[null,1,1,1,1,0]
//解释：
//Solution solution = new Solution([1, 3]);
//solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
//
//由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
//[null,1,1,1,1,0]
//[null,1,1,1,1,1]
//[null,1,1,1,0,0]
//[null,1,1,1,0,1]
//[null,1,0,1,0,0]
//......
//诸若此类。


public class ChoosebyWeight {
    int[] pre;
    int total;

//    执行用时：96 ms, 在所有 Java 提交中击败了11.43%的用户
//    内存消耗：43.5 MB, 在所有 Java 提交中击败了26.15%的用户
    public ChoosebyWeight(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        total = w[0];
        for (int i=1;i<w.length;++i){
            pre[i]=pre[i-1]+w[i];
            total=total+w[i];
        }
    }
    public int pickIndex() {
        int ran = (int)(Math.random()*total)+1;
            return search(ran);
    }
    public int search(int x){
        for (int i=0;i< pre.length;i++){
            if (x < pre[i]){
                return i;
            }
        }
        return 0;
    }

}


