package tree;

import java.util.Objects;

public class Demo {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        test(node1);

    }
    private static void test(TreeNode node) {
        if (Objects.nonNull(node.left)) {
            test(node.left);
        }
        System.out.println(node.val);
        if (Objects.nonNull(node.right)) {
            test(node.right);
        }
    }

}
