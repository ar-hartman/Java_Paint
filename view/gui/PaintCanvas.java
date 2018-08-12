package view.gui;

import javax.swing.JComponent;
import java.awt.*;

/*
 * Description: 
 * No changes from Instructor provided code.
 * 
 */

public class PaintCanvas extends JComponent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
}
