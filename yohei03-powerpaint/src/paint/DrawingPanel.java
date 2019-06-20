/**
 * TCSS 305 – Fall 2017 Instructor Charles Bryan Assignment 5 – PowerPaint
 */

package paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;
import tools.Ellipse;
import tools.Eraser;
import tools.InterfaceTool;
import tools.Line;
import tools.Pencil;
import tools.Rectangle;

/**
 * This is the making drawing panel class.
 * 
 * @author Yohei Sato yohei03@uw.edu
 * 
 * @version 18 November 2017.
 */
public class DrawingPanel extends JPanel {
    /**
     * the serial ID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * the line string.
     */
    private static final String LINE = "Line";
    /**
     * the Ellipse string.
     */
    private static final String ELLIPSE = "Ellipse";
    /**
     * the rectangle string.
     */
    private static final String RECTANGLE = "Rectangle";
    /**
     * the eraser string.
     */
    private static final String ERASER = "Eraser";
    /**
     * width size for the white board.
     */
    private static final int WIDTH = 500;
    /**
     * the height size for the white board.
     */
    private static final int HEIGHT = 300;
    /**
     * the number 10.
     */
    private static final int NUMBERTEN = 10;
    /**
     * UW purple color code.
     */
    private static final Color UWPURPLE = new Color(51, 0, 111);
    /**
     * UW golden color code.
     */
    private static final Color UWGOLDEN = new Color(232, 211, 162);
    /**
     * the Color value.
     */
    private static Color myColor = UWPURPLE;
    /**
     * The primaryColor.
     */
    private static Color myPrimaryColor;
    /**
     * The secondary color.
     */
    private static Color mySecondaryColor;

    /**
     * The varilable in InterfaceTool class.
     */
    private InterfaceTool myCurrentTool;
    /**
     * the shape information array list.
     */
    private final List<ShapeInfor> mySavedShapeInfor = new ArrayList<ShapeInfor>();
    /**
     * The thickness.
     */
    private int myThicknessLevel;

    /**
     * the constructor method.
     * 
     * @param theToolBar the tool bar value.
     */
    public DrawingPanel(final JToolBar theToolBar) {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        myCurrentTool = new Pencil();
        myThicknessLevel = NUMBERTEN;
        setOpaque(true);
        settingUp();

    }

    /**
     * the constructor method.
     */
    public DrawingPanel() {
        super();
        myPrimaryColor = UWPURPLE;
        mySecondaryColor = UWGOLDEN;
    }

    /**
     * setter for thickness value.
     * 
     * @param theThickness the thickness value.
     */
    public void setThicknessLevel(final int theThickness) {
        myThicknessLevel = theThickness;
    }

    @Override
    public void paint(final Graphics theGraphics) {

        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        // final Shape line = new Line2D.Double(myInitialPoint, myLastPoint);

        // go through arrayList of line2d objects & draw all of them

        for (int i = 0; mySavedShapeInfor.size() > i; i++) {

            g2d.setPaint(mySavedShapeInfor.get(i).getColorInfor());
            g2d.setStroke(new BasicStroke(mySavedShapeInfor.get(i).getThicknessInfor()));

            if (mySavedShapeInfor.get(i).getMyType().equals(LINE)) {
                g2d.draw(mySavedShapeInfor.get(i).getShape().getShape());
                // System.out.println("Line print i: " + i);
            }
            if (mySavedShapeInfor.get(i).getMyType().equals(RECTANGLE)) {

                final Point init = mySavedShapeInfor.get(i).getShape().getInitialPoint();
                final Point end = mySavedShapeInfor.get(i).getShape().getEndPoint();
                final Rectangle2D.Double r = new Rectangle2D.Double();
                r.setFrameFromDiagonal(init, end);

                g2d.draw(r);

            }

            if (mySavedShapeInfor.get(i).getMyType().equals(ERASER)) {

                final Point init = mySavedShapeInfor.get(i).getShape().getInitialPoint();
                final Point end = mySavedShapeInfor.get(i).getShape().getEndPoint();

                g2d.clearRect(init.x, init.y, end.x - init.x, end.y - init.y);

            }

            if (mySavedShapeInfor.get(i).getMyType().equals(ELLIPSE)) {
                final Point init = mySavedShapeInfor.get(i).getShape().getInitialPoint();
                final Point end = mySavedShapeInfor.get(i).getShape().getEndPoint();
                final Ellipse2D.Double e = new Ellipse2D.Double();
                e.setFrameFromDiagonal(init, end);

                g2d.draw(e);

                // g2d.draw(mySavedShapeInfor.get(i).getShape().getShape());

            }

            if (mySavedShapeInfor.get(i).isDisplayOnce()) {
                mySavedShapeInfor.remove(i);
            }
        }
        g2d.setStroke(new BasicStroke(myThicknessLevel));
        g2d.setPaint(myColor);

    }

    /**
     * setting up action variable.
     */
    private void settingUp() {
        final MouseInputAdapter action = new MouseThing();
        addMouseListener(action);
        addMouseMotionListener(action);

    }

    /**
     * setter for current tool.
     * 
     * @param theTool the tool value.
     */
    public void setCurrentTool(final InterfaceTool theTool) {
        // System.out.println("CHANGED TOOL TO: " + theTool);
        myCurrentTool = theTool;
    }

    /**
     * getter for the color value.
     * 
     * @param theColor the color information.
     */
    public static void getPrimaryColor(final Color theColor) {
        myPrimaryColor = theColor;
    }

    /**
     * getter for the color.
     * 
     * @param theColor the color value.
     */
    public static void getSecondaryColor(final Color theColor) {
        mySecondaryColor = theColor;
    }

    /**
     * making clear funtion work.
     */
    public void setClear() {
        mySavedShapeInfor.clear();
        repaint();
    }

    /**
     * 
     * @author yohei
     *
     */

    public class MouseThing extends MouseInputAdapter {
        @Override
        public void mousePressed(final MouseEvent theEvent) {
            if (myThicknessLevel == 0) {
                return;
            }
            firePropertyChange("Property", null, true);
            myCurrentTool.setInitialPoint(theEvent.getPoint());
            myColor = checkLeftOrRight(theEvent);
            repaint();
        }

        @Override
        public void mouseReleased(final MouseEvent theEvent) {
            if (myThicknessLevel == 0) {
                return;
            }
            myCurrentTool.setEndPoint(theEvent.getPoint());
            if (myCurrentTool instanceof Line) {
                final InterfaceTool newLine = new Line();
                newLine.setInitialPoint(myCurrentTool.getInitialPoint());
                newLine.setEndPoint(theEvent.getPoint());

                mySavedShapeInfor.add(new ShapeInfor(newLine, LINE, myColor, myThicknessLevel,
                                                     false));
                myColor = checkLeftOrRight(theEvent);
            }

            if (myCurrentTool instanceof Rectangle) {

                final InterfaceTool newLine = new Rectangle();
                newLine.setInitialPoint(myCurrentTool.getInitialPoint());
                newLine.setEndPoint(theEvent.getPoint());

                mySavedShapeInfor.add(new ShapeInfor(newLine, RECTANGLE, myColor,
                                                     myThicknessLevel, false));
                myColor = checkLeftOrRight(theEvent);

            }

            if (myCurrentTool instanceof Ellipse) {
                final InterfaceTool newLine = new Ellipse();
                newLine.setInitialPoint(myCurrentTool.getInitialPoint());
                newLine.setEndPoint(theEvent.getPoint());

                mySavedShapeInfor.add(new ShapeInfor(newLine, ELLIPSE, myColor,
                                                     myThicknessLevel, false));
                myColor = checkLeftOrRight(theEvent);

            }

//            if (myCurrentTool instanceof Eraser) {
//                final InterfaceTool newLine = new Eraser();
//                final Point eraserStart = new Point(theEvent.getPoint().x - 10,
//                                                    theEvent.getPoint().y - 10);
//                newLine.setInitialPoint(eraserStart);
//                newLine.setEndPoint(theEvent.getPoint());
//
//                mySavedShapeInfor.add(new ShapeInfor(newLine, ERASER, myColor,
//                                                     myThicknessLevel, false));
//                myColor = checkLeftOrRight(theEvent);
//
//            }
            repaint();
        }

        /**
         * mouse Dragged method that is using for when mouse is dragged.
         * 
         * @param theEvent contains event value.
         */
        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            if (myThicknessLevel == 0) {
                return;
            }
            myCurrentTool.setEndPoint(theEvent.getPoint());
            if (myCurrentTool instanceof Line) {
                myColor = checkLeftOrRight(theEvent);
            }

            if (myCurrentTool instanceof Line) {

                final InterfaceTool newLine = new Line();
                newLine.setInitialPoint(myCurrentTool.getInitialPoint());
                newLine.setEndPoint(theEvent.getPoint());

                mySavedShapeInfor.add(new ShapeInfor(newLine, LINE, myColor, myThicknessLevel,
                                                     true));

                myColor = checkLeftOrRight(theEvent);
            }
            if (myCurrentTool instanceof Pencil) {
                final InterfaceTool newPencil = new Pencil();
                newPencil.setInitialPoint(myCurrentTool.getInitialPoint());
                newPencil.setEndPoint(theEvent.getPoint());
                myCurrentTool.setInitialPoint(theEvent.getPoint());
                mySavedShapeInfor.add(new ShapeInfor(newPencil, LINE, myColor,
                                                     myThicknessLevel, false));
                myColor = checkLeftOrRight(theEvent);

            }
            if (myCurrentTool instanceof Rectangle) {

                final InterfaceTool newLine = new Rectangle();
                newLine.setInitialPoint(myCurrentTool.getInitialPoint());
                newLine.setEndPoint(theEvent.getPoint());
                mySavedShapeInfor.add(new ShapeInfor(newLine, RECTANGLE, myColor,
                                                     myThicknessLevel, true));
                myColor = checkLeftOrRight(theEvent);
            }
            if (myCurrentTool instanceof Ellipse) {

                final InterfaceTool newLine = new Ellipse();
                newLine.setInitialPoint(myCurrentTool.getInitialPoint());
                newLine.setEndPoint(theEvent.getPoint());

                mySavedShapeInfor.add(new ShapeInfor(newLine, ELLIPSE, myColor,
                                                     myThicknessLevel, true));

                myColor = checkLeftOrRight(theEvent);
            }
            if (myCurrentTool instanceof Eraser) {
                final InterfaceTool newLine = new Eraser();
                newLine.setInitialPoint(myCurrentTool.getInitialPoint());
                newLine.setEndPoint(theEvent.getPoint());
                myCurrentTool.setInitialPoint(theEvent.getPoint());
                mySavedShapeInfor.add(new ShapeInfor(newLine, LINE, Color.WHITE, 
                                                     myThicknessLevel, false));
                myColor = checkLeftOrRight(theEvent);
            }
            repaint();
        }

        /**
         * this method is mouseEntered method for making the specific cursor.
         * 
         * @param theEvent event value.
         */
        public void mouseEntered(final MouseEvent theEvent) {

            setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        }

        /**
         * for checking to click right button or left button.
         * 
         * @param theEvent the event value.
         * @return color value.
         */
        public Color checkLeftOrRight(final MouseEvent theEvent) {
            Color color = UWPURPLE;
            if (SwingUtilities.isLeftMouseButton(theEvent)) {
                color = myPrimaryColor;
            } else if (SwingUtilities.isRightMouseButton(theEvent)) {
                color = mySecondaryColor;
            }
            return color;
        }

    }
}
