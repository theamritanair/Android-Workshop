package com.example.amrita.ghostgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Random;

public class SimpleDictionary {

    private ArrayList<String> words; //iterate through the words in the dictionary and store in the arraylist
    private Random random;



    public SimpleDictionary(InputStream inputstream) throws IOException {
        words = new ArrayList<>();
        BufferedReader bfr = new BufferedReader(
                new InputStreamReader(inputstream));
        String line = "";
        while((line = bfr.readLine())!=null){
            String word = line.trim();
            if(word.length()>=4)
                words.add(word);

        }

    }

    public boolean isAGoodWord(String word){
        return words.contains(word);
    }

    public String isAValidWord(String prefix){
        if(prefix==null || prefix.equals("")){
            random = new Random();
            return words.get(random.nextInt(words.size()));  // if words.size not specified, return number till 2 to the power 32

        }
        else{
            int low =0;
            int high = words.size();
            int mid;
            while(low<high){
                mid = (low+high -low)/2;

                if(words.get(mid).startsWith(prefix)){
                    return words.get(mid);
                }
                else if(prefix.compareTo(words.get(mid))>0){
                    low = mid+1;
                }else
                    high = mid -1;
            }
        }
        return null;
    }




}
