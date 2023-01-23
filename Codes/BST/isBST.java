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

	public static boolean isBST(BinaryTreeNode<Integer> root) {

		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
		if(root == null){
			return true;
		}
		if(root.left == null && root.right == null){
			return true;
		}
		if(root.left == null){
			return root.data <= minimum(root.right) && isBST(root.right);
		}
		if(root.right == null){
			return maximum(root.left) < root.data && isBST(root.left);
		}
		return maximum(root.left) < root.data && minimum(root.right) >= root.data && isBST(root.left) && isBST(root.right);
	}

	public static int minimum(BinaryTreeNode<Integer> root){
		int minimum = Integer.MAX_VALUE;
		if(root == null){
			return minimum;
		}
		int leftMinimum = minimum(root.left);
		int rightMinimum = minimum(root.right);
		return Math.min(root.data, Math.min(leftMinimum, rightMinimum));
	}

	public static int maximum(BinaryTreeNode<Integer> root){
		int maximum = Integer.MIN_VALUE;
		if(root == null){
			return maximum;
		}
		int leftMaximum = maximum(root.left);
		int rightMaximum = maximum(root.right);
		return Math.max(root.data, Math.max(leftMaximum, rightMaximum));
	}

}