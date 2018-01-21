package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Dude {
    public boolean alive = true;
    public boolean jump = false;
    int count = 0;
    public int y = 330;
    boolean jumpUp = true;
    ImageIcon imgWalk1 = new ImageIcon("src\\game\\soldier\\poses\\soldier_walk1.png");
    ImageIcon imgWalk2 = new ImageIcon("src\\game\\soldier\\poses\\soldier_walk2.png");
    ImageIcon imgJump = new ImageIcon("src\\game\\soldier\\poses\\soldier_jump.png");
    ImageIcon imgFall = new ImageIcon("src\\game\\soldier\\poses\\soldier_fall.png");
    Image still = imgWalk1.getImage();
    boolean right = true;
    boolean walk1 = true;
    public Dude(){
    }

    
    public Image getImage() {
        return still;
    }

    public void animation(){
        count++;
        if(count == 15){
            count = 0;
            if(walk1){
                walk1 = false;
                still = imgWalk2.getImage();
            }
            else{
                walk1 = true;
                still = imgWalk1.getImage();
            }
            
        }
    }
    
    public void jump(){
        if(jumpUp){
            y--;
            still = imgJump.getImage();
        }
        else{
            y++;
            still = imgFall.getImage();
        }
        if(jumpUp && y <= 230){
            jumpUp = false;
        }
        if(!jumpUp && y >= 330){
            jumpUp = true;
            jump = false;
        }
    }
    
}
