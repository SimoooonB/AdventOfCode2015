package Day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day3 {
    private final static String path = "src\\Day03\\input.txt";
    private final static ArrayList<String> input = getInput();

    public static void main(String[] args){
        System.out.println("Part 1:");
        teil1();

        System.out.println("Part 2:");
        teil2();
    }

    public static void teil1(){
        String directions = input.get(0);
        int x = 0;
        int y = 0;
        ArrayList<House> houses = new ArrayList<>();

        houses.add(new House(x,y,1));

        for(int i=0;i<directions.length();i++){
            switch(directions.charAt(i)){
                case '^' -> y++;
                case 'v' -> y--;
                case '<' -> x--;
                case '>' -> x++;
            }
            boolean houseAlreadyVisited = false;
            for(House h : houses){
                if(h.getX() == x && h.getY() == y){
                    houseAlreadyVisited = true;
                }
            }
            if(!houseAlreadyVisited){
                houses.add(new House(x,y,1));
            }
        }
        System.out.println(houses.size());
    }

    public static void teil2(){
        String directions = input.get(0);
        int x = 0;
        int y = 0;
        int x2 = 0;
        int y2 = 0;
        ArrayList<House> houses = new ArrayList<>();

        houses.add(new House(x,y,1));

        for(int i=0;i<directions.length();i++){

            switch(directions.charAt(i)){
                case '^' -> y++;
                case 'v' -> y--;
                case '<' -> x--;
                case '>' -> x++;
            }
            boolean houseAlreadyVisited = false;
            for(House h : houses){
                if(h.getX() == x && h.getY() == y){
                    houseAlreadyVisited = true;
                }
            }
            if(!houseAlreadyVisited){
                houses.add(new House(x,y,1));
            }


            i++;
            if(i>=directions.length()){break;}
            switch(directions.charAt(i)){
                case '^' -> y2++;
                case 'v' -> y2--;
                case '<' -> x2--;
                case '>' -> x2++;
            }
            houseAlreadyVisited = false;
            for(House h : houses){
                if(h.getX() == x2 && h.getY() == y2){
                    houseAlreadyVisited = true;
                }
            }
            if(!houseAlreadyVisited){
                houses.add(new House(x2,y2,1));
            }

        }
        System.out.println(houses.size());
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
