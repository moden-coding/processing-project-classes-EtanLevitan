import processing.core.PApplet;
import processing.core.PImage;

public class Snake {
    private int length;
    private int snakex;
    private int snakey;
    private PApplet draw;
    private int speedx;
    private int speedy;
    private boolean alive;
    private PImage jew;
    // private int newsnakex;
    // private int newsnakey;
    private int newsnakexy;

    public Snake(int length, int snakex, int snakey, PApplet d) {
        this.length = 50;
        this.snakex = snakex;
        this.snakey = snakey;
        // this.newsnakex = newsnakex;
        // this.newsnakey = newsnakey;
        draw = d;
        speedx = 5;
        speedy = 5;
        alive = true;
        jew = draw.loadImage("Jew.jpg");
        jew.resize(50, 50);
    }

    public void moveright() {
        snakex += speedx;
    }

    public void moveleft() {
        snakex -= speedx;
    }

    public void moveup() {
        snakey -= speedy;
    }

    public void movedown() {
        snakey += speedy;
    }

    public void display() {
        if (alive == true) {
           
        }
         draw.image(jew, snakex, snakey);
        // draw.square(snakex + speedx, snakey + speedy, length);
    }

    public boolean isdead() {
        if (alive == true) {
            if ((snakex > draw.width || snakex < 0) || (snakey > draw.height || snakey < 0)) {
                alive = false;
                return true;
            }

        }
        return false;

    }

    public void endgame() {
        if (alive == false) {

        }
    }

    public int X() {
        return snakex;
    }

    public int Y() {
        return snakey;
    }

    public void snakereset() {
        snakex = 70;
        snakey = 400;
        alive = true;
    }

    public void setPosition(int xPos, int yPos){
        snakex = xPos;
        snakey = yPos;
    }
    public void X(int X) {
        snakex = X;
    }

    public void Y(int Y) {
        snakey = Y;
    }

    // public int newsnakex() {
    //     return newsnakex;
    // }

    // public int newsnakey() {
    //     return newsnakey;
    // }

}
