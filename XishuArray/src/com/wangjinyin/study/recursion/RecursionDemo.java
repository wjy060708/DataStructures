package com.wangjinyin.study.recursion;

/**
 * @author jinyin wang
 * @create 2020-03-26 19:43
 * 递归的案例
 */
public class RecursionDemo {

    public static void main(String[] args) {
        test(5);
        System.out.println(orial(4));
    }

    //打印问题
    public static  void test(int n) {
       if (n > 2) {
           test(n - 1);
       }
        System.out.println(n);
    }
    //阶乘问题
    public static int orial(int i) {
        if (i == 1) {
            return 1;
        } else {
            return orial(i - 1) * i;
        }
    }
}
