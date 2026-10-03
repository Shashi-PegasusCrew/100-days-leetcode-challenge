class Solution {
    int fun(int i, String s) {
        int ans = 0;
        if (i < 0)
            return 0;

        if (s.charAt(i) == '(')
            return 0;

        if (i > 0 && s.charAt(i - 1) == '(') {
            ans = 2 + fun(i - 2, s);
        } else if (i > 0 && s.charAt(i - 1) == ')') {
            int len = fun(i - 1, s);

            int j = i - len - 1;

            if (j >= 0 && s.charAt(j) == '(') {
                ans = len + 2 + fun(j - 1, s);
            }
        }
        return ans;
    }

    public int longestValidParentheses(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, fun(i, s));
        }
        return ans;
    }
}