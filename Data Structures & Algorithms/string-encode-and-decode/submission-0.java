

public class Solution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        
        while (i < s.length()) {
            int j = i;
            // Find the delimiter to isolate the length integer
            while (s.charAt(j) != '#') {
                j++;
            }
            // Parse the length
            int length = Integer.parseInt(s.substring(i, j));
            
            // Extract the actual string
            i = j + 1 + length;
            res.add(s.substring(j + 1, i));
        }
        
        return res;
    }
}