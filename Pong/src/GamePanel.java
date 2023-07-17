import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

//the extend allow to use GamePanel as a JPanel
public class GamePanel extends JPanel implements Runnable{

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (5.0/9.0));
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
        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        this.setFocusable(true); //if i click on the game window it will start recognizing keyboard input
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();

    }

    public void newBall(){

    }
    public void newPaddles(){
        paddle1 = new Paddle(0,(GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        paddle2 = new Paddle((GAME_WIDTH-PADDLE_WIDTH),(GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
    }
    public void paint(Graphics g){
        image = createImage(this.getWidth(), this.getHeight()); //create an image
        graphics = image.getGraphics(); //open the acess to draw on that image
        draw(graphics); //the drawing on the image happens here
        g.drawImage(image,0,0,this); //put the masterpiece on the panel
    }
    public void draw(Graphics g){
        paddle1.draw(g);
        paddle2.draw(g);
    }
    public void move(){
        paddle1.move();
        paddle2.move();
    }
    public void checkCollision(){
        //stops paddles at windows edges
        if(paddle1.y <= 0){
            paddle1.y = 0; //he is stuck at 0 (on top of the screen)
        }
        if(paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT)){
            paddle1.y = (GAME_HEIGHT-PADDLE_HEIGHT); //same thing here but at the buttom
        }
        if(paddle2.y <= 0){
            paddle2.y = 0; //he is stuck at 0 (on top of the screen)
        }
        if(paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT)){
            paddle2.y = (GAME_HEIGHT-PADDLE_HEIGHT); //same thing here but at the buttom
        }
    }
    public void run(){
        //game loop
        long lastTime = System.nanoTime(); //retrive pc time in nanoseconde
        double amountOfTicks = 60.0; //varable that tells the pc how many game update we want in a second
        double ns = 1000000000 / amountOfTicks; //variable that calculates the duration of each ticks to be able to fit them in a second (1000000000 is 1 seconde in nanoseconds)
        double delta = 0;
        while(true){
            long now =System.nanoTime();
            delta = delta + (now - lastTime)/ns; //calculates if enough time has passed(in ticks) to trigger a new update
            lastTime = now;
            if(delta >= 1){ //if delta = 1 enough time has passed
                move(); //update game internal state
                checkCollision();
                repaint();//draw the new internal state
                delta--;
            }
        }
    }
    //Action-listener method for the GamePanel
    //those keyPressed/keyReleased methods will call the mothodes pressed/released of the paddle
    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e){
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
}
