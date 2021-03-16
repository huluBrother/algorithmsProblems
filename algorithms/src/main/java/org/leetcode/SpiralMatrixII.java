package org.leetcode;

import java.util.Arrays;

/**
 * @ProjectName: algorithmsJava
 * @Package: org.leetcode
 * @ClassName: SpiralMatrixII
 * @Author: zhanghx
 * @Description: 螺旋矩阵 II  https://leetcode-cn.com/problems/spiral-matrix-ii/
 * @Date: 2021/3/16 15:22
 * @Version: 1.0
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        SpiralMatrixII util = new SpiralMatrixII();
        int n = 2;
        final int[][] ints = util.generateMatrix(n);
        for(int i= 0;i<n;i++){
            System.out.println(Arrays.toString(ints[i]));
        }
    }


    /**
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     * 输入：n = 1
     * 输出：[[1]]
     */
    public int[][] generateMatrix(int n) {
        int spiralMatrix[][] = new int[n][n];//这里会把数组初始化为0
        int row = 0;//坐标的行
        int col = 0;//坐标的列
        int direction = 0;// 0-> 右 1->下 2-> 左 3->上
        for(int i=1;i<=n*n;i++){
            spiralMatrix[row][col] = i;
            if(direction == 0){//向右移动
                if((col+1) == n || spiralMatrix[row][col+1] != 0){
                    row = row + 1;
                    direction = 1;
                }else{
                    col = col + 1;
                }
            }else if(direction == 1){//向下移动
                if((row+1) == n || spiralMatrix[row+1][col] != 0){
                    col = col - 1;
                    direction = 2;
                }else{
                    row = row + 1;
                }
            }else if(direction == 2){//向左移动
                if((col-1) < 0 || spiralMatrix[row][col-1] != 0){
                    row = row - 1;
                    direction = 3;
                }else{
                    col = col - 1;
                }
            }else if(direction == 3){//向上移动
                if((row-1) < 0 || spiralMatrix[row-1][col] != 0){
                    col = col + 1;
                    direction = 0;
                }else{
                    row = row - 1;
                }
            }
        }


        return spiralMatrix;
    }
}
