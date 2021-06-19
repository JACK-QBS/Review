package DataStructure.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 三种深度优先遍历
 */
public class dfs {
    //1、前序遍历：
    //递归方式：根、左子树、右子树
    public static void preTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.v);
            preTraversal(root.left);
            preTraversal(root.right);
        }
    }
    //非递归方式：
    public static void preOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            //遍历左子树
            while (cur != null) {
                System.out.println(cur.v);
                stack.push(cur);
                cur = cur.left;
            }
            //弹出栈顶元素
            TreeNode top = stack.pop();
            //遍历右子树
            cur = cur.right;
        }
    }

    //2、中序遍历：
    //递归方式：
    public static void inTraversal(TreeNode root) {
        if (root != null) {
            inTraversal(root.left);
            System.out.println(root);
            inTraversal(root.right);
        }
    }
    //非递归方式：
    public static void inOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            //遍历左子树：
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //弹出栈顶元素：
            TreeNode top = stack.pop();
            System.out.println(top.v);
            //遍历右子树：
            cur = cur.right;
        }
    }

    //3、后序遍历：
    //递归方式：
    public static void lastTraversal(TreeNode root) {
        if (root != null) {
            lastTraversal(root.left);
            lastTraversal(root.right);
            System.out.println(root);
        }
    }
    //非递归方式：
    public static void lastOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode last = null;//记录上次遍历的结点
        while (!stack.isEmpty() || cur != null) {
            //遍历左子树
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //查看栈顶元素，但不删除
            TreeNode top = stack.peek();
            if (top.right == null) {
                //没有右子树，向上返回
                stack.pop();
                last = top;
                System.out.println(top.v);
            } else if (top.right == last) {
                //存在右子树，已遍历，正在向上返回
                stack.pop();
                last = top;
                System.out.println(top.v);
            } else {
                //存在右子树，且未遍历
                cur = cur.right;
            }
        }
    }
}
