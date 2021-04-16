package com.java.L1160FindWordFormbyChar;

public class FindWordFormedByChar {

//    public int countCharacters(String[] words, String chars) {

//         int total = 0;
//         HashMap<Character, Integer> charMap = wordToDict(chars);
//         for(String word: words){
//             boolean goodWord = true;
//             HashMap<Character, Integer> wordMap = wordToDict(word);
//             for(char letter : wordMap.keySet()){
//                 if(!charMap.containsKey(letter) || charMap.get(letter) < wordMap.get(letter)){
//                     goodWord = false;
//                     break;
//                 }
//             }
//             if(goodWord)
//                 total += word.length();
//         }
//         return total;
//     }

//     private HashMap<Character, Integer> wordToDict(String word){
//         char[] arr = word.toCharArray();
//         HashMap<Character, Integer> map = new HashMap<>();
//         for(char letter : arr){
//             map.put(letter, map.getOrDefault(letter, 0) + 1);
//         }
//         return map;
//     }

    public int countCharacters(String[] words, String chars) {
        int[] charDict = wordToDict(chars);
        int total = 0;
        for(String word: words){
            boolean goodWord = true;
            int[] wordDict = wordToDict(word);
            for(int i = 0; i < word.length(); i++){
                if(charDict[word.charAt(i) - 'a']  == 0 ||
                        charDict[(word.charAt(i) - 'a')] < wordDict[word.charAt(i) - 'a']){
                    goodWord = false;
                    break;
                }
            }
            if(goodWord){
                total += word.length();
            }
        }
        return total;
    }

    private int[] wordToDict(String word){
        int[] dict = new int[26];
        char[] arr = word.toCharArray();
        for(char letter: arr){
            dict[letter - 'a'] += 1;
        }
        return dict;
    }
}

