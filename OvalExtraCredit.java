import java.applet.Applet;
import javax.swing.*;
import java.awt.*;
public class OvalExtraCredit extends Applet
{
    int x = 91;
    public void paint(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillOval(1,1,3*15,4*15);
        g.setColor(Color.RED);
        g.fillOval(46,1,3*15,4*15);
    }

    public void update(Graphics g)
    {
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        g.setColor(Color.BLUE);
        g.fillOval(x+45,1,3*15,4*15);
        x+=45;
    }
}
