package vip.floatationdevice.flyingjfr;

import javax.swing.JFrame;
import javax.swing.Timer;

import static vip.floatationdevice.flyingjfr.Main.MAX_X;
import static vip.floatationdevice.flyingjfr.Main.MAX_Y;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Flyer extends JFrame
{
    Flyer ins=this;
    private static final long serialVersionUID = 1L;
    int sizex=100, sizey=100;
    double x=MAX_X/2-sizex, y=MAX_Y/2-sizey;
    double addx=1, addy=1;
    
    public void reset()
    {
        sizex=100;
        sizey=100;
        x=MAX_X/2-sizex;
        y=MAX_Y/2-sizey;
        addx=1;
        addy=1;
    }
    
    Flyer(double sx,double sy)
    {
        setSize(sizex,sizey);
        setLocation((int)x,(int)y);
        
        ActionListener taskPerformer=new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                if(x>MAX_X*1.5||y>MAX_Y*1.5||x<MAX_X*-1||y<MAX_Y*-1){reset();}
                x+=addx;y+=addy;
                addx*=(sx+1);addy*=(sy+1);
                setLocation((int)x,(int)y);
            }
        };
        new Timer(10,taskPerformer).start();
    }
    
}
