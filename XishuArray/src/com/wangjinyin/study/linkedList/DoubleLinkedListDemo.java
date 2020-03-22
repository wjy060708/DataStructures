package com.wangjinyin.study.linkedList;

/**
 * @author jinyin wang
 * @create 2020-03-22 12:30
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {

        //测试双链表
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        //添加测试
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();

        //修改测试
        HeroNode2 heroNode5 = new HeroNode2(4,"公送胜","入云龙");

        doubleLinkedList.update(heroNode5);
        doubleLinkedList.list();

        //测试删除
        doubleLinkedList.delete(heroNode5);
    }
}

class  DoubleLinkedList {
    //先创建一个头结点 不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头结点
    public HeroNode2 getHead() {
        return head;
    }

    //添加节点
    public void add(HeroNode2 node) {
        //当不考虑编号的顺序时，将节点加入链表尾部
        HeroNode2 temp = head;
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
        node.pre = temp;
    }

    /**
     * 修改节点的信息  双向链表的修改和单项链表是一样的
     */
    public void update(HeroNode2 newHearoNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;
        HeroNode2 temp = head;
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
    public void delete(HeroNode2 newHearoNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHearoNode.no) {
                flag = true;
                break;
            } else {
                temp = temp.next;
            }
        }

        if (flag == true) { //可以删除
          temp.next.pre = temp.next ;

          if (temp.next != null) {
              temp.next.pre = temp.pre;
          }
        } else {
            System.out.println("此链表没有对应的值");
        }
    }


    //显示链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;

        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }

    }
}

    class HeroNode2 {
        public int no;
        public String name;
        public String nickname;

        public HeroNode2 next; //指向下一个节点
        public HeroNode2 pre; //指向上一个节点

        //构造器
        public HeroNode2(int no, String name, String nickname) {
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

