import java.applet.Applet;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    public abstract class applet2 extends Applet implements ActionListener{
        private  TextField agefile;
        private float age;
        public void init(){
            agefile = new TextField(10);
            add(agefile);
            agefile.addActionListener(this);
        }
        public void actionperformed(ActionEvent event){
            age = Integer.parseInt(agefile.getText());}
        public void paint(Graphics g)
        {
            if(age>= 18)
                g.drawString("your car vol ",50 ,100);
            else
                g.drawString("your cannot vol ",50 ,100);
        }
    }

