import javax.swing.*;
import java.awt.*;
/*
 * Jeremy Krovitz
 * Csci 1130-91
 * Summer 2017
 * This is the SmileyApplet class. This class extends JApplet and objects from BuildSmileyFace and SmileyControl are created within this class.
 */

public class SmileyApplet extends JApplet {

    //These are my instance variables.
    private BuildSmileyFace buildSmileyFace1, buildSmileyFace2, buildSmileyFace3; 
    private SmileyControl control1, control2, control3;
    private JPanel centerContainer, smileyAndControl1, smileyAndControl2, smileyAndControl3;

    /**
     * This is the init method. Here we create a new instance of BorderLayout and initialize the border to
     * be the value of the new BorderLayout. We pass border to SetLayout and call setUpTitle and setUpCenter.
     */
    public void init(){
        BorderLayout border=new BorderLayout();
        setLayout(border);
        setUpTitle();
        setUpCenter();
    }

    /**
     * In this method we create a new instance of JPanel and initialize the titlePanel to be the value
     * of the new JPanel. Additionally, we create a new instance of JLabel and initialize title to be
     * the value of the new JLabel. We add the title to the JPanel, titlePanel. We add the titlePanel to
     * the borderLayout.
     */
    private void setUpTitle(){
        JPanel titlePanel=new JPanel(new FlowLayout());
        JLabel title=new JLabel("Change the Smiley Face!");
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);
    }

    /**
     * Here we create a new instance of JPanel and initialize the centerContainer to be the value
     * of the new JPanel. We call several helper methods to help setUpTheCenter, and we add the
     * centerContainer to the center.
     */
    private void setUpCenter(){
        centerContainer=new JPanel(new FlowLayout());
        initializingTheSmileyAndControlJPanelsAndTheirBorders();
        setUpSmileys();
        setUpControls();
        settingThePreferredSize();
        addingSmileysAndControlsToJPanels();
        addingTheSmileyAndControlJPanelsToCenterContainer();
        add(centerContainer, BorderLayout.CENTER);
    }

    /**
     * In this method, we initialize the JPanels and set up the borders.
     */
    private void initializingTheSmileyAndControlJPanelsAndTheirBorders(){
        smileyAndControl1=new JPanel(new BorderLayout());
        smileyAndControl1.setBorder(BorderFactory.createLineBorder(Color.black));
        smileyAndControl2=new JPanel(new BorderLayout());
        smileyAndControl2.setBorder(BorderFactory.createLineBorder(Color.black));
        smileyAndControl3=new JPanel(new BorderLayout());
        smileyAndControl3.setBorder(BorderFactory.createLineBorder(Color.black));

    }

    /**
     * In this method, we create three new instances of objects from our helper class BuildSmileyFace.
     */
    private void setUpSmileys(){
        final int LOC_X = 40;
        final int LOC_Y = 40;
        final int SIZE = 80;
        buildSmileyFace1 =new BuildSmileyFace(LOC_X, LOC_Y, SIZE, SIZE );
        buildSmileyFace2 =new BuildSmileyFace(LOC_X, LOC_Y, SIZE, SIZE);
        buildSmileyFace3 =new BuildSmileyFace(LOC_X, LOC_Y, SIZE, SIZE);
    }


    /**
     * In this method we create three new instances of objects from our helper class Smiley Control, and
     * pass in the three objects we created in setUpSmileys that came from the helper class
     * BuildSmileyFace.
     */
    private void setUpControls() {
        control1 = new SmileyControl(buildSmileyFace1);
        control2 = new SmileyControl(buildSmileyFace2);
        control3 = new SmileyControl(buildSmileyFace3);

    }

    /**
     * In this method we determine and set the size that we want for each of the three
     * instances of the BuildSmileyFace object.
     */
    private void settingThePreferredSize(){
        final int PREFERRED_SIZE = 200;
        buildSmileyFace1.setPreferredSize(new Dimension(PREFERRED_SIZE, PREFERRED_SIZE));
        buildSmileyFace2.setPreferredSize(new Dimension(PREFERRED_SIZE, PREFERRED_SIZE));
        buildSmileyFace3.setPreferredSize(new Dimension(PREFERRED_SIZE, PREFERRED_SIZE));
    }

    /**
     * Here we add one of the three instances from BuildSmileyFace and
     * one of the three instances from SmileyControl to their corresponding
     * JPanels.
     */
    private void addingSmileysAndControlsToJPanels(){
        smileyAndControl1.add(buildSmileyFace1, BorderLayout.CENTER);
        smileyAndControl1.add(control1, BorderLayout.SOUTH);
        smileyAndControl2.add(buildSmileyFace2, BorderLayout.CENTER);
        smileyAndControl2.add(control2, BorderLayout.SOUTH);
        smileyAndControl3.add(buildSmileyFace3, BorderLayout.CENTER);
        smileyAndControl3.add(control3, BorderLayout.SOUTH);
    }

    /**
     * Here we add each of the smileyAndControl panels to the centerContainer.
     */
    private void addingTheSmileyAndControlJPanelsToCenterContainer(){
        centerContainer.add(smileyAndControl1);
        centerContainer.add(smileyAndControl2);
        centerContainer.add(smileyAndControl3);
    }

}
