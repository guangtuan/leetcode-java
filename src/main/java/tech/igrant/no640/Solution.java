package tech.igrant.no640;

class Solution {

    private static class Holder {
        int xRepeat;
        int num;

        @Override
        public String toString() {
            return "%dx num=%d".formatted(xRepeat, num);
        }
    }

    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        String left = split[0];
        String right = split[1];
        Holder l = handle(left);
        Holder r = handle(right);
        int repeatDelta = l.xRepeat - r.xRepeat;
        int numberDelta = r.num - l.num;
        if (numberDelta == 0) {
            // 常数项为 0，系数不等于 0，则 x=0
            if (repeatDelta != 0) {
                return "x=0";
            } else {
                // 常数项为 0，系数等于 0，则 x 为任何数
                return "Infinite solutions";
            }
        }
        // 常数项不是 0，系数是 0，0x = 1（显然不成立）
        if (repeatDelta == 0) {
            return "No solution";
        }
        // 常数项不是 0，系数不是 0，约分可求解得到 x 的值
        return "x=%d".formatted(numberDelta / repeatDelta);
    }

    private int toInt(String str) {
        if (str.startsWith("-")) {
            return -1 * toInt(str.substring(1));
        }
        if (str.length() == 0) {
            return 1;
        }
        return Integer.parseInt(str);
    }

    private Holder handle(String str) {
        String newStr = str.replaceAll("-", "+-");
        String[] parts = newStr.split("\\+");
        Holder holder = new Holder();
        for (String part : parts) {
            if (part.length() == 0) {
                continue;
            }
            if (part.endsWith("x")) {
                int factor = toInt(part.replace("x", ""));
                holder.xRepeat += factor;
            } else if (part.endsWith("-x")) {
                int factor = toInt(part.replace("-x", ""));
                holder.xRepeat -= factor;
            } else if (part.contains("-")) {
                int minus = toInt(part.replace("-", ""));
                holder.num -= minus;
            } else {
                int plus = toInt(part);
                holder.num += plus;
            }
        }
        return holder;
    }

}
