package carMenu;

import java.util.ArrayList;

public class Car {
	private String mark; //марка
	private String model;//модель
	private String writeUp;//описание
	private static  ArrayList<Car> cars;
	
	public Car(String mark, String model, String writeUp) {
		this.setMark(mark);
		this.setModel(model);
		this.setWriteUp(writeUp);		
	}
	

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getWriteUp() {
		return writeUp;
	}

	public void setWriteUp(String writeUp) {
		this.writeUp = writeUp;
	}

}
