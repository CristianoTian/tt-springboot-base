package com.hy.tt.algorithm;

import java.util.ArrayDeque;

/**
 * @author thy
 * @date 2020/7/27
 */
public class TreeNode {

    TreeNode left;
    TreeNode right;
    int value;

    public TreeNode(int value){
        this.value = value;
    }

    /**
     * init tree  1 2 3 4 null 5 6
     *         1
     *     2      3
     *  4  null 5   6
     * @return
     */
    public static TreeNode initTree(){
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        return root;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }



    /**
     * 层序遍历
     * @param root
     */
    public static void sequenceTravseral(TreeNode root){
        if(root == null){
            return;
        }
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque();
        arrayDeque.offer(root);
        while(!arrayDeque.isEmpty()){
            TreeNode node = arrayDeque.poll();
            if(node.getLeft() != null){
                arrayDeque.offer(node.getLeft());
            }
            if(node.getRight() != null){
                arrayDeque.offer(node.getRight());
            }
            System.out.println(node.getValue());
        }
    }


    /**
     * 分层打印,每层有多少个
     */
    public static void layeredPrint(TreeNode root){
        if(root == null){
            return;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int level = 0;
        int levelNum = 0;
        while(!deque.isEmpty()){
            levelNum = deque.size();
            level++;
            for(int i = 0; i < levelNum; i++){
                TreeNode node = deque.poll();
                System.out.print(node.getValue() + " ");
                if(node.getLeft() != null){
                    deque.offer(node.getLeft());
                }
                if(node.getRight() != null){
                    deque.offer(node.getRight());
                }
            }
            System.out.print(" level:" + level + " levelNum:" + levelNum + "\n");
        }
    }


    public static void layeredPrintLeftest(TreeNode root){
        if(root == null){
            return;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int levelNum;
        while(!deque.isEmpty()){
            levelNum = deque.size();
            //取队列头
            System.out.println(deque.peek().getValue());
            for(int i = 0; i < levelNum; i++){
                TreeNode node = deque.poll();
                if(node.getLeft() != null){
                    deque.offer(node.getLeft());
                }
                if(node.getRight() != null){
                    deque.offer(node.getRight());
                }
            }

        }
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree();
        sequenceTravseral(root);
        layeredPrint(root);
        layeredPrintLeftest(root);
    }
}
