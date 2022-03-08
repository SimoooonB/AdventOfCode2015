package Day03;

public class House {
    int x;
    int y;
    int presents = 0;

    public House(int x,int y,int presents){
        this.x = x;
        this.y = y;
        this.presents = presents;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getPresents(){
        return presents;
    }

    public boolean hasNoPresents(){
        return presents == 0;
    }

    public void givePresent(){
        presents++;
    }
}
