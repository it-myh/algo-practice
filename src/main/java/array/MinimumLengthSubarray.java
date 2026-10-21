package array;

/**
 * 找到数组中连续的和sum >= target，而且长度要最短的
 */
public class MinimumLengthSubarray {
    /**
     * 暴力求法
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen1(int target, int[] nums) {
        long start = System.currentTimeMillis();
        // 记录最长的长度
        int lenMin = nums.length + 1;
        int sum;
        // i表示区间的开始，j表示的是区间的结束
        for (int i = 0; i < nums.length; i++) {
            // 用于与target比较
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum >= target){
                    int subLen = j - i + 1;
                    lenMin = (subLen) < lenMin ?  subLen: lenMin;
                    break;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return lenMin == (nums.length + 1) ? 0 : lenMin;
    }
    /**
     * 滑动窗口（双指针法）
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen2(int target, int[] nums) {
        // 记录开始的位置
        int i = 0;
        // 求和用，来比较target
        int sum = 0;
        // 记录最终最短的len
        int result = nums.length + 1;
        // j记录结束
        for(int j = 0; j < nums.length; j++){
            sum += nums[j];
            while(sum >= target){
                int subLen = j - i + 1;
                result = subLen < result ? subLen : result;
                sum -= nums[i++];
            }
        }
        return result == (nums.length + 1) ? 0 : result;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,2,4,3};
        int len1 = minSubArrayLen2(7, arr);
        int len2 = minSubArrayLen2(7, arr);
        System.out.println("暴力法" + len1);
        System.out.println("滑动窗口法" + len2);
    }
}
