package com.wangjinyin.study.linkedList;

/**
 * @author jinyin wang
 * @create 2020-03-18 21:38
 */

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //加入
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        // 测试一下单链表的反转功能
        System.out.println("原来链表的情况~~");

        System.out.println(singleLinkedList.count());
        singleLinkedList.list();


    }
}
/*定义一个管理链表的类*/
class SingleLinkedList {

    //先创建一个头结点 不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点
    public void add(HeroNode node) {
        //当不考虑编号的顺序时，将节点加入链表尾部
        HeroNode temp = head;
        //遍历链表
        while (true) {
            //找到链表的尾部
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            //如果没有找到将继续后移动
            temp = temp.next;
        }
        //当退出循环后则说明为链表最后
        temp.next = node;
    }

    public void addByOrder(HeroNode node) {
        //1.需要找到新添加节点的位置 通过辅助节点实现
        //2.新节点.next = temp.next
        //3.temp.next = 新节点
        HeroNode temp = head;
        boolean flag = false; //默认为false
        while (true) {
            if(temp.next == null) {
                break;
            }

            if(temp.next.no > node.no) { //位置找到了
                break;
            } else if(temp.next.no == node.no) { //说明编号已经存在
               flag = true;
               break;
            } else {
                temp = temp.next;
            }
        }
        //判断flag的值
        if (flag) { //不能添加，说明编号存在
            System.out.println("不能添加，编号已经存在");
        } else {
            //添加
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 修改节点的信息
     */
    public void update(HeroNode newHearoNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;
        HeroNode temp = head;
        while(true) {
            if (temp.next == null) {
               break;
            }
            if (temp.next.no == newHearoNode.no) {
                flag = true;
                break;
            } else {
                temp = temp.next;
            }
        }
        if (flag == true) {
            newHearoNode.next = temp.next;
            temp.next = newHearoNode;
        } else {
            System.out.println("此链表没有对应的值");
        }

    }

    /**
     * 删除节点
     */
    public void delete(HeroNode newHearoNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == newHearoNode.no) {
                flag = true;
                break;
            } else {
                temp = temp.next;
            }
        }

        if (flag == true) { //可以删除
            temp.next = temp.next.next;
        } else {
            System.out.println("此链表没有对应的值");
        }
    }

    //显示链表
    public void list() {
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;

        while(true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    public  HeroNode getHeroNode(HeroNode node, int index) {
        if (node.next == null) {
            System.out.println("此链表为空");
        }
        //获取链表的长度
        int size = 0;
        HeroNode temp = node;
        while (node.next != null) {
            size++;
            temp = temp.next;
        }

        //第二次遍历返回倒数第k个元素
        if (size < index || size <= 0) {
            System.out.println("此链表小于index");
            return null;
        } else {
            HeroNode temp2 = node.next;
            for (int i = 0; i < size - index; i++) {
                temp2 = temp2.next;
            }
            return temp2;
        }
    }

    //面试题 求单链表的个数
    public int count() {
        if (head.next == null) {
            return  0;
        }
        int count = 0;
        HeroNode temp = head;

        while(true) {
            if (temp.next != null) {
                count ++;
                temp = temp.next;
            } else {
                break;
            }
        }
        return  count;
    }

    //将单链表反转
    public  static  void revers(HeroNode head) {
        //如果当前链表为空或者只有一个节点 则无需反转
        if(head.next == null || head.next.next == null){
            System.out.println("当前链表无需反转 ");
            return;
        }

        //新创建一个链表
        HeroNode newHeroNode = new HeroNode(0, "", "");
        //定义一个变量来保存当前节点
        HeroNode current = head.next;
        //当前节点的下一个节点
        HeroNode next = null;
        while(current != null) {
            next = current.next; //需要暂时保存当前节点的下一个节点
            current.next = newHeroNode.next; //将新链表.next 指向当前链表.next
            newHeroNode.next = current;      //将当前节点插在新链表的头部.next
            current = next;                  //实现遍历
        }
        //将head.next 指向新的链表
        head.next = newHeroNode.next;

    }
}

//定义HeroNode ， 每个HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;

    public HeroNode next; //指向下一个节点
    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}
