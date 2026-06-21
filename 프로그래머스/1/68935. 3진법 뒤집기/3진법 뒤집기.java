class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        int num = n;
        while (num > 0) {
            sb.append(num % 3);
            num /= 3;
        }
        return Integer.parseInt(sb.toString(), 3);
    }
}