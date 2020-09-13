package leetcode.editor.cn;

//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 665 👎 0

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        int mid = 0;
        while(preorder[0] != inorder[mid++]) {}
//        System.out.println(mid);
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode left = buildTree(Arrays.copyOfRange(preorder, 1, mid),
                Arrays.copyOfRange(inorder,0, mid - 1));
        TreeNode right = buildTree(Arrays.copyOfRange(preorder, mid, preorder.length),
                Arrays.copyOfRange(inorder,mid, inorder.length));
        root.left = left;
        root.right = right;
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}