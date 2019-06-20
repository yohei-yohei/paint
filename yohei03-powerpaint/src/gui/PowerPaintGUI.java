/**
* TCSS 305 – Fall 2017
* Instructor Charles Bryan
* Assignment 5 – PowerPaint
*/

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import paint.ColorIcon;
import paint.DrawingPanel;
import tools.Ellipse;
import tools.Eraser;
import tools.Line;
import tools.Pencil;
import tools.Rectangle;


/** This is the GUI class.
 * @author Yohei Sato yohei03@uw.edu
 * 
 * @version 18 November 2017.
 */
public class PowerPaintGUI extends JFrame implements PropertyChangeListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * the pencil string. 
     */
    private static final String PENCIL = "Pencil";
    /**
     * the Line string.
     */
    private static final String LINE = "Line";
    /**
     * the Rectangle string.
     */
    private static final String RECTANGLE = "Rectangle";
    /**
     * the Ellipse string.
     */
    private static final String ELLIPSE = "Ellipse";
    /**
     * the Eraser string.
     */
    private static final String ERASER = "Eraser";
    /**
     * the rectangle Selection string.
     */
    private static final String RECTANGLESELECTION = "Rectangle Selection";
    /**
     * the Line selection string.
     */
    private static final String LINESELECTION = "Line Selection";
    /**
     * The pencil selection string.
     */
    private static final String PENCILSELECTION = "Pencil Selection";
    /**
     * The Ellipse Selection string.
     */
    private static final String ELLIPSESELECTION = "Ellipse Selection";
    /**
     * The minimum number of JSlider bar.
     */
    private static final int FT_MIN = 0;
    /**
     * The maximum number of JSlider bar.
     */
    private static final int FT_MAX = 20;
    /**
     * The initial number of JSlider bar.
     */
    private static final int FT_INIT = 10;
    /**
     * width size for the white board.
     */
    /**
     * The Integer five.
     */
    private static final int FIVE = 5;
    /**
     * the UW purple.
     */
    private final Color myUWPurple = new Color(51, 0, 111);  
    /**
     * the UW gold.
     */
    private final Color myUWGold =  new Color(232, 211, 162);
    /**
     * the color icon for primary color.
     */
    private final ColorIcon myColorIconP;
    /**
     * the secondary color.
     */
    private final ColorIcon myColorIconS;
    /**
     * the frame variable.
     */
    private final JFrame myFrame;
    /**
     * the menu bar.
     */
    private final PowerPaintMenuBar myMenuBar;
    /**
     * The submenu content.
     */
    private final JMenu myThickness;
    /**
     * the Primary Color button.
     */
    private JMenuItem myPrimaryColor;
    /**
     * the secondary color button.
     */
    private JMenuItem mySecondaryColor;
    /**
     * the clear button.
     */
    private final JMenuItem myClear;
    /**
     * the tool button.
     */
    private JMenu myTool;

    /**
     * the tool bar variable.
     */
    private JToolBar myToolBar;
    /**
     * the pencil button.
     */
    private JRadioButton myPencilButton;
    /**
     * the line button.
     */
    private JRadioButton myLineButton;
    /**
     * the rectangle button.
     */
    private JRadioButton myRectangleButton;
    /**
     * the ellipse button.
     */
    private JRadioButton myEllipseButton;
    /**
     * the eraser button.
     */
    private JRadioButton myEraserButton;
    /**
     * the Jtoggle pencil button.
     */
    private JToggleButton myPencilButtonJ;
    /**
     * the line Jtoggle button.
     */
    private JToggleButton myLineButtonJ;
    /**
     * the rectangle Jtoggle button.
     */
    private JToggleButton myRectangleButtonJ;
    /**
     * the ellipse JToggle button.
     */
    private JToggleButton myEllipseButtonJ;
    /**
     * the eraser Jtoggle button.
     */
    private JToggleButton myEraserButtonJ;
    /**
     * the white board for the drawing.
     */
    private DrawingPanel myWhiteboard;
    /**
     * the current primary color.
     */
    private Color myCurrentColorP;
    /**
     * the current secondary color.
     */
    private Color myCurrentColorS;
    
/**
 * The constructor.
 */
    public PowerPaintGUI() {
        super();
        myMenuBar = new PowerPaintMenuBar();
        myFrame = new JFrame("Assignment 5");
        myThickness = new JMenu("Thickness");
        myThickness.setMnemonic(KeyEvent.VK_T);
        myColorIconP = new ColorIcon(myUWPurple);
        myColorIconS = new ColorIcon(myUWGold);

        myClear = new JMenuItem("Clear");
        myClear.setMnemonic(KeyEvent.VK_C);

    }
    /**
     * the color set up method. 
     */
    public void colorSetUp() {
        myPrimaryColor = new JMenuItem("Primary Color...", myColorIconP);
        myPrimaryColor.setMnemonic(KeyEvent.VK_P);
        mySecondaryColor = new JMenuItem("Secondary Color...", myColorIconS);
        mySecondaryColor.setMnemonic(KeyEvent.VK_S);
        myCurrentColorP = myUWPurple;
        myCurrentColorS = myUWGold;
    }
    /**
     * Making the clear button.
     */
    public void makeClearButton() {
        myClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myWhiteboard.setClear();
                myClear.setEnabled(false);
                
            }
        });
        
    }

    /**
     * making the tool bar.
     */
    public void makeToolBar() {
        final ImageIcon imageIconP = new ImageIcon("./images/pencil.gif");
        final ImageIcon imageIconL = new ImageIcon("./images/line.gif");
        final ImageIcon imageIconR = new ImageIcon("./images/rectangle.gif");
        final ImageIcon imageIconEl = new ImageIcon("./images/ellipse.gif");
        final ImageIcon imageIconEr = new ImageIcon("./images/eraser.gif");
        final ButtonGroup group2 = new ButtonGroup();
        myToolBar = new JToolBar("Still draggable");

        // common action definition for Pencil Button added by SWJ
        // ****************************************************************** 
        final PencilAction pencilAction = new PencilAction(PENCIL, imageIconP,
                                          PENCILSELECTION, KeyEvent.VK_K);                 
        myPencilButtonJ = new JToggleButton(pencilAction);

        myPencilButtonJ.setSelected(false);

        final LineAction lineAction = new LineAction(LINE, imageIconL,
                                        LINESELECTION, KeyEvent.VK_L);                 
        myLineButtonJ = new JToggleButton(lineAction);

        myLineButtonJ.setSelected(true);
        final RectangleAction rectangleAction = new RectangleAction(RECTANGLE, imageIconR,
                                      RECTANGLESELECTION, KeyEvent.VK_R);                 
        myRectangleButtonJ = new JToggleButton(rectangleAction);
        myRectangleButtonJ.setSelected(false);
        final EllipseAction ellipseAction = new EllipseAction(ELLIPSE, imageIconEl,
                                    ELLIPSESELECTION, KeyEvent.VK_E);                 
        myEllipseButtonJ = new JToggleButton(ellipseAction);
        myEllipseButtonJ.setSelected(false);
        final EraserAction eraserAction = new EraserAction(ERASER, imageIconEr,
                                     "Errase Selection", KeyEvent.VK_A);                 
        myEraserButtonJ = new JToggleButton(eraserAction);
        myEraserButtonJ.setSelected(false);
        //

        group2.add(myPencilButtonJ);
        group2.add(myLineButtonJ);
        group2.add(myPencilButtonJ);
        group2.add(myRectangleButtonJ);
        group2.add(myEllipseButtonJ);
        group2.add(myEraserButtonJ);
        myToolBar.add(myPencilButtonJ);
        myToolBar.add(myLineButtonJ);
        myToolBar.add(myRectangleButtonJ);
        myToolBar.add(myEllipseButtonJ);
        myToolBar.add(myEraserButtonJ);

    }

/**
 * Making the thicknessbar JSlider.
 */
    public void makeThicknessBar() {
        final JSlider thicknessBar 
            = new JSlider(JSlider.HORIZONTAL, FT_MIN, FT_MAX, FT_INIT);
        thicknessBar.setMajorTickSpacing(FIVE);
        thicknessBar.setMinorTickSpacing(1);
        thicknessBar.setPaintTicks(true);
        thicknessBar.setPaintLabels(true);
        thicknessBar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                final JSlider source = (JSlider) theEvent.getSource();
                final int fps = (int) source.getValue();
                myWhiteboard.setThicknessLevel(fps);
            }

        });

        thicknessBar.setMajorTickSpacing(FT_INIT);
        thicknessBar.setPaintTicks(true);
        myThickness.add(thicknessBar);
    }
    /**
     * The setter for the primary color.
     */
    public void setPrimaryColor() {
        DrawingPanel.getPrimaryColor(myCurrentColorP);
    }
    /**
     * the setter for the secondary color.
     */
    public void setSecondaryColor() {
        DrawingPanel.getSecondaryColor(myCurrentColorS);
    }
/**
 * Making the help button.
 */
    public void makeHelpButton() {
        final JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        final JMenuItem about = new JMenuItem("About...");
        about.setMnemonic(KeyEvent.VK_A);
        help.add(about);
        myMenuBar.add(help);
        final ImageIcon imageIcon = new ImageIcon("./images/scenary.gif");
        about.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(null, 
                               "Yohei Sato \nAutumn 2017 \nTCSS 305 Assignment 5 ", 
                    "                                                     About", 
                                              JOptionPane.INFORMATION_MESSAGE, imageIcon);
            }
        });

    }

/**
 * Making the tool button.
 */
    public void makeToolButton() {
        myTool = new JMenu("Tools");
        myTool.setMnemonic(KeyEvent.VK_T);
        final ButtonGroup group = new ButtonGroup();
        final PencilAction pencilAction = new PencilAction(PENCIL, null,
                                               PENCILSELECTION, KeyEvent.VK_P);              
        myPencilButton = new JRadioButton(pencilAction);

        myPencilButton.setSelected(false);

        final LineAction lineAction = new LineAction(LINE, null,
                                          LINESELECTION, KeyEvent.VK_L);              
        myLineButton = new JRadioButton(lineAction);
        myLineButton.setSelected(true);


        final RectangleAction rectangleAction = new RectangleAction(RECTANGLE, null,
                                          RECTANGLESELECTION, KeyEvent.VK_R);              
        myRectangleButton = new JRadioButton(rectangleAction);
        myRectangleButton.setSelected(false);
        final EllipseAction ellipseAction = new EllipseAction(ELLIPSE, null,
                                               ELLIPSESELECTION, KeyEvent.VK_E);              
        myEllipseButton = new JRadioButton(ellipseAction);
        myEllipseButton.setSelected(false);
        final EraserAction eraserAction = new EraserAction(ERASER, null,
                                       "Eraser Selection", KeyEvent.VK_A);              
        myEraserButton = new JRadioButton(eraserAction);  

        myEraserButton.setSelected(false);

        group.add(myPencilButton);
        group.add(myLineButton);
        group.add(myPencilButton);
        group.add(myRectangleButton);
        group.add(myEllipseButton);
        group.add(myEraserButton);
        myTool.add(myPencilButton);
        myTool.add(myLineButton);
        myTool.add(myRectangleButton);
        myTool.add(myEllipseButton);
        myTool.add(myEraserButton);

    }




/**
 * making primary color button action.
 */
    public void makePrimaryColor() {
        myPrimaryColor.addActionListener(new ActionListener() {        
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myCurrentColorP 
                    = JColorChooser.showDialog(myFrame, "Primary Color" , myUWPurple);
                if (myCurrentColorP == null) {
                    myCurrentColorP = myUWPurple;

                } else {
                    setPrimaryColor();
                }
                myColorIconP.setColor(myCurrentColorP);

            }
        });
        mySecondaryColor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myCurrentColorS 
                    = JColorChooser.showDialog(myFrame, "Secondary Color" , myUWGold);
                if (myCurrentColorS == null) {
                    myCurrentColorS = myUWGold;
                } else {
                    setSecondaryColor();
                }
                myColorIconS.setColor(myCurrentColorS);
            }
        });


    }
    /**
     * the method for making the option button.
     */
    public void makeOptionButton() {
        final JMenu option = new JMenu("Options");
        option.setMnemonic(KeyEvent.VK_O);
        myClear.setEnabled(false);
        option.add(myThickness);
        option.addSeparator();
        option.add(myPrimaryColor);
        option.add(mySecondaryColor);
        option.addSeparator();
        option.add(myClear);
        myMenuBar.add(option);
    }
    /**
     * Setting Jtaggle button's enabled.
     */
    private void setGray() {

        myPencilButtonJ.setSelected(false);
        myLineButtonJ.setSelected(false);
        myPencilButtonJ.setSelected(false);
        myRectangleButtonJ.setSelected(false);
        myEllipseButtonJ.setSelected(false);
        myEraserButtonJ.setSelected(false);
    }

/**
 * The starting method.
 */
    public void start() {
        colorSetUp();
        final JMenuItem menuItem = new JMenuItem();
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                                                         KeyEvent.VK_T, ActionEvent.ALT_MASK));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());        
        makePrimaryColor();
        makeOptionButton();
        makeToolButton();
        setPrimaryColor();
        setSecondaryColor();
        myMenuBar.add(myTool);
        makeThicknessBar();
        makeClearButton();
        makeHelpButton();
        makeToolBar(); //CREATE TOOLBAR
        myThickness.add(menuItem);
        myFrame.setJMenuBar(myMenuBar);
        myFrame.add(myToolBar, BorderLayout.SOUTH);
        myWhiteboard = new DrawingPanel(myToolBar);  //CONNECT TOOLBAR TO DRAWINGPANEL   
        myWhiteboard.addPropertyChangeListener(this);
        myWhiteboard.setCurrentTool(new Line());
        myFrame.add(myWhiteboard, BorderLayout.CENTER);
        myFrame.pack();
        myFrame.setVisible(true);

    }
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("Property".equals(theEvent.getPropertyName())) {
            myClear.setEnabled((boolean) theEvent.getNewValue());
        }
    }
    /**
     * the Inner class for pencil's action.
     * 
     * @author yohei
     *
     */
    class PencilAction extends AbstractAction implements ActionListener {
        /**
         * the serial ID.
         */
        private static final long serialVersionUID = 1L;
        /**
         * 
         * @param theText contains text
         * @param theIcon contains icon information.
         * @param theDesc contains desc.
         * @param theMnemonic contains mnemonic value.
         */
        PencilAction(final String theText, final ImageIcon theIcon,
                            final String theDesc, final Integer theMnemonic) {
            super(theText, theIcon);
            putValue(SHORT_DESCRIPTION, theDesc);
            putValue(MNEMONIC_KEY, theMnemonic);
        }
        /**
         * this method makes pencil's action work.
         * 
         * @param theEvent that contanis event value.
         */
        public void actionPerformed(final ActionEvent theEvent) {

            setGray();
            myPencilButtonJ.setSelected(true);
            myPencilButton.setSelected(true);
            myWhiteboard.setCurrentTool(new Pencil());      

        }
    }
/**
 * the line action class.
 * 
 * @author Yohei Sato yohei03@uw.edu
 *
 */
    class LineAction extends AbstractAction {
        /**
         * the serial number.
         */
        private static final long serialVersionUID = 1L;
        /**
         * line action constructor.
         * 
         * @param theText the text value.
         * @param theIcon the icon information.
         * @param theDsec the desc information.
         * @param theMnemonic the mnemonic value.
         */
        LineAction(final String theText, final ImageIcon theIcon,
                          final String theDsec, final Integer theMnemonic) {
            super(theText, theIcon);
            putValue(SHORT_DESCRIPTION, theDsec);
            putValue(MNEMONIC_KEY, theMnemonic);
        }
        /**
         * this method makes the line action function work.
         * 
         * @param theEvent event value.
         */
        public void actionPerformed(final ActionEvent theEvent) {
            setGray();
            myLineButtonJ.setSelected(true);
            myLineButton.setSelected(true);
            myWhiteboard.setCurrentTool(new Line());            
        }
    }
    /**
     * the class for Rectangle action.
     * 
     * @author yohei Sato
     */
    class RectangleAction extends AbstractAction {
        /**
         * the serial ID.
         */
        private static final long serialVersionUID = 1L;
/**
 * Rectangle action constructor.
 * 
 * @param theText the text value.
 * @param theIcon the icon value.
 * @param theDesc the desc value.
 * @param theMnemonic the mnemonic value.
 */
        RectangleAction(final String theText, final ImageIcon theIcon,
                               final String theDesc, final Integer theMnemonic) {
            super(theText, theIcon);
            putValue(SHORT_DESCRIPTION, theDesc);
            putValue(MNEMONIC_KEY, theMnemonic);
        }
        /**
         * this method makes the rectangle action function work.
         * 
         * @param theEvent event value.
         */
        public void actionPerformed(final ActionEvent theEvent) {
            setGray();
            myRectangleButtonJ.setSelected(true);
            myRectangleButton.setSelected(true);
            myWhiteboard.setCurrentTool(new Rectangle());            

        }
    }
    /**
     * the class for EllipseAction.
     * 
     * @author yohei Sato
     */
    class EllipseAction extends AbstractAction {
        /**
         * the serial ID.
         */
        private static final long serialVersionUID = 1L;
        /**
         * Rllipse action constructor.
         * 
         * @param theText the text value.
         * @param theIcon the icon value.
         * @param theDesc the desc value.
         * @param theMnemonic the mnemonic value.
         */
        EllipseAction(final String theText, final ImageIcon theIcon,
                             final String theDesc, final Integer theMnemonic) {
            super(theText, theIcon);
            putValue(SHORT_DESCRIPTION, theDesc);
            putValue(MNEMONIC_KEY, theMnemonic);
        }
        /**
         * this method makes the ellipse action function work.
         * 
         * @param theEvent event value.
         */
        public void actionPerformed(final ActionEvent theEvent) {

            setGray();
            myEllipseButtonJ.setSelected(true);
            myEllipseButton.setSelected(true);
            myWhiteboard.setCurrentTool(new Ellipse());            

        }
    }
    /**
     * the class for EraserAction.
     * 
     * @author yohei Sato
     */
    class EraserAction extends AbstractAction {
        /**
         * the serial ID.
         */
        private static final long serialVersionUID = 1L;
        /**
         * the constructor.
         * 
         * @param theText the text value.
         * @param theIcon the icon value.
         * @param theDesc the desc value.
         * @param theMnemonic the mnemonic value.
         */
        EraserAction(final String theText, final ImageIcon theIcon,
                            final String theDesc, final Integer theMnemonic) {
            super(theText, theIcon);
            putValue(SHORT_DESCRIPTION, theDesc);
            putValue(MNEMONIC_KEY, theMnemonic);
        }
        /**
         * this method makes the eraser action function work.
         * 
         * @param theEvent event value.
         */
        public void actionPerformed(final ActionEvent theEvent) {
            setGray();
            myEraserButtonJ.setSelected(true);
            myEraserButton.setSelected(true);
            myWhiteboard.setCurrentTool(new Eraser());            

        }
    }
}
