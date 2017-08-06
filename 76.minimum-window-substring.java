public class Solution {
    public String minWindow(String s, String t) {
       if (s == null || s.length() == 0 || s.length() < t.length()) return "";
       int[] map = new int[128];
       int start = 0, end = 0, minStart = 0, minLength = Integer.MAX_VALUE, count = t.length();
       for(char c:t.toCharArray()) map[c]++;
       while(end < s.length()) {
         if (map[s.charAt(end)]-- > 0)
           count--;
         end++;
         while (count == 0) {
            if (end - start < minLength) {
              minLength = end - start;
              minStart = start;
            }
            map[s.charAt(start)]++;
            if (map[s.charAt(start)] > 0) {
              count++;
            }
            start++;
         }
       }
       return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength); 
    }
}
