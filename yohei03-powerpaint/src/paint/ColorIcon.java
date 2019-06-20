/**
* TCSS 305 – Fall 2017
* Instructor Charles Bryan
* Assignment 5a – PowerPaint
*/
package paint;
/**
* TCSS 305 – Fall 2017
* Instructor Charles Bryan
* Assignment 5 – PowerPaint
*/
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;
/** This is the making Color icon class.
 * @author Yohei Sato yohei03@uw.edu
 * 
 * @version 18 November 2017.
 */
public class ColorIcon implements Icon {
    /**
     * the constant value for icon height and width size.
     */
    private static final int SIZE = 14;
    /**
     * the color value.
     */
    private Color myColor;
    /**
     * the constructor method.
     * 
     * @param theColor the color value.
     */
    public ColorIcon(final Color theColor) {
        myColor = theColor;
    }

    @Override
    public int getIconHeight() {
        return SIZE;
    }

    @Override
    public int getIconWidth() {    
        return SIZE;
    }
    /**
     * setter for color.
     * 
     * @param theColor the color value.
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }

    @Override
    public void paintIcon(final Component theComponent, 
                          final Graphics theGraphics, final int theX, final int theY) {
        theGraphics.setColor(myColor);
        theGraphics.fillRect(theX, theY, SIZE, SIZE);
        theGraphics.setColor(Color.BLACK);
        theGraphics.drawRect(theX, theY, SIZE, SIZE);
        
    }

}
