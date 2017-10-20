import javax.swing.*;
import java.awt.*;

/*
 * Jeremy Krovitz
 * CSi 1130-91
 * Summer 2017
 * This is the flower project. It is the first assignment in Intro to Java.
 */

public class Flowers extends JApplet
{
    public void paint(Graphics g)
    {
        //The keyword "super" refers to parent class, which is the JApplet Class in this case.
        super.paint(g);

        //Here we cast our Graphics object to Graphic2D.
        Graphics2D g2d = (Graphics2D) g;

        //This is where we basically tell the program to turn on the anti-aliasing.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //Call getImage to load image; call getCodeBase to specify location where running applet.
        Image img = getImage(getCodeBase(), "SunnyDayNoClouds.jpg");

        //Call drawImage to draw the image onto the applet.
        g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);

        //Call getImage to load image; call getCodeBase to specify location where running applet.
        Image img2 = getImage(getCodeBase(), "Clouds.jpg");

        //Call drawImage to draw the image onto the applet.
        g2d.drawImage(img2, getWidth()/2-100, getHeight()/2-385, getWidth()/2+285, getHeight()-385, 0, 0, 300, 154, this);

        //The method setColor changes color of rectangle that will be drawn to white.
        g2d.setColor(Color.WHITE);

        //The method fillRect draws four filled in white rectangles.
        g2d.fillRect(getWidth()/2-355, getHeight()/2-85, 140, 80);
        g2d.fillRect(getWidth()/2-155, getHeight()/2-85, 140, 110);
        g2d.fillRect(getWidth()/2+25, getHeight()/2-85, 140, 80);
        g2d.fillRect(getWidth()/2+225, getHeight()/2-85, 140, 100);

        // Call method setColor to change color of rectangle to be outlined in black.
        g2d.setColor(Color.BLACK);

        ////The method drawRect draws four rectangles outlined in black.
        g2d.drawRect(getWidth()/2-355, getHeight()/2-85, 140, 80);
        g2d.drawRect(getWidth()/2-155, getHeight()/2-85, 140, 110);
        g2d.drawRect(getWidth()/2+25, getHeight()/2-85, 140, 80);
        g2d.drawRect(getWidth()/2+225, getHeight()/2-85, 140, 100);

        //setFont sets the font for flower 1.
        g2d.setFont (new Font ("Times New Roman", Font.PLAIN, 14));

        //setColor sets color for flower 1. I am color blind and am not certain that this is blue.
        Color colorBlindBlue;

        //Here we are creating a new instance of the color object.
        colorBlindBlue = (new Color(84, 94, 147));

        //We call setColor as we want the description of flower 1 to be colorBlindBlue.
        g2d.setColor(colorBlindBlue);

        //drawString is called to draw text on the applet for flower 1.
        g2d.drawString ("The Oval Flower:", getWidth()/2-353, getHeight()/2-71);
        g2d.drawString ("This flower is made up", getWidth()/2 -353, getHeight()/2 -57);
        g2d.drawString ("of a stem, a circle, and", getWidth()/2 - 353, getHeight()/2 -43);
        g2d.drawString ("three ovals.", getWidth()/2 - 353, getHeight()/2 - 29);

        //setFont sets the font for flower 2.
        g2d.setFont (new Font ("Sans-Serif", Font.ITALIC, 14));

        //setColor sets the color for flower 2.
        g2d.setColor( new Color(128, 0, 128));

        //drawString is called to draw text on the applet for flower 2.
        g2d.drawString("The Rectangular", getWidth()/2 - 153, getHeight()/2-71);
        g2d.drawString("Flower: This flower", getWidth()/2- 153, getHeight()/2-57);
        g2d.drawString("is made up a stem", getWidth()/2 - 153, getHeight()/2 - 43);
        g2d.drawString("with an outer", getWidth()/2 - 153, getHeight()/2 -29);
        g2d.drawString("rectangle and", getWidth()/2 - 153, getHeight()/2 -15);
        g2d.drawString("four inner", getWidth()/2 - 153, getHeight()/2 -1);
        g2d.drawString("rectangles.", getWidth()/2 - 153, getHeight()/2 + 13);

        //setFont sets the font for flower 3.
        g2d.setFont (new Font ("Dialog", Font.BOLD, 14));

        //setColor sets the color for flower 3.
        g2d.setColor( new Color(76, 128, 36));

        //drawString is called to draw text on the applet for flower 3.
        g2d.drawString("The Arc Flower:", getWidth()/2+27, getHeight()/2-71);
        g2d.drawString("This flower is", getWidth()/2 + 27, getHeight()/2-57);
        g2d.drawString("made up of a", getWidth()/2 + 27, getHeight()/2 - 43);
        g2d.drawString("series of inner", getWidth()/2 + 27, getHeight()/2 -29);
        g2d.drawString("arcs.", getWidth()/2 + 27, getHeight()/2-15);

        //setFont sets the font for flower 4.
        g2d.setFont (new Font ("Monospaced", Font.PLAIN, 14));

        //setColor sets the color for flower 4.
        g2d.setColor( new Color(214, 116, 123));

        //drawString is called to draw text on the applet for flower 4.
        g2d.drawString("The Pentagonal", getWidth()/2+227, getHeight()/2-71);
        g2d.drawString("Flower: this", getWidth()/2+227, getHeight()/2-57);
        g2d.drawString("flower has five", getWidth()/2+227, getHeight()/2-43);
        g2d.drawString("sides and is thus", getWidth()/2+227, getHeight()/2-29);
        g2d.drawString("shaped like a", getWidth()/2+227, getHeight()/2-15);
        g2d.drawString("pentagon.", getWidth()/2+227, getHeight()/2-1);

        //The setColor method is called to draw the stems of the four flowers.
        g2d.setColor(new Color(65, 109, 13));
        g2d.drawLine(getWidth()/2-285, getHeight()/2+115, getWidth()/2-285, getHeight()/2+405);
        g2d.drawLine(getWidth()/2-90, getHeight()/2+115, getWidth()/2-90, getHeight()/2+405);
        g2d.drawLine(getWidth()/2+85, getHeight()/2+145, getWidth()/2+85, getHeight()/2+405);
        g2d.drawLine(getWidth()/2+265, getHeight()/2+115, getWidth()/2+265, getHeight()/2+405);

        //The method calls needed to draw the body of flower 1.
        g2d.setColor(new Color(38, 142, 225));
        g2d.fillOval(getWidth()/2-285, getHeight()/2+90, 100, 50);
        g2d.fillOval(getWidth()/2-375, getHeight()/2+95, 100, 50);
        g2d.fillOval(getWidth()/2-310, getHeight()/2+15, 50, 100);

        g2d.setColor(new Color(49, 3, 59));
        g2d.drawOval(getWidth()/2-285, getHeight()/2+90, 100, 50);
        g2d.drawOval(getWidth()/2-375, getHeight()/2+95, 100, 50);
        g2d.drawOval(getWidth()/2-310, getHeight()/2+15, 50, 100);

        g2d.setColor(Color.GREEN);
        g2d.fillOval(getWidth()/2-298, getHeight()/2+105, 37,37);

        g2d.setColor(new Color(49, 3, 59));
        g2d.drawOval(getWidth()/2-298, getHeight()/2+105, 37,37);

        //The method calls needed to draw the body of flower 2.
        g2d.setColor(new Color (141, 236, 176));
        g2d.fillRect(getWidth()/2-135, getHeight()/2+45, 100, 80);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(getWidth()/2-135, getHeight()/2+45, 100, 80);

        g2d.setColor(new Color(0, 83, 151));
        g2d.fillRect(getWidth()/2-125, getHeight()/2+55, 80, 60);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(getWidth()/2-125, getHeight()/2+55, 80, 60);

        g2d.setColor(new Color (141, 236, 176));
        g2d.fillRect(getWidth()/2-115, getHeight()/2+65, 60, 40);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(getWidth()/2-115, getHeight()/2+65, 60, 40);

        g2d.setColor(new Color(0, 83, 151));
        g2d.fillRect(getWidth()/2-110, getHeight()/2+70, 50, 30);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(getWidth()/2-110, getHeight()/2+70, 50, 30);

        g2d.setColor(new Color (141, 236, 176));
        g2d.fillRect(getWidth()/2-105, getHeight()/2+75, 40, 20);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(getWidth()/2-105, getHeight()/2+75, 40, 20);

        //The method calls needed to draw the body of flower 3.
        g2d.setColor(new Color(178, 172, 234));
        g2d.fillArc(getWidth()/2+35, getHeight()/2+45, 100, 100, 180, 180);

        g2d.setColor(Color.BLACK);
        g2d.drawArc(getWidth()/2+35, getHeight()/2+45, 100, 100, 180, 180);
        g2d.drawArc(getWidth()/2+45, getHeight()/2+45, 80, 100, 180, 180);
        g2d.drawArc(getWidth()/2+55, getHeight()/2+45, 60, 100, 180, 180);
        g2d.drawArc(getWidth()/2+65, getHeight()/2+45, 40, 100, 180, 180);
        g2d.drawArc(getWidth()/2+75, getHeight()/2+45, 20, 100, 180, 180);
        g2d.drawArc(getWidth()/2+85, getHeight()/2+45, 0, 100, 180, 180);

        //The method calls needed to draw the body of flower 4.
        g2d.setColor(new Color (194, 208, 33));
        Polygon pg = new Polygon();
        pg.addPoint(getWidth()/2+350, getHeight()/2+119);
        pg.addPoint(getWidth()/2+330, getHeight()/2+65);
        pg.addPoint(getWidth()/2+275, getHeight()/2+35);
        pg.addPoint(getWidth()/2+205, getHeight()/2+65);
        pg.addPoint(getWidth()/2+185, getHeight()/2+119);
        g2d.fillPolygon(pg);

        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(pg);
    }
}
