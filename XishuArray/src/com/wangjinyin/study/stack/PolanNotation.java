package com.wangjinyin.study.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jinyin wang
 * @create 2020-03-24 20:07
 * 逆波兰表达式
 */
public class PolanNotation {
    public static void main(String[] args) {
        //先定义一个逆波兰表达式 (3+4)*5-6      3 4 + 5 * 6 -
        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList" + rpnList);
        System.out.println(calculate(rpnList));
    }

    //将一个逆波兰表达式，依次将数据和运算 放入到Arraylist中
    public static List<String> getListString(String suffixExpression) {
        List<String> list = new ArrayList<String>();
        String[] split = suffixExpression.split(" ");
        for (String ele : split) {
          list.add(ele);
        }
        return list;
    }
    //完成对逆波兰表达式的运算
    public static int calculate(List<String>  ls) {
      //创建一个栈
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            //这里使用正则表达式来取出数
            if (item.matches("\\d+")) {
                //入栈
                stack.push(item);
            } else {
                //pop出两个数 并运算 再入栈
                 int num = Integer.parseInt(stack.pop());
                 int num2 = Integer.parseInt(stack.pop());
                 int res = 0;
                 if (item.equals("+")) {
                     res = num + num2;
                 } else if(item.equals("-")){
                     res = num - num2;
                 } else if(item.equals("*")){
                     res = num * num2;
                 } else if (item.equals("/")){
                     res = num / num2;
                 } else  {
                     throw  new RuntimeException("运算符有误");
                 }
                 //把res入栈
                stack.push(res+"");
            }
         }
        return Integer.parseInt(stack.pop());
    }
}
