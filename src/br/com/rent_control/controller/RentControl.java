package br.com.rent_control.controller;
import br.com.rent_control.view.*;
import javax.swing.*;

public class RentControl  extends JFrame{
	
	private static final long serialVersionUID = 1582258940777760838L;
	private Login telaLogin;

	public RentControl() {
		telaLogin = new Login(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Rent Control");
        setSize(950, 600);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);

        add(telaLogin);
	}
	
	public static void main(String[] args) {
		new RentControl();
    }
}