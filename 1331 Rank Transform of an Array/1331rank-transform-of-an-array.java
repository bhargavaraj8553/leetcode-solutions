
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] arr1 = Arrays.copyOf(arr, arr.length);

        Arrays.sort(arr1);

        HashMap<Integer, Integer> mp = new HashMap<>();
        int index=1;
        for (int num : arr1) {
            if (!mp.containsKey(num)) {
                mp.put(num, index++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i]= mp.get(arr[i]);
        }

        return arr;

    }
}