/**
 * 
 */
package stackAndQueue;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author LV 利用数组实现栈结构
 */
class Stack<T> {
	ArrayList<Object> array = new ArrayList<Object>();
	T e = null;
	int size = 0;

	// 判断栈是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	// 对栈执行压栈操作
	public void push(T e) {
		array.add(size, e);
		size++;
	}

	// 对栈执行出栈操作
	public T pop() {
		if (!isEmpty()) {
			e = (T) array.get(--size);
			return e;
		} else
			return null;
	}

	// 查询栈顶元素
	public T peek() {
		if (!isEmpty()) {
			return (T) array.get(--size);
		} else {
			System.out.println("Empty Stack");
			return null;
		}
	}

	// 输出栈中所有元素
	public void printStack() {
		if (!isEmpty()) {
			for (int i = 0; i < size; i++) {
				System.out.print(array.get(i));
			}
		} else {
			System.out.println("Empty Stack");
		}
	}
}

public class StackImplByArrays {
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
