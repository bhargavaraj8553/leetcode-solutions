class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int k=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >='a' && c <='z') || (c >='A' && c <='Z') || (c>='0' && c<='9')){
                stringBuilder.append(Character.toLowerCase(c));
            }
        }
        System.out.println(stringBuilder);
        return checkIfStringPalindrome(stringBuilder.toString());
    }

    private boolean checkIfStringPalindrome(String val) {
        int i=0;
        int j=val.length()-1;
        while(i<=j){
            if (val.charAt(i++)!=val.charAt(j--)) return false;
        }
        return true;
    }
}
