package main;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel{

	Vector<String> columnName = new Vector<String>();
	//Vector<Vector> data = new Vector<Vector>();
	Handler handler;
	
	public MyModel(Handler handler) {
		
		this.handler=handler;
		
		
		for(int i=0;i<handler.data.size();i++){
			System.out.println(handler.data.get(i));
			
			
			
		}
		for(int i=0;i<handler.columnName.size();i++){
			columnName.addElement(handler.columnName.get(i));
			System.out.println(handler.columnName.size()+"사이즈");
		}
		
		columnName.addElement("이름");
		columnName.addElement("나이");
		columnName.addElement("성별");
		columnName.addElement("33");
		
	}
	public String getColumnName(int col) {
		return columnName.get(col);
	}
	
	
	public int getRowCount() {
		return handler.data.size();
	}

	public int getColumnCount() {
		return columnName.size();
	}

	public Object getValueAt(int row, int col) {
		
		return handler.data.get(row).get(col);
	}

}
