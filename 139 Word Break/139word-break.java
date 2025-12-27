
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return solve(s, dict, 0, memo);
    }

    private boolean solve(String s, Set<String> dict, int start, Boolean[] memo) {

        if (start== s.length()){
            return true;
        }
        if (memo[start]!=null) return memo[start];

        for (int j = start; j < s.length(); j++) {
            if (dict.contains(s.substring(start, j+1))){
                if (solve(s, dict, j+1, memo)){

                    return memo[start] = true;
                }
            }
        }
        return memo[start]= false;
    }

}