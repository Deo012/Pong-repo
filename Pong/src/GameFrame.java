import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

//the extends allow to use GameFrame as a Jframe
public class GameFrame extends JFrame{

    GamePanel panel;

    GameFrame(){
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ends the application when we hit the x button
        this.pack(); //the frame is gonna fit his size to the components we are gonna put in (the panel)
        this.setVisible(true);
        this.setLocationRelativeTo(null); //the frame appears in the middle of the screen
    }

}
