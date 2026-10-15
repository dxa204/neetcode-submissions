class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        java.util.Arrays.sort(sArr);
        java.util.Arrays.sort(tArr);
        String sorted1 = new String(sArr);
        String sorted2 = new String(tArr);
        return sorted1.equals(sorted2);
    }
}
