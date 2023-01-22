/*
	
	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

*/

public class Solution {

	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		//Your code goes here
		// 6 2 3 9
		// 2 6 3 9 
		if(preOrder.length == 0){
			return null;
		}
		int rootValue = preOrder[0];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootValue);
		if(preOrder.length == 1){
			return root;
		}
		int i= 0;
		for(i = 0;i<inOrder.length;i++){
			if(rootValue == inOrder[i]){
				break;
			}
		}
		
	
		int j = 0;
		int[] preOrderleft = new int[i];
		int[] inOrderleft = new int[i];
		int k = 0;
		for(j=0;j<i;j++){
			inOrderleft[k] = inOrder[j];
			k++;
		}
		k=0;
		for (j = 1; j < i+1; j++) {
			preOrderleft[k] = preOrder[j];
			k++;
		}
		BinaryTreeNode<Integer> left = buildTree(preOrderleft, inOrderleft);
		root.left = left;
		int[] preOrderRight = new int[inOrder.length-i-1];
		int[] inOrderRight = new int[inOrder.length - i - 1];
		k = 0;
		for (j = i+1; j < inOrder.length; j++) {
			inOrderRight[k] = inOrder[j];
			preOrderRight[k] = preOrder[j];
			k++;
		}
		BinaryTreeNode<Integer> right = buildTree(preOrderRight, inOrderRight);
		root.right = right;
		return root;
	}

}