package DataStructure.tree;

/**
 * 二叉搜索树
 */
public class bst {
    //查找
    public boolean search(Integer key,TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            int cmp = key.compareTo(cur.v);
            //比较传入的数字和二叉搜索树中结点的值
            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                //去该结点的 左子树 中查找
                cur = cur.left;
            } else {
                //去该结点的 右子树 中查找
                cur = cur.right;
            }
        }
        return false;
    }

    //插入：
    public void insert(Integer key,TreeNode root) {
        //如果是空树，直接插入
        if (root == null) {
            root = new TreeNode(key);
            return;
        }
        //按照查找的逻辑找到所要插入的位置
        TreeNode cur = root;
        TreeNode parent = null;//cur的双亲结点
        int cmp = 0;
        while (cur != null) {
            cmp = key.compareTo(key);
            if (cmp == 0) {
                //说明二叉树中已经有了该结点了，抛出异常
                throw new RuntimeException("该二叉树中已经存在该元素，无法插入");
            } else if (cmp < 0) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        //cur已经找到要插入的位置
        TreeNode node = new TreeNode(key);
        if (cmp < 0) {
            parent.left = node;
        } else {
            parent.right = node;
        }
    }
}
