/**
 * Taken from: https://leetcode.com/problems/isomorphic-strings/
 */

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, List<Integer>> sMap = new HashMap<>();
        Map<Character, List<Integer>> tMap = new HashMap<>();

        boolean isomorphic = true;

        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i)) && tMap.containsKey(t.charAt(i))) {
                List sList = sMap.get(s.charAt(i));
                List tList = tMap.get(t.charAt(i));

                if(sList.equals(tList)){
                    sList.add(i);
                    tList.add(i);

                    sMap.put(s.charAt(i), sList);
                    tMap.put(t.charAt(i), tList);

                } else {
                    isomorphic = false;
                    break;
                }

            } else if (!sMap.containsKey(s.charAt(i)) && !tMap.containsKey(t.charAt(i))) {
                    List<Integer> lis = new ArrayList<>();
                    lis.add(i);
                    
                    sMap.put(s.charAt(i), lis);
                    tMap.put(t.charAt(i), lis);

            } else {
                isomorphic = false;
                break;
            }
        }

        return isomorphic;
    }
}