package stackAndQueue;

import java.util.Scanner;

/**
 * @author LV 利用单链表实现栈结构
 */
// 创建结点类
class Node<T> {
	Node<T> next = null;
	T data = null;

	public Node(T data) {
		this.data = data;
	}
}

class Stack<T> {
	private Node<T> bottom = null;
	private Node<T> top = null;
	private Node<T> popNode = null;
	private Node<T> peekNode = null;

	public Node<T> getPopNode() {
		return popNode;
	}

	public Node<T> getPeekNode() {
		return peekNode;
	}

	public Stack() {
	}
	//判断栈是否为空
	public boolean isEmpty() {
		return top == null;
	}
	//执行压栈操作
	public void push(T data) {
		Node newNode = new Node(data);
		if (this.isEmpty()) {
			newNode.next = null;
			top = bottom = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}
	//执行出栈操作
	public T pop() {
		if (!this.isEmpty()) {
			popNode = top;
			top = top.next;
		} else if (top == bottom && top != null) {
			popNode = top;
		} else {
			System.out.println("Empty Stack");
		}
		return this.getPopNode().data;
	}
	//查询栈顶元素
	public T peek() {
		peekNode = top;
		return this.getPeekNode().data;
	}
	//打印栈
	public void printStack() {
		while (top != null) {
			System.out.println(top);
			top = top.next;
		}
	}
}

public class StackImplByList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		Scanner in = new Scanner(System.in);
		try {
			try {
				System.out.println("请输入压栈元素，并以逗号分隔");
				String numberInput = in.nextLine();
				String numbers[] = numberInput.split(",");
				for (int i = 0; i < numbers.length; i++) {
					stack.push(Integer.parseInt(numbers[i]));
				}
				System.out.println("栈中元素为:");
				stack.printStack();
				while (true) {
					System.out.println("\n是否执行出栈操作？ 请输入yes或no");
					String commond = in.nextLine();
					if (commond.equalsIgnoreCase("yes")) {
						System.out.println("弹出元素为： " + stack.pop());
					} else {
						break;
					}
				}
				System.out.println("栈是否为空？ " + stack.isEmpty());
				System.out.println("栈顶元素为： " + stack.peek());
			} finally {
				in.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
