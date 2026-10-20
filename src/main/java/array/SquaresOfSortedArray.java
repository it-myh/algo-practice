package array;
import java.util.Arrays;
public class SquaresOfSortedArray {
    // 双指针法(推荐)
    public static int[] sortedSquares1(int[] nums){
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        for(int start = 0, end = nums.length - 1; start <= end;){
            if(nums[start] * nums[start] >= nums[end] * nums[end]){
                result[index--] = nums[start] * nums[start];
                start++;
            }else{
                result[index--] = nums[end] * nums[end];
                end--;
            }
        }
        return result;
    }
    // 暴力排序法
    public static int[] sortedSquares2(int[] nums){
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{-5,1,2,3,4};
        int[] newArr = sortedSquares2(arr);
        System.out.println(Arrays.toString(newArr));
    }
}
