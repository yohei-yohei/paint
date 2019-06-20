/**
* TCSS 305 – Fall 2017
* Instructor Charles Bryan
* Assignment 5 – PowerPaint
*/
package tools;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/** This is the ellipse tool class.
 * @author Yohei Sato yohei03@uw.edu
 * 
 * @version 18 November 2017.
 */
public class Ellipse extends AbstractTool {

    @Override
    public Shape getShape() {
        final Ellipse2D.Double r = new Ellipse2D.Double();
        r.setFrameFromDiagonal(getInitialPoint(), getEndPoint());
        return new Ellipse2D.Double(getInitialPoint().x, getInitialPoint().y, 
                                      getEndPoint().x - getInitialPoint().x,
                                      getEndPoint().y - getInitialPoint().y);
    }

}
