import java.awt.*;
import javax.swing.*;
import java.util.Random;
public class Dot
{
    //instance variables 
    public final int APPLET_WIDTH = 900;
    public final int APPLET_HEIGHT = 900;
    private static Random generator= new Random();
    private int x; 
    private int y;
    private int radius;
    private Color mycolor;
    private int  ColorNum= generator.nextInt (9)+1;
    //constructors
    public Dot()
    {
        x=10;
        y=10;
        radius=8;
        mycolor=Color.cyan;
    }

    public Dot (int myX, int myY, int myRad, Color color)
    {
        x=myX;
        y=myY;
        radius= myRad;
        mycolor= color;
    }

    public Dot(Dot d)
    {
        x=d.x; 
        y=d.y;
        radius=d.radius;
        mycolor=d.mycolor;
    }

    public Color pickAColor()
    {

        switch (ColorNum)
        {
            case 1: return Color.red;
            case 2: return Color.pink;
            case 3: return Color.orange;
            case 4: return Color.yellow;
            case 5: return Color.green;
            case 6: return Color.cyan;
            case 7: return Color.blue;
            case 8: return Color.magenta;
            case 9: return Color.black;
            default: return Color.white;
        }

    }

    public int getColorNumber()
    {
        return ColorNum;
    }

    public Dot(int maxX, int maxY)
    {
        x=generator.nextInt(maxX);
        y=generator.nextInt(maxY);
        radius=8;
        mycolor= pickAColor();
    }

    public void draw(Graphics g)
    {
        g.setColor(mycolor);
        g.fillOval(x-radius,y-radius, 2*radius, 2*radius);
    }

    public void teleport (Graphics g, int newX, int newY)
    {
        erase(g);
        x=newX;
        y=newY;
        draw(g);
    }
    public void grid (Graphics g, int GridX, int GridY)
    {
        erase(g);
        x=GridX;
        y=GridY;
        draw(g);
    }

    public void erase(Graphics g)
    {
        Color eraseColor=Color.white;
        Color tempColor= mycolor;
        mycolor=eraseColor;
        draw(g);
        mycolor=tempColor;
    } 

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int newx)
    {
        x=newx;
    }

    public void setY(int newy)
    {
        y=newy;
    }

    public void setColor(Color nColor)
    {
        mycolor=nColor;
    }

    
}
