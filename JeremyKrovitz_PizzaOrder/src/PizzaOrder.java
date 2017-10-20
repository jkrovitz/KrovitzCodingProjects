import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;

/*
 * Jeremy Krovitz
 * CSci 1130-91
 * Summer 2017
 *
 * This is the Pizza Order assignment where the user
 * of the program gets to choose their desired pizza
 * size, toppings, and then gets to submit their final
 * order.
 *
 * I worked with Rose Dillon on this assignment.
 */

public class PizzaOrder extends JApplet implements ActionListener, ItemListener {

    //Declaring my instance variables here.
    private JButton submit;
    private JPanel pizzaSizesAndToppingsPanel;
    private Image smallPepperoniImg, mediumPepperoniImg,
            largePepperoniImg, smallCheesePizzaImg, mediumCheesePizzaImg,
            largeCheesePizzaImg, mushroomsLargeImg, mushroomsMediumImg,
            mushroomsSmallImg, greenPepperLargeImg, greenPepperMediumImg,
            greenPepperSmallImg, olivesLargeImg, olivesMediumImg,
            olivesSmallImg;
    private JLabel sizes, toppings;
    private boolean isSmall, isMedium, isLarge, isPepperoni,
            isMushroom, isGreenPepper, isOlives;
    private ButtonGroup pizzaSizesGroup;
    private JRadioButton small, medium, large;
    private JCheckBox pepperoni, mushroom, greenPepper, olives;
    private JTextArea orderSummaryArea;
    private Color mamaMiaGreen, pizzaColor;
    private int totalLargeChecks, totalMediumChecks, totalSmallChecks,
            totalPepperoniChecks, totalGreenPepperChecks, totalMushroomChecks,
            totalOliveChecks;

    /**
     * In the init method, we specify that we want to use the layout manager
     * BorderLayout by calling the method setLayout. In the init method
     * we initialize the pizza color, mamaMiaGreen, the booleanVariables
     * and the images. Additionally, we call the methods setUpHeader,
     * setUpFooter, initializingAndAddingSizesAndToppings, and setUpOrderSummary
     * within this method.
     */
    public void init() {
        setLayout(new BorderLayout());
        pizzaColor = new Color(216, 221, 176);
        mamaMiaGreen = new Color(67, 240, 112);
        isSmall = false;
        isMedium = false;
        isLarge = false;
        isPepperoni = false;
        isMushroom = false;
        isGreenPepper = false;
        isOlives = false;
        smallPepperoniImg = getImage(getCodeBase(), "smallPepperoni.png");
        mediumPepperoniImg = getImage(getCodeBase(), "mediumPepperoni.png");
        largePepperoniImg = getImage(getCodeBase(), "largePepperoni.png");
        smallCheesePizzaImg = getImage(getCodeBase(), "smallCheesePizza.png");
        mediumCheesePizzaImg = getImage(getCodeBase(), "mediumCheesePizza.png");
        largeCheesePizzaImg = getImage(getCodeBase(), "largeCheesePizza.png");
        mushroomsLargeImg = getImage(getCodeBase(), "mushroomsLarge.png");
        mushroomsMediumImg = getImage(getCodeBase(), "mushroomsMedium.png");
        mushroomsSmallImg = getImage(getCodeBase(), "mushroomsSmall.png");
        greenPepperLargeImg = getImage(getCodeBase(), "greenPepperLarge.png");
        greenPepperMediumImg = getImage(getCodeBase(), "greenPepperMedium.png");
        greenPepperSmallImg = getImage(getCodeBase(), "greenPepperSmall.png");
        olivesLargeImg = getImage(getCodeBase(), "olivesLarge.png");
        olivesMediumImg = getImage(getCodeBase(), "olivesMedium.png");
        olivesSmallImg = getImage(getCodeBase(), "olivesSmall.png");

        setUpHeader();
        setUpFooter();
        initializingAndAddingSizesAndToppings();
        setUpOrderSummary();
    }

    /**
     * This is the paint method, which allows shapes, text,
     * images, etc. to be drawn to the applet.
     *
     * @param g This is an instance of the graphics class.
     */
    public void paint(Graphics g) {
        super.paint(g);

        //The antialiasing is done here.
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(pizzaColor); //The pizza color is set here.


    /*
     * Here small, medium, and large images of pizza and pizza
     * toppings will be drawn on the applet based on the pizza
     * size selected by the user.
     */

        toppingSelectedBeforePizzaSize();

        if(isSmall)

        {
            g2d.drawImage(smallCheesePizzaImg, getWidth() / 2 - 100, getHeight() / 2 - 75, this);
        }

        if(isMedium)

        {
            g2d.drawImage(mediumCheesePizzaImg, getWidth() / 2 - 158, getHeight() / 2 - 125, this);
        }

        if(isLarge)

        {
            g2d.drawImage(largeCheesePizzaImg, getWidth() / 2 - 203, getHeight() / 2 - 160, this);
        }

        if(isPepperoni &&isSmall)

        {
            g2d.drawImage(smallPepperoniImg, getWidth() / 2 - 90, getHeight() / 2 - 70, this);
        }

        if(isPepperoni &&isMedium)

        {
            g2d.drawImage(mediumPepperoniImg, getWidth() / 2 - 148, getHeight() / 2 - 120, this);
        }

        if(isPepperoni &&isLarge)

        {
            g2d.drawImage(largePepperoniImg, getWidth() / 2 - 193, getHeight() / 2 - 145, this);
        }

        if(isMushroom &&isSmall)

        {
            g2d.drawImage(mushroomsSmallImg, getWidth() / 2 - 90, getHeight() / 2 - 70, this);
        }

        if(isMushroom &&isMedium)

        {
            g2d.drawImage(mushroomsMediumImg, getWidth() / 2 - 148, getHeight() / 2 - 110, this);
        }

        if(isMushroom &&isLarge)

        {
            g2d.drawImage(mushroomsLargeImg, getWidth() / 2 - 193, getHeight() / 2 - 145, this);
        }

        if(isGreenPepper &&isSmall)

        {
            g2d.drawImage(greenPepperSmallImg, getWidth() / 2 - 90, getHeight() / 2 - 70, this);
        }

        if(isGreenPepper &&isMedium)

        {
            g2d.drawImage(greenPepperMediumImg, getWidth() / 2 - 148, getHeight() / 2 - 120, this);
        }

        if(isGreenPepper &&isLarge)

        {
            g2d.drawImage(greenPepperLargeImg, getWidth() / 2 - 193, getHeight() / 2 - 140, this);
        }

        if(isOlives &&isSmall)

        {
            g2d.drawImage(olivesSmallImg, getWidth() / 2 - 90, getHeight() / 2 - 70, this);
        }

        if(isOlives &&isMedium)

        {
            g2d.drawImage(olivesMediumImg, getWidth() / 2 - 148, getHeight() / 2 - 120, this);
        }

        if(isOlives &&isLarge)

        {
            g2d.drawImage(olivesLargeImg, getWidth() / 2 - 193, getHeight() / 2 - 140, this);
        }

    }

    /**
     * This method will be called if any of the pizza toppings are checked before a
     * pizza size has been selected and will uncheck the JCheckBox, causing the
     * topping to be shown as getting removed on the JTextArea.
     */
    private void toppingSelectedBeforePizzaSize() {
        if ((pepperoni.isSelected() || mushroom.isSelected() || greenPepper.isSelected() || olives.isSelected()) && !isLarge && !isSmall && !isMedium) {
            if (pepperoni.isSelected()) {
                pepperoni.setSelected(false);
                sizeBeforeToppingsMessage();
            }

            if (mushroom.isSelected()) {
                mushroom.setSelected(false);
                sizeBeforeToppingsMessage();
            }

            if (greenPepper.isSelected()) {
                greenPepper.setSelected(false);
                sizeBeforeToppingsMessage();
            }

            if (olives.isSelected()) {
                olives.setSelected(false);
                sizeBeforeToppingsMessage();
            }
        }
    }

    /*
     * This is the method that tells a user they must select the pizza size before their pizza toppings.
     */
    private void sizeBeforeToppingsMessage(){
        JOptionPane.showMessageDialog(this, "You must select a pizza size before" +
                " choosing a topping.");
    }


    /**
     * In setUpHeader, we initialize the header JPanel, put the logo for
     * Mama Mia's Drop Dead in the JLabel pizzaPlaceTitleLabel add the
     * JLabel to the JPanel and finally we add the header to the applet
     * and specify that we want the header added in the northern location
     * of the applet.
     */
    private void setUpHeader() {
        JPanel header = new JPanel();
        header.setBackground(mamaMiaGreen);
        header.setLayout(new FlowLayout());
        Image pizzaPlaceTitleImage = getImage(getCodeBase(), "pizzaLogo.png");
        ImageIcon pizzaPlaceTitleIcon = new ImageIcon(pizzaPlaceTitleImage);
        JLabel pizzaPlaceTitleLabel = new JLabel(pizzaPlaceTitleIcon);
        add(pizzaPlaceTitleLabel);
        header.add(pizzaPlaceTitleLabel);
        add(header, BorderLayout.NORTH);
    }

    /**
     * In this method we declare the local variable theBottomPanel
     * on the left and initialize it with a new instance of JPanel
     * on the right. We also instantiate a JButton and initialize
     * the submit instance variable with it. Additionally we
     * call setLayout to specify the layout manager, FlowLayout.
     * We also set the background, add the submit button, and
     * finally add theBottomPanel in the southern part of the
     * BorderLayout.
     */
    private void setUpFooter() {
        JPanel theBottomPanel = new JPanel();
        submit = new JButton("order");
        submit.setBorderPainted( true );
        submit.setContentAreaFilled( true );
        theBottomPanel.setBackground(mamaMiaGreen);
        theBottomPanel.setLayout(new FlowLayout());
        theBottomPanel.add(submit);
        submit.addActionListener(this);
        add(theBottomPanel, BorderLayout.SOUTH);
    }

    /**
     * This is the main method for initializing and adding
     * sizes and toppings to the pizza. The method
     * contains helper methods within it.
     */
    private void initializingAndAddingSizesAndToppings() {
        instantiatingJPanelButtonGroupAndJLabels();
        instantiatingJRadioButtons();
        instantiatingJCheckBoxes();
        pizzaSizesAndToppingsPanel.add(sizes);
        addingSizes();
        pizzaSizesAndToppingsPanel.add(toppings);
        addingTheToppings();
        add(pizzaSizesAndToppingsPanel, BorderLayout.WEST);
    }

    /**
     * In this method we instantiate the JPanel, theButtonGroup, and the JLabels.
     */
    private void instantiatingJPanelButtonGroupAndJLabels() {
        pizzaSizesAndToppingsPanel = new JPanel(new GridLayout(10, 1, 5, 20));
        pizzaSizesGroup = new ButtonGroup();
        sizes = new JLabel("<html><font size = +2 color = #ff9900ff> Pizza Sizes:  </font></html>");
        toppings = new JLabel("<html><font size = +2 color = #ff9900ff>Pizza Toppings: </font></html>");
    }

    /**
     * In this method we instantiate the JButtons.
     */
    private void instantiatingJRadioButtons() {
        small = new JRadioButton("Small");
        medium = new JRadioButton("Medium");
        large = new JRadioButton("Large");
    }

    /**
     * In this method we instantiate the JCheckBoxes.
     */
    private void instantiatingJCheckBoxes() {
        pepperoni = new JCheckBox("Pepperoni");
        mushroom = new JCheckBox("Mushroom");
        greenPepper = new JCheckBox("Green Pepper");
        olives = new JCheckBox("Olives");
    }

    /**
     * This is one of the sub-methods of initializingAndAddingSizesAndToppings.
     * The method contains calls to the three helper methods
     * addingItemListenersForSizes, addingToTheGroup, and addingSizesToThePanel
     * that each have to do with adding the pizza sizes to the applet.
     */
    private void addingSizes(){
        addingItemListenersForSizes();
        addingToTheGroup();
        addingSizesToThePanel();
    }

    /**
     * This method adds the item listeners for each of the JRadioButtons
     * corresponding with pizza size.
     */
    private void addingItemListenersForSizes() {
        small.addItemListener(this);
        medium.addItemListener(this);
        large.addItemListener(this);
    }

    /**
     * This method adds the JRadioButtons to the group. Within
     * a group, the options will be mutually exclusive, which
     * means that when one "radio button is selected in the group,
     * the button that is currently selected will be toggled
     * to become unselected"(Boese 80).
     */
    private void addingToTheGroup(){
        pizzaSizesGroup.add(small);
        pizzaSizesGroup.add(medium);
        pizzaSizesGroup.add(large);
    }

    /**
     * The pizza sizes are added to the PizzaSizesAndToppingsPanel
     * in this method.
     */
    private void addingSizesToThePanel(){
        pizzaSizesAndToppingsPanel.add(small);
        pizzaSizesAndToppingsPanel.add(medium);
        pizzaSizesAndToppingsPanel.add(large);
    }

    /**
     * This is one of the sub-methods of initializingAndAddingSizesAndToppings.
     * The method contains calls to the three helper methods
     * addingToppingsToTheApplet, addingToppingsToTheJPanel,
     * and addingItemListenersToTheToppings that each have to do with
     * adding the pizza toppings to the applet.
     */
    private void addingTheToppings() {
        addingToppingsToTheApplet();
        addingToppingsToTheJPanel();
        addingItemsListenersToTheToppings();
    }

    /**
     * This method adds the toppings to the applet itself.
     */
    private void addingToppingsToTheApplet() {
        add(pepperoni);
        add(mushroom);
        add(greenPepper);
        add(olives);
    }

    /**
     * This method adds the toppings to the pizzaSizesAndToppingsPanel.
     */
    private void addingToppingsToTheJPanel() {
        pizzaSizesAndToppingsPanel.add(pepperoni);
        pizzaSizesAndToppingsPanel.add(mushroom);
        pizzaSizesAndToppingsPanel.add(greenPepper);
        pizzaSizesAndToppingsPanel.add(olives);
    }

    /**
     * This method adds the item listeners to each of the toppings.
     */
    private void addingItemsListenersToTheToppings(){
        pepperoni.addItemListener(this);
        mushroom.addItemListener(this);
        greenPepper.addItemListener(this);
        olives.addItemListener(this);
    }

    /**
     * This method declares and initializes the local variable order header. It
     * instantiates a new textArea and initializes the orderSummaryArea variable
     * with it. The orderSummaryArea is added to the orderSummaryPanel. The
     * orderSummaryPanel is also added to the eastern part of the border layout.
     */
    private void setUpOrderSummary() {
        String orderHeader = "Mama Mia's Drop Dead Pizza\n\n1003 Mama Mia Drive\n" +
                "Maple Grove, MN, 55311\n763-488-8888 \n \n \n";
        JPanel orderSummaryPanel= new JPanel(new FlowLayout());
        orderSummaryArea = new JTextArea(32, 20);
        orderSummaryArea.setText(orderHeader);
        orderSummaryArea.setLineWrap(true);
        orderSummaryArea.setEditable(false);
        JScrollPane pane = new JScrollPane(orderSummaryPanel);
        orderSummaryPanel.add(orderSummaryArea);
        add(pane, BorderLayout.EAST);
    }


    /**
     * This method is executed with the selection and deselection
     * of JCheckBoxes and JRadioButtons.
     * @param e This variable represents the source of the event.
     */
    public void itemStateChanged(ItemEvent e){
        if(e.getSource() == large){
            double largePrice = 10.99;
            if(large.isSelected()){
                totalLargeChecks++;
                String output = "1 large pizza     \t $" + largePrice;
                orderSummaryArea.append(output);
                isLarge = true;
                repaint();
            }

            else if(!large.isSelected()){
                totalLargeChecks--;
                String output = "1 large pizza removed           $" +  - largePrice;
                orderSummaryArea.append(output);
                isLarge = false;
                repaint();
            }
        }
        if(e.getSource() == medium){
            Double mediumPrice = 9.99;
            if(medium.isSelected()){
                totalMediumChecks++;
                String output = "1 medium pizza     \t $" + mediumPrice + '\n';
                orderSummaryArea.append(output);
                isMedium = true;
                repaint();
            }

            else if(!medium.isSelected()){
                totalMediumChecks--;
                String output = "1 medium pizza removed \t $" +  - mediumPrice;
                orderSummaryArea.append(output);
                isMedium = false;
                repaint();
            }
        }
        if(e.getSource() == small){
            Double smallPrice = 8.99;
            if(small.isSelected()){
                totalSmallChecks++;
                String output = "1 small pizza     \t $" + smallPrice + '\n';
                orderSummaryArea.append(output);
                isSmall = true;
                repaint();
            }

            else if(!small.isSelected()){
                totalSmallChecks--;
                String output = "1 small pizza removed \t $" +  - smallPrice;
                orderSummaryArea.append(output);
                isSmall = false;
                repaint();
            }
        }

        if(e.getSource() == pepperoni){
            double pepperoniPrice = 1.99;
            if(pepperoni.isSelected()){
                totalPepperoniChecks++;
                String output = "pepperoni         \t $" + pepperoniPrice +'\n';
                orderSummaryArea.append(output);
                isPepperoni = true;
                repaint();
            }

            else if(!pepperoni.isSelected()){
                totalPepperoniChecks--;
                String output = '\n' + "pepperoni removed \t $" +  - pepperoniPrice + '\n';
                orderSummaryArea.append(output);
                isPepperoni = false;
                repaint();
            }
        }


        if(e.getSource() == greenPepper){
            double greenPepperPrice = 0.99;
            if(greenPepper.isSelected()){
                totalGreenPepperChecks++;
                String output = "green pepper    \t $" + greenPepperPrice + "\n";
                orderSummaryArea.append(output);
                isGreenPepper = true;
                repaint();
            }

            else if(!greenPepper.isSelected()){
                totalGreenPepperChecks--;
                String output = "green pepper removed \t $" +  - greenPepperPrice + "\n";
                orderSummaryArea.append(output);
                isGreenPepper = false;
                repaint();
            }
        }

        if(e.getSource() == mushroom){
            double mushroomPrice = 0.99;
            if(mushroom.isSelected()){
                totalMushroomChecks++;
                String output = "mushrooms             \t $" + mushroomPrice + "\n";
                orderSummaryArea.append(output);
                isMushroom = true;
                repaint();
            }

            else if(!mushroom.isSelected()){
                totalMushroomChecks--;
                String output = "mushrooms removed \t $" +  - mushroomPrice + "\n";
                orderSummaryArea.append(output);
                isMushroom = false;
                repaint();
            }
        }
        if(e.getSource() == olives){
            double olivePrice = 0.99;
            if(olives.isSelected()){
                totalOliveChecks++;
                String output = "olives                \t $" + olivePrice + "\n";
                orderSummaryArea.append(output);
                isOlives = true;
                repaint();
            }

            else if(!olives.isSelected()){
                totalOliveChecks--;
                String output = "olives removed \t $" +  - olivePrice + "\n";
                orderSummaryArea.append(output);
                isOlives = false;
                repaint();
            }
        }
    }

    /**
     * This method converts a decimal to a
     * dollar amount in String form. It keeps
     * two of the trailing zeros and also
     * rounds to the nearest hundredth.
     *
     * @param number A decimal value that needs
     *               to be converted to a dollar
     *               amount of type String.
     *
     * @return A dollar amount of type String.
     */
    private String formatDecimal(double number) {
        NumberFormat dollarFormatter = NumberFormat.getCurrencyInstance();
        return dollarFormatter.format(number);
    }

    /**
     * This action listener handles the button clicks on the
     * submit button. It prints the sub total, the tax amount,
     * and the order total of the pizza to the text area.
     * @param e This variable represents the source of the event.
     */
    public void actionPerformed(ActionEvent e) {

        double salesTax, orderTotal, subTotalPrice;

        String roundedSubTotalPriceString, roundedSalesTaxString, roundedOrderTotalString;

        subTotalPrice = (totalLargeChecks*10.99 + totalMediumChecks * 9.99 +
                totalSmallChecks*8.99 + totalGreenPepperChecks*.99
                + totalPepperoniChecks*1.99+ totalMushroomChecks*.99
                + totalOliveChecks*.99);

        roundedSubTotalPriceString = formatDecimal(subTotalPrice);

        salesTax = subTotalPrice * 0.07625;
        roundedSalesTaxString = formatDecimal(salesTax);

        orderTotal = salesTax + subTotalPrice;
        roundedOrderTotalString = formatDecimal(orderTotal);

        Object obj = e.getSource();
        if (obj == submit) {
            orderSummaryArea.append( '\n' + " " + '\n' + "Order subtotal:       \t" +
                    roundedSubTotalPriceString);
            orderSummaryArea.append('\n' + "Sales tax:              \t" + roundedSalesTaxString);
            orderSummaryArea.append('\n' + "Order total:            \t" + roundedOrderTotalString);
            orderSummaryArea.append('\n' + "  " + '\n' + " " + '\n' + "Thank you " +
                    "for ordering from" + '\n' + "Mama Mia's " + "Drop Dead Pizza!"
                    + '\n');
            submit.setEnabled(false); //Set to false because it would be unusual to let user resubmit their order.
            remove(pizzaSizesAndToppingsPanel); //Prevents user from being able to check any of the JCheckBoxes or JRadioButtons.

        }
    }
}