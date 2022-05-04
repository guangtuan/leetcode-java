package tech.igrant.no1823;

class Solution {

    static class Node {
        private int number;
        private Node next;

        public Node(int number, Node next) {
            this.number = number;
            this.next = next;
        }
    }

    public int findTheWinner(int n, int k) {
        if (k == 1) {
            return n;
        }
        Node[] nodes = new Node[n];
        for (int i = n - 1; i >= 0; i--) {
            Node curr = new Node(i + 1, null);
            nodes[i] = curr;
            if (i != n - 1) {
                curr.next = nodes[i + 1];
            }
        }
        nodes[n - 1].next = nodes[0];
        int run = n;
        Node start = nodes[0];
        while (run > 1) {
            int step = 1;
            Node cursor = start;
            while (true) {
                step++;
                if (step == k) {
                    break;
                }
                cursor = cursor.next;
            }
            cursor.next = cursor.next.next;
            start = cursor.next;
            run--;
        }
        return start.number;
    }
}