package vip.floatationdevice.flyingjfr;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Main
{
    public static final int MAX_X=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int MAX_Y=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    public static final String IMG_URLS[]=// Images used (path)
    {
        "/resources/ico0.png",
        "/resources/ico1.png",
        "/resources/ico2.png",
        "/resources/ico3.png",
        "/resources/ico4.png",
        "/resources/ico5.png",
        "/resources/ico6.png"
    };
    public static ArrayList<Image> imgs=new ArrayList<Image>(); // Images used (Image object)
    public final static KeyListener KL=new KeyListener()
    {// Press any key to exit
        @Override
        public void keyTyped(KeyEvent e){}
        @Override
        public void keyPressed(KeyEvent e){System.exit(0);}
        @Override
        public void keyReleased(KeyEvent e){}
    };
    
    // Startup
    public static void main(String args[])
    {
        for(int a=0;a!=IMG_URLS.length;a++){imgs.add(Toolkit.getDefaultToolkit().getImage(Main.class.getResource(IMG_URLS[a])));} // Initialize image list
        new Background().setVisible(true); // Show a black background
        for(int i=0;i!=30;i++)
        {
            new Flyer().setVisible(true); // Initialize a flying JFrame window
            try{Thread.sleep(400);}catch(Throwable e){} // Wait 400ms
        }
    }// End
}
