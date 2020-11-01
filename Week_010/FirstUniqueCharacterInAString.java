package leetcode.editor.cn;

//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 281 👎 0

public class FirstUniqueCharacterInAString{
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        boolean[] used = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (used[i]) {
                continue;
            }
            if (s.lastIndexOf(s.charAt(i)) == i) {
                return i;
            }
            if (s.lastIndexOf(s.charAt(i)) != -1) {
                used[s.lastIndexOf(s.charAt(i))] = true;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}