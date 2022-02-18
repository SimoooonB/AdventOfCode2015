package Day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.SourceDataLine;

public class Day02 {
    private final static String path = "src\\Day02\\input.txt";
    private final static ArrayList<String> input = getInput();

    public static void main(String[] args){
        System.out.println("Part 1:");
        teil1();

        System.out.println("Part 2:");
        teil2();
    }

    public static void teil1(){
        int amountOfWrappingPaper = 0;
        for(String line:input){
            String[] values = line.split("x");
            int l = Integer.parseInt(values[0]);
            int w = Integer.parseInt(values[1]);
            int h = Integer.parseInt(values[2]);
            int min = l*w;
            if(w*h < min){min = w*h;}
            if(l*h < min){min = l*h;}
            amountOfWrappingPaper += 2*l*w + 2*w*h + 2*h*l + min;
        }
        System.out.println("Amount of wrapping paper needed: " + amountOfWrappingPaper);
    }

    public static void teil2(){
        int amountOfRibbonNeeded = 0;
        for(String line:input){
            String[] values = line.split("x");
            int l = Integer.parseInt(values[0]);
            int w = Integer.parseInt(values[1]);
            int h = Integer.parseInt(values[2]);
            int volume = l*w*h;
            amountOfRibbonNeeded += volume;
            if(l>=w && l>=h){
                amountOfRibbonNeeded += 2*(w+h);
            }else if(w>=l && w>=h){
                amountOfRibbonNeeded += 2*(l+h);
            }else{
                amountOfRibbonNeeded += 2*(l+w);
            }
        }
        System.out.println("Amount of Ribbon needed: " + amountOfRibbonNeeded);
    }

    private static ArrayList<String> getInput(){
        try{
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line;
                ArrayList<String> input = new ArrayList<>();
                while((line = br.readLine()) != null){
                    input.add(line);
                }
                return input;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
