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
public class Bai29 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            Tree tree = new Tree();
            int n = in.nextInt();
            for (int i = 1; i <= n; i++) {
                int data = in.nextInt();
                tree.Insert(data);
            }
            tree.ShowTruoc();
            System.out.println("");
        }
    }
}

class Tree {

    private Node root; // node goc

    public Tree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // insert node vao cay
    public void Insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
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

    private Node delete(Node root, int k) {
        Node p;
        Node p2, n;
        if (root.getData() == k) {
            Node lt;
            Node rt;
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

    public void ShowTruoc() {
        Truoc(root);
    }

    private void Truoc(Node node) {
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                System.out.print(node.getData() + " ");
            }
            Truoc(node.getLeft());
            Truoc(node.getRight());
        }
    }
}

class Node {

    int data;
    Node left;
    Node right;

    public Node() {
        left = null;
        right = null;
        data = 0;
    }

    public Node(int d) {
        left = null;
        right = null;
        data = d;
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
