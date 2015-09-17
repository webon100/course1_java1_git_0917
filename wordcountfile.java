/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package javatest2015.pkg100;

/**
 *
 * @author ross.bai
 */

import java.io.BufferedReader; 
import java.io.FileReader; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashMap; 
 

public class wordcountfile {
    
    public static void main(String[] args) { 
        // Creating new HashMap objects 
        // keys are String, values are Integer 
        HashMap<String, Integer> wordcount = new HashMap<String, Integer>();
 
        try { 
            // Opening file 
            BufferedReader in = new BufferedReader(new FileReader("C:/wordcounttext.txt"));
            // string buffer for file reading   
            String str;
 
            // reading line by line from file    
            while ((str = in.readLine()) != null) { 
                str = str.toLowerCase(); // convert to lower case 
 
                // starting index, we'll use this to copy words from string 
                int idx1 = -1;
                // process each characters  
                for (int i = 0; i < str.length(); i++) { 
                    // trigger condition if current character is not letter 
                    // or it is the end of line  
                    if ((!Character.isLetter(str.charAt(i))) || (i + 1 == str.length())) { 
                        // do nothing if previous character was also non-letter 
                        if (i - idx1 > 1) { 

                            if (Character.isLetter(str.charAt(i))) 
                                i++;
 
                            // copying...  
                            String word = str.substring(idx1 + 1, i);
 
                            // Check if word is in HashMap 
                            if (wordcount.containsKey(word)) { 
                                // counts  
                                wordcount.put(word, wordcount.get(word) + 1);
                            } else { 
                                // this is first time we see this word, set value '1' 
                                wordcount.put(word, 1);
                            } 
                        } 
 
                        // remember current position as last non-letter symbol                         
                        idx1 = i;
                    } 
                } 
            } 
            // Close buffered reader 
            in.close();
        } catch (Exception e) { 
            //error msg
            e.printStackTrace();
            System.exit(1);
        } 
 
        // This code sorts outputs HashMap sorting it by values 
 
        // First we're getting values array  
        ArrayList<Integer> values = new ArrayList<Integer>();
        values.addAll(wordcount.values());
        // and sorting it (in reverse order) 
        Collections.sort(values, Collections.reverseOrder());
 
        int last_i = -1;
        // loop 
        for (Integer i : values) { 
            if (last_i == i) // without duplicates  
                continue;
            last_i = i;
            // output
            for (String s : wordcount.keySet()) { 
                if (wordcount.get(s) == i) // which have this value  
                    System.out.println(s + ":" + i);
            } 
            // it is ok and works  
        } 
    } 
    
}
