package tech.igrant.weekly_contest.no300.no2;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

class Solution {

    final int right = 1;
    final int down = 2;
    final int left = 3;
    final int up = 4;

    private Predicate<Position> inRange(int m, int n) {
        return position -> {
            if (position.x < 0) {
                return false;
            }
            if (position.y < 0) {
                return false;
            }
            if (position.x > n - 1) {
                return false;
            }
            return position.y <= m - 1;
        };
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ret = new int[m][n];
        ListNode cursor = head;
        Position currentPosition = new Position(0, 0);
        int dir = right;
        Set<String> visited = new HashSet<>();
        Predicate<Position> inRange = inRange(m, n);
        while (currentPosition != null) {
            if (cursor != null) {
                ret[currentPosition.y][currentPosition.x] = cursor.val;
            } else {
                ret[currentPosition.y][currentPosition.x] = -1;
            }
            visited.add(currentPosition.toString());
            dir = nextDir(dir, currentPosition, visited, inRange);
            currentPosition = nextPosition(dir, currentPosition);
            if (cursor != null) {
                cursor = cursor.next;
            }
        }
        return ret;
    }

    private Position nextPosition(int dir, Position currentPosition) {
        switch (dir) {
            case left -> {
                return currentPosition.left();
            }
            case right -> {
                return currentPosition.right();
            }
            case up -> {
                return currentPosition.up();
            }
            case down -> {
                return currentPosition.down();
            }
            default -> {
                return null;
            }
        }
    }

    private int nextDir(int dir, Position currentPosition, Set<String> visited, Predicate<Position> inRange) {
        if (dir == right) {
            Position nextToRight = currentPosition.right();
            if (inRange.test(nextToRight) && !visited.contains(nextToRight.toString())) {
                return right;
            }
            Position nextToDown = currentPosition.down();
            if (inRange.test(nextToDown) && !visited.contains(nextToDown.toString())) {
                return down;
            }
            Position nextToLeft = currentPosition.left();
            if (inRange.test(nextToLeft) && !visited.contains(nextToLeft.toString())) {
                return left;
            }
            Position nextToUp = currentPosition.up();
            if (inRange.test(nextToUp) && !visited.contains(nextToUp.toString())) {
                return up;
            }
            return -1;
        }
        if (dir == down) {
            Position nextToDown = currentPosition.down();
            if (inRange.test(nextToDown) && !visited.contains(nextToDown.toString())) {
                return down;
            }
            Position nextToLeft = currentPosition.left();
            if (inRange.test(nextToLeft) && !visited.contains(nextToLeft.toString())) {
                return left;
            }
            Position nextToUp = currentPosition.up();
            if (inRange.test(nextToUp) && !visited.contains(nextToUp.toString())) {
                return up;
            }
            Position nextToRight = currentPosition.right();
            if (inRange.test(nextToRight) && !visited.contains(nextToRight.toString())) {
                return right;
            }
            return -1;
        }
        if (dir == left) {
            Position nextToLeft = currentPosition.left();
            if (inRange.test(nextToLeft) && !visited.contains(nextToLeft.toString())) {
                return left;
            }
            Position nextToUp = currentPosition.up();
            if (inRange.test(nextToUp) && !visited.contains(nextToUp.toString())) {
                return up;
            }
            Position nextToRight = currentPosition.right();
            if (inRange.test(nextToRight) && !visited.contains(nextToRight.toString())) {
                return right;
            }
            Position nextToDown = currentPosition.down();
            if (inRange.test(nextToDown) && !visited.contains(nextToDown.toString())) {
                return down;
            }
            return -1;
        }
        if (dir == up) {
            Position nextToUp = currentPosition.up();
            if (inRange.test(nextToUp) && !visited.contains(nextToUp.toString())) {
                return up;
            }
            Position nextToRight = currentPosition.right();
            if (inRange.test(nextToRight) && !visited.contains(nextToRight.toString())) {
                return right;
            }
            Position nextToDown = currentPosition.down();
            if (inRange.test(nextToDown) && !visited.contains(nextToDown.toString())) {
                return down;
            }
            Position nextToLeft = currentPosition.left();
            if (inRange.test(nextToLeft) && !visited.contains(nextToLeft.toString())) {
                return left;
            }
            return -1;
        }
        return  -1;
    }

    private static class Position {
        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x=%s, y=%s".formatted(x, y);
        }

        public Position down() {
            return new Position(x, y + 1);
        }

        public Position left() {
            return new Position(x - 1, y);
        }

        public Position up() {
            return new Position(x, y - 1);
        }

        public Position right() {
            return new Position(x + 1, y);
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
