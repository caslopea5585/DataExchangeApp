package main;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class AppMain extends JFrame{
	JPanel p_west,p_east;
	JButton bt_xml, bt_oracle,bt_json;
	JTextArea txt;
	JTable table;
	JScrollPane scroll;
	
	
	
	public AppMain() {
		p_west = new JPanel();
		p_east = new JPanel();
		
		bt_xml=new JButton("XML열기");
		bt_oracle = new JButton("Oracle저장");
		bt_json = new JButton("Json Export");
		
		txt= new JTextArea();
		
		table = new JTable();
		scroll = new JScrollPane(table);
		
		
		setLayout(new GridLayout(1, 2));
		p_west.add(bt_xml);
		p_west.add(bt_oracle);
		p_west.add(scroll);
		
		p_east.add(bt_json);
		p_east.add(txt);
		
		
		add(p_west);
		add(p_east);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		
		
	}
	
	public static void main(String[] args) {
		new AppMain();
	}
}
