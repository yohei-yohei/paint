/**
* TCSS 305 – Fall 2017
* Instructor Charles Bryan
* Assignment 5 – PowerPaint
*/
package tools;

import java.awt.Point;
import java.awt.Shape;
/** This is the abstract class for tool function.
 * @author Yohei Sato yohei03@uw.edu
 * 
 * @version 18 November 2017.
 */
public abstract class AbstractTool implements InterfaceTool {
    /**
     * the point for default.
     */
    public static final Point NO_POINT = new Point(-50, -50);
    /**
     * the initial point.
     */
    private Point myInitialPoint;
    /**
     * the end point.
     */
    private Point myEndPoint;
    /**
     * the constructor method.
     */
    public AbstractTool() {
        myInitialPoint = NO_POINT; 
        myEndPoint = NO_POINT;
    }
    
    @Override
    public void setInitialPoint(final Point theInitialPoint) {
        myInitialPoint = theInitialPoint;
        myEndPoint = theInitialPoint;
    }
    @Override
    public void setEndPoint(final Point theEndPoint) {
        myEndPoint = theEndPoint;
    }
    @Override
    public Point getInitialPoint() {
        return myInitialPoint;
    }
    @Override
    public Point getEndPoint() {
        return myEndPoint;
        
    }
    @Override
    public abstract Shape getShape();
}   
