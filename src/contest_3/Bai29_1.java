package luyentap3;

import java.util.*;
import java.util.stream.Collectors;

public class Bai29 {
    static List<Node> list;
    public static void main(String[] args) {//NODE LA
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            list = new ArrayList<>();
            makeTree(arr, arr.length);
            List<Node> temp = list
                    .stream()
                    .filter(node -> node.nLeft == null && node.nRight == null)
                    .sorted(Comparator.comparingInt(o -> o.value))
                    .collect(Collectors.toList());
            for (Node node : temp) {
                System.out.print(node.value + " ");
            }
            System.out.println();
        }
    }
    static Node makeTree(int[] pre, int size) {
        Node root = new Node(pre[0]);
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);
        list.add(root);
        for (int i = 1; i < size; i++) {
            Node temp = null;
            while (!nodeStack.isEmpty() && pre[i] > nodeStack.peek().value) {
                temp = nodeStack.pop();
            }
            if (temp != null) {
                temp.nRight = new Node(pre[i]);
                list.add(temp.nRight);
                nodeStack.push(temp.nRight);
            } else {
                temp = nodeStack.peek();
                temp.nLeft = new Node(pre[i]);
                list.add(temp.nLeft);
                nodeStack.push(temp.nLeft);
            }
        }
        return root;
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
