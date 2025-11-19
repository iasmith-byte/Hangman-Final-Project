import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class HangmanCanvas extends JPanel {

    public void paintComponent(Graphics g) {
        // Casts g as a Graphics2D object, allows us to draw/fill
        // with shape objects
        Graphics2D g2 = (Graphics2D)g;

        //black background
        Rectangle2D.Double h = new Rectangle2D.Double(0, 0, 4000, 1000);
        // setColor tells g2 what to color everything until called again
        g2.setColor(Color.BLACK);
        // g2.fill() fills the area defined by the shape
        g2.fill(h);
        //setColor allows to adjust custom RGB values

        //Hangman's gallows
        g2.setColor(new Color(255, 255, 255));
        // g2.draw() defines the outline made by the shape
        g2.draw(h);

        g2.drawLine(300,500,1000,500);

        // g2.draw() defines the outline made by the shape
        g2.setColor(new Color(255, 255, 255));
        // g2.draw() defines the outline made by the shape
        g2.draw(h);
        g2.drawLine(630,500,630,70);

        g2.setColor(new Color(255, 255, 255));
        // g2.draw() defines the outline made by the shape
        g2.draw(h);
        g2.drawLine(825,70,630,70);


        g2.setColor(new Color(255, 255, 255));
        // g2.draw() defines the outline made by the shape
        g2.draw(h);
        g2.drawLine(825,70,825,100);


        //Body parts
        //head
        Ellipse2D.Double c = new Ellipse2D.Double(810, 100, 30, 30);
        //setColor allows to adjust custom RGB values
        g2.setColor(new Color(255, 255, 255));
        // g2.fill() fills the area defined by the shape
        g2.fill(c);
        // g2.draw() defines the outline made by the shape
        g2.draw(c);

        //body
        g2.setColor(new Color(255, 255, 255));
        // g2.draw() defines the outline made by the shape
        g2.draw(h);
        g2.drawLine(825,100,825,200);

        // left leg
        g2.setColor(new Color(255, 255, 255));
        // g2.draw() defines the outline made by the shape
        g2.draw(h);
        g2.drawLine(800,210,825,200);

        // right leg
        g2.setColor(new Color(255, 255, 255));
        // g2.draw() defines the outline made by the shape
        g2.draw(h);
        g2.drawLine(850,210,825,200);

        //Right arm
        g2.setColor(new Color(255, 255, 255));
        // g2.draw() defines the outline made by the shape
        g2.draw(h);
        g2.drawLine(880,150,825,160);

        //Left Arm
        g2.setColor(new Color(255, 255, 255));
        // g2.draw() defines the outline made by the shape
        g2.draw(h);
        g2.drawLine(760,150,825,160);



    }

}

