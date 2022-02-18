package Day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day1 {
    private final static String path = "src\\Day01\\input.txt";
    private final static ArrayList<String> input = getInput();

    public static void main(String[] args){
        System.out.println("Part 1:");
        teil1();

        System.out.println("Part 2:");
        teil2();
    }

    public static void teil1(){
        int floor = 0;
        String parenthesis = input.get(0);
        for(int i = 0;i<parenthesis.length();i++){
            if(parenthesis.charAt(i) == '('){
                floor++;
            }else{
                floor--;
            }
        }
        System.out.println(floor);
    }

    public static void teil2(){
        int floor = 0;
        String parenthesis = input.get(0);
        for(int i = 0;i<parenthesis.length();i++){
            if(parenthesis.charAt(i) == '('){
                floor++;
            }else{
                floor--;
            }
            if(floor < 0){
                System.out.println(i+1);
                break;
            }
        }
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
