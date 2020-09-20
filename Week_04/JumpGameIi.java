package leetcode.editor.cn;

//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 699 👎 0

public class JumpGameIi{
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int i = 0, count = 0;
        if (nums.length == 1) {
            return count;
        }
        while (i < nums.length) {
            if (i + nums[i] >= nums.length - 1) {
                return count + 1;
            }
            i = nextJump(nums, i + 1, i + nums[i]);
            count++;
        }
        return count;
    }
    private int nextJump(int[] nums, int start, int end) {
        int maxLen = 0, pos = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] + i - start >= maxLen) {
                pos = i;
                maxLen = nums[i] + i - start;
            }
        }
        return pos;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}