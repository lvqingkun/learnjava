package stackAndQueue;

import java.util.Scanner;

/**
 * @author LV 用单链表实现队列
 */
class Node<T> {
	Node<T> next = null;
	T data = null;

	public Node(T data) {
		this.data = data;
	}
}

class Queue<T> {
	Node<T> head = null;
	Node<T> tail = null;

	public void put(T data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = tail = newNode;
			newNode.next = null;
		} else {
			tail.next = newNode;
			newNode.next = null;
			tail = tail.next;
		}
	}

	public T pop() {
		Node<T> e = null;
		if (isEmpty()) {
			System.out.println("The Queue is Empty");
			return null;
		} else {
			e = head;
			head = head.next;
		}
		return e.data;
	}

	public boolean isEmpty() {
		return tail == head && head == null;
	}

	public void printQueue() {
		Node<T> tmp = head;
		while (tmp != null) {
			System.out.print(head.data);
			tmp = tmp.next;
		}
	}

	public T peek() {
		return head.data;
	}
}

public class QueueImplByList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner in = new Scanner(System.in);
			try {
				Queue<Integer> queue = new Queue<Integer>();
				System.out.println("请输入要插入队列的数组，以空格间隔");
				String input = in.nextLine();
				int lenth = input.trim().length();
				String[] numbers = new String[lenth];
				numbers=input.split(",");
				for (int i = 0; i < lenth; i++) {
					queue.put(Integer.parseInt(numbers[i]));
				}
				while (true) {
					System.out.println("是否弹出队列元素？请选择yes或no");
					String commond = in.nextLine();
					if (commond.equalsIgnoreCase("yes")) {
						queue.pop();
						queue.printQueue();
					} else {
						break;
					}
				}
				System.out.println("最终队列为：");
				queue.printQueue();
			} finally {
				in.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
