package br.com.rent_control.view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SignUp extends JPanel{
	private static final long serialVersionUID = 6407486089823829922L;
	private final ImageIcon fundo;
	
	public SignUp() {
		setLayout(null);
        fundo = new ImageIcon("src/br/com/rent_control/image/backgroundCadastro2.png");
	}
	@Override
    public void paintComponent(Graphics g) {
        g.drawImage(fundo.getImage(), 0, 0, fundo.getIconWidth(), fundo.getIconHeight(), this);
    }	
}