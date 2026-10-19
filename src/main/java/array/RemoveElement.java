package array;

public class RemoveElement {
    /**
     * 暴力解法
     * @param nums 数组，数据的来源
     * @param val  要删除的值
     * @return
     */
    public static int removeElement1(int[] nums, int val){
        int size = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val){
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                // 因为元素整体向右移了一位，新移过来的元素需要检查
                i--;
                // 此时已经排除了一个元素，我们的数组长度就需要-1
                size--;
            }
        }
        // 返回去除重复元素后的，数组大小
        return size;
    }

    /**
     * 快慢指针的解法
     * @param nums 数组
     * @param val  要删除的值
     * @return
     */
    public static int removeElement2(int[] nums, int val){
        int slowIndex = 0;
        // 用i表示块指针，用于寻找目标元素
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            // 没找找到目标值
            if(nums[fastIndex] != val){
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    /**
     * 相向双指针法1
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement3(int[] nums, int val){
        // 定义双指针,指向数组的索引
        int left = 0;
        int right = nums.length - 1;
        // 先找到第一个不是val的位置
        while(right>=0 && nums[right] == val) right--;
        while(left <= right){
            if(nums[left] == val){
                nums[left] = nums[right];
                right--;
            }
            left++;
            while(right>=0 && nums[right] == val) right--;
        }
        return left;
    }
    /**
     * 相向双指针法2
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement4(int[] nums, int val){
        // 定义双指针,指向数组的索引
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            if(nums[left] == val){
                nums[left] = nums[right];
                right--;
            }else{
                left++;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,5,6,7,8,9,10};
        System.out.println("没去除的数组长度:" + nums.length);// 11
        //System.out.println("暴力法：去除后的数组长度:" + removeElement1(nums, 5));// 9，去除了5这两个元素
        //System.out.println("快慢指针：去除后的数组长度:" + removeElement2(nums, 5));// 9，去除了5这两个元素
        //System.out.println("双指针1：去除后的数组长度:" + removeElement2(nums, 5));// 9，去除了5这两个元素
        System.out.println("双指针2：去除后的数组长度:" + removeElement2(nums, 5));// 9，去除了5这两个元素

    }
}
