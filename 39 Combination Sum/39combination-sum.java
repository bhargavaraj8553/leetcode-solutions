class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneCombination = new ArrayList<>();

        generateCombinations(candidates, target, oneCombination, result, 0);
        return result;
    }

    public static void generateCombinations(int[] candidates, int target, List<Integer> oneCombination, List<List<Integer>> result, int index) {
        if(target < 0){
            return;
        }
        if (index == candidates.length) {
            //base condition
            if(0 == target){
                result.add(new ArrayList<> (oneCombination));
            }
            return;
        }
        if (candidates[index]<=target){
            oneCombination.add(candidates[index]);
            generateCombinations(candidates, target- candidates[index], oneCombination, result, index);
            oneCombination.remove(oneCombination.size() - 1);
        }

        generateCombinations(candidates, target, oneCombination, result, index+1);


    }
}