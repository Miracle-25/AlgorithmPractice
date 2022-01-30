package Practice.No347topKFrequent;
//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
//        示例 1:
//        输入: nums = [1,1,1,2,2,3], k = 2
//        输出: [1,2]

//        示例 2:
//        输入: nums = [1], k = 1
//        输出: [1]
import java.util.*;

public class topKFrequent {

//    执行用时：64 ms, 在所有 Java 提交中击败了5.18%的用户
//    内存消耗：40.4 MB, 在所有 Java 提交中击败了99.27%的用户
    public static int[] topKFrequent1(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer,Integer> record = new HashMap<Integer,Integer>();
        for (int i=0;i<nums.length;i++){
            if (record.containsKey(nums[i])){
                record.replace(nums[i], record.get(nums[i])+1 );
            }else {
                record.put(nums[i],1);
            }
        }
        int tempKey=0;
        for(int i=0;i<k;i++){
        int start = 0;
        for(int temp:record.keySet()){
            if (start<record.get(temp)){
                start = record.get(temp);
                tempKey = temp;
            }
        }
        res[i] = tempKey;
        record.remove(res[i]);
        }
        return res;
    }

//    执行用时：12 ms, 在所有 Java 提交中击败了92.62%的用户
//    内存消耗：41.3 MB, 在所有 Java 提交中击败了5.02%的用户
    public static int[] topKFrequent2(int[] nums, int k){
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

//    执行用时：13 ms, 在所有 Java 提交中击败了79.74%的用户
//    内存消耗：40.8 MB, 在所有 Java 提交中击败了84.90%的用户
    public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
    for (int num : nums) {
        occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
    }

    List<int[]> values = new ArrayList<int[]>();
    for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
        int num = entry.getKey(), count = entry.getValue();
        values.add(new int[]{num, count});
    }
    int[] ret = new int[k];
    qsort(values, 0, values.size() - 1, ret, 0, k);
    return ret;
}
    public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            qsort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("Hello world");
        System.out.println(topKFrequent1(new int[]{1, 1, 1, 2, 2, 3},2).toString());
    }
}
