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
public class Bai28 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BST test = new BST();
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] temp = s.split(" ");
            int q = Integer.parseInt(temp[0]);
            if (q == 1) {
                int data = Integer.parseInt(temp[1]);
                test.Insert(data);
            }
            if (q == 2) {
                int data = Integer.parseInt(temp[1]);
                test.Delete(data);
            }
            if (q == 3) {
                test.ShowTruoc();
                System.out.println("");
            }
            if (q == 4) {
                test.ShowGiua();
                System.out.println("");
            }
            if (q == 5) {
                test.ShowSau();
                System.out.println("");
            }
        }
    }
}

class BST {

    private BSTNode root; // node goc

    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // insert node vao cay
    public void Insert(int data) {
        root = insert(root, data);
    }

    private BSTNode insert(BSTNode node, int data) {
        if (node == null) {
            node = new BSTNode(data);
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

    private BSTNode delete(BSTNode root, int k) {
        BSTNode p, p2, n;
        if (root.getData() == k) {
            BSTNode lt, rt;
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

    private void Truoc(BSTNode node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            Truoc(node.getLeft());
            Truoc(node.getRight());
        }
    }

    public void ShowGiua() {
        Giua(root);
    }

    private void Giua(BSTNode node) {
        if (node != null) {
            Giua(node.getLeft());
            System.out.print(node.getData() + " ");
            Giua(node.getRight());
        }
    }

    public void ShowSau() {
        Sau(root);
    }

    private void Sau(BSTNode node) {
        if (node != null) {
            Sau(node.getLeft());
            Sau(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

}

class BSTNode {

    int data;
    BSTNode left;
    BSTNode right;

    public BSTNode() {
        left = null;
        right = null;
        data = 0;
    }

    public BSTNode(int d) {
        left = null;
        right = null;
        data = d;
    }

    public int getData() {
        return data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

}
