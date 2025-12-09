class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        generateCombinations(0, n, sb, ans);

        return ans;
    }

    private void generateCombinations(int index, int length, StringBuilder currString, List<String> ans) {
        if (index == 2 * length) {
            if (isBalancedString(currString)) {
                ans.add(currString.toString());
            }
            return;
        }
        currString.append("(");
        generateCombinations(index + 1, length, currString, ans);
        currString.deleteCharAt(currString.length() - 1);

        currString.append(")");
        generateCombinations(index + 1, length, currString, ans);
        currString.deleteCharAt(currString.length() - 1);

    }

    private boolean isBalancedString(StringBuilder currString) {
        Stack<Character> st = new Stack<>();
        for (char ch : currString.toString().toCharArray()) {
            if (ch == '(') {
                st.push(')');
            } else if (ch == ')') {
                if (st.isEmpty() || st.peek()!=')'){
                    return false;
                }
                st.pop();
            }
        }
        if (st.isEmpty()){
            return true;
        }
        return false;
    }
}