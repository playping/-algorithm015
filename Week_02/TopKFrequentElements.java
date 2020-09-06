package leetcode.editor.cn;

//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 447 👎 0

import java.util.*;

public class TopKFrequentElements{
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) {
            return nums;
        }
        PriorityQueue<Double> queue = new PriorityQueue<>();
        Arrays.sort(nums);
        int j = 0;
        int count = 0;
        int max = Math.abs(nums[0]) ;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                double d = Double.valueOf(count + "." + (nums[j] + max) + "1");
                queue.add(d);
                j = i;
                count = 0;
            }
            count++;
        }
        if (count > 0) {
            double d = Double.valueOf(count + "." + (nums[j] + max) + "1");
            queue.add(d);
        }
        int[] a = new int[k];
        double[] obj = new double[queue.size()];
        int p = 0;
        while (!queue.isEmpty()) {
            obj[p++] = queue.poll();
        }
        for (int i = obj.length - 1; i >= 0; i--) {
            if (obj.length - 1 - i >= k) {
                break;
            }
            String str = obj[i] + "";
            str = str.split("\\.")[1];
            str = str.substring(0,str.length() -1);
            a[obj.length - 1 - i] = Integer.valueOf(str) - max;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}