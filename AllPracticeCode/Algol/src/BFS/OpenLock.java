package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7',
 * '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的
 * 一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 */
public class OpenLock {
    private static int openLock(String[] deadends, String target) {
        //定义数组，其中的元素表示向大调整还是向小调整
        int[] p = {-1, 1};

        //将死亡数组中的元素放入Set中方便后序查找
        Set<String> wordDict = new HashSet<>();
        for (String s : deadends) {
            wordDict.add(s);
        }

        //定义队列将需要调整的元素放入
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        //用来记录遍历的元素是否重复
        Set<String> book = new HashSet<>();
        book.add("0000");

        //记录所需要的次数
        int len = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curStr = queue.poll();
                //如果队列中初始的元素就在死亡数组中就直接返回-1；
                if (wordDict.contains(curStr))
                    return -1;
                //遍历每一个密码位进行调整
                for (int i = 0; i < 4; i++) {
                    //每次密码位只能进行两种调整向大或者向小
                    for (int j = 0; j < 2; j++) {
                        char[] tmp = curStr.toCharArray();
                        //如果调整位的字符是‘0‘并且向下调整的话结果为负会超过数字字符的范围，进行判断为'0'就
                        // 调整为'9'，其余对10取模
                        tmp[i] = (char) (((tmp[i] - '0' + p[j]) < 0 ? 9 : (tmp[i] - '0' + p[j]) % 10) + '0');
                        String newTar = new String(tmp);
                        //如果之前已经在队列添加过或者再死亡数组中的新字符串就不在进行后面的操作，直接进入循环跳过
                        if (book.contains(newTar) || wordDict.contains(newTar))
                            continue;
                        if (newTar.equals(target))
                            return len + 1;
                        queue.add(newTar);
                        book.add(newTar);
                    }
                }
            }
            len++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] s = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        int result = openLock(s, target);
        System.out.println(result);
    }
}
