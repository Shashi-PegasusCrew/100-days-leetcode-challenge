class Solution {
    public int reverseDegree(String s) {
        int index=1,sum=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int value=26-(c-'a');
            sum+=value*index++;
        }
        return sum;
        
    }
}