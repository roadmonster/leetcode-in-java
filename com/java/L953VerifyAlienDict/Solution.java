package com.java.L953VerifyAlienDict;

public class Solution {
    public static void main(String[] args) {
        String[] words = new String[]{"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(verifyAlienDict(words, order));
    }

    public static boolean verifyAlienDict(String[]words, String order){
        int[]alphbet = new int[26];
        for(int i = 0; i < order.length(); i++){
            alphbet[order.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < words.length - 1; i++){
            if (isGreaterThan(words[i], words[i + 1], alphbet)){
                return false;
            }
        }
        return true;

    }

    private static boolean isGreaterThan(String word, String word1, int[]alphabet) {
        int len = word.length();
        int len1 = word1.length();
        int minLen = Math.min(len, len1);
        for(int i = 0; i < minLen; i++){
            if(word.charAt(i) == word1.charAt(i))
                continue;
            int val = alphabet[word.charAt(i) - 'a'];
            int val1 = alphabet[word1.charAt(i) - 'a'];
            if(val > val1)
                return true;
            else
                return false;
        }
        return len > len1;
    }



}
