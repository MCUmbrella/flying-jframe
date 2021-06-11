package vip.floatationdevice.flyingjfr;

import java.awt.Image;
import java.awt.Toolkit;


public class Main
{
    public static final int MAX_X=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int MAX_Y=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    public final static Image IMG[]=
    {
        Toolkit.getDefaultToolkit().getImage("./ico0.png"),
        Toolkit.getDefaultToolkit().getImage("./ico1.png"),
        Toolkit.getDefaultToolkit().getImage("./ico2.png"),
        Toolkit.getDefaultToolkit().getImage("./ico3.png"),
        Toolkit.getDefaultToolkit().getImage("./ico4.png"),
        Toolkit.getDefaultToolkit().getImage("./ico5.png"),
        Toolkit.getDefaultToolkit().getImage("./ico6.png")
    };

    public static void main(String args[])
    {
        
        new Thread()
        {
            @Override
            public void start()
            {
                new Background().setVisible(true);
                for(int i=1;i!=30;i++)
                {
                    new Flyer().setVisible(true);
                    try
                    {
                        Thread.sleep(300);
                    }catch(Throwable e){}
                }
            }
        }.start();
    }
}
