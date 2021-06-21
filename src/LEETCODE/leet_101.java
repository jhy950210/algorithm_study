package src.LEETCODE;

public class leet_101 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode leftNode = new TreeNode(2, node3,node4);
        TreeNode rightNode = new TreeNode(2, node4,node3);

        TreeNode root = new TreeNode(1, leftNode, rightNode);

        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {

        if(root == null){ // TreeNode가 비어있을경우
            return true;
        }

        return checkSym(root.left,root.right);
    }

    public static boolean checkSym(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        } else if((left == null && right != null) || (left != null && right == null)){
            return false;
        } else{ // 트리 마지막 depth까지 반복
            return left.val == right.val && checkSym(left.left, right.right) && checkSym(left.right, right.left);
        }

    }
}
