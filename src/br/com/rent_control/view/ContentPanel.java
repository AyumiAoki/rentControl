package br.com.rent_control.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class ContentPanel - Represents the content panel in the application
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class ContentPanel extends JPanel {

    private static final long serialVersionUID = -3093766985729099958L;
    private final ImageIcon backgroundPanel;

    /**
     * Parameterless constructor
     */
    public ContentPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        backgroundPanel = new ImageIcon(getClass().getResource("/br/com/rent_control/view/images/backgroundPanelContent.png"));
    }

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(backgroundPanel.getImage(), 0, 0, backgroundPanel.getIconWidth(), backgroundPanel.getIconHeight(),
				this);
	}
}