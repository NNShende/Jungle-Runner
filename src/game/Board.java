package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener{
    Dude p;
    Image img;
    Timer time;
    int x = 0;
    public Board(){
        p = new Dude();
        addKeyListener(new AL());
        setFocusable(true);
        ImageIcon i = new ImageIcon("src\\game\\jungle.png");
        img = i.getImage();
        time = new Timer(5, this);
        time.start();
    }
    
    public void actionPerformed(ActionEvent e){
        repaint();
    }
    
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img,x, 0,null);
        g2d.drawImage(img,900 + x,0,null);
        if(x <= -900){
            x = 0;
        }
        g2d.drawImage(p.getImage(),50,p.y,null);
        if(!p.jump){
            p.animation();
        }
        else{
            p.jump();
        }
        x-=2;
    }
    
    private class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_SPACE){
                p.jump = true;
            }
        }
        
        public void keyReleased(KeyEvent e){
            
        }
    }
}
