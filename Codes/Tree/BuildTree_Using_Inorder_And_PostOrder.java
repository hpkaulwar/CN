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

	public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
		//Your code goes here
		return buildTreeHelper(postOrder,inOrder, 0, postOrder.length-1, 0, inOrder.length-1);
	}

	public static BinaryTreeNode<Integer> buildTreeHelper(int[] postOrder, int[] inOrder, int startIndexPostOrder, int endIndexPostOrder, int startIndexInOrder, int endIndexInOrder){
		if(startIndexInOrder > endIndexInOrder){
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(postOrder[endIndexPostOrder]);
		int i = 0;
		for(i=startIndexInOrder;i<endIndexInOrder;i++){
			if(root.data == inOrder[i]){
				break;
			}
		}
		int startIndexInOrderLeft = startIndexInOrder;
		int endIndexInOrderLeft = i-1;
		int lengthOfLeft = endIndexInOrderLeft - startIndexInOrderLeft +1;
		int startIndexInOrderRight = i+1;
		int endIndexInOrderRight = endIndexInOrder;
		int startIndexPostOrderLeft = startIndexPostOrder;
		int endIndexPostOrderLeft  = startIndexPostOrderLeft +lengthOfLeft -1;
		int startIndexPostOrderRight = startIndexPostOrderLeft + lengthOfLeft;
		int endIndexPostOrderRight = endIndexPostOrder-1;

		BinaryTreeNode<Integer> leftSubTree = buildTreeHelper(postOrder,inOrder, startIndexPostOrderLeft, endIndexPostOrderLeft, startIndexInOrderLeft, endIndexInOrderLeft);
		BinaryTreeNode<Integer> rightSubTree = buildTreeHelper(postOrder,inOrder, startIndexPostOrderRight, endIndexPostOrderRight, startIndexInOrderRight, endIndexInOrderRight);
		root.left= leftSubTree;
		root.right= rightSubTree;
		return root;
	}

}