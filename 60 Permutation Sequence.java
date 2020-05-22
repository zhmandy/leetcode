class Solution {
    // 分组, skip掉k之前的permutation来优化时间
    // 用类似hash的方法找到对应的组以及对应的组内位置
    public String getPermutation(int n, int k) {
        if (n < 1 || n > 9 || k < 1) return "";
        char[] ret = new char[n];
        List<Integer> nums = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        
        int[] partitions = new int[n];
        partitions[0] = 1;
        for (int i = 1; i < n; i++) {
            partitions[i] = partitions[i-1] * i;
        }
        
        k--;  // convert to index
        for (int i = 0; i < n; i++) {
            ret[i] = Character.forDigit(nums.remove(k / partitions[n-i-1]), 10);
            k = k % partitions[n-i-1];
        }
        return new String(ret);
    }
}