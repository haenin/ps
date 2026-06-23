class Solution {
    public String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                answer += ' ';
            }
            else if (c >= 'A' && c <= 'Z') {
                c = (char)('A' + (c - 'A' + n) % 26);
                answer += c;
            }
            else if (c >= 'a' && c <= 'z') {
                c = (char)('a' + (c - 'a' + n) % 26);
                answer += c;
            }
        }

        return answer;
    }
}