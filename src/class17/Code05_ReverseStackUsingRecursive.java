package class17;

import java.util.Stack;

public class Code05_ReverseStackUsingRecursive {

	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int i = f(stack);
		reverse(stack);
		stack.push(i);
	}

	// 栈底元素移除掉
	// 上面的元素盖下来
	// 返回移除掉的栈底元素
	public static int f(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = f(stack);
			stack.push(result);
			return last;
		}
	}

	//错误示例
	public static int f1(Stack<Integer> stack) {
		int cur = stack.pop();
		int last = f1(stack);
		if (!stack.isEmpty()) {
			stack.push(last);
		}
		return cur;
	}

	public static void main(String[] args) {
		Stack<Integer> test = new Stack<>();
//		test.push(1);
//		test.push(2);
//		test.push(3);
//		test.push(4);
//		test.push(5);
		test.push(3);
		test.push(2);
		test.push(1);
		reverse(test);
		System.out.println("-------------");
		while (!test.isEmpty()) {
			System.out.println(test.pop());
		}

//		f1(test);
//		System.out.println("-------------");
//		while (!test.isEmpty()) {
//			System.out.println(test.pop());
//		}

	}

}
