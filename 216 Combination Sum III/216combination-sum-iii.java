class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int[] numbers = {1,2,3,4,5,6,7,8,9};

        generateCombinations(0, k, n, numbers, result, new ArrayList<>());
        return result;
    }

    private void generateCombinations(int i, int k, int target, int[] numbers, List<List<Integer>> result, List<Integer> oneCombination) {
        if (target==0 && k==0){
            result.add(new ArrayList<>(oneCombination));
            return;
        }
        if (i>= numbers.length || k<0 || numbers[i]> target){
            return;
        }
        oneCombination.add(numbers[i]);
        generateCombinations(i+1, k-1, target- numbers[i],numbers, result, oneCombination);
        oneCombination.remove(oneCombination.size()-1);

        generateCombinations(i+1, k, target, numbers, result, oneCombination);
    }
}