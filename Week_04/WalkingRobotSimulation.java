package leetcode.editor.cn;

//机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令： 
//
// 
// -2：向左转 90 度 
// -1：向右转 90 度 
// 1 <= x <= 9：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物。 
//
// 第 i 个障碍物位于网格点 (obstacles[i][0], obstacles[i][1]) 
//
// 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。 
//
// 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。 
//
// 
//
// 示例 1： 
//
// 输入: commands = [4,-1,3], obstacles = []
//输出: 25
//解释: 机器人将会到达 (3, 4)
// 
//
// 示例 2： 
//
// 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出: 65
//解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
// 
//
// 
//
// 提示： 
//
// 
// 0 <= commands.length <= 10000 
// 0 <= obstacles.length <= 10000 
// -30000 <= obstacle[i][0] <= 30000 
// -30000 <= obstacle[i][1] <= 30000 
// 答案保证小于 2 ^ 31 
// 
// Related Topics 贪心算法 
// 👍 110 👎 0

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation{
    public static void main(String[] args) {
        Solution solution = new WalkingRobotSimulation().new Solution();
//        solution.robotSim(new int[]{-2,8,3,7,-1},
//                new int[][]{{-4,-1},{1,-1},{1,4},{5,0},{4,5},{-2,-1},{2,-5},{5,1},{-3,-1},{5,-3}});
        solution.robotSim(new int[]{4,-1,4,-2,4},new int[][]{{2,4}});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        int dir = 0, max = 0;//0
        int[][] area = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        Set<String> set = new HashSet<>();
        for (int[] ob : obstacles) {
            set.add(ob[0] + "," + ob[1]);
        }
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                dir = (dir + 1) % 4;
                continue;
            }
            if (commands[i] == -2) {
                dir = (dir + 3) % 4;
                continue;
            }
            for (int k = 0; k < commands[i]; k++) {
                x += area[dir][0];
                y += area[dir][1];
                if (set.contains(x + "," + y)) {
                    x -= area[dir][0];
                    y -= area[dir][1];
                    break;
                }
                max = Math.max(x * x + y * y, max);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}