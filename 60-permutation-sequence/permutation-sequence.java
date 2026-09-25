class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder nums = new StringBuilder();
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            nums.append(i);
            fact *= i;
        }

        k--;

        StringBuilder ans = new StringBuilder();

        for (int i = n; i >= 1; i--) {
            fact /= i;
            int index = k / fact;
            ans.append(nums.charAt(index));
            nums.deleteCharAt(index);
            k %= fact;
        }

        return ans.toString();
    }
}