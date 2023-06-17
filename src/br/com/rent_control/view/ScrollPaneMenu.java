/**
 * 
 */
package br.com.rent_control.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;


/**
 * @author ayumi
 *
 */
public class ScrollPaneMenu extends JScrollPane{

	private static final long serialVersionUID = -2751027052884507997L;

	public ScrollPaneMenu(JPanel menuPanel) {
		super(menuPanel);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getVerticalScrollBar().setUI(new CustomScrollBarUI());
		
		Border border = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GREEN);
		setBorder(border);
		
		setSize(new Dimension(180, this.getSize().height));
		setPreferredSize(this.getSize());
	}
	
	private class CustomScrollBarUI extends BasicScrollBarUI {
	    private final int SCROLL_BAR_SIZE = 8;

	    @Override
	    protected JButton createDecreaseButton(int orientation) {
	        JButton button = new JButton();
	        button.setBorder(null);
	        button.setContentAreaFilled(false);
	        button.setPreferredSize(new Dimension(0, 0));
	        return button;
	    }

	    @Override
	    protected JButton createIncreaseButton(int orientation) {
	        JButton button = new JButton();
	        button.setBorder(null);
	        button.setContentAreaFilled(false);
	        button.setPreferredSize(new Dimension(0, 0));
	        return button;
	    }

	    @Override
	    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
	        Graphics2D g2 = (Graphics2D) g.create();
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	        g2.setPaint(Color.WHITE);
	        g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width - 1, thumbBounds.height - 1, 5, 5);

	        g2.dispose();
	    }

	    @Override
	    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
	    	g.setColor(Color.WHITE);
	        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
	    }

	    @Override
	    protected Dimension getMinimumThumbSize() {
	        return new Dimension(SCROLL_BAR_SIZE, SCROLL_BAR_SIZE);
	    }

	    @Override
	    public Dimension getPreferredSize(JComponent c) {
	        return new Dimension(SCROLL_BAR_SIZE, 0);
	    }
	}
}
