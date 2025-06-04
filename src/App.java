import java.util.ArrayList;

import processing.core.*;

public class App extends PApplet {
    Snake snake;
    Food food;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    boolean goingup = false;
    boolean goingdown = false;
    boolean goingright = false;
    boolean goingleft = false;
    boolean isgoing = false;
    PImage Money;
    int stage = 0;
    boolean collisions;
    int newsnakex = -50;
    int newsnakey = -50;
    ArrayList<Snake> snakes = new ArrayList<>();
    int count = snakes.size();

    public void setup() {
        Money = loadImage("Money.jpg");
        Money.resize(1500, 800);
        snake = new Snake(50, 70, 400, this);
        food = new Food(900, 400, 50, this);
    }

    public void settings() {
        size(1500, 800);
    }

    public void draw() {
        background(Money);
        if (stage == 0) {
            background(Money);
            textSize(75);
            textAlign(CENTER, CENTER);
            text("Press space to play jewgle snake", 750, 400);
        } else if (stage == 1) {
            food.appear();
            snake.display();
            movedirection();
            collision();
            if (snakes.size() > 0) {
                snakes.get(0).setPosition(snake.X(), snake.Y());
            }
            drawnewsnakes();
            if (snakes.size() > 0) {
                for (int i = 1; i < snakes.size(); i++) {
                    Snake currentSnake = snakes.get(i);
                    Snake previousSnake = snakes.get(i - 1);
                    currentSnake.setPosition(previousSnake.X(), previousSnake.Y());
                }
            }
            count = snakes.size();
            System.out.println(count);
            if (snake.isdead() == true) {
                stage = 5;
            }
            if (collisions == true) {
                food.eaten();
                food.randoms();

                if (snakes.size() == 0) {
                    if (goingright == true) {
                        snakes.add(new Snake(50, snake.X() - 50, snake.Y(), this));
                    }
                    if (goingleft == true) {
                        snakes.add(new Snake(50, snake.X() + 50, snake.Y(), this));
                    }
                    if (goingdown == true) {
                        snakes.add(new Snake(50, snake.X(), snake.Y() - 50, this));
                    }
                    if (goingup == true) {
                        snakes.add(new Snake(50, snake.X(), snake.Y() + 50, this));
                    }
                } else if (snakes.size() > 0) {
                    Snake finalsnake = snakes.get(snakes.size() - 1);
                    if (goingright == true) {
                        snakes.add(new Snake(50, finalsnake.X() - 50, finalsnake.Y(), this));
                    }
                    if (goingleft == true) {
                        snakes.add(new Snake(50, finalsnake.X() + 50, finalsnake.Y(), this));
                    }
                    if (goingdown == true) {
                        snakes.add(new Snake(50, finalsnake.X(), finalsnake.Y() - 50, this));
                    }
                    if (goingup == true) {
                        snakes.add(new Snake(50, finalsnake.X(), finalsnake.Y() + 50, this));
                    }
                }

            }
        } else if (stage == 3) {
            snake.display();
            movedirection();
            snake.isdead();
        } else if (stage == 4) {

        } else if (stage == 5) {
            isgoing = false;
            textAlign(CENTER, CENTER);
            text("YOU DIED, Press space to play again", 750, 400);

        }

    }

    public void keyPressed() {

        if (key == 'p') {
            if (snakes.size() == 0) {
                if (goingright == true) {
                    snakes.add(new Snake(50, snake.X() - 50, snake.Y(), this));
                }
                if (goingleft == true) {
                    snakes.add(new Snake(50, snake.X() + 50, snake.Y(), this));
                }
                if (goingdown == true) {
                    snakes.add(new Snake(50, snake.X(), snake.Y() - 50, this));
                }
                if (goingup == true) {
                    snakes.add(new Snake(50, snake.X(), snake.Y() + 50, this));
                }
            } else if (snakes.size() > 0) {
                Snake finalsnake = snakes.get(snakes.size() - 1);
                if (goingright == true) {
                    snakes.add(new Snake(50, finalsnake.X() - 50, finalsnake.Y(), this));
                }
                if (goingleft == true) {
                    snakes.add(new Snake(50, finalsnake.X() + 50, finalsnake.Y(), this));
                }
                if (goingdown == true) {
                    snakes.add(new Snake(50, finalsnake.X(), finalsnake.Y() - 50, this));
                }
                if (goingup == true) {
                    snakes.add(new Snake(50, finalsnake.X(), finalsnake.Y() + 50, this));
                }
            }
        }
        if (key == ' ' && isgoing == false) {
            isgoing = true;
            goingright = true;
            goingleft = false;
            goingdown = false;
            goingup = false;
            stage = 1;
            snake.snakereset();
            food.foodreset();
            snakes.clear();
        }
        if (key == 'w' && goingdown == false) {
            goingright = false;
            goingleft = false;
            goingdown = false;
            goingup = true;

        }
        if (key == 'd' && goingleft == false) {
            goingright = true;
            goingleft = false;
            goingdown = false;
            goingup = false;
        }
        if (key == 'a' && goingright == false) {
            goingright = false;
            goingleft = true;
            goingdown = false;
            goingup = false;
        }
        if (key == 's' && goingup == false) {
            goingright = false;
            goingleft = false;
            goingdown = true;
            goingup = false;
        }

    }

    public void movedirection() {
        if (!isgoing) {
            return;
        }
        if (goingdown == true) {
            snake.movedown();
        }
        if (goingleft == true) {
            snake.moveleft();
        }
        if (goingright == true) {
            snake.moveright();
        }
        if (goingup == true) {
            snake.moveup();
        }
    }

    public void collision() {
        if (food.getx() <= snake.X() + 50 && food.getx() + 50 >= snake.X() && food.gety() <= snake.Y() + 50
                && food.gety() + 50 >= snake.Y()) {
            collisions = true;
        } else {
            collisions = false;
        }
    }

    public void drawnewsnakes() {
        for (int i = 0; i < snakes.size(); i++) {
            snakes.get(i).display();

            // snakes.get(i).Y(snake.Y() + snakes.get(i).newsnakey());
            // snakes.get(i).X(snake.X() + snakes.get(i).newsnakex());
        }
    }

}
// public void setPosition(){
// for(int i=1; i < snakes.size();i++){
// snakes.get(i).X(snakes.get(i-1).X());
// snakes.get(i).Y(snakes.get(i-1).Y());
// }
// }
