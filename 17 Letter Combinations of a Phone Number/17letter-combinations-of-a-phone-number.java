class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;


        Map<Character, String> letterToStringMap = new HashMap<>();

        letterToStringMap.put('2', "abc");
        letterToStringMap.put('3', "def");
        letterToStringMap.put('4', "ghi");
        letterToStringMap.put('5', "jkl");
        letterToStringMap.put('6',"mno");
        letterToStringMap.put('7',"pqrs");
        letterToStringMap.put('8', "tuv");
        letterToStringMap.put('9', "wxyz");

        generateCombinations(0, digits, letterToStringMap, result, "");
        return result;
    }

    private void generateCombinations(int i, String digits, Map<Character, String> letterToStringMap, List<String> result, String string) {

        if (i == digits.length()){
            result.add(string);
            return;
        }

        String digitsString = letterToStringMap.get(digits.charAt(i));

        for (int j=0;j<digitsString.length();j++){
            generateCombinations(i+1, digits, letterToStringMap, result, string+digitsString.charAt(j));
            //this will reduce and avoid the addition and deletion of extra elements in this string
        }
    }
}