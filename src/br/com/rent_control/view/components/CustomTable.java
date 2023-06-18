package br.com.rent_control.view.components;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.com.rent_control.model.vo.User;


public class CustomTable extends JPanel {
	private ImageIcon imageIcon;
	private User user;
	
	public CustomTable() {
		// TODO Auto-generated constructor stub
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.white);
		imageIcon =  new ImageIcon("src/br/com/rent_control/view/images/tableHeader.png");
		JLabel label = new JLabel(imageIcon);
		label.setBounds(30, 100, 789, 43);
		add(label);
		
		user = new User("ayumi aoki", "brasil", "04761241233", 123, 32567677, "13032003", 69088413, 137,"jorge teixeira", "rua malvarisco", "manaus", "amazonas");
		User user2 = new User("Paulo Victor", "Brasil", "70214855228", 785, 32367689, "13032003", 69088413, 137,"Jorge Teixeira", "Rua Malvarisco", "Manaus", "Amazonas");
		List<User> users = new ArrayList<>();
		users.add(user2);
		users.add(user);
		users.add(user2);
		users.add(user);
		users.add(user2);
		users.add(user);
		users.add(user2);
		users.add(user);
		users.add(user2);
		users.add(user);
		users.add(user2);
		users.add(user);
		users.add(user);
		users.add(user2);
		users.add(user);
		users.add(user2);
		users.add(user);
		users.add(user2);
		users.add(user);
		int y = 154;
		for (User user : users) {
			displayLabel(user.getName(), 49, y);
			displayLabel(user.getCpf(), 222, y);
			displayLabel(Long.toString(user.getLicenseNumber()), 378, y);
			displayLabel(user.getDateOfBirth(), 546, y);
			displayIcon("edit.png", ColorUtils.WARNING_COLOR, 679, y);
			displayIcon("trash.png", ColorUtils.DANGER_COLOR,750, y);
			y += 38;
		}
		
		
		
		
	}
	
	private void displayLabel(String label, int x, int y) {
		JLabel newLabel = new JLabel(label);
		newLabel.setBounds(x, y, 165, 24);
		newLabel.setFont(newLabel.getFont().deriveFont(Font.BOLD, 14));
		add(newLabel);
	}
	
	private void displayIcon(String path, Color color, int x, int y) {
		JButton btn = new JButton();
		btn.setIcon(new ImageIcon("src/br/com/rent_control/view/images/" + path));
		btn.setForeground(Color.WHITE);
		btn.setBounds(x, y - 6, 40, 34);
		btn.setBackground(color);
		btn.setBorder(null);
		add(btn);
	}
}
