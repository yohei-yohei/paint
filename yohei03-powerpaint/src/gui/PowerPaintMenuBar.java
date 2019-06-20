/**
* TCSS 305 – Fall 2017
* Instructor Charles Bryan
* Assignment 5 – PowerPaint
*/
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
/** This is the class for making MenuBar.
 * @author Yohei Sato yohei03@uw.edu
 * 
 * @version 18 November 2017.
 */
public class PowerPaintMenuBar extends JMenuBar {
    /**
     * the serial ID.
     */
    private static final long serialVersionUID = -9012190807150872737L;
    /**
     * the menu bar.
     */
    private final JMenuBar myMenuBar;
    /**
     * The constructor.
     */
    public PowerPaintMenuBar() {
        super();
        myMenuBar = new JMenuBar();
    }
    /**
     * making helop button.
     */
    public void makeHelpButton() {
        final JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        final JMenuItem about = new JMenuItem("About...");
        about.setMnemonic(KeyEvent.VK_A);
        help.add(about);
        myMenuBar.add(help);
        final ImageIcon imageIcon = new ImageIcon("./images/scenary.gif");
        about.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(null, 
                               "Yohei Sato \nAutumn 2017 \nTCSS 305 Assignment 5 ", 
                    "                                                     About", 
                                              JOptionPane.INFORMATION_MESSAGE, imageIcon);
            }
        });

    }
}
