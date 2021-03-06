package vip.floatationdevice.flyingjfr;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;

import static vip.floatationdevice.flyingjfr.Main.MAX_X;
import static vip.floatationdevice.flyingjfr.Main.MAX_Y;
import static vip.floatationdevice.flyingjfr.Main.KL;
import static vip.floatationdevice.flyingjfr.Main.IMG_URLS;
import static vip.floatationdevice.flyingjfr.Main.imgs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Flyer extends JFrame
{
    private static final long serialVersionUID = 1L; // what
    int imgnum=new Random().nextInt(IMG_URLS.length); // Select one image
    Image img=imgs.get(imgnum); // Load the image
    int sizex, sizey; // Standard window size based on image size
    double sizemultiplier=0.01; // Window size multiplier
    double x=MAX_X/2, y=MAX_Y/2; // Window location
    double sx=new Random().nextDouble(), sy=new Random().nextDouble(); // Base X & Y movement speed
    double a=new Random().nextDouble()%0.03; // Acceleration
    
    Flyer()
    {
        try
        {
            BufferedImage b=ImageIO.read(getClass().getResource(IMG_URLS[imgnum]));
            sizex=b.getWidth();
            sizey=b.getHeight();
        }catch(Throwable e){e.printStackTrace();System.exit(-1);}
        setUndecorated(true);
        setBackground(new Color(0f,0f,0f,0f));
        if(new Random().nextBoolean())sx*=-1;if(new Random().nextBoolean())sy*=-1;
        setLocation((int)x,(int)y);
        
        ActionListener taskPerformer=new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                sizemultiplier=(0.01+Math.sqrt(Math.pow(MAX_X/2-x,2)+Math.pow(MAX_Y/2-y,2))*0.001)*(1+a*50); // The most confusing line ever
                if(x>MAX_X||y>MAX_Y||x<-sizex*3||y<-sizey*3){reset();} // Reset window location & size if it flew out of the screen
                x+=sx;y+=sy;
                sx*=(a+1);
                sy*=(a+1);
                setSize((int)(sizex*sizemultiplier),(int)(sizey*sizemultiplier));
                setLocation((int)x,(int)y);
            }
        };
        addKeyListener(KL);
        new Timer(25,taskPerformer).start(); // Start flying
    }
    
    void reset()
    {// Put the window back in the screen's center & select a new image
        imgnum=new Random().nextInt(IMG_URLS.length);
        try
        {
            BufferedImage b=ImageIO.read(getClass().getResource(IMG_URLS[imgnum]));
            sizex=b.getWidth();
            sizey=b.getHeight();
        }catch(Throwable e){e.printStackTrace();System.exit(-1);}
        sizemultiplier=0.01;
        x=MAX_X/2; y=MAX_Y/2;
        img=imgs.get(imgnum);
        sx=new Random().nextDouble(); sy=new Random().nextDouble();
        a=new Random().nextDouble()%0.03;
        if(new Random().nextBoolean())sx*=-1;if(new Random().nextBoolean())sy*=-1;
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g)
    {// Auto resize image
        g.drawImage(img,0,0,(int)(sizex*sizemultiplier),(int)(sizey*sizemultiplier),this);
    }
}
