package leetcode.editor.cn;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 392 👎 0

import java.util.ArrayList;
import java.util.List;

//回溯算法剪枝是效率的关键
public class Combinations{
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        combine(new ArrayList<>(), k, n, 1, list);
//        pickOrNo(new ArrayList<>(), k, 1, n, list);
        return list;
    }
    //执行耗时:47 ms,击败了11.90% 的Java用户
    private void pickOrNo(List<Integer> temp, int k, int cur, int n, List<List<Integer>> list) {
        if (cur > n + 1) {
            return;
        }
        if(temp.size() == k) {
            list.add(new ArrayList<>(temp));
            return;
        }
        temp.add(cur);
        pickOrNo(temp, k, cur + 1, n, list);
        temp.remove(temp.size() - 1);
        pickOrNo(temp, k, cur + 1, n, list);
    }
    // 执行耗时:2 ms,击败了97.44% 的Java用户
    private void pickOrNo2(List<Integer> temp, int k, int cur, int n, List<List<Integer>> list) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        if (cur > n + 1) {
            return;
        }
        if(temp.size() == k) {
            list.add(new ArrayList<>(temp));
            return;
        }
        temp.add(cur);
        pickOrNo(temp, k, cur + 1, n, list);
        temp.remove(temp.size() - 1);
        pickOrNo(temp, k, cur + 1, n, list);
    }
    //执行耗时:27 ms,击败了30.62% 的Java用户
    private void combine(List<Integer> temp, int k, int n, int start, List<List<Integer>> list) {
        if (temp.size() == k) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            combine(temp, k, n, i + 1, list);//i + 1,从下一个数开始添加
            temp.remove(temp.size() - 1);
        }
    }
    //执行耗时:2 ms,击败了97.44% 的Java用户 n - (k - path.size()) + 1
    private void combine2(List<Integer> temp, int k, int n, int start, List<List<Integer>> list) {
        if (temp.size() == k) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n - (k - temp.size()) + 1; i++) {
            temp.add(i);
            combine(temp, k, n, i + 1, list);//i + 1,从下一个数开始添加
            temp.remove(temp.size() - 1);
        }
    }
    //执行耗时:3 ms,击败了76.57% 的Java用户
    private void combine3(List<Integer> temp, int k, int n, int start, List<List<Integer>> list) {
        if (temp.size() + (n - start + 1) < k) {
            return;
        }
        if (temp.size() == k) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            combine(temp, k, n, i + 1, list);//i + 1,从下一个数开始添加
            temp.remove(temp.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}