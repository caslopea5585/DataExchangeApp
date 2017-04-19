package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class AppMain extends JFrame implements ActionListener{
	JPanel p_west,p_east;
	JButton bt_xml, bt_oracle,bt_json;
	JTextArea txt;
	JTable table;
	JScrollPane scroll;
	JFileChooser chooser;
	Handler handler;
	MyModel model;
	
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
		
		
		bt_xml.addActionListener(this);
		bt_oracle.addActionListener(this);
		bt_json.addActionListener(this);
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		
		
	}
	
	

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==bt_xml){
			xml();
		}else if(obj==bt_oracle){
			
		}else if(obj==bt_json){
			
		}
		
	}
	
	
	public void xml(){
		chooser=new JFileChooser("C:/java_workspace2/DataExchangeApp/data"); 
		int result = chooser.showOpenDialog(this);
		//model = new MyModel();
		if(result==JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			System.out.println(file.getAbsolutePath());
			
			SAXParserFactory factory=null;
			factory = SAXParserFactory.newInstance();
			
			
			try {
				SAXParser parser = factory.newSAXParser();
				parser.parse(file.getAbsolutePath(), handler = new Handler());
				model = new MyModel(handler);
				
				
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			table.setModel(model);
			table.updateUI();
			
			
		}
	}
	
	
	
	public static void main(String[] args) {
		new AppMain();
	}
}
