package com.wangjinyin.study.recursion;

/**
 * @author jinyin wang
 * @create 2020-03-30 20:11
 */
public class Queue8 {

    int max = 8;
    int[] array = new int[max];

    private static  int count = 0;

    public static void main(String[] args) {
        //测试
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(count);
    }

    //编写一个方法，放置第n个皇后
    private void check(int n) {
        if (n == 8) {
            print();
            count ++;
            return;
        }
        //依次放入皇后
        for (int i = 0; i < max; i++) {
            //先把当前皇后放在该行第一列
            array[n] = i;
            if (judge(n)) { //不冲突
                //接着放n+1个皇后
                check(n + 1);
            }
        }
    }

    //查看我们当前摆放的第n个皇后，就去检测该皇后与已经摆放的皇后是否冲突
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
              //array[i] == array[n] 当前的皇后与已经摆放的皇后在同一列
              //Math.abs(n-i) == Math.abs(array[n] -array[i]) 是否在同一斜线
             if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] -array[i])) {
                 return  false;
             }
        }
        return true;
    }

    //写一个方法，将皇后摆放的位置打印出来
    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
