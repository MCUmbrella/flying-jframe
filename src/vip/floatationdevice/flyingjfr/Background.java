package vip.floatationdevice.flyingjfr;

import javax.swing.JFrame;
import javax.swing.JPanel;

import static vip.floatationdevice.flyingjfr.Main.MAX_X;
import static vip.floatationdevice.flyingjfr.Main.MAX_Y;

import java.awt.Color;
public class Background extends JFrame
{
    private static final long serialVersionUID = 1L;
    Background()
    {
        setUndecorated(true);
        setSize(MAX_X,MAX_Y);
        setLocation(0,0);
        JPanel j=new JPanel();
        j.setBackground(Color.black);
        add(j);
    }
}
