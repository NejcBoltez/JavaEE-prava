<<<<<<< HEAD
package rest;
import java.io.*;
import java.util.*;

public class Tajnik extends Zaposleni
{
	private boolean pravosodniIzpit;

	public Tajnik()
	{
		super();
		this.pravosodniIzpit = false;
	}
	public boolean getIzpit()
	{
		return this.pravosodniIzpit;
	}
	public void setIzpit(boolean izpit)
	{
		this.pravosodniIzpit = izpit;
	}
	public String toString()
	{
		String zapis = "";
		zapis += super.toString();
		zapis += "Ali ima delavec pravosodni izpit: " + getIzpit() + "]";
		zapis += "\r\n";

		return zapis;
	}
	public String shraniKotNiz()
	{
			String zapis = "";
			zapis += "*T\r\n";
			zapis += getIme() + "\r\n";
			zapis += getRD() + "\r\n";
			zapis += getSpol() + "\r\n";
			zapis += getStarost() + "\r\n";
			zapis += getIzpit() + "\r\n";

			zapis += "##\r\n";

			return zapis;
	}
	public static Tajnik preberiIzNiza(ArrayList<String> zapis)
	{
		Tajnik novinec = new Tajnik();

		try
		{
			novinec.setIme(zapis.get(0));
			novinec.setRD(zapis.get(1));
			novinec.setSpo(zapis.get(2));
			novinec.setStarost(Integer.parseInt(zapis.get(3)));
			String n = zapis.get(4);

			Boolean i = false;


			if ( n.equals("True") || n.equals("true"))
			{
				i = true;
			}
			else if( n.equals("False") || n.equals("false"))
			{
				i = false;
			}
			novinec.setIzpit(i);

			return novinec;
		}
		catch(Exception ex)
		{
			System.out.println("Prišlo je do napake: ");
			throw ex;
		}
	}
	public static Tajnik vnosTaj() throws Exception
	{
			BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

			Tajnik novipri = new Tajnik();

			System.out.println("**  Vnos novega tajnika  **");

			String nov = "Tajnik";
			novipri.setTip(nov);


			System.out.println("Vnesi ime delavca (sumniki niso priporoceni, ker jih cmd ne prepozna): ");
			String ime2 = vhod.readLine();
			novipri.setIme(ime2);

			System.out.println("Vnesi Rojstni dan tajnika: ");
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

		loop:
		while(true)
		{
			System.out.println("Vnesite ali ima tajnik pravosodni izpit: ");
			String niz = vhod.readLine();
			boolean izp = false;

			if ( niz.equals("Da") || niz.equals("da") || niz.equals("DA"))
			{
				izp = true;
			}
			else if( niz.equals("Ne") || niz.equals("ne") || niz.equals("NE"))
			{
				izp = false;
			}
			else
			{
				System.out.println("Napaka pri vnosu");
				continue loop;
			}
			novipri.setIzpit(izp);
			break;
		}

		System.out.println("Novi tajnik uspesno vnesen");

		return novipri;
	}

}
=======
package rest;
import java.io.*;
import java.util.*;

public class Tajnik extends Zaposleni
{
	private boolean pravosodniIzpit;

	public Tajnik()
	{
		super();
		this.pravosodniIzpit = false;
	}
	public boolean getIzpit()
	{
		return this.pravosodniIzpit;
	}
	public void setIzpit(boolean izpit)
	{
		this.pravosodniIzpit = izpit;
	}
	public String toString()
	{
		String zapis = "";
		zapis += super.toString();
		zapis += "Ali ima delavec pravosodni izpit: " + getIzpit() + "]";
		zapis += "\r\n";

		return zapis;
	}
	public String shraniKotNiz()
	{
			String zapis = "";
			zapis += "*T\r\n";
			zapis += getIme() + "\r\n";
			zapis += getRD() + "\r\n";
			zapis += getSpol() + "\r\n";
			zapis += getStarost() + "\r\n";
			zapis += getIzpit() + "\r\n";

			zapis += "##\r\n";

			return zapis;
	}
	public static Tajnik preberiIzNiza(ArrayList<String> zapis)
	{
		Tajnik novinec = new Tajnik();

		try
		{
			novinec.setIme(zapis.get(0));
			novinec.setRD(zapis.get(1));
			novinec.setSpo(zapis.get(2));
			novinec.setStarost(Integer.parseInt(zapis.get(3)));
			String n = zapis.get(4);

			Boolean i = false;


			if ( n.equals("True") || n.equals("true"))
			{
				i = true;
			}
			else if( n.equals("False") || n.equals("false"))
			{
				i = false;
			}
			novinec.setIzpit(i);

			return novinec;
		}
		catch(Exception ex)
		{
			System.out.println("Prišlo je do napake: ");
			throw ex;
		}
	}
	public static Tajnik vnosTaj() throws Exception
	{
			BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

			Tajnik novipri = new Tajnik();

			System.out.println("**  Vnos novega tajnika  **");

			String nov = "Tajnik";
			novipri.setTip(nov);


			System.out.println("Vnesi ime delavca (sumniki niso priporoceni, ker jih cmd ne prepozna): ");
			String ime2 = vhod.readLine();
			novipri.setIme(ime2);

			System.out.println("Vnesi Rojstni dan tajnika: ");
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

		loop:
		while(true)
		{
			System.out.println("Vnesite ali ima tajnik pravosodni izpit: ");
			String niz = vhod.readLine();
			boolean izp = false;

			if ( niz.equals("Da") || niz.equals("da") || niz.equals("DA"))
			{
				izp = true;
			}
			else if( niz.equals("Ne") || niz.equals("ne") || niz.equals("NE"))
			{
				izp = false;
			}
			else
			{
				System.out.println("Napaka pri vnosu");
				continue loop;
			}
			novipri.setIzpit(izp);
			break;
		}

		System.out.println("Novi tajnik uspesno vnesen");

		return novipri;
	}

}
>>>>>>> bba9f3dc6e03ed882c48ad5a808d0165642e9017
