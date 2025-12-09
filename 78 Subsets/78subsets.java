class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        generateSubsets(0, nums, list, res);
        return res;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        generateSubsets(index+1, nums, list, res);
        list.remove(list.size()-1);
        generateSubsets(index+1, nums, list, res);
    }
}
