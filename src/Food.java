import processing.core.PApplet;
import processing.core.PImage;

public class Food {
    private int foodX;
    private int foodY;
    private int size;
    private boolean isAppeared;
    private boolean firstfood;
    private PImage matzah;
    private PApplet draw;
    private boolean eaten;
    private boolean eaten2;

    int randomNumx = (int) (Math.random() * (1450 - 50 + 1)) + 50;
    int randomNumy = (int) (Math.random() * (800 - 50 + 1)) + 50;

    public Food(int foodX, int foodY, int size, PApplet d) {
        size = 50;
        this.foodX = foodX;
        this.foodY = foodY;
        isAppeared = true;
        firstfood = true;
        draw = d;
        eaten = false;
        matzah = draw.loadImage("mawtzav2.png");
        matzah.resize(75, 50);
        eaten2 = false;
    }

    public void appear() {
        if (eaten == false) {
            draw.image(matzah, foodX, foodY);
        } else {
            foodX = randomNumx;
            foodY = randomNumy;
            draw.image(matzah, foodX, foodY);
            eaten = false;
        }

    }

    public int getx() {
        return foodX;
    }

    public int gety() {
        return foodY;
    }

    public void eaten() {
        eaten = true;

    }

    public void randoms() {
        randomNumx = (int) (Math.random() * (1450 - 50 + 1)) + 50;
        randomNumy = (int) (Math.random() * (800 - 50 + 1)) + 50;
    }
    public void foodreset(){
        foodX=900;
        foodY=400;
        eaten=false;
    }

}