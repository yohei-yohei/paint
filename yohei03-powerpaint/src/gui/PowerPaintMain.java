/**
* TCSS 305 – Fall 2017
* Instructor Charles Bryan
* Assignment 5 – PowerPaint
*/
package gui;

import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/** This is the main class for powerpaint program.
 * @author Yohei Sato yohei03@uw.edu
 * 
 * @version 18 November 2017.
 */
public final class PowerPaintMain {
    /**
     * the setting special menu fame.
     */
    private PowerPaintMain() {
        try {
            UIManager.setLookAndFeel("javax.swing.metal.MetalLookAndFeel");
        } catch (final UnsupportedLookAndFeelException exception) {
            exception.printStackTrace();
        } catch (final IllegalAccessException exception) {
            exception.printStackTrace();
        } catch (final InstantiationException exception) {
            exception.printStackTrace();
        } catch (final ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        throw new IllegalStateException();
    }
/**
 * The main method, invokes the SnapShop GUI. Command line arguments are
 * ignored.
 * 
 * @param theArgs Command line arguments.
 */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PowerPaintGUI().start();
            }
        });
    }
}
