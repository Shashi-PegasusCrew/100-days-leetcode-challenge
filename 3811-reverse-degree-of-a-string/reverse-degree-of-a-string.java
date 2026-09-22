class Solution {
    int fun(int i, int index, String s) {
        if (i >= s.length() )
            return 0;
        char c = s.charAt(i);
        int value = 26 - (c - 'a');
        return value * index + fun(i+1, index+1, s);
        
    }

    public int reverseDegree(String s) {
        return fun(0, 1, s);
    }
}