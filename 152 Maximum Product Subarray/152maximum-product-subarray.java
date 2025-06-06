class Solution {
    public int maxProduct(int[] nums) {

        int currentMin=nums[0];
        int currentMax=nums[0];
        int globalMax= nums[0];
        for (int i=1;i<nums.length;i++){
            int tempMax= currentMax;
            int num = nums[i];
            currentMax = Math.max(Math.max(currentMax* num, currentMin* num), num);
        //    System.out.println("max" + currentMax);
            currentMin = Math.min(Math.min(currentMin * num, tempMax* num), num);
        //    System.out.println("min " + currentMin);
            globalMax = Math.max(globalMax, currentMax);
            // System.out.println("globalMax" + globalMax);
        }
        return globalMax;
    }
}