package array;
import java.util.Scanner;
/**
 * 螺旋矩阵
 */
public class SpiralMatrixII {
    public static int[][] generateMatrix(int n){
        int[][] arr = new int[n][n];
        int num = 1;
        int x = 0,  y = 0;// 表示每次的转圈的起点
        int loop = 1;//控制循环的次数，默认转一圈
        int offset = 1;// 包右不包左，控制最大索引然后减去偏移的量
        int i, j;//表示行和列
        while(loop <= (n / 2)){
            // 向右
            for(j = y; j < n - offset; j++){
                arr[x][j] = num++;
            }
            // 向下
            for(i = x; i < n - offset; i++){
                arr[i][j] = num++;
            }
            // 向左
            for(; j > y; j--){
                arr[i][j] = num++;
            }
            // 向下
            for(; i > x; i--){
                arr[i][j] = num++;
            }
            // 更新起点位置，偏移量，循环次数
            x++;
            y++;
            offset++;
            loop++;
        }
        // 当矩形的边为奇数时，中间位置的数字为零，需要手动添加
        if(n % 2 != 0){
            arr[x][y] = num;// 也是下一个的起点，不过一圈只有一个元素，所以直接复制即可
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你的数字n：");
        int n = sc.nextInt();
        int[][] arr = generateMatrix(n);
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
