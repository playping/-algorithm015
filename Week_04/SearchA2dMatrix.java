package leetcode.editor.cn;

//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找 
// 👍 243 👎 0

public class SearchA2dMatrix{
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        int[][] m = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        solution.searchMatrix(m, 11);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int up = 0, down = matrix.length - 1;
        while (up < down) {
            int mid = up + (down - up) / 2;
            if (matrix[mid][0] == target || matrix[mid][matrix[0].length - 1] == target) {
                return true;
            }
            if (matrix[mid][0] < target
                    && matrix[mid][matrix[0].length - 1] > target) {
                up = mid;
                break;
            }
            if (matrix[mid][0] > target) {
                down = mid - 1;
            }
            else {
                up = mid + 1;
            }
        }
        int[] nums = matrix[up];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return nums[left] == target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}