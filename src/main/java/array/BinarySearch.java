package array;

import java.util.Arrays;

public class BinarySearch {
    /**
     * 第一种情况左闭右闭区间[ , ]
     */
    public static int search1(int[] nums, int target) {
        // 避免目标值不在数组中，就不用循环变量了
        if(target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        // 定义左右的边界
        int left=0, right=nums.length - 1;
        // 循环遍历找出是否有这个数,有就返回目标值
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] > target){
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }else{
                return nums[mid];
            }
        }
        // 没有返回-1
        return -1;
    }

    /**
     * 第二种情况左闭右开区间[ , )
     */
    public static int search2(int[] nums, int target){
        // 避免目标值不在数组中，就不用循环变量了
        if(target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        // 定义左右的边界
        int left=0, right=nums.length;
        // 循环遍历找出是否有这个数,有就返回目标值
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] > target){
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }else{
                return nums[mid];
            }
        }
        // 没有返回-1
        return -1;
    }
    public static void main(String[] args) {
        // 目标值
        int target = 5;
        // 定义一个数组，一定是有序数组，可以使用Arrays.sort(数组名)，来排序。
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(nums));
        System.out.println("方法一：" + search1(nums, target));
        System.out.println("方法二：" + search2(nums, target));
    }
}
