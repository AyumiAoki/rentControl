package br.com.rent_control.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import br.com.rent_control.controller.RentControl;

public class Login  extends JPanel{

	private static final long serialVersionUID = 7811418568475134687L;

	private final RentControl frameRenteControl;
	private final ImageIcon fundo;
	
    private final JLabel labelNome;
    private final JLabel labelSenha;
    private final JLabel labelAdmin;
	
	private JButton btnEntrar;
	private JButton btnFuncionario;
	private JButton btnCadastrar;
    private JTextField txtCPF;
    private JPasswordField txtSenha;
    
    private Color secundaryMain = new Color(48, 46, 37);
    private Color PrimaryMain = new Color(38, 135, 78);

	public Login(final RentControl frameRenteControl) {

		setLayout(null);
		this.frameRenteControl = frameRenteControl;
        fundo = new ImageIcon("src/br/com/rent_control/image/backgroundLogin.png");
        
		this.labelNome = new JLabel("Nome");
		labelNome.setBounds(590, 156, 40, 14);
		this.labelSenha = new JLabel("Senha");
		labelSenha.setBounds(590, 229, 45, 14);
		this.labelAdmin = new JLabel("Sou administrador");
		labelAdmin.setBounds(779, 294, 131, 14);
        
        txtCPF = new JTextField();
        txtCPF.setBounds(590,170,320,35);
        txtCPF.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, secundaryMain));
        txtCPF.setFont(new Font("", Font.BOLD, 12));
        txtCPF.setCaretColor(secundaryMain);
        txtCPF.setEditable(true);
        
        txtSenha = new JPasswordField();
        txtSenha.setBounds(590,243,320,35);
        txtSenha.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, secundaryMain));
        txtSenha.setFont(new Font("", Font.BOLD, 12));
        txtSenha.setCaretColor(secundaryMain);
        txtSenha.setEditable(true);
        
        btnFuncionario = new JButton();
        btnFuncionario.setBounds(756, 294, 15, 15);
        btnFuncionario.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, secundaryMain));
        btnFuncionario.setContentAreaFilled(false);
        
        btnEntrar = new JButton("Entrar");
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setBounds(630, 395, 240, 35);
        btnEntrar.setBackground(PrimaryMain);
        btnEntrar.setBorder(null);
        
        btnCadastrar = new JButton("Cadastre-se");
        btnCadastrar.setForeground(secundaryMain);
        btnCadastrar.setBounds(694, 481, 112, 35);
        btnCadastrar.setContentAreaFilled(false);
        btnCadastrar.setBorder(null);
        
        add(labelNome);
        add(txtCPF);
        add(labelSenha);
        add(txtSenha);
        add(btnFuncionario);
        add(btnEntrar);
        add(labelAdmin);
        add(btnCadastrar);
        
       btnCadastrar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			SignUp screenSignUp = new SignUp();
			setVisible(false);
			frameRenteControl.add(screenSignUp);
            screenSignUp.requestFocus();
		}
	});

	}
	
	@Override
    public void paintComponent(Graphics g) {
        g.drawImage(fundo.getImage(), 0, 0, fundo.getIconWidth(), fundo.getIconHeight(), this);
    }
}
