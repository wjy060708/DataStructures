package com.wangjinyin.study.arrayQueue;

import java.awt.geom.QuadCurve2D;
import java.util.Scanner;

/**
 * @author jinyin wang
 * @create 2020-03-18 19:40
 * 使用数组模拟队列
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //输出一个菜单
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~");
    }
}

class ArrayQueue {

    private  int maxSize; //队列的大小

    private int front;  //对头指针

    private int rear;  //对位指针

    private int[] arr; //用于存放数据

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; //指向队列的头部 执行队列头部的前一个位置
        rear = -1;  //指向队列的尾部 ，队列的最后一个数据
    }

    //判断队列是否满
    public boolean isFull() {
        return  rear == maxSize - 1;
    }

    //判断对垒是否为空
    public boolean isNull() {
        return  front == rear;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (!isFull()) {
            rear ++;
            arr[rear] = n;
        } else {
            System.out.println("队列已满");
        }
    }

    //出队列
    public int getQueue() {
        if (!isNull()) {
            front ++;
            return  arr[front];
        } else {
            throw new RuntimeException("队列为空，不能去数据");
        }
    }

    //显示队列的所有内容
    public void showQueue() {
        if (!isNull()) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        } else {
            throw new RuntimeException("队列为空，不能去数据");
        }
    }

    //显示队列的头部数据
    public int headQueue() {
        if (!isNull()) {
            return  arr[front + 1];
        } else {
            throw new RuntimeException("队列为空，不能去数据");
        }
    }
}
