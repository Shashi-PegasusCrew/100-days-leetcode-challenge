import java.util.HashSet;

class Solution {
    private HashSet<Long> powersOf5 = new HashSet<>();

    public int minimumBeautifulSubstrings(String s) {
        for (int i = 0; i <= 10; i++) {
            powersOf5.add((long) Math.pow(5, i));
        }

        int ans = fun(0, 0, s);
        return ans >= 1e9 ? -1 : ans + 1;
    }

    private int fun(int p, int i, String s) {
      
        if (i == s.length() - 1) {
            if (check(p, i, s)) {
                return 0;
            }
            return (int) 1e9;
        }

        int m = (int) 1e9;

        if (check(p, i, s)) {
            int a = 1 + fun(i + 1, i + 1, s);
            m = Math.min(m, a);
        }

        int a = fun(p, i + 1, s);
        m = Math.min(m, a);

        return m;
    }

    private boolean check(int l, int r, String s) {
      
        if (s.charAt(l) == '0') {
            return false;
        }

        long num = 0;
        for (int i = l; i <= r; i++) {
            num = (num << 1) + (s.charAt(i) - '0');
        }

       
        return powersOf5.contains(num);
    }
}
