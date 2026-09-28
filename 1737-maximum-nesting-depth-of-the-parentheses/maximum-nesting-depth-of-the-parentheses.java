class Solution {
    public int maxDepth(String s) {
        int temp = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                temp++;
                if (temp > count) {
                    count = temp;
                }
            } else if (ch == ')') {
                temp--;
            }
        }

        return count;
    }
}
