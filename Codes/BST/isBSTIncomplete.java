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
			return root.data <= root.right.data && isBST(root.right);
		}
		if(root.right == null){
			return root.left.data < root.data && isBST(root.left);
		}
		return root.left.data < root.data && root.right.data >= root.data && isBST(root.left) && isBST(root.right);
	}

}