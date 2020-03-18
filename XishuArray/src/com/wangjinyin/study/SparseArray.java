package com.wangjinyin.study;

/**
 * @author jinyin wang
 * @create 2020-03-17 20:26
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二位数组11*11
        //1 表示黑子 2 表示蓝子
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;

        //输出原始的二维数组
        System.out.println("原始的二维数组");
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组转化为 稀疏数组
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    sum ++;
                }
            }
        }
        System.out.println(sum);

        //创建对应的稀疏二维数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历二维数组 将非0的存进稀疏数组中
        //count用于记录第几个非0数
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    count ++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArray[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println("输出稀疏数组");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将稀疏数组->原始数组
        //1.先读取稀疏数组的第一行 创建新数组
        int len = sparseArr[0][0];
        int high = sparseArr[0][1];
        int sum2 = sparseArr[0][2];
        int chessArr2[][] = new int[len][high];

        //2.读取稀疏数组的其他值 赋值给原始数组
        for (int i = 1; i < sparseArr.length ; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //打印还原后的数组
        System.out.println("打印还原后的数组");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
