package leetcode.editor.cn;

//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法 
// 👍 396 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> list = new ArrayList<>();
        unique(new ArrayList<>(), nums, list, used);
        return list;
    }
    //排列：位置不同也是一个新的排列
    private void unique(List<Integer> temp, int[] nums, List<List<Integer>> list, boolean[] used) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            used[i] = true;
            unique(temp, nums, list, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
     }
}
//leetcode submit region end(Prohibit modification and deletion)

}