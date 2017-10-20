import javax.swing.*;
import java.awt.*;

/*
 * Jeremy Krovitz
 * Csci 1130-91
 * Summer 2017
 * This is the BuildSmileyFace class. It extends JPanel and builds the smiley face.
 */

public class BuildSmileyFace extends JPanel{

    //These are the BuildSmileyFace instance variables.
    private int locx,locy, height, width;
    private Color faceColor;
    private Color eyeColor;
    private Color mouthColor;
    private Color hatColor;
    private Boolean unhappyBoolean;
    private Boolean hatBoolean;
    private Boolean winkBoolean;
    private Graphics2D g2d;

    /**
     * This is the BuildSmileyFace constructor. This method automatically gets called when
     * we create an instance of the BuildSmileyFace class. This constructor is customized
     * to take in four parameters, each of which will be storeed in instance variables and
     * referenced in the paintComponent method.
     * @param x gets stored in the instance variable locx.
     * @param y gets stored in the instance variable locy.
     * @param h gets stored in the instance variable height.
     * @param w gets stored in the instance variable width.
     */
   public BuildSmileyFace(int x, int y, int h, int w){
        locx=x;
        locy=y;
        height=h;
        width=w;
        faceColor =Color.BLACK;
        eyeColor = Color.BLACK;
        mouthColor = Color.BLACK;
        hatColor = Color.BLACK;
        unhappyBoolean = false;
        hatBoolean = false;
        winkBoolean = false;
    }

    /**
     * This is the paint method, which allows shapes, text,
     * images, etc. to be drawn to the applet. We have
     * if and if-else statements containing calls to methods
     * that will paint various SmileyFace features to the
     * applet if the condition is met.
     * @param g this is an instance of the Graphics class.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(faceColor);
        g2d.fillOval(locx, locy, width, height);
        if (hatBoolean) {
            paintHat();
        }
        if (winkBoolean) {
            paintEyesWithAWink();
        }
        else {
            paintEyesWithoutAWink();
        }
        if (unhappyBoolean) {
           paintUnhappyFace();
        }
        else {
            paintHappyFace();
        }
    }

    /**
     * This is a paintComponent helper method that will draw a hat if the JRadioButton for a hat is selected.
     */
    public void paintHat(){
        g2d.setColor(Color.white);
        g2d.drawOval(locx+width/15, locy + height/24, (3*width/4)+(width/5), height / 15);
        g2d.drawRect(locx+width/15,locy - (height/12), 3*width/4, ((height / 15)+(height/8)));
        g2d.setColor(hatColor);
        g2d.fillOval(locx+width/15, locy + height/24, (3*width/4)+(width/5), height / 15);
        g2d.fillRect(locx+width/15,locy - (height/12), 3*width/4, ((height / 15)+(height/8)));
    }

    /**
     * This is the paintComponent helper method that will draw a smiley winking if the JCheckBox for wink is checked.
     */
    public void paintEyesWithAWink() {
        g2d.setColor(Color.white);
        g2d.fillOval(locx + width / 4, locy + height / 4, 2 * width / 9, 2 * height / 9);
        g2d.fillRect(11 * width / 20 + locx, locy + height / 3, 2 * width / 9, height / 12);
        g2d.setColor(eyeColor);
        g2d.fillRect(11 * width / 19 + locx, locy + height / 3 + height / 60, 2 * width / 12, height / 24);
        g2d.fillOval(locx + width / 4 + (width / 24), locy + height / 4 + width / 60, 2 * width / 9 - width / 24, 2 * height / 9 - width / 24);
    }

    /**
     * This is the paintComponent helper method that will draw a smiley that isn't winking if the JCheckBox for wink is unchecked.
     */
    public void paintEyesWithoutAWink(){
        g2d.setColor(Color.white);
        g2d.fillOval(locx + width / 4, locy + height / 4, 2 * width / 9, 2 * height / 9);
        g2d.fillOval(11 * width / 20 + locx, locy + height / 4, 2 * width / 9, 2 * height / 9);
        g2d.setColor(eyeColor);
        g2d.fillOval(locx + width / 4 + (width/24), locy + height / 4 +width/60 , 2 * width / 9 -width/24, 2 * height / 9-width/24);
        g2d.fillOval(11 * width / 20 + locx +width/24 , locy + height / 4 +width/60, 2 * width / 9-width/24, 2 * height / 9 - width/24);
    }

    /**
     * This is a paintComponent helper method that will draw a face that looks unhappy if the JRadioButton for unhappy is selected.
     */
    public void paintUnhappyFace(){
        g2d.setColor(mouthColor);
        g2d.fillArc(locx + width / 4, locy + 7 * height / 12, width / 2, height / 2, 0, 180);
        g2d.setColor(Color.white);
        g2d.drawArc(locx + width / 4, locy + 7 * height / 12, width / 2, height / 2, 0, 180);
    }

    /**
     * This is a paintComponent helper method that will draw a face that looks happy if the JRadioButton for happy is selected.
     */
    public void paintHappyFace(){
        g2d.setColor(mouthColor);
        g2d.fillArc(locx + width / 4, locy + 7 * height / 16, width / 2, height / 2, 180, 180);
        g2d.setColor(Color.white);
        g2d.drawArc(locx + width / 4, locy + 7 * height / 16, width / 2, height / 2, 180, 180);
    }


    /**
     * This method sets the face color of the smiley face.
     * @param f gets stored in the instance variable faceColor.
     */
    public void setFaceColor(Color f){faceColor=f;
    }

    /**
     * This method sets the eye color of the smiley face.
     * @param e gets stored in the instance variable eyeColor.
     */
    public void setEyeColor(Color e) {
        eyeColor = e;
    }

    /**
     * This method sets the mouth color of the smiley face.
     * @param m gets stored in the instance variable mouthColor.
     */
   public void setMouthColor(Color m){
        mouthColor = m;
    }

    /**
     * This method sets the hat color of the smiley face.
     * @param h gets stored in the instance variable hatColor.
     */
    public void setHatColor(Color h){
        hatColor = h;
    }

    /**
     * This method sets the height and width of the smiley face.
     * @param size gets stored in the instance variables height and width.
     */
    public void setSize(int size){
        height+=size;
        width+=size;
    }

    /**
     * Sets the Boolean value unhappyBoolean to be true and triggers the smiley face to be repainted.
     */
    public void setUnhappyBoolean(){
        unhappyBoolean =true;
        repaint();

    }

    /**
     * Sets the Boolean value unhappyBoolean to be false and triggers the smiley face to be repainted.
     */
    public void setHappyBoolean(){
        unhappyBoolean = false;
        repaint();
    }

    /**
     * Sets the Boolean value hatBoolean to be true and triggers the smiley face to be repainted.
     */
    public void setHatBoolean(){
        hatBoolean = true;
        repaint();
    }

    /**
     * Sets the Boolean value hatBoolean to be false and triggers the smiley face to be repainted.
     */
    public void setNoHatBoolean(){
        hatBoolean = false;
        repaint();
    }

    /**
     * Sets the Boolean value winkBoolean to be true and triggers the smiley face to be repainted.
     */
    public void setWinkBoolean(){
        winkBoolean = true;
        repaint();
    }

    /**00FFFF
     * Sets the Boolean value winkBoolean to be false and triggers the smiley face to be repainted.
     */
    public void setNoWinkBoolean(){
        winkBoolean = false;
        repaint();
    }

}