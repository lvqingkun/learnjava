package list;

import java.io.IOException;
import java.util.Scanner;

/**
 * ������Ĳ���ɾ���������
 * 
 * @author LV
 */
class Node {
	// ���������
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
	// ÿ��������listֻ����headָ��ʵ����
	private Node head = null;

	public MyLinkedList() {
	}

	/**
	 * �������в�������
	 * 
	 * @param data
	 *            ���������ݵ�����
	 */
	public void addNode(int data) {
		Node newNode = new Node(data);
		// �������Ϊ�գ��½ڵ㼴Ϊͷ���
		if (head == null) {
			head = newNode;
			// ע��˴�return�����٣���������������ִ�г���
			return;
		}
		Node temp = head;
		// Ѱ�ҵ����һ�����
		while (temp.next != null) {
			temp = temp.next;
		}
		// ������β�����½ڵ�
		temp.next = newNode;
	}

	/**
	 * ɾ��ָ���ڵ�
	 * 
	 * @param index
	 *            ��ɾ����index���ڵ�
	 * @return �ɹ�Ϊtrue��ʧ��Ϊfalse
	 */
	public boolean deleteNode(int index) {
		Node temp = head;
		// indexԽ�磬��ɾ��ʧ��
		if (index < 1 || index > length()) {
			return false;
		}
		// ɾ�������һ���ڵ�
		if (index == 1) {
			head = head.next;
			return true;
		}
		/*
		 * �˶δ������ԭ�����ڷ����� else { while (temp.next != null) { int i = 1; while (i
		 * < index) { temp = temp.next; i++; } } Node tmp=temp.next.next;
		 * temp.next = tmp; return true; }
		 */
		int i = 1;
		Node preNode = head;
		Node curNode = preNode.next;
		while (curNode != null) {
			if (i == index - 1) {
				// ʵ�ֽڵ��ɾ������
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
	 * ��������ĳ���
	 * 
	 * @return���ؽڵ㳤��
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
	 * �������������
	 * 
	 * @return����������ͷ���
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
	 * ��ӡ����
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
			System.out.println("������Ҫ���������Ԫ�ظ���:");
			int th = Integer.parseInt(in1.next());
			System.out.println("������Ҫ���������Int��Ԫ��:");
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
			System.out.println("������Ҫɾ����Ԫ�ص�λ��:");
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
