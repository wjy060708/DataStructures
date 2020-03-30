package com.wangjinyin.study.recursion;
/**
 * @author jinyin wang
 * @create 2020-03-26 20:04
 * 递归解决迷宫问题
 */
public class MiGong {

    public static void main(String[] args) {
        //创建二维数组 代表迷宫
        int[][] map = new int[8][7];
        //1.表示强
        for (int i = 0;i < 7; i ++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0;i < 8; i ++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println(setWay(map, 1 ,1));
        for (int i = 0; i < 8 ; i++) {
            for (int j = 0; j < 7; j ++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //使用递归来解决迷宫问题

    /**
     *
     * @param map 迷宫
     * @param i   i j表示从哪个位置开始的
     * @param j  起点map[1][1] -> 终点map[6][5]
     * @return
     * map[i][j] == 0表示该点没有走过  map[i][j] == 2 表示通路可以走 map[i][j] = 2表示该点没有走过，但不通
     * 先走 下->右->上->左
     */
    public static  boolean setWay(int[][] map, int i, int j) {
        //表明已经找到通路了
        if (map[6][5] == 2) {
           return  true;
        } else {
            if (map[i][j] == 0) { //如果当前节点没有走过
                //按照策略走
                map[i][j] = 2; //假定可以走通
                if (setWay(map, i + 1, j)) { //向下走
                    return true;
                } else if (setWay(map, i, j + 1)) { //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) { //向上走
                    return true;
                } else if (setWay(map, i, j - 1)){  //向左走
                    return true;
                } else {
                    //说明该点是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else { //如果map[i][j] != 0 可能1,2,3
               return false;
            }
        }
    }
}
