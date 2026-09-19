class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            int a=nums[i];
            if (tmp.size() == 0 || a > tmp.get(tmp.size() - 1)) {
                tmp.add(a);
            } else {
                for (int j = 0; j < tmp.size(); j++) {
                    if (tmp.get(j) >= a) {
                        tmp.set(j, a);
                        break;
                    }
                }
            }
        }
        return tmp.size();
    }
}
