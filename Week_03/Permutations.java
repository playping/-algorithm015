package leetcode.editor.cn;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 882 👎 0

import java.util.ArrayList;
import java.util.List;

public class Permutations{
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        solution.permute(new int[]{1,2,3});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //执行耗时:425 ms,击败了5.42% 的Java用户
//        permute(0, nums, list, new ArrayList<>());
        //执行耗时:3 ms,击败了46.33% 的Java用户
        permute2(new ArrayList<>(), nums, list);
        return list;
    }
    //方法二：回溯 执行耗时:3 ms,击败了46.33% 的Java用户
    private void permute2(List<Integer> temp, int[] nums, List<List<Integer>> list) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //剃除重复
            if (temp.contains(Integer.valueOf(nums[i]))) {
                continue;
            }
            temp.add(nums[i]);
            permute2(temp, nums, list);
            temp.remove(temp.size() - 1);//回溯
        }
    }
    //方法一：递归 执行耗时:425 ms,击败了5.42% 的Java用户
    private void permute(int level, int[] nums, List<List<Integer>> list, List<Integer> temp) {
        if (level > nums.length) {
            return;
        }
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int n : nums) {
            if (temp.contains(Integer.valueOf(n))) {//剃除重复
                continue;
            }
            temp.add(n);
            permute(level + 1, nums, list, temp);//当前位置：选择
            temp.remove(temp.size() - 1);
            permute(level + 1, nums, list, temp);//当前位置：不选择
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}