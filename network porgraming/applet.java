import java.applet.Applet;
import java.awt.*;
public class applet extends Applet{
    public class box {
        double width;
        double height;
        double depth;
        public box(){}
    }
  //  private box mybox ;
    double vol ;
    public void init()
    {
        box mybox = new box();
        mybox.width=10;
        mybox.height=8;
        mybox.depth=4;
        vol = mybox.width * mybox.height * mybox.depth;
    }
    public void paint(Graphics g)
    {
        g.drawString("vol of box : "+vol,100,100);
    }
}