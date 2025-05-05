class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int y= reverse(x);
        return x == y;
    }

    public int reverse(int x) {
        int result = 0;
        boolean nagativeFlag = x<0;
        if (nagativeFlag) x=-x;
        while(x>0){
            if(result>Integer.MAX_VALUE/10 || result<Integer.MIN_VALUE/10){
                return 0;
            }
            int l= x%10;
            result = result*10 + l;
            x/=10;
        }
        return nagativeFlag? -result:result;
    }
}