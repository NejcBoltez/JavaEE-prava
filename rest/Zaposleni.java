package rest;
import java.io.*;
import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

public class Zaposleni extends Tovarna
{
	public int idTov;
	public int id;
	public String Tip;
	public String ImeDelavca;
	public String RojstniDatum;
	public String Spol;
	public int Starost;
	public String sektor;
	public String izobrazba;
	

	public Zaposleni() {
		this.Tip = "";
		this.ImeDelavca = "neznano";
		this.RojstniDatum = "neznano";
		this.Spol = "neznano";
		this.Starost = 0;
		this.sektor = "neznano";
		this.izobrazba = "neznano";
	}
	
	public Zaposleni(String tip, String imeDelavca, String rojstniDatum, String spol, int starost, String sektor,String izobrazba) {
			this.Tip = tip;
			this.ImeDelavca = imeDelavca;
			this.RojstniDatum = rojstniDatum;
			this.Spol = spol;
			this.Starost = starost;
			this.sektor = sektor;
			this.izobrazba = izobrazba;
	}
	public int getIdTov() {
		return this.idTov;
	}

	public void setIdTov(int idTov) {
		this.idTov = idTov;
	}
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTip() {
			return this.Tip;
		}

	public void setTip(String tip) {
		this.Tip = tip;
	}

	public String getImeDelavca() {
		return this.ImeDelavca;
	}

	public void setImeDelavca(String imeDelavca) {
		this.ImeDelavca = imeDelavca;
	}

	public String getRojstniDatum() {
		return this.RojstniDatum;
	}

	public void setRojstniDatum(String rojstniDatum) {
		this.RojstniDatum = rojstniDatum;
	}

	public String getSpol() {
		return this.Spol;
	}

	public void setSpol(String spol) {
		this.Spol = spol;
	}

	public int getStarost() {
		return this.Starost;
	}

	public void setStarost(int starost) {
		this.Starost = starost;
	}

	public String getSektor() {
		return this.sektor;
	}

	public void setSektor(String sektor) {
		this.sektor = sektor;
	}

	public String getIzobrazba() {
		return this.izobrazba;
	}

	public void setIzobrazba(String izobrazba) {
		this.izobrazba = izobrazba;
	}
		public static String vnesiDan() throws IOException
		{

			BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

			zunanja:
			while(true)
			{
				System.out.println("Vnesi dan: ");
				String dan = vhod.readLine();

				if ( Integer.parseInt(dan) <= 0 || Integer.parseInt(dan) >31)
				{
					System.out.println("Prislo je do napake.");
					continue zunanja;
				}
				return dan;
			}
		}

		public static String vnesiMesec() throws IOException
		{
			BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

			zunanja:
			while(true)
			{
				System.out.println("Vnesi mesec: ");
				String mesec = vhod.readLine();

				if ( Integer.parseInt(mesec) <= 0 || Integer.parseInt(mesec) > 12)
				{
					System.out.println("Prislo je do napake.");
					continue zunanja;
				}
				return mesec;
			}
		}

		public static String  vnesiLeto() throws IOException
		{
			BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

			zunanja:
			while(true)
			{
				System.out.println("Vnesi leto: ");
				String leto = vhod.readLine();

				if(Integer.parseInt(leto) < 1940)
				{
					System.out.println("Prislo je do napake: ");

					continue zunanja;
				}
				return leto;
			}
		}

		public String toString()
		{
			StringBuilder builder = new StringBuilder();
			builder.append("***  " + getTip() + "  ***\r\n");
			builder.append("[Ime in Priimek: " + getImeDelavca() + ",\r\n");
			builder.append("Rojstni dan delavca: " + getRojstniDatum() + ",\r\n");
			builder.append("Spol delavca: " + getSpol() + ",\r\n");
			builder.append("Starost delavca: " + getStarost() + "," + "\r\n");
			builder.append("Sektor v katerem dela: " + getSektor() + "," + "\r\n");
			builder.append("Trenutna stopnja izobrazbe: " + getIzobrazba() + "," + "\r\n");
			
			 String izpis = builder.toString();
			
			return izpis;
		}
		public String shraniKotNiz()
		{
			StringBuilder builder = new StringBuilder();
			builder.append("*D\r\n");
			builder.append(getImeDelavca()+"\r\n");
			builder.append(getRojstniDatum()+"\r\n");
			builder.append(getSpol()+"\r\n");
			builder.append(getStarost()+"\r\n");
			builder.append(getSektor()+"\r\n");
			builder.append(getIzobrazba()+"\r\n");
			builder.append(getTip()+"\r\n");
			builder.append("##\r\n");

			String zapis = builder.toString();
			
			return zapis;
		}

	public static Zaposleni preberiIzNiza(ArrayList<String> zapis)
	{
		Zaposleni novinec = new Zaposleni();

		try
		{
			novinec.setImeDelavca(zapis.get(0));
			novinec.setRojstniDatum(zapis.get(1));
			novinec.setSpol(zapis.get(2));
			novinec.setStarost(Integer.parseInt(zapis.get(3)));
			novinec.setSektor(zapis.get(3));

			return novinec;
		}
		catch(Exception ex)
		{
			System.out.println("Prislo je do napake: ");
			throw ex;
		}
	}
}
