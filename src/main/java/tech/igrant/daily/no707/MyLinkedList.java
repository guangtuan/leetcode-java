package tech.igrant.daily.no707;

class MyLinkedList {

    static class Node {
        private final int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "%d->%s".formatted(
                    this.val,
                    this.next == null ? "null" : this.next.toString()
            );
        }
    }

    private Node head;
    private Node tail;
    private int count = 0;

    public MyLinkedList() {

    }

    private Node getWithIndex(Node node, int index) {
        if (node == null) {
            return null;
        }
        if (index == 0) {
            return node;
        }
        return getWithIndex(node.next, index - 1);
    }

    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        if (index >= count) {
            return -1;
        }
        Node node = getWithIndex(head, index);
        return node == null ? -1 : node.val;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            int secondVal = head.val;
            Node secondNext = head.next;
            Node next = new Node(secondVal, secondNext);
            head = new Node(val, next);
            if (count == 1) {
                tail = head.next;
            }
        }
        count = count + 1;
    }

    public void addAtTail(int val) {
        if (tail == null) {
            tail = new Node(val);
            head = tail;
        } else {
            Node oldTail = tail;
            tail = new Node(val);
            oldTail.next = tail;
        }
        count = count + 1;
    }

    public void addAtIndex(int index, int val) {
        if (index == count) {
            addAtTail(val);
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        Node found = getWithIndex(head, index - 1);
        if (found == null) {
            return;
        }
        Node tmpNext = found.next;
        found.next = new Node(val, tmpNext);
        count++;
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            if (head != null) {
                head = head.next;
                count--;
            }
        } else {
            Node withIndex = getWithIndex(head, index - 1);
            if (withIndex != null && withIndex.next != null) {
                withIndex.next = withIndex.next.next;
                count--;
                if (withIndex.next == null) {
                    tail = withIndex;
                }
            }
        }
    }

    public boolean ok() {
        if (head == null) {
            return true;
        }
        String s = this.toString();
        return s.endsWith(this.tail.toString());
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        return "[%d]: %s".formatted(count, head.toString());
    }

}
