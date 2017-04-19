/*
 * 태크나 각종 데이터 발견시 이벤트 발생.
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
	
	//실행부가 어느 태그 위치에 와 있는지 여부를 체크하는 변수
	boolean flag=true;
	boolean member;
	boolean name;
	boolean age;
	boolean phone;
	boolean gender;
	
	public Handler(MyModel model) {
		this.model = model;
		
	}
	
	//시작 태그가 발견되면
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//시작 태그중 <member>태그를 발견하면 Vector를 생성하자
		
		
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
	
	//태그와 태그 사이의 텍스트가 발견되면 호출됨!!
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
	
	//끝태그가 발견되면
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</"+qName+">");
		
		if(qName.equalsIgnoreCase("member")){
			data.add(vec);
		}
	
	}
	
	public void endDocument() throws SAXException {
		System.out.println("담겨진 총 명수는?? " + data.size());
		
	}
	
}
