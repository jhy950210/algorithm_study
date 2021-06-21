package src.LEETCODE;

import java.util.Collections;
import java.util.PriorityQueue;

/* leet_111 */
public class leet_111 {

	public static void main(String[] args) {
		System.out.println();
	}
	
	public static int minDepth(TreeNode root) {
		if(root == null) { return 0;}
		
		if(root.left == null && root.right == null) {
			return 1;
		}
		
		if(root.left == null) {
			return minDepth(root.right) + 1;
		}
		
		if(root.right == null) {
			return minDepth(root.left) + 1;
		}
		
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
	
	
}





