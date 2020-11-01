package leetcode.editor.cn;

//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入："ab-cd"
//输出："dc-ba"
// 
//
// 示例 2： 
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 示例 3： 
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 100 
// 33 <= S[i].ASCIIcode <= 122 
// S 中不包含 \ or " 
// 
// Related Topics 字符串 
// 👍 66 👎 0

public class ReverseOnlyLetters{
    public static void main(String[] args) {
        Solution solution = new ReverseOnlyLetters().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseOnlyLetters(String S) {
        char[] ans = S.toCharArray();
        int i = 0, j = S.length() - 1;
        while (i < j) {
            char test = S.charAt(i) > 'Z' ? (char)(S.charAt(i) - 32) : S.charAt(i);
            if (test < 'A' || test > 'Z') {
                i++;
                continue;
            }
            test = S.charAt(j) > 'Z' ? (char)(S.charAt(j) - 32) : S.charAt(j);
            if (test < 'A' || test > 'Z') {
                j--;
                continue;
            }
            char temp = ans[i];
            ans[i] = ans[j];
            ans[j] = temp;
            i++;
            j--;

        }
        return String.valueOf(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}