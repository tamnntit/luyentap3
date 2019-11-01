/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contest_3;

import java.util.Scanner;

/**
 *
 * @author daoan
 */
public class Bai30 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            Tree30 tree = new Tree30();
            int n = in.nextInt();
            for (int i = 1; i <= n; i++) {
                int data = in.nextInt();
                tree.Insert(data);
            }
            
            System.out.println(tree.Height());
        }
    }
}

class Tree30 {

    private Node30 root; // node goc

    public Tree30() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // insert node vao cay
    public void Insert(int data) {
        root = insert(root, data);
    }

    private Node30 insert(Node30 node, int data) {
        if (node == null) {
            node = new Node30(data);
        } else {
            if (data < node.getData()) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

    public void Delete(int data) {
        root = delete(root, data);
    }

    private Node30 delete(Node30 root, int k) {
        Node30 p;
        Node30 p2, n;
        if (root.getData() == k) {
            Node30 lt;
            Node30 rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null) {
                return null;
            } else if (lt == null) {
                p = rt;
                return p;
            } else if (rt == null) {
                p = lt;
                return p;
            } else {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null) {
                    p = p.getLeft();
                }
                p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData()) {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        } else {
            n = delete(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }

    public int Height() {
        return height(root);
    }

    private int height(Node30 node) {
        if (node == null) {
            return -1;
        }
        else{
            if(node.getLeft() == null && node.getRight() == null){
                return 0;
            }
            else{
                if(node.getLeft() != null && node.getRight() != null){
                    return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
                }
                else{
                    if(node.getLeft() == null){
                        return 1 + height(node.getRight());
                    }
                    else{
                        return 1 + height(node.getLeft());
                    }
                }
            }
        }
    }
}

class Node30 {

    int data;
    Node30 left;
    Node30 right;

    public Node30() {
        left = null;
        right = null;
        data = 0;
    }

    public Node30(int d) {
        left = null;
        right = null;
        data = d;
    }

    public int getData() {
        return data;
    }

    public Node30 getLeft() {
        return left;
    }

    public Node30 getRight() {
        return right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(Node30 left) {
        this.left = left;
    }

    public void setRight(Node30 right) {
        this.right = right;
    }
}
