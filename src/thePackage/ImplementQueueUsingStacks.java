package thePackage;

import java.util.Stack;

public class ImplementQueueUsingStacks {

	class MyQueue {

		Stack<Integer> input = new Stack<Integer>(); // holds the actual data
		Stack<Integer> output = new Stack<Integer>(); // temporary "swapping" structure

		public MyQueue() {}

		public void push(int x) {
			input.push(x);
		}

		public int pop() {
			if (output.isEmpty()) {
				while (!input.isEmpty()) {
					output.push(input.pop());
				}
			}
			return output.pop();
		}

		public int peek() {
			if (output.isEmpty()) {
				while (!input.isEmpty()) {
					output.push(input.pop());
				}
			}
			return output.peek();
		}

		public boolean empty() {
			return input.empty() && output.empty();
		}
	}

}
