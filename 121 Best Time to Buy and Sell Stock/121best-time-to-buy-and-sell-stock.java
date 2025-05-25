class Solution {
    public int maxProfit(int[] prices) {
        int maxDiff= Integer.MIN_VALUE;
        int minValueSoFar= prices[0];
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i]- minValueSoFar;
            if (prices[i]<minValueSoFar){
                minValueSoFar = prices[i];
            }
            maxDiff= Integer.max(maxDiff, diff);
            
        }
        return maxDiff>0?maxDiff:0;
    }
}
