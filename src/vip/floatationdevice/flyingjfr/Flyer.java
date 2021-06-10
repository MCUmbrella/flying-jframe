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
    double sx=new Random().nextDouble(), sy=new Random().nextDouble(); // Base X & Y movement speed
    double ax=new Random().nextDouble()%0.01;// // X acceleration
    double ay=new Random().nextDouble()%0.01;// // Y acceleration
    boolean negx=new Random().nextBoolean(), negy=new Random().nextBoolean(); // Controls movement direction
    public void reset()
    {
        //sizex=100; sizey=100;
        x=MAX_X/2-sizex; y=MAX_Y/2-sizey;
        sx=new Random().nextDouble(); sy=new Random().nextDouble();
        if(new Random().nextBoolean())sx*=-1;if(new Random().nextBoolean())sy*=-1;
    }
    
    Flyer()
    {
        if(new Random().nextBoolean())sx*=-1;if(new Random().nextBoolean())sy*=-1;
        setSize(sizex,sizey);
        add(new JButton(""+(new Random().nextDouble()+0)%0.01));
        setLocation((int)x,(int)y);
        
        ActionListener taskPerformer=new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                if(x>MAX_X*1.5||y>MAX_Y*1.5||x<MAX_X*-1||y<MAX_Y*-1){reset();} // Reset window location & size if it flew out of the screen
                x+=sx;y+=sy;
                sx*=(ax+1);
                sy*=(ay+1);
                setLocation((int)x,(int)y);
            }
        };
        new Timer(10,taskPerformer).start(); // Start flying
    }
    
}
