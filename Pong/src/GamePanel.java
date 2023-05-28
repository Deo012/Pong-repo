import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

//the extend allow to use GamePanel as a JPanel
public class GamePanel extends JPanel implements Runnable{

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * 0.5555);
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;

    GamePanel(){
        newPaddle();
        newBall();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();

    }

    public void newBall(){

    }
    public void newPaddle(){

    }
    public void paint(Graphics g){

    }
    public void draw(Graphics g){

    }
    public void move(){

    }
    public void checkCollision(){

    }
    public void run(){

    }
    //Action-listener method for the GamePanel
    //those keyPressed-released methods will cal the pressed/released of the paddle
    public class AL extends KeyAdapter {
        public void KeyPressed(KeyEvent e){

        }
        public void KeyReleased(KeyEvent e){

        }
    }
}
