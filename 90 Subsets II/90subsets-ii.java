class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        generateCombinations(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void generateCombinations(int start, int[] nums, ArrayList<Integer> oneCombination, List<List<Integer>> result) {

        // if (start== nums.length){
            result.add(new ArrayList<>(oneCombination));
            // return;
        // }

        for (int i = start; i < nums.length; i++) {
            if (i> start && nums[i]== nums[i-1]) continue;

            oneCombination.add(nums[i]);
            generateCombinations(i+1, nums, oneCombination, result);
            oneCombination.remove(oneCombination.size() - 1);
        }
    }
}