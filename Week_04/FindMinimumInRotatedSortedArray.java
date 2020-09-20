package leetcode.editor.cn;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 你可以假设数组中不存在重复元素。 
//
// 示例 1: 
//
// 输入: [3,4,5,1,2]
//输出: 1 
//
// 示例 2: 
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0 
// Related Topics 数组 二分查找 
// 👍 257 👎 0

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray{
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int mid = (nums.length - 1) / 2;
        //方法一排序之后输出第一个
        //执行耗时:2 ms,击败了5.24% 的Java用户
        //内存消耗:38.8 MB,击败了10.78% 的Java用户
        Arrays.sort(nums);
        return nums[0];
    }
    private void secondone(int[] nums, int mid) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}