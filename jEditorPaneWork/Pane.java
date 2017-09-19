package jEditorPaneWork;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

public class Pane extends JFrame{
	private JEditorPane pane;
	private Scanner sc;
	private String textFromFile="";
	private JScrollPane scroll;
	
	public Pane() throws IOException, URISyntaxException {
		pane = new JEditorPane();
		pane.setContentType("text/html");
		pane.setSelectedTextColor(Color.RED);
		scroll = new JScrollPane(pane);
		
		setTextFromFile();			
		searchPhrase("boolean");

		pane.setText(textFromFile);
		add(scroll);
		setSize(700, 500);
		setVisible(true);
	}

	private void searchPhrase(String phrase) {
		String newColor = "<b style=\"color:#770000\">"+ phrase +"</b>"; 
		
		textFromFile = textFromFile.replaceAll(phrase, newColor);		
	}

	private void setTextFromFile() throws URISyntaxException, IOException {
		File file = new File("C:/Users/Администратор/Desktop/java/Junior/lesson13/src/index.html");
		URI uri = file.toURI();
		sc = new Scanner(Paths.get(uri), "windows-1251");
						
		while(sc.hasNext()) {
			textFromFile += sc.nextLine();
		}
		
	}
}
