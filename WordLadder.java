package com.java;

import java.util.*;

public class WordLadder {
    public int wordLadder(String start, String end, List<String>wordList){
        Queue<String>q = new LinkedList<>();
        HashSet<String> mySet = new HashSet<>(wordList);
        q.offer(start);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String myWord = q.poll();
                if(myWord.equals(end)){
                    return level+1;
                }
                char[]array = myWord.toCharArray();
                for(int j = 0; j < array.length; j++){
                    char temp = array[j];
                    for(char letter = 'a'; letter <= 'z'; letter++){
                        if(letter == array[j])
                            continue;
                        array[j] = letter;
                        String tempWord = new String(array);
                        if(mySet.contains(tempWord)){
                            mySet.remove(tempWord);
                            q.offer(tempWord);
                        }
                    }
                    array[j] = temp;
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<String> dict = new ArrayList<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        String start = "hit";
        String end = "cog";
        System.out.println(new WordLadder().wordLadder(start, end, dict));
    }
}
