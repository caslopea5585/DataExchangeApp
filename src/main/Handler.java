/*
 * ��ũ�� ���� ������ �߽߰� �̺�Ʈ �߻�.
 * */
package main;
import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler{
	MyModel model;
	Vector<String> vec;
	Vector<String> columnName = new Vector<String>();
	Vector<Vector> data = new Vector<Vector>();
	String colName;
	
	//����ΰ� ��� �±� ��ġ�� �� �ִ��� ���θ� üũ�ϴ� ����
	boolean flag=true;
	boolean member;
	boolean name;
	boolean age;
	boolean phone;
	boolean gender;
	
	public Handler(MyModel model) {
		this.model = model;
		
	}
	
	//���� �±װ� �߰ߵǸ�
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//���� �±��� <member>�±׸� �߰��ϸ� Vector�� ��������
		
		
		if(qName.equalsIgnoreCase("member")){
			vec = new Vector<String>();
			member=true;
		}	if(qName.equalsIgnoreCase("name")){
			name=true;
		}	if(qName.equalsIgnoreCase("age")){
			age=true;
		}	if(qName.equalsIgnoreCase("phone")){
			phone=true;
		}	if(qName.equalsIgnoreCase("gender")){
			gender=true;
		}
		
		
	}
	
	//�±׿� �±� ������ �ؽ�Ʈ�� �߰ߵǸ� ȣ���!!
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(name){
			vec.add(new String(ch, start, length));
			name=false;
		}else if(age){
			vec.add(new String(ch, start, length));
			age=false;
		}else if(phone){
			vec.add(new String(ch, start, length));
			phone=false;
		}else if(gender){
			vec.add(new String(ch, start, length));
			gender=false;
		}
		
	}
	
	//���±װ� �߰ߵǸ�
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</"+qName+">");
		
		if(qName.equalsIgnoreCase("member")){
			data.add(vec);
		}
	
	}
	
	public void endDocument() throws SAXException {
		System.out.println("����� �� �����?? " + data.size());
		
	}
	
}
