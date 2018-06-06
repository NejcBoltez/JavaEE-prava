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

		//	public String getIzo()
//	{
//		return this.izobrazba;
//	}
//	public static void setIzo(Zaposleni delavec, String izobra)
//	{
//		delavec.izobrazba = izobra;
//	}
//	public String getImeDelavca() {
//		return this.ImeDelavca;
//	}
//
//	public static void setImeDelavca(Zaposleni delavec, String imeDelavca) {
//		delavec.ImeDelavca = imeDelavca;
//	}
//
//	public String getRojstniDatum() {
//		return RojstniDatum;
//	}
//
//	public static void setRojstniDatum(Zaposleni delavec, String rojstniDatum) {
//		delavec.RojstniDatum = rojstniDatum;
//	}
//
//	public String getSektor() {
//		return sektor;
//	}
//
//	public static void setSektor(Zaposleni delavec, String sektor) {
//		delavec.sektor = sektor;
//	}
//	
//	public String getSpol() {
//		return Spol;
//	}
//	public static void setSpol(Zaposleni delavec, String spol) {
//		delavec.Spol = spol;
//	}
//	public int getStarost() {
//		return Starost;
//	}
//	public static void setStarost(Zaposleni delavec, int st) {
//		delavec.Starost = st;
//	}
//	public String getTip() {
//		return Tip;
//	}
//	public static void setTip(Zaposleni delavec, String tip) {
//		delavec.Tip = tip;
//	}
//
//	public Zaposleni()
//	{
//		this.ImeDelavca = "neznano";
//		this.RojstniDatum = null;
//		this.Spol = "Moski";
//		this.sektor = "neznano";
//		this.izobrazba="neznano";
//		this.Tip="neznano";
//	}
//
//	public Zaposleni(String zacIme, String zacRD, String zacSpo, int zacStaro, String sek, String izobra, String t)
//	{
//		this.ImeDelavca = zacIme;
//		this.RojstniDatum = zacRD;
//		this.Spol = zacSpo;
//		this.Starost = zacStaro;
//		this.sektor = sek;
//		this.izobrazba=izobra;
//		this.Tip=t;
//	}
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
			String izpis = "";
			izpis += "***  " + this.Tip + "  ***\r\n";
			izpis += "[Ime in Priimek: " + getImeDelavca() + ",\r\n";
			izpis += "Rojstni dan delavca: " + getRojstniDatum() + ",\r\n";
			izpis += "Spol delavca: " + getSpol() + ",\r\n";
			izpis += "Starost delavca: " + getStarost() + "," + "\r\n";
			izpis += "Sektor v katerem dela: " + getSektor() + "," + "\r\n";
			izpis += "Trenutna stopnja izobrazbe: " + getIzobrazba() + "," + "\r\n";
			return izpis;
		}
		public String shraniKotNiz()
		{
			String zapis = "";
			zapis += "*D\r\n";
			zapis += getImeDelavca()  + "\r\n";
			zapis += getRojstniDatum() + "\r\n";
			zapis += getSpol() + "\r\n";
			zapis += getStarost() + "\r\n";
			zapis += getSektor() +"\r\n";
			zapis += getIzobrazba() +"\r\n";
			zapis += getTip() +"\r\n";

			zapis += "##\r\n";

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
