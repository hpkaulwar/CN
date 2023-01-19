import java.util.Stack;
public class Solution {

	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		//Your code goes here
		if(!input.isEmpty()){
			int value = input.pop();
			reverseStack(input, extra);
			inputAtBottom(input,value);
		}	
	}

	public static void inputAtBottom(Stack<Integer> input, int value) {
		if (input.isEmpty()) {
			input.push(value);
		}else{
			int val = input.pop();
			inputAtBottom(input, value);
			input.push(val);
		}
			
			
	}
}