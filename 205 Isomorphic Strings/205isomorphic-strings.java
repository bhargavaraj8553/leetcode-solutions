class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        Arrays.fill(mapS, -1);
        Arrays.fill(mapT, -1);

        //Input: s = "egg", t = "add"
        for (int i = 0; i < s.length(); i++) {
            int indexS = s.charAt(i);
            int indexT = t.charAt(i);
            if (mapS[indexS]==-1 && mapT[indexT]==-1){
                mapS[indexS] = indexT;
                mapT[indexT] = indexS;
            } else {
                if (mapS[indexS]!= indexT
                 || mapT[indexT]!= indexS)  {
                return false;
                }
            }
        }
        return true;
    }
}