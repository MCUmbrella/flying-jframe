package vip.floatationdevice.flyingjfr;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

import static vip.floatationdevice.flyingjfr.Main.MAX_X;
import static vip.floatationdevice.flyingjfr.Main.MAX_Y;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Flyer extends JFrame
{
    private static final long serialVersionUID = 1L; // what
    int sizex=100, sizey=100; // Initial window size
    double x=MAX_X/2-sizex, y=MAX_Y/2-sizey; // Initial window location
    double addx=new Random().nextDouble(), addy=new Random().nextDouble(); // Base X & Y movement speed
    double speedx=new Random().nextDouble()%0.01;// // X acceleration
    double speedy=new Random().nextDouble()%0.01;// // Y acceleration
    boolean negx=new Random().nextBoolean(), negy=new Random().nextBoolean(); // Controls movement direction
    public void reset()
    {
        sizex=100; sizey=100;
        x=MAX_X/2-sizex; y=MAX_Y/2-sizey;
        addx=new Random().nextDouble(); addy=new Random().nextDouble();
    }
    
    Flyer()
    {
        //reset();
        //if(negx) {speedx*=-1;addx*=-1;}
        //if(negy) {speedy*=-1;addy*=-1;}
        setSize(sizex,sizey);
        add(new JButton(""+(new Random().nextDouble()+0)%0.01));
        setLocation((int)x,(int)y);
        
        ActionListener taskPerformer=new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                if(x>MAX_X*1.5||y>MAX_Y*1.5||x<MAX_X*-1||y<MAX_Y*-1){reset();} // Reset window location & size if it flew out of the screen
                x+=addx;y+=addy;
                addx*=(speedx+1);
                addy*=(speedy+1);
                setLocation((int)x,(int)y);
            }
        };
        new Timer(10,taskPerformer).start(); // Start flying
    }
    
}
