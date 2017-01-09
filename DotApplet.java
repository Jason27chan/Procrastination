import java.awt.*;
import javax.swing.*;
import java.util.*;
public class DotApplet extends JApplet
{
    private final int APPLET_WIDTH = 700;
    private final int APPLET_HEIGHT = 400;
    private final int dotCount=4000;

    private static Random generator=new Random(); 
    Dot[] d=new Dot [dotCount];
    public void init()
    {
        setBackground(Color.white);
        setSize(APPLET_WIDTH, APPLET_HEIGHT);
        for (int i=0; i<dotCount; i++)
        {
            d[i]= new Dot(APPLET_WIDTH, APPLET_HEIGHT);

        }
    }

    public void pause( int count)
    {
        try 
        {
            Thread.sleep(count);
        }
        catch (InterruptedException e)
        {
            System.out.print("got interupted!");  
        }
    }

    public void paint(Graphics g)
    {
        for (int i=0; i<dotCount; i++)
        {
            d[i].draw(g);
            pause(2);
        }

        for (int i=0; i<dotCount;i++)
        {
            int width= APPLET_WIDTH/9;
            int LeftStripeEdge= (d[i].getColorNumber()-1)*width;
            int newX = generator.nextInt(width)+LeftStripeEdge;
            int newY=d[i].getY();
            d[i].teleport(g,newX, newY);
            pause(2);
        }
        
        
        
        for (int i=0; i<dotCount; i++)
        {
            int width= APPLET_WIDTH/3;
            int height= APPLET_HEIGHT/3;
            int LeftBoxEdge= ((d[i].getColorNumber()-1)%3)*width;
            int BottomBoxEdge= ((d[i].getColorNumber()-1)/3)*height;
            int getX=generator.nextInt(width)+LeftBoxEdge;
            int getY=generator.nextInt(height)+BottomBoxEdge;
            d[i].grid(g,getX,getY);
            pause(2);
        }
    }
}
