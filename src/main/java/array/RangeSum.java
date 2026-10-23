package array;
/**
 * 求任意一段数组区间的和将其返回（前缀和）
 */
public class RangeSum {
    public static long prefixSum(int[] nums, int start, int end) {
        long[] arr = new long[nums.length];
        arr[0] = nums[0];
        for(int i = 1; i < arr.length; i++){
            arr[i] = nums[i] + arr[i - 1];
        }
        if(start!=0){
            return arr[end] - arr[start - 1];
        }
        return arr[end];
    }
    public static void main(String[] args) {
        int start = 0;
        int end = 3;
        int[] arr = new int[]{1,2,3,4,9,8,7,1,6};
        long prefixScore = prefixSum(arr, start, end);
        System.out.println(prefixScore);//1+2+3+4=10
    }
}
