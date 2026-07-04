class Solution {
    public int[] solution(String s) {
        int countTotal = 0;
        int countZero = 0;

        while (!s.equals("1")) {
            int zeros = 0;
            StringBuilder ones = new StringBuilder();

            for (char c : s.toCharArray()) {
                if (c == '0') zeros++;
                else ones.append(c);
            }

            countZero += zeros;
            s = Integer.toBinaryString(ones.length()); 
            countTotal++;
        }

        return new int[]{countTotal, countZero};
    }
}