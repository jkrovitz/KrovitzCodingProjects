

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*
 * Jeremy Krovitz
 * Csci 1130-91
 * Summer 2017
 * This is the SmileyControl class. It extends JPanel and is responsible for the Buttons, JPanels,
 * JRadioButtons, JCheckBoxes and ButtonGroups.
 */
public class SmileyControl extends JPanel implements ActionListener, ItemListener {

    //These are my instance variables.
    private BuildSmileyFace buildSmileyFace;
    private JCheckBox winkCheckBox;
    private JButton bigger, smaller, pickAFaceColor, pickAnEyeColor, pickAMouthColor, pickAHatColor;
    private JPanel theJButtonsPanel, theItemListenersPanel;
    private JRadioButton unhappy, happy, hat, noHat;

    /**
     * This is the SmileyControl constructor. It takes in a BuildSmileyFace object and calls setUpControls.
     * @param c gets stored in the instance variable buildSmileyFace.
     */
    public SmileyControl(BuildSmileyFace c) {
        buildSmileyFace = c;
        setUpControls();
    }

    /**
     * In this method we initialize a JPanel. We call the method everythingActionEvents, which calls methods and instantiates
     * objects that each pertain to various ActionEvents. We add theJButtonsPanel to the controlPanel. We call the
     * method everythingItemEvents, which calls methods and instantiates objects that each pertain to various item events.
     * We add theItemListenersPanel to the controlPanel, and add the controlPanel to the southern part of the applet.
     */
    public void setUpControls() {

        JPanel controlPanel = new JPanel(new FlowLayout());

        everythingActionEvents();
        controlPanel.add(theJButtonsPanel);

        everythingItemEvents();
        controlPanel.add(theItemListenersPanel);

        add(controlPanel, BorderLayout.SOUTH);
    }


    /**
     * Calls methods pertaining to actionEvents, initializes and sets the layout for theJButtonsPanel.
     */
    public void everythingActionEvents(){
        initializeJButtons();
        addActionListenersMethod();
        theJButtonsPanel = new JPanel();
        theJButtonsPanel.setLayout(new GridLayout(6, 1));
        addingTheJButtonsToTheJPanel();
    }


    /**
     * Calls methods pertaining to itemEvents, initializes and sets the layout for theItemEventsPanel.
     */
    public void everythingItemEvents(){
        initializeJCheckBoxAndJRadioButtons();
        addItemListenersMethod();
        initializingAndAddingToTheGroupsMethod();
        theItemListenersPanel = new JPanel();
        theItemListenersPanel.setLayout(new GridLayout(6, 1));
        addingToTheItemListenersPanel();
    }


    /**
     * This method initializes the JButtons and sets pickAhatColor not to be enabled initially as the
     * default JRadioButton that is selected within the headwareGroup is noHat.
     */
    public void initializeJButtons() {
        bigger = new JButton("bigger");
        smaller = new JButton("smaller");
        pickAFaceColor = new JButton("change face color");
        pickAnEyeColor = new JButton("change eye color");
        pickAMouthColor = new JButton("change mouth color");
        pickAHatColor = new JButton("change hat color");
        pickAHatColor.setEnabled(false);
    }

    /**
     * This method adds the actionListeners to the JButtons.
     */
    public void addActionListenersMethod(){
        bigger.addActionListener(this);
        smaller.addActionListener(this);
        pickAFaceColor.addActionListener(this);
        pickAnEyeColor.addActionListener(this);
        pickAMouthColor.addActionListener(this);
        pickAHatColor.addActionListener(this);
    }

    /**
     * This method initializes the JCheckBoxes and JRadioButtons.
     */
    public void initializeJCheckBoxAndJRadioButtons() {
        winkCheckBox = new JCheckBox("wink");
        happy = new JRadioButton("happy");
        unhappy = new JRadioButton("unhappy");
        hat = new JRadioButton("hat");
        noHat = new JRadioButton("no hat");
    }



    /**
     * This method adds the itemListeners to the JCheckBox and the JRadioButtons.
     */
    public void addItemListenersMethod()
    {
        happy.addItemListener(this);
        unhappy.addItemListener(this);
        hat.addItemListener(this);
        noHat.addItemListener(this);
        winkCheckBox.addItemListener(this);
    }

    /**
     * This method initializes the ButtonGroups - emotionsGroup and headwareGroups - and
     * the corresponding JRadioButtons are added to the appropriate ButtonGroup.
     */
    public void initializingAndAddingToTheGroupsMethod() {
        ButtonGroup emotionsGroup = new ButtonGroup();
        emotionsGroup.add(happy);
        emotionsGroup.add(unhappy);
        ButtonGroup headwearGroup = new ButtonGroup();
        headwearGroup.add(hat);
        headwearGroup.add(noHat);
    }


    /**
     * This method adds the JButtons for making the smiley bigger, smaller, changing the face color, the
     * eye color, the mouth color, and the hat color to the JPanel.
     */
    public void addingTheJButtonsToTheJPanel() {
        theJButtonsPanel.add(bigger);
        theJButtonsPanel.add(smaller);
        theJButtonsPanel.add(pickAFaceColor);
        theJButtonsPanel.add(pickAnEyeColor);
        theJButtonsPanel.add(pickAMouthColor);
        theJButtonsPanel.add(pickAHatColor);
    }

    /**
     * This method adds the JRadioButtons and JCheckBox to theItemListenersPanel. It also makes noHat and
     * happy checked as default options within their ButtonGroups.
     */
    public void addingToTheItemListenersPanel() {
        theItemListenersPanel.add(noHat);
        theItemListenersPanel.add(hat);
        noHat.setSelected(true);
        theItemListenersPanel.add(happy);
        happy.setSelected(true);
        theItemListenersPanel.add(unhappy);
        theItemListenersPanel.add(winkCheckBox);
    }

    /**
     * Calls a series of helper methods listening for various ActionEvents.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        biggerActionPerformed(e);
        smallerActionPerformed(e);
        pickAFaceColorActionPerformed(e);
        pickAnEyeColorActionPerformed(e);
        pickAMouthColorActionPerformed(e);
        pickAHatColorActionPerformed(e);
    }


    /**
     * This method makes the Smiley bigger after the JButton "bigger" is pressed.
     * @param e represents the event that happened, which triggers a response by this method.
     */
    public void biggerActionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == bigger) {
            buildSmileyFace.setSize(10);
            buildSmileyFace.repaint();
        }
    }

    /**
     * This method makes the Smiley smaller after the JButton "smaller" is pressed.
     * @param e represents the event that happened, which triggers a response by this method.
     */
    public void smallerActionPerformed(ActionEvent e){
        Object source = e.getSource();
        if (source == smaller) {
            buildSmileyFace.setSize(-10);
            buildSmileyFace.repaint();
        }
    }

    /**
     * This method changes the smiley's face color after the JButton "change face color" is pressed.
     * @param e represents the event that happened, which triggers a response by this method.
     */
    public void pickAFaceColorActionPerformed(ActionEvent e){
        Object source = e.getSource();
        if (source == pickAFaceColor) {
            Color faceColorPicked = JColorChooser.showDialog(this, "Choose a face color.", Color.cyan);
            buildSmileyFace.setFaceColor(faceColorPicked);
            buildSmileyFace.repaint();
        }
    }

    /**
     * This method changes the smiley's eye color after the JButton "change eye color" is pressed.
     * @param e represents the event that happened, which triggers a response by this method.
     */
    public void pickAnEyeColorActionPerformed(ActionEvent e) {
        Object source = e.getSource();
            if (source == pickAnEyeColor) {
            Color eyeColorPicked = JColorChooser.showDialog(this, "Choose an eye color.", Color.cyan);
            buildSmileyFace.setEyeColor(eyeColorPicked);
            buildSmileyFace.repaint();
        }
    }

    /**
     * This method changes the smiley's mouth color after the JButton "change mouth color" is pressed.
     * @param e represents the event that happened, which triggers a response by this method.
     */
    public void pickAMouthColorActionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == pickAMouthColor) {
            Color mouthColorPicked = JColorChooser.showDialog(this, "Choose a mouth color.", Color.cyan);
            buildSmileyFace.setMouthColor(mouthColorPicked);
            buildSmileyFace.repaint();
        }

    }

    /**
     * This method changes the smiley's hat color after the JButton "change hat color" is pressed.
     * @param e represents the event that happened, which triggers a response by this method.
     */
    public void pickAHatColorActionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == pickAHatColor) {
            Color hatColorPicked = JColorChooser.showDialog(this, "Choose a hat color.", Color.cyan);
            buildSmileyFace.setHatColor(hatColorPicked);
            buildSmileyFace.repaint();
        }
    }

    /**
     * This method calls a series of Helper methods listening for various itemEvents.
     * @param e represents the event that happened, which triggers a response by this method.
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        happyBehaviorItemStateChanged(e);
        hatOrNoHatBehavior(e);
        winkOrNoWinkBehaviorItemStateChanged(e);
    }

    /**
     * When the happy JRadioButton is checked, the smiley is repainted to have a happy look, and
     * when the unhappy JRadioButton is checked, the smiley is repainted to have an unhappy look.
     * @param e represents the event that happened, which triggers a response by this method.
     */
    private void happyBehaviorItemStateChanged(ItemEvent e){
        if (e.getSource() == happy) {
            buildSmileyFace.setHappyBoolean();
            buildSmileyFace.repaint();
        }
        if (e.getSource() == unhappy) {
            buildSmileyFace.setUnhappyBoolean();
            buildSmileyFace.repaint();
        }
    }

    /**
     * When the hat JRadioButton is checked, the smiley is repainted wearing a hat, and
     * when the noHat JRadioButton is checked, the smiley is repainted without a hat.
     * @param e represents the event that happened, which triggers a response by this method.
     */
    private void hatOrNoHatBehavior(ItemEvent e) {
        if (e.getSource() == hat) {
            pickAHatColor.setEnabled(true);
            buildSmileyFace.setHatBoolean();
            buildSmileyFace.repaint();
        }
        if (e.getSource() == noHat) {
            pickAHatColor.setEnabled(false);
            buildSmileyFace.setNoHatBoolean();
            buildSmileyFace.repaint();
        }
    }

    /**
     * When the winkCheckBox is checked, the smiley is repainted with one of its eyes winking, and
     * when the noWink JRadioButton is checked, the smiley is repainted without one of its eyes winking.
     * @param e represents the event that happened, which triggers a response by this method.
     */
    private void winkOrNoWinkBehaviorItemStateChanged(ItemEvent e){

        if(e.getSource() == winkCheckBox){
            if(winkCheckBox.isSelected()) {
                buildSmileyFace.setWinkBoolean();
                buildSmileyFace.repaint();
            }
            else{
                buildSmileyFace.setNoWinkBoolean();
                buildSmileyFace.repaint();
            }

        }
    }
}
