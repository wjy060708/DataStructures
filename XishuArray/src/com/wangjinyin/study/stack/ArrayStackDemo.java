package com.wangjinyin.study.stack;

import java.util.Scanner;

/**
 * @author jinyin wang
 * @create 2020-03-22 15:45
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        //测试一下ArrayStack 是否正确
        //先创建一个ArrayStack对象->表示栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while(loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~~");
    }
}

class ArrayStack {
    private int maxSzie; //栈的大小

    private int[] stack;

    private int  top = -1; //栈顶

    //构造栈
    public ArrayStack(int maxSzie) {
        this.maxSzie = maxSzie;
        stack = new int[maxSzie];
    }

    //判断栈满
    public boolean isFull() {
      return top == maxSzie - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int no) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        stack[top ++ ] = no;
    }

    //入栈 将栈顶的数据返回
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈为空");
            throw  new RuntimeException("栈为空");
        }
        int value = stack[top];
        top --;
        return  value;
    }

    //显示栈
    public void list() {
        if (isEmpty()) {
            System.out.println("没有数据");
        }
        for (int i = top; i > 0; i --) {
            System.out.printf("%d", stack[i]);
        }
    }
}
