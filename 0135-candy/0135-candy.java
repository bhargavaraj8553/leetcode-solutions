
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];

        left[0]=1;

        for (int i=1;i<n;i++){
            if (ratings[i]>ratings[i-1]){
                left[i]= left[i-1]+1;
            } else {
                left[i]=1;
            }
        }
        int right=1;
        int current =1;
        int sum=Math.max(1, left[n-1]);
        for (int i = n-2;i>=0;i--){
            if (ratings[i]>ratings[i+1]){
                current= right+1;
                right = current;
            } else{
                current=1;
                right=1;
            }
            sum+= Math.max(left[i], current);
        }
        return sum;
    }
}