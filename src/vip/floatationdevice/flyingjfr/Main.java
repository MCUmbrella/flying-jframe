package vip.floatationdevice.flyingjfr;

import java.awt.Toolkit;
import java.util.Random;

public class Main
{
    public static final int MAX_X=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int MAX_Y=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    public static void main(String args[])
    {
        new Thread()
        {
            @Override
            public void start()
            {
                for(int i=1;i!=20;i++)
                {
                    double speedx=(new Random().nextDouble()+1.003)%0.005,speedy=(new Random().nextDouble()+1.003)%0.005;
                    new Flyer(speedx,speedy).setVisible(true);
                    try
                    {
                        Thread.sleep(300);
                        System.gc();
                    }catch(Throwable e){}
                }
            }
        }.start();
    }
}
