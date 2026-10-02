class Solution {

    public static void fun(String s, int n, int a, int b, List<String> ans) {

        if (b > a) return;

        if (a > n || b > n) return;

        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }

        fun(s + "(", n, a + 1, b, ans);
        fun(s + ")", n, a, b + 1, ans);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        fun("", n, 0, 0, ans);

        return ans;
    }
}