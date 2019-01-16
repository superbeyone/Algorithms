package com.superbeyone.algorothms.practice001;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className Solution
 * @description minimum-depth-of-binary-tree
 * @create 2019-01-07 15:00
 **/

import java.util.LinkedList;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class Solution {
    /**
     * 深度优先遍历（DFS）
     * 如果当前节点为空，则最小深度为0
     * 效率低
     *
     * @param root
     * @return
     */
    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = run(root.left);
        int r = run(root.right);
        if (l == 0 || r == 0) {
            return l + r + 1;
        }
        return Math.min(l, r) + 1;
    }

    /**
     * 广度优先遍历（BFS）
     * 找到第一个叶子结点就停止遍历
     * 效率高
     *
     * @param root
     * @return
     */
    public int run2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> layerList = new LinkedList<>();
        queue.addFirst(root);
        int start = 0;
        int end = 1;
        int level = 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.removeLast();
            start++;
            layerList.addFirst(temp);
            if (temp.left == null && temp.right == null) {
                return level;
            }
            if (temp.left != null) {
                queue.addFirst(temp.left);
            }
            if (temp.right != null) {
                queue.addFirst(temp.right);
            }

            if (start == end) {
                level++;
                start = 0;
                end = queue.size();
                layerList = new LinkedList<>();
            }
        }
        return level;
    }

}
