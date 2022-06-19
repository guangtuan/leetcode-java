package tech.igrant.no1089;

class Solution {

    private static class Node {
        private final int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node getNode(int[] arr, int idx) {
        if (idx == arr.length) {
            return null;
        }
        Node ret = new Node(arr[idx]);
        ret.next = getNode(arr, idx + 1);
        return ret;
    }

    public void duplicateZeros(int[] arr) {
        Node head = getNode(arr, 0);
        Node cursor = head;
        int l = arr.length;
        while (l > 0) {
            if (cursor == null) {
                break;
            }
            if (cursor.val == 0) {
                Node tmp = cursor.next;
                cursor.next = new Node(0);
                cursor.next.next = tmp;
                cursor = tmp;
                l = l - 2;
            } else {
                cursor = cursor.next;
                l = l - 1;
            }
        }
        Node cursor2 = head;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = cursor2.val;
            cursor2 = cursor2.next;
        }
    }

}
