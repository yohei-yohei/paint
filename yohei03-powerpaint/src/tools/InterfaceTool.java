/**
* TCSS 305 – Fall 2017
* Instructor Charles Bryan
* Assignment 5 – PowerPaint
*/
package tools;

import java.awt.Point;
import java.awt.Shape;

/** This is interface class for tool classes.
 * @author Yohei Sato yohei03@uw.edu
 * 
 * @version 18 November 2017.
 */
public interface InterfaceTool {
    /**
     * setting initial point.
     * 
     * @param theInitialPoint initial point.
     */
    void setInitialPoint(Point theInitialPoint);
    /**
     * setting the end point.
     * 
     * @param theEndPoint end point.
     */
    void setEndPoint(Point theEndPoint);
    /**
     * getting the initial point.
     * 
     * @return myInitial point.
     */
    Point getInitialPoint();
    /**
     * getting the end point.
     * 
     * @return myEndPoint.
     */
    Point getEndPoint();
    /**
     * getting the shape.
     * 
     * @return myShape.
     */
    Shape getShape();
}
