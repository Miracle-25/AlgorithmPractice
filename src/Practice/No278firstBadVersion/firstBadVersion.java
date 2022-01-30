package Practice.No278firstBadVersion;

//        你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
//        假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
//        你可以通过调用bool isBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
//
//        示例 1：
//        输入：n = 5, bad = 4
//        输出：4
//        解释：
//        调用 isBadVersion(3) -> false
//        调用 isBadVersion(5)-> true
//        调用 isBadVersion(4)-> true
//        所以，4 是第一个错误的版本。
//
//        示例 2：
//        输入：n = 1, bad = 1
//        输出：1


public class firstBadVersion extends VersionControl {
//    public int firstBadVersion(int n) {
//        return search(1,n);
//    }
//    public int search(int begin,int end){
//        int mid = (begin-end)/2+begin;
//        if (begin>=end-1){
//            return isBadVersion(begin)?begin:begin+1;
//        }
//        if (isBadVersion(mid)){
//            return search(begin,mid);
//        }else {
//            return search(mid,end);
//        }
//    }

//    执行用时：12 ms, 在所有 Java 提交中击败了39.69%的用户
//    内存消耗：35.2 MB, 在所有 Java 提交中击败了41.13%的用户
    public int firstBadVersion(int n){
        int begin = 1,end = n;
        while (begin<end){
            int mid = (end-begin)/2+begin;
            if (isBadVersion(mid)){
                end = mid;
            }else {
                begin = mid;
            }
        }
        return isBadVersion(begin)? begin:begin+1;
    }
}
