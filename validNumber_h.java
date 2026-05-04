class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // Sign only allowed at start or after 'e'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                // 'e' only allowed once and must follow a digit
                if (seenE || !seenDigit) {
                    return false;
                }
                seenE = true;
                seenDigit = false; // Reset: digits MUST follow 'e'
            } else if (c == '.') {
                // Dot only allowed once and cannot follow 'e'
                if (seenDot || seenE) {
                    return false;
                }
                seenDot = true;
            } else {
                return false;
            }
        }

        return seenDigit;
    }
}
