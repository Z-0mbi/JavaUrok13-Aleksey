package carMenu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JMenu;

public class JMyMenu extends JMenu{
	private Font font;
	
	public JMyMenu(String name) {
		super(name);
		font = new Font("Area",Font.BOLD,14);		
		setFont(font);
		setForeground(Color.BLUE);
	}

}
