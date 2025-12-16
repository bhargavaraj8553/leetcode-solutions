class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        func(0, s, path, result);
        return result;
    }

    private void func(int index, String s, List<String> path, List<List<String>> result) {
        if (index==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(index, i, s)){
                path.add(s.substring(index, i+1));
                func(i+1, s, path, result);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(int start, int end, String s) {
        
        while(start<end){
            if (s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}