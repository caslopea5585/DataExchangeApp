package main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
=======
>>>>>>> parent of 41ef3aa... no message

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

<<<<<<< HEAD
import org.xml.sax.SAXException;



public class AppMain extends JFrame implements ActionListener{
=======
public class AppMain extends JFrame{
>>>>>>> parent of 41ef3aa... no message
	JPanel p_west,p_east;
	JButton bt_xml, bt_oracle,bt_json;
	JTextArea txt;
	JTable table;
	JScrollPane scroll;
<<<<<<< HEAD
	JFileChooser chooser;
	MyModel model;
	SAXParser parser;
	SAXParserFactory factory;
	Handler handler;
	DBManager manager;
	Connection con;
	ArrayList<PetDto> pet = new ArrayList<PetDto>();
	PetDto dto;
=======
	
	
>>>>>>> parent of 41ef3aa... no message
	
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
		
		p_east.setLayout(new BorderLayout());
		p_east.add(bt_json,BorderLayout.NORTH);
		p_east.add(txt,BorderLayout.CENTER);
		
		
		add(p_west);
		add(p_east);
		
<<<<<<< HEAD
		
		bt_json.addActionListener(this);
		bt_oracle.addActionListener(this);
		bt_xml.addActionListener(this);
		
		
		
=======
>>>>>>> parent of 41ef3aa... no message
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		
		
<<<<<<< HEAD
		
	}
	
	public void xml(){
		chooser = new JFileChooser("C:/java_workspace2/DataExchangeApp/data");
		int result =chooser.showOpenDialog(this);
		model = new MyModel();
		factory = SAXParserFactory.newInstance();
		
		
		if(result == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			try {
				parser = factory.newSAXParser();
				parser.parse(path, handler=new Handler(model));
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		table.setModel(model );
		table.updateUI();
	}
	
	
	public void oracle(){
		manager = DBManager.getInstance();
		con = manager.getConnection();
		PreparedStatement pstmt=null;
		
		String sql;
		
		try {
		
			 sql="delete from pet";
			 pstmt=con.prepareStatement(sql);
			 int result2= pstmt.executeUpdate();
			
			for(int i=0;i<model.data.size();i++){
				 sql="insert into pet(type,name,age,gender) values('"+model.data.get(i).get(0)+"','"+model.data.get(i).get(1)+"','"+model.data.get(i).get(2)+"','"+model.data.get(i).get(3)+"')";
				pstmt = con.prepareStatement(sql);
				int result = pstmt.executeUpdate();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void json(){
		PreparedStatement pstmt =null;
		ResultSet rs= null;
		String sql = "select * from pet";
		
		for(int i=0;i<pet.size();i++){
			pet.remove(i);
			System.out.println("지우니");
		}
		
		try {
			pstmt = con.prepareStatement(sql);
			rs =pstmt.executeQuery();
			while(rs.next()){
				dto = new PetDto();
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setAge(rs.getString("age"));
				dto.setType(rs.getString("type"));
				
				
				pet.add(dto);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(pet.size());
		
		txt.setText("");
		for(int i=0;i<pet.size();i++){
			StringBuffer sb = new StringBuffer();
			sb.append("{ \n");
			sb.append(" \"name :"+pet.get(i).getType()+" \"\n");
			sb.append(" \"type :"+pet.get(i).getName()+"\"\n");
			sb.append(" \"age :"+pet.get(i).getAge()+"\"\n");
			sb.append(" \"gender :"+pet.get(i).getGender()+"\"\n");
			sb.append("}\n");
			
			
			txt.append(sb.toString());
		}
		
		
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj==bt_json){
			pet.clear();
			json();
		}else if(obj==bt_oracle){
			pet.clear();
			oracle();
		}else if(obj==bt_xml){
			pet.clear();
			xml();
		}
=======
>>>>>>> parent of 41ef3aa... no message
	}
	
	public static void main(String[] args) {
		new AppMain();
	}
}
