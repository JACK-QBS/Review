package DataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历
 */
public class bfs {
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //把根节点放入队列
        queue.add(root);
        while (!queue.isEmpty()) {
            //取出队首元素
            TreeNode cur = queue.remove();
            //打印遍历结点的值
            System.out.println(cur.v);
            //把该节点的左右孩子放入队列中
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }
}
