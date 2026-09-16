class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        solve(nums, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }

    void solve(int[] nums, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            used[i] = true;
            list.add(nums[i]);

            solve(nums, list, used);

            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}