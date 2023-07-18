import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Ball extends Rectangle{

    Random random;
    int xVelocity;
    int yVelocity;

    Ball(int x, int y, int width, int height){
        super(x,y,width,height);
        random = new Random();
        int randomXDirection = random.nextInt(2); //generates a random number between 0 and 2 (2 not included)
        //ici le random est soit 0 ou 1. Si c'Est 1 on vas vers X positif (a gauche). Sinon on vas a vers X negatif
        //c'Est pour ca il faut mettre 0 à -1
        if(randomXDirection == 0){
           randomXDirection--; //ca le bascule vers les négatifs pour le faire aller a gauche
        }
        setXDirection(randomXDirection);

        int randomYDirection = random.nextInt(2);
        if(randomYDirection == 0){
            randomYDirection--;
        }
        setYDirection(randomYDirection);
    }


    //when the ball is created it starts at the middle and go in a random direction
    public void setXDirection(int randomXDirection){
        xVelocity = randomXDirection;
    }
    public void setYDirection(int randomYDirection){
        yVelocity = randomYDirection;
    }
    public void move(){
        x += xVelocity;
        y += yVelocity;
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x,y,width,height);
    }
}
