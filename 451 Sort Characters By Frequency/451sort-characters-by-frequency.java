class Solution {
    public String frequencySort(String s) {
        StringBuilder finalString = new StringBuilder();
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charFreqMap.put(s.charAt(i), charFreqMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        TreeMap<Integer, List<Character>> freqToAllCharactersMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Character, Integer> entry : charFreqMap.entrySet()) {
            if (!freqToAllCharactersMap.containsKey(entry.getValue())) {
                freqToAllCharactersMap.put(entry.getValue(), new ArrayList<>());
            }
            freqToAllCharactersMap.get(entry.getValue()).add(entry.getKey());
        }

        for (Map.Entry<Integer, List<Character>> entry : freqToAllCharactersMap.entrySet()) {
            int freq = entry.getKey();
            List<Character> cHaracterList = entry.getValue();

            for (char c : cHaracterList) {
                for (int i = 0; i < freq; i++) {
                    finalString.append(c);
                }
            }
        }
        return finalString.toString();
    }
}