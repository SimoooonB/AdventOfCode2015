package Day04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.security.*;

public class Day4 {
    private final static String path = "src\\Day04\\input.txt";
    private final static ArrayList<String> input = getInput();

    public static void main(String[] args){
        System.out.println("Part 1:");
        teil1();

        System.out.println("Part 2:");
        teil2();
    }

    public static void teil1(){
        for(int i = 1;i>0;i++){
            try {
                String hash = md5("ckczppom" + i);
                if(hash.startsWith("00000")){
                    System.out.println(i);
                    return;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }

    public static void teil2(){
        for(int i = 1;i>0;i++){
            try {
                String hash = md5("ckczppom" + i);
                if(hash.startsWith("000000")){
                    System.out.println(i);
                    return;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }

    public static String md5(String plaintext) throws NoSuchAlgorithmException{
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(plaintext.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while(hashtext.length() < 32 ){
        hashtext = "0"+hashtext;
        }
        return hashtext;
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
