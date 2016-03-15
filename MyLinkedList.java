package list;

import java.io.IOException;
import java.util.Scanner;

/**
 * 单链表的插入删除排序操作
 * 
 * @author LV
 */
class Node {
	// 创建结点类
	Node next = null;
	int data = 0;

	public Node(int data) {
		this.data = data;
	}
}

public class MyLinkedList {
	/**
	 * @param args
	 */
	// 每个单链表list只含有head指针实例域
	private Node head = null;

	public MyLinkedList() {
	}

	/**
	 * 向单链表中插入数据
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
	 * 删除指定节点
	 * 
	 * @param index
	 *            ：删除第index个节点
	 * @return 成功为true，失败为false
	 */
	public boolean deleteNode(int index) {
		Node temp = head;
		// index越界，则删除失败
		if (index < 1 || index > length()) {
			return false;
		}
		// 删除链表第一个节点
		if (index == 1) {
			head = head.next;
			return true;
		}
		/*
		 * 此段代码出错，原因仍在分析中 else { while (temp.next != null) { int i = 1; while (i
		 * < index) { temp = temp.next; i++; } } Node tmp=temp.next.next;
		 * temp.next = tmp; return true; }
		 */
		int i = 1;
		Node preNode = head;
		Node curNode = preNode.next;
		while (curNode != null) {
			if (i == index - 1) {
				// 实现节点的删除操作
				preNode.next = curNode.next;
				return true;
			}
			preNode = curNode;
			curNode = curNode.next;
			i++;
		}
		return true;
	}

	/**
	 * 计算链表的长度
	 * 
	 * @return返回节点长度
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
	 * 对链表进行排序
	 * 
	 * @return返回排序后的头结点
	 */
	public Node orderList() {
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return head;
		}
		Node nextNode = null;
		Node curNode = null;
		int temp = 0;
		curNode = head;
		while (curNode.next != null) {
			nextNode = curNode.next;
			while (nextNode != null) {
				if (curNode.data > nextNode.data) {
					temp = curNode.data;
					curNode.data = nextNode.data;
					nextNode.data = temp;
				}
				nextNode = nextNode.next;
			}
			curNode = curNode.next;
		}
		return head;
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
		MyLinkedList list = new MyLinkedList();
		try {
			Scanner in1 = new Scanner(System.in);
			Scanner in2 = new Scanner(System.in);
			System.out.println("请输入要插入链表的元素个数:");
			int th = Integer.parseInt(in1.next());
			System.out.println("请输入要插入链表的Int型元素:");
			int[] numberInt = new int[th];
			int i = 0;
			String numberInput = in2.nextLine();
			String[] number = new String[th];
			number = numberInput.split(",");
			for (int j = 0; j < number.length; j++) {
				numberInt[j] = Integer.parseInt(number[j]);
			}
			for (; i < numberInt.length; i++) {
				list.addNode(numberInt[i]);
			}
			System.out.println("The new constructed list is:");
			list.printList();
			System.out.println("\nThe length of the list is:" + list.length());
			System.out.println("请输入要删除的元素的位数:");
			list.deleteNode(new Scanner(System.in).nextInt());
			System.out.println("The list deleted is:");
			list.printList();
			list.orderList();
			System.out.println("\nThe list ordered is:");
			list.printList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
