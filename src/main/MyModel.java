package main;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel{

	Vector<String> columnName = new Vector<String>();
	Vector<Vector> data = new Vector<Vector>();
	
	
	public MyModel() {
		
		columnName.addElement("�̸�");
		columnName.addElement("����");
		columnName.addElement("��ȣ");
		columnName.addElement("����");
		
	}
	public String getColumnName(int col) {
		return columnName.get(col);
	}
	
	
	public int getRowCount() {
		return data.size();
	}

	public int getColumnCount() {
		return columnName.size();
	}
	
	public void setColumnName(Vector<String> columnName) {
		this.columnName = columnName;
	}

	public Object getValueAt(int row, int col) {
		
		return data.get(row).get(col);
	}

}
