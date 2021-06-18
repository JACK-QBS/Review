package DataStructure.tree;

public class TreeNode {
    int v;
    TreeNode left;
    TreeNode right;

    public TreeNode(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "v=" + v +
                '}';
    }
}
