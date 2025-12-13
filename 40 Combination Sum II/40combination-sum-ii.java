import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        generateCombinations(0, target, candidates, new ArrayList<>(), result);
        return result;
    }

    private void generateCombinations(int start, int target, int[] candidates, ArrayList<Integer> oneCombination, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(oneCombination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i> start && candidates[i]==candidates[i-1]) continue;
            if (candidates[i]>target) break;
            oneCombination.add(candidates[i]);
            generateCombinations(i+1, target - candidates[i], candidates, oneCombination, result);
            oneCombination.remove(oneCombination.size() - 1);
        }
    }
}