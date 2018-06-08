<<<<<<< HEAD
package rest;
import java.io.*;
import java.util.*;

public class Informatik extends Zaposleni
{
	private String izobrazba;

	public Informatik()
	{
		super();
		this.izobrazba = "neznana";
	}
	public String getIzo()
	{
		return this.izobrazba;
	}
	public void setIzo(String izobra)
	{
		this.izobrazba = izobra;
	}
	public String toString()
	{
		String zapis = "";
		zapis += super.toString();
		zapis += "Izobrazba: " + getIzo() + "]";
		zapis += "\n\r";

		return zapis;
	}
	public String shraniKotNiz()
	{
		String zapis = "";
		zapis += "*I\r\n";
		zapis += getIme() + "\r\n";
		zapis += getRD() + "\r\n";
		zapis += getSpol() + "\r\n";
		zapis += getStarost() + "\r\n";
		zapis += getIzo() + "\r\n";

		zapis += "##\r\n";

		return zapis;
	}
	public static Informatik preberiIzNiza(ArrayList<String> zapis)
	{
		Informatik novinec = new Informatik();

		try
		{
			novinec.setIme(zapis.get(0));
			novinec.setRD(zapis.get(1));
			novinec.setSpo(zapis.get(2));
			novinec.setStarost(Integer.parseInt(zapis.get(3)));
			novinec.setIzo(zapis.get(4));

			return novinec;
		}
		catch(Exception ex)
		{
			System.out.println("Prislo je do napake: ");
			throw ex;
		}
	}
	public static Informatik vnosInfo() throws Exception
	{
			BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));


			Informatik novipri = new Informatik();

			System.out.println("**  Vnos novega informatika  **");

			String nov = "Informatik";
			novipri.setTip(nov);

			System.out.println("Vnesi ime delavca (sumniki niso priporoceni, ker jih cmd ne prepozna): ");
			String ime2 = vhod.readLine();
			novipri.setIme(ime2);

			System.out.println("Vnesi Rojstni dan informatika: ");
			String dan = Zaposleni.vnesiDan();
			String mesec = Zaposleni.vnesiMesec();
			String leto = Zaposleni.vnesiLeto();

			String rojst = dan + "." + mesec + "." + leto;

			novipri.setRD(rojst);

			int starost = 0;

			for(int i = Integer.parseInt(leto); i <2017; i++)
			{
				starost ++;
			}

			novipri.setStarost(starost);

			zanka:
			while(true)
			{
				System.out.println("Vnesi spol: ");
				String spo = vhod.readLine();

				if ( spo.equals("Moski") || spo.equals("moski"))
				{
					spo = "Moski";
					novipri.setSpo(spo);
				}
				else if( spo.equals("Zenska") || spo.equals("zenska"))
				{
					spo = "Zenska";
					novipri.setSpo(spo);
				}
				else
				{
					System.out.println("Nepravilno vnesen spol");
					System.out.println("Ponovno vnesi spol");
					continue zanka;
				}
				break;

			}

			System.out.println("Vnesi izobrazbo informatika: ");
			String niz = vhod.readLine();
			novipri.setIzo(niz);

			System.out.println("Novi informatik uspesno vnesen");

			return novipri;
	}
}
=======
package rest;
import java.io.*;
import java.util.*;

public class Informatik extends Zaposleni
{
	private String izobrazba;

	public Informatik()
	{
		super();
		this.izobrazba = "neznana";
	}
	public String getIzo()
	{
		return this.izobrazba;
	}
	public void setIzo(String izobra)
	{
		this.izobrazba = izobra;
	}
	public String toString()
	{
		String zapis = "";
		zapis += super.toString();
		zapis += "Izobrazba: " + getIzo() + "]";
		zapis += "\n\r";

		return zapis;
	}
	public String shraniKotNiz()
	{
		String zapis = "";
		zapis += "*I\r\n";
		zapis += getIme() + "\r\n";
		zapis += getRD() + "\r\n";
		zapis += getSpol() + "\r\n";
		zapis += getStarost() + "\r\n";
		zapis += getIzo() + "\r\n";

		zapis += "##\r\n";

		return zapis;
	}
	public static Informatik preberiIzNiza(ArrayList<String> zapis)
	{
		Informatik novinec = new Informatik();

		try
		{
			novinec.setIme(zapis.get(0));
			novinec.setRD(zapis.get(1));
			novinec.setSpo(zapis.get(2));
			novinec.setStarost(Integer.parseInt(zapis.get(3)));
			novinec.setIzo(zapis.get(4));

			return novinec;
		}
		catch(Exception ex)
		{
			System.out.println("Prislo je do napake: ");
			throw ex;
		}
	}
	public static Informatik vnosInfo() throws Exception
	{
			BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));


			Informatik novipri = new Informatik();

			System.out.println("**  Vnos novega informatika  **");

			String nov = "Informatik";
			novipri.setTip(nov);

			System.out.println("Vnesi ime delavca (sumniki niso priporoceni, ker jih cmd ne prepozna): ");
			String ime2 = vhod.readLine();
			novipri.setIme(ime2);

			System.out.println("Vnesi Rojstni dan informatika: ");
			String dan = Zaposleni.vnesiDan();
			String mesec = Zaposleni.vnesiMesec();
			String leto = Zaposleni.vnesiLeto();

			String rojst = dan + "." + mesec + "." + leto;

			novipri.setRD(rojst);

			int starost = 0;

			for(int i = Integer.parseInt(leto); i <2017; i++)
			{
				starost ++;
			}

			novipri.setStarost(starost);

			zanka:
			while(true)
			{
				System.out.println("Vnesi spol: ");
				String spo = vhod.readLine();

				if ( spo.equals("Moski") || spo.equals("moski"))
				{
					spo = "Moski";
					novipri.setSpo(spo);
				}
				else if( spo.equals("Zenska") || spo.equals("zenska"))
				{
					spo = "Zenska";
					novipri.setSpo(spo);
				}
				else
				{
					System.out.println("Nepravilno vnesen spol");
					System.out.println("Ponovno vnesi spol");
					continue zanka;
				}
				break;

			}

			System.out.println("Vnesi izobrazbo informatika: ");
			String niz = vhod.readLine();
			novipri.setIzo(niz);

			System.out.println("Novi informatik uspesno vnesen");

			return novipri;
	}
}
>>>>>>> bba9f3dc6e03ed882c48ad5a808d0165642e9017
