package com.java.WordLadder;

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
                System.out.println("This is queue's popped word " + myWord);
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
                            System.out.println(tempWord);
                            mySet.remove(tempWord);
                            q.offer(tempWord);
                            System.out.println("This is my set: " + mySet);
                        }
                    }
                    array[j] = temp;
                }
                System.out.println("finished checking one word");
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
        dict.add("cog");
        String start = "hit";
        String end = "cog";
        System.out.println(new WordLadder().wordLadder(start, end, dict));
    }
}
