package rest;

import java.util.ArrayList;

public class Tovarnazaposleni {
	int id;
	Zaposleni delavec;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Zaposleni getDelavec() {
		return delavec;
	}
	public void setDelavec(Zaposleni delavec) {
		this.delavec = delavec;
	}
	public Tovarnazaposleni(int id, Zaposleni delavec) {
		super();
		this.id = id;
		this.delavec = delavec;
	}
	public Tovarnazaposleni() {
		super();
	}
}
