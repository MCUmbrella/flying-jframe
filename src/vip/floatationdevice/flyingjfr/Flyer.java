package vip.floatationdevice.flyingjfr;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;

import static vip.floatationdevice.flyingjfr.Main.MAX_X;
import static vip.floatationdevice.flyingjfr.Main.MAX_Y;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Flyer extends JFrame
{
    private static final long serialVersionUID = 1L; // what
    final String imgurls[]=// Images used
    {
        "/resources/ico0.png",
        "/resources/ico1.png",
        "/resources/ico2.png",
        "/resources/ico3.png",
        "/resources/ico4.png",
        "/resources/ico5.png",
        "/resources/ico6.png"
    };
    final String imgurl=imgurls[new Random().nextInt(imgurls.length)];// Select one image
    final Image img=Toolkit.getDefaultToolkit().getImage(getClass().getResource(imgurl));// Load the image
    //int sizex=124, sizey=104; // Initial window size
    int sizex, sizey; // Standard window size based on image size
    int sizemultiplier=0; // Window size multiplier
    double x, y; // Initial window location
    double sx=new Random().nextDouble(), sy=new Random().nextDouble(); // Base X & Y movement speed
    double a=new Random().nextDouble()%0.03;// Acceleration
    
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
        try
        {
            BufferedImage b=ImageIO.read(getClass().getResource(imgurl));
            sizex=b.getWidth();
            sizey=b.getHeight();
        }catch(Throwable e){e.printStackTrace();System.exit(-1);}
        System.out.println(sizex+", "+sizey);
        setUndecorated(true);
        if(new Random().nextBoolean())sx*=-1;if(new Random().nextBoolean())sy*=-1;
        setSize(sizex,sizey);
        x=(MAX_X-sizex)/2;
        y=(MAX_Y-sizey)/2;
        setLocation((int)x,(int)y);
        
        ActionListener taskPerformer=new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                if(x>MAX_X||y>MAX_Y||x<-sizex||y<-sizey){reset();} // Reset window location & size if it flew out of the screen
                x+=sx;y+=sy;
                sx*=(a+1);
                sy*=(a+1);
                setLocation((int)x,(int)y);
            }
        };
        addKeyListener(KL);
        new Timer(25,taskPerformer).start(); // Start flying
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
        g.drawImage(img, 0, 0, sizex, sizey, Color.BLACK, this);
    }
    
}
