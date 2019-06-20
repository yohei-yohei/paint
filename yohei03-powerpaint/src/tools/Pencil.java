/**
* TCSS 305 – Fall 2017
* Instructor Charles Bryan
* Assignment 5 – PowerPaint
*/
package tools;

import java.awt.Shape;
import java.awt.geom.Line2D;

/** This is pencil tool class.
 * @author Yohei Sato yohei03@uw.edu
 * 
 * @version 18 November 2017.
 */
public class Pencil extends AbstractTool {
    
    
    @Override
    public Shape getShape() {
        return new Line2D.Double(getInitialPoint(), getEndPoint());
    }
}
