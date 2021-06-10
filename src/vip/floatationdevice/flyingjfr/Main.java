package vip.floatationdevice.flyingjfr;

import java.awt.Toolkit;

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
