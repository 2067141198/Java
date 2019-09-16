import java.util.*;

public class ThreeNum {
    //时间复杂度达到了O(N^3)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //想将数组变成有序数组
        Arrays.sort(nums);
        //外层循环让第一个指针从数组中的第一个元素开始遍历
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 1 && nums[i] == nums[i -1]) {
                continue;
            }
            //第二个指针从i的后一位开始
            int j = i + 1;
            //第三个指针从数组中最后一个元素开始
            int k = nums.length - 1;
            //如果两个指针不相遇就让循环继续下去
            while(j < k) {
                //if(nums[j] == nums[j -1] || nums[k] == nums[k - 1]) continue;
                //先得出三个指针指向的元素之和
                int sum = nums[i] + nums[j] + nums[k];
                //如果和为0满足题意就将这三个位置处的元素加入到inList中，再判断list中是否有与inList相等的顺序表，如果没有就添加
                //如果小于0说明第二个指针位置处的元素过小，将第二个指针向右移动
                //如果大于0说明第三个指针位置处的元素过大，将第三个指针向左移动
                if(sum == 0) {
                    List<Integer> inList = new ArrayList<>();
                    inList.add(nums[i]);
                    inList.add(nums[j]);
                    inList.add(nums[k]);
                    if(!list.contains(inList)) {
                        list.add(inList);
                    }
                    j++; k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return list;
    }
}
