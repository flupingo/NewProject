package com.Arithmetic;

/**
 * Created：Jeffrey
 * date   ：2021/8/9 16:29
 */
public class BinaryTree {
    TreeNode root;//根节点


    class TreeNode {
        int no;
        String name;
        TreeNode left;  //左节点
        TreeNode right; //右节点

        TreeNode(int no, String name) {
            this.no = no;
            this.name = name;
        }

        @Override
        public String toString() {
            return "节点{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }

        //新增
        void add(TreeNode node) {
            TreeNode temp = root;
            if (node.no > temp.no) {

            }


        }


        //前序遍历 - 递归
        void preOrder() {
            System.out.println(this); //先输出节点

            //分别遍历左右节点
            if (this.left != null) {
                //递归遍历左节点
                this.left.preOrder();
            }
            if (this.right != null) {
                //递归遍历左节点
                this.right.preOrder();
            }
        }

        //中序
        void midOrder() {
            if (this.left != null) {
                //递归遍历左节点
                this.left.preOrder();
            }
            System.out.println(this); //输出节点
            if (this.right != null) {
                //递归遍历左节点
                this.right.preOrder();
            }

        }

        //后序
        void lastOrder() {
            if (this.left != null) {
                //递归遍历左节点
                this.left.preOrder();
            }
            if (this.right != null) {
                //递归遍历左节点
                this.right.preOrder();
            }
            System.out.println(this); //输出节点
        }
    }

}
