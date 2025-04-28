class Solution {
    public double average(int[] salary) {
        int allSum=0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int n: salary){
            allSum+=n;
            if(n>max) max=n;
            if(n<min) min =n;
        }
        return (double) (allSum - min - max) /(salary.length-2);
    }
}