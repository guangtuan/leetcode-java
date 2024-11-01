package tech.igrant.no498;

class Solution {

    static final int up = 0;
    static final int upRight = 1;
    static final int right = 2;
    static final int downRight = 3;
    static final int down = 4;
    static final int downLeft = 5;
    static final int left = 6;
    static final int upLeft = 7;

    private static final class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean in(Range range) {
            return x >= 0 && y >= 0 && x <= range.x && y <= range.y;
        }

        @Override
        public String toString() {
            return "{x=%d, y=%d}".formatted(x, y);
        }

        public void move(int dir) {
            switch (dir) {
                case upRight -> {
                    this.x = this.x + 1;
                    this.y = this.y - 1;
                }
                case down -> {
                    this.y = this.y + 1;
                }
                case downLeft -> {
                    this.x = this.x - 1;
                    this.y = this.y + 1;
                }
                case left -> {
                    this.x = this.x - 1;
                }
                case right -> {
                    this.x = this.x + 1;
                }
                case upLeft, downRight, up -> {

                }
            };
        }
    }

    private record Range(int x, int y) {
    }

    private int nextDirection(int currentDirection, Position position, Range range) {
        if (position.x > range.x) {
            if (currentDirection == down) {
                return downLeft;
            } else {
                return down;
            }
        }
        if (position.y > range.y) {
            if (currentDirection == right) {
                return upRight;
            } else {
                return right;
            }
        }
        if (position.x < 0) {
            return right;
        }
        if (position.y < 0) {
            return down;
        }
        if (currentDirection == down) {
            return downLeft;
        }
        if (currentDirection == right) {
            return upRight;
        }
        return currentDirection;
    }

    public int[] findDiagonalOrder(int[][] mat) {
        Range range = new Range(mat[0].length - 1, mat.length - 1);
        int dir = upRight;
        Position position = new Position(0, 0);
        int count = 0;
        int total = (range.x + 1) * (range.y + 1);
        int[] ret = new int[total];
        do {
            if (position.in(range)) {
                ret[count] = mat[position.y][position.x];
                count++;
            }
            dir = nextDirection(dir, position, range);
            position.move(dir);
        } while (count != total);
        return ret;
    }

}
