
class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        char [] chars = s.toCharArray();
        for (int i = 0; i <= chars.length-3; ++i){
            if (chars[i] != chars[i+1] && chars[i] != chars[i+2] && chars[i+1] != chars[i+2]) ++count;
        }
        return count;
    }
}