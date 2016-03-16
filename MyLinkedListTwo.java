package list;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 在上次实现单链表的插入删除排序操作之后，继续实现单链表的删除重复数据，找出单链表倒数第k个元素，实现单链表反转，逆序输出单链表
 * 查找单链表中间结点，检测单链表是否有环
 * 
 * @author LV
 */
// 创建结点类
class Node {
	Node next = null;
	int data = 0;

	public Node(int data) {
		this.data = data;
	}
}

public class MyLinkedListTwo {
	/**
	 * @param args
	 */
	// 每个单链表list只含有head指针实例域
	private Node head = null;
	private ArrayList<Integer> duplicateData = new ArrayList<Integer>();
	private Node tmp;

	public MyLinkedListTwo() {
	}

	/**
	 * 向单链表中插入数据以构建单链表
	 * 
	 * @param data
	 *            ：插入数据的内容
	 */
	public void addNode(int data) {
		Node newNode = new Node(data);
		// 如果链表为空，新节点即为头结点
		if (head == null) {
			head = newNode;
			// 注意此处return不可少，否则程序流会继续执行出错
			return;
		}
		Node temp = head;
		// 寻找到最后一个结点
		while (temp.next != null) {
			temp = temp.next;
		}
		// 在链表尾插入新节点
		temp.next = newNode;
	}

	/**
	 * 删除单链表中重复的数据
	 */
	public ArrayList<Integer> deleteDuplicate() {
		Node node = head;
		Node pre = null;
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		while (node != null) {
			if (table.containsKey(node.data)) {
				duplicateData.add(node.data);
				pre.next = node.next;
			} else {
				table.put(node.data, 1);
				pre = node;
			}
			node = node.next;
		}
		return duplicateData;
	}

	/**
	 * 找出倒数第k个数据
	 * 
	 * @return 返回该数据的值
	 */
	public int findData(int k) {
		Node first = head;
		Node second = head;
		if (k < 1 || k > this.length()) {
			System.out.println("wrong index");
		}
		for (int i = 0; i < k; i++) {
			first = first.next;
		}
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		tmp = second;
		return tmp.data;
	}

	/**
	 * 实现单链表反转
	 * 
	 * @return 返回反转后单链表的头结点
	 */
	public void reverseList() {
		Node pre = null;
		Node reverseHead = head;
		Node cur = head;
		Node further = null;
		while (cur != null) {
			if (cur.next == null) {
				reverseHead = cur;
			}
			further = cur.next;
			cur.next = pre;
			pre = cur;
			cur = further;
		}
		this.head = reverseHead;
	}

	/**
	 * 逆序输出单链表 利用递归方法实现
	 */
	public void reversePrintList(Node node) {
		if (node != null) {
			reversePrintList(node.next);
			System.out.print(node.data);
		}
	}

	/**
	 * 查找单链表中间结点
	 */
	public int findMiddle() {
		Node first = head;
		Node second = head;
		while (first != null && first.next != null && first.next.next != null) {
			first = first.next.next;
			second = second.next;
		}
		return second.data;
	}

	/**
	 * 检测单链表是否有环
	 */
	public boolean isContainsRound() {
		Node first = head;
		Node second = head;
		while (first.next != null) {
			first = first.next.next;
			second = second.next;
			if (first == second) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取链表的长度
	 * 
	 * @return 链表长度
	 */
	public int length() {
		int num = 0;
		Node temp = head;
		if (head == null) {
			num = 0;
		}
		while (temp != null) {
			temp = temp.next;
			num++;
		}
		return num;
	}

	/**
	 * 打印链表
	 */
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			MyLinkedListTwo list = new MyLinkedListTwo();
			Scanner in = new Scanner(System.in);
			try {
				System.out.println("请输入要插入的元素：");
				String numbers = in.nextLine();
				String numberInput[] = numbers.split(",");
				for (int i = 0; i < numberInput.length; i++) {
					list.addNode(Integer.parseInt(numberInput[i]));
				}
				System.out.println("构建好的单链表为：");
				list.printList();
				System.out.println("\n单链表的长度为： " + list.length());
				System.out.println("删除的重复元素为：");
				list.duplicateData = list.deleteDuplicate();
				Iterator it = list.duplicateData.iterator();
				while (it.hasNext()) {
					System.out.print(it.next());
				}
				System.out.println("\n删除重复元素后的单链表为：");
				list.printList();
				System.out.println("\n请输入要查找的倒数第几位数的索引");
				int index = in.nextInt();
				System.out.println(list.findData(index));
				System.out.println("实现反转后的单链表为：");
				list.reverseList();
				list.printList();
				System.out.println("\n利用递归逆序输出单链表为：");
				list.reversePrintList(list.head);
				System.out.println("\n单链表的中间结点为：");
				System.out.println(list.findMiddle());
				System.out.println("单链表是否包含环？ " + list.isContainsRound());
			} finally {
				in.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
