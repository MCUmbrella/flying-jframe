package vip.floatationdevice.flyingjfr;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main
{
    public static final int MAX_X=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int MAX_Y=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    public static final String IMG_URLS[]=// Images used
    {
        "/resources/ico0.png",
        "/resources/ico1.png",
        "/resources/ico2.png",
        "/resources/ico3.png",
        "/resources/ico4.png",
        "/resources/ico5.png",
        "/resources/ico6.png"
    };
    public final static KeyListener KL=new KeyListener()
    {
        @Override
        public void keyTyped(KeyEvent e){}
        @Override
        public void keyPressed(KeyEvent e){System.exit(0);}
        @Override
        public void keyReleased(KeyEvent e){}
    };
    
    public static void main(String args[])
    {
        new Background().setVisible(true);
        for(int i=0;i!=30;i++)
        {
            new Flyer().setVisible(true);
            try
            {
                Thread.sleep(400);
            }catch(Throwable e){}
        }
    }
}
