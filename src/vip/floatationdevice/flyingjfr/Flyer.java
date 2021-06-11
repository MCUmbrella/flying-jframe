package vip.floatationdevice.flyingjfr;

import javax.swing.JFrame;
import javax.swing.Timer;

import static vip.floatationdevice.flyingjfr.Main.MAX_X;
import static vip.floatationdevice.flyingjfr.Main.MAX_Y;
import static vip.floatationdevice.flyingjfr.Main.IMG;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Flyer extends JFrame
{
    private static final long serialVersionUID = 1L; // what
    int sizex=124, sizey=104; // Initial window size
    double x=MAX_X/2-sizex, y=MAX_Y/2-sizey; // Initial window location
    double sx=new Random().nextDouble(), sy=new Random().nextDouble(); // Base X & Y movement speed
    double a=new Random().nextDouble()%0.01;// Acceleration
    public void reset()
    {
        //sizex=100; sizey=100;
        x=MAX_X/2-sizex; y=MAX_Y/2-sizey;
        sx=new Random().nextDouble(); sy=new Random().nextDouble();
        if(new Random().nextBoolean())sx*=-1;if(new Random().nextBoolean())sy*=-1;
        setVisible(true);
    }
    
    Flyer()
    {
        setUndecorated(true);
        if(new Random().nextBoolean())sx*=-1;if(new Random().nextBoolean())sy*=-1;
        setSize(sizex,sizey);
        setLocation((int)x,(int)y);
        
        ActionListener taskPerformer=new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                if(x>MAX_X*1.5||y>MAX_Y*1.5||x<MAX_X*-0.5||y<MAX_Y*-0.5){reset();} // Reset window location & size if it flew out of the screen
                x+=sx;y+=sy;
                sx*=(a+1);
                sy*=(a+1);
                setLocation((int)x,(int)y);
            }
        };
        addKeyListener(KL);
        new Timer(10,taskPerformer).start(); // Start flying
    }
    
    final static KeyListener KL=new KeyListener()
    {
        @Override
        public void keyTyped(KeyEvent e){}
        @Override
        public void keyPressed(KeyEvent e){System.exit(0);}
        @Override
        public void keyReleased(KeyEvent e){}
    };
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(IMG[new Random().nextInt(IMG.length)], 0, 0, sizex, sizey, Color.BLACK, this);
    }
    
}
