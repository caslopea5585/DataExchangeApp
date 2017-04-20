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
	Vector<String> col_name;

	boolean member;
	boolean name;
	boolean age;
	boolean phone;
	boolean gender;
	
	boolean pet;
	boolean type;
	
	boolean car;
	boolean brand;
	boolean price;
	boolean color;
	
	public Handler(MyModel model) {
		this.model = model;
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equalsIgnoreCase("member")){
			vec = new Vector<String>();
			member=true;
		}	if(qName.equalsIgnoreCase("pet")){
			vec = new Vector<String>();
			pet=true;
		}	if(qName.equalsIgnoreCase("car")){
			vec = new Vector<String>();
			car=true;
		}	if(qName.equalsIgnoreCase("name")){
			name=true;
		}	if(qName.equalsIgnoreCase("age")){
			age=true;
		}	if(qName.equalsIgnoreCase("phone")){
			phone=true;
		}	if(qName.equalsIgnoreCase("type")){
			type=true;
		}	if(qName.equalsIgnoreCase("age")){
			age=true;
		}	if(qName.equalsIgnoreCase("brand")){
			brand=true;
		}	if(qName.equalsIgnoreCase("price")){
			price=true;
		}	if(qName.equalsIgnoreCase("color")){
			color=true;
		}	if(qName.equalsIgnoreCase("gender")){
			gender=true;
		}	
	}
	
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
		}else if(type){
			vec.add(new String(ch, start, length));
			type=false;
		}else if(brand){
			vec.add(new String(ch, start, length));
			brand=false;
		}else if(price){
			vec.add(new String(ch, start, length));
			price=false;
		}else if(color){
			vec.add(new String(ch, start, length));
			color=false;
		}
		
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		
		if(qName.equalsIgnoreCase("member")){
			model.data.add(vec);

		}else if(qName.equalsIgnoreCase("car")){
			model.data.add(vec);

		}else if(qName.equalsIgnoreCase("pet")){
			model.data.add(vec);

		}
	}
	

	
}
