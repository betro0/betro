import javax.swing.*;
import java.applet.Applet;
import java.applet.*;
import java.awt.*;
class boxdemon extends Applet {
public class boxdemo extends box
{
   private box mybox ;
      double vol ;
      public void init()
      {
          boxdemo mybox = new boxdemo() ;
      }
    public void paint(Graphics g)
    {
        mybox.width=20;
        mybox.height=30;
        mybox.depth=10;
        double vol = mybox.width * mybox.height * mybox.depth;
        g.drawString("vol of box" + vol,220,150);
    }
}}