/**
* TCSS 305 – Fall 2017
* Instructor Charles Bryan
* Assignment 5 – PowerPaint
*/
package tools;

import java.awt.Shape;
import java.awt.geom.Line2D;


/** This is the line tool class.
 * @author Yohei Sato yohei03@uw.edu
 * 
 * @version 18 November 2017.
 */
public class Line extends AbstractTool {


    
    @Override
    public Shape getShape() {
        return new Line2D.Double(getInitialPoint(), getEndPoint());
    }
}
