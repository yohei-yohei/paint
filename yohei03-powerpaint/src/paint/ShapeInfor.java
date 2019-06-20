/**
* TCSS 305 – Fall 2017
* Instructor Charles Bryan
* Assignment 5 – PowerPaint
*/
package paint;

import java.awt.Color;
import tools.InterfaceTool;

/** This is a class for saving shape information class.
 * @author Yohei Sato yohei03@uw.edu
 * 
 * @version 18 November 2017.
 */
public class ShapeInfor {
    /**
     * the chikness value.
     */
    private Integer myThickness;
    /**
     * the color value.
     */
    private Color myColor;
    /**
     * the reference to source shape.
     */
    private InterfaceTool myShape;
    /**
     * the type of shape: Line, Rectangle, Circle.
     */
    private String myType;
    /**
     * the display once option.
     */
    private boolean myDisplayOnce;
/**
 * the constructor method.
 * 
 * @param theShape the sahpe information
 * @param theType the type infor.
 * @param theColor the color value.
 * @param theThickness the thickness value.
 * @param theDisplay the display value.
 */
    public ShapeInfor(final InterfaceTool theShape, final String theType, 
                      final Color theColor, final Integer theThickness,
                      final boolean theDisplay) {
        myThickness = theThickness;
        myColor = theColor;
        myShape = theShape;
        this.myType = theType;
        myDisplayOnce = theDisplay;
    }
    /**
     * setter for the color information.
     * 
     * @param theColor the color value.
     */
    public void setColorInfor(final Color theColor) {
        myColor = theColor;
    }
    /**
     * setter for the shape information.
     * 
     * @param theShape the shape value.
     */
    public void setShapeInfor(final InterfaceTool theShape) {
        myShape = theShape;
    }
    /**
     * setter for the thickness information.
     * 
     * @param theThickness the thickness value
     */
    public void setIntegerInfor(final Integer theThickness) {
        myThickness = theThickness;
    }
    /**
     * getting color information.
     * 
     * @return the color value.
     */
    public Color getColorInfor() {
        return myColor;
    }
    /**
     * getting shape information.
     * 
     * @return shape information.
     */
    public InterfaceTool getShape() {
        return myShape;
    }
    /**
     * getting thickness information.
     * 
     * @return the thickness value.
     */
    public Integer getThicknessInfor() {
        return myThickness;
    }
/**
 * getting the type information.
 * 
 * @return the type information.
 */
    public String getMyType() {
        return myType;
    }
    /**
     * setting the type information.
     * 
     * @param theType the type information.
     */
    public void setMyType(final String theType) {
        myType = theType;
    }
    /**
     * checking the display once boolean value.
     * 
     * @return display once boolean is true or not.
     */
    public boolean isDisplayOnce() {
        return myDisplayOnce;
    }
/**
 * setting the boolean.
 * 
 * @param theDisplayOnce the display once boolean.
 */
    public void setDisplayOnce(final boolean theDisplayOnce) {
        myDisplayOnce = theDisplayOnce;
    }
    /**
     * the string method.
     * 
     * @return the string information.
     */
    public String toString() {
        return "Shape: " + getShape().toString() + " Type: " + getMyType() 
            + " Color: " + getColorInfor().toString();            
    }
    
}