package luyentap3;

import java.util.Scanner;
import java.util.Stack;

public class Bai30 {
    public static void main(String[] args) {// DO SAU CUA CAY
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-->0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Node root = makeTree(arr, arr.length);
            System.out.println(maxDepth(root)-1);
        }
    }
    static Node makeTree(int[] pre, int size) {
        Node root = new Node(pre[0]);
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);
        for (int i = 1; i < size ; i++) {
            Node temp = null;
            while (!nodeStack.isEmpty() && pre[i] > nodeStack.peek().value) {
                temp = nodeStack.pop();
            }
            if (temp!=null) {
                temp.nRight = new Node(pre[i]);
                nodeStack.push(temp.nRight);
            } else {
                temp = nodeStack.peek();
                temp.nLeft = new Node(pre[i]);
                nodeStack.push(temp.nLeft);
            }
        }
        return root;
    }
    static int maxDepth(Node node) {
        if (node == null)
            return 0;
        else {
            int lDepth = maxDepth(node.nLeft);
            int rDepth = maxDepth(node.nRight);
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }
    static class Node {
        int value;
        Node nLeft = null;
        Node nRight = null;
        public Node(int value) {
            this.value = value;
        }
    }
}
