package thePackage;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
//		if (s.length() == 0 || s == null)
//			throw new IllegalArgumentException("String provided cannot be null or have a length of 0");

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);

			// if curr is a slash, that might indicate the beginning of a code comment,
			// in which case we have to ignore that section
			if (curr == '/') {
				// 1. single line comment
				if (s.charAt(i + 1) == '/') {
					// cycle through the file until a newline character (\n) is reached
					i++;
					while ((s.charAt(i) != '\n') && i < s.length()) {
						i++;
					}
				}
				// 2. code comment block
				else if (s.charAt(i + 1) == '*') {
					i++;
					while (!(s.charAt(i) == '*' && s.charAt(i + 1) == '/') && i < s.length()) {
						i++;
					}
				}
			}

			// we also have to control for the case where we have single quotation marks
			// around the opening/closing characters
			else if (curr == '\'') {
				if (s.charAt(i + 1) == '(' || s.charAt(i + 1) == '[' || s.charAt(i + 1) == '{'
						|| s.charAt(i + 1) == ')' || s.charAt(i + 1) == ']' || s.charAt(i + 1) == '}') {
					if (s.charAt(i + 2) == '\'') {
						i += 2;
					}
				}
			}

			// we need to handle string literals, as they could contain parentheses,
			// brackets, and braces
			else if (curr == '"') {
				// cycle through the file until another closing string is found
				// TODO: maybe the double quotation marks could be added to the stack?
				i++;
				while ((s.charAt(i) != '"') && i < s.length()) {
					i++;
				}
			}

			// if curr is an opening char, add to the stack
			else if (curr == '(' || curr == '[' || curr == '{') {
				stack.push(curr);
			}
			// else if curr is a closing char, then we need to see if it closes the previous
			// opening char
			// if it DOES NOT, then the string is NOT nested properly and we can return
			// false
			// if it DOES, then we can pop the opening brace off the stack and continue
			else if (curr == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.peek() == '(') {
					stack.pop();
				} else {
					return false;
				}
			} else if (curr == ']') {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.peek() == '[') {
					stack.pop();
				} else {
					return false;
				}
			} else if (curr == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.peek() == '{') {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		// now we must check to ensure there are no leftover opening chars that
		// still need to be closed
		if (!stack.isEmpty()) {
			return false;
		}

		return true;
	}
}
