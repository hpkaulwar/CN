import java.util.Stack;
public class Solution {

	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		//Your code goes here
		helpreverseStack(input, extra);
		while(!extra.isEmpty()){
			input.push(extra.pop());
		}
	}

	public static void helpreverseStack(Stack<Integer> input, Stack<Integer> extra) {
		int value;
		if (!input.isEmpty()) {
			value = input.pop();
			helpreverseStack(input, extra);
			extra.push(value);
		} 	
	}
}