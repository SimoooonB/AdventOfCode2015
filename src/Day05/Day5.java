package Day05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day5 {
    private final static String path = "src\\Day05\\input.txt";
    private final static ArrayList<String> input = getInput();

    public static void main(String[] args){
        System.out.println("Part 1:");
        teil1();

        System.out.println("Part 2:");
        teil2();
    }

    public static void teil1(){
        int niceStrings = 0;
        for(String s : input){
            if(isNice(s)){
                niceStrings++;
            }
        }
        System.out.println(niceStrings);
    }

    private static boolean isNice(String s){
        return containsThreeVowels(s) && containsDoubleLetter(s) && !containsBadStrings(s);
    }

    private static boolean containsThreeVowels(String s){
        int vowelCounter = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                vowelCounter++;
                if(vowelCounter >= 3){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean containsDoubleLetter(String s){
        char prev = s.charAt(0);
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if(c == prev){
                return true;
            }
            prev = c;
        }
        return false;
    }

    private static boolean containsBadStrings(String s){
        return s.contains("ab") || s.contains("cd") || s.contains("pq") || s.contains("xy");
    }

    public static void teil2(){
        int niceStrings = 0;
        for(String s : input){
            if(isNice2(s)){
                niceStrings++;
            }
        }
        System.out.println(niceStrings);
    }

    private static boolean isNice2(String s){
        return pairAppearsTwice(s) && repeatingLetter(s);
    }

    private static boolean pairAppearsTwice(String s){
        for(int i=0;i<s.length()-3;i++){
            String pair = s.substring(i, i+2);
            if(s.substring(i+2).contains(pair)){
                return true;
            }
        }
        return false;
    }

    private static boolean repeatingLetter(String s){
        for(int i=0;i<s.length()-2;i++){
            if(s.charAt(i) == s.charAt(i+2)){
                return true;
            }
        }
        return false;
    }

    private static ArrayList<String> getInput(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            ArrayList<String> input = new ArrayList<>();
            while((line = br.readLine()) != null){
                input.add(line);
            }
            return input;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
