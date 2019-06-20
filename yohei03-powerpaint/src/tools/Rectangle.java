/**
* TCSS 305 – Fall 2017
* Instructor Charles Bryan
* Assignment 5 – PowerPaint
*/
package tools;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
/** This is rectangle tool classes.
 * @author Yohei Sato yohei03@uw.edu
 * 
 * @version 18 November 2017.
 */
public class Rectangle extends AbstractTool {
    @Override
    public Shape getShape() {
        final Rectangle2D.Double r = new Rectangle2D.Double();
        r.setFrameFromDiagonal(getInitialPoint(), getEndPoint());

        return r;
        
    }
    
}
