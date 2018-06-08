<<<<<<< HEAD
package rest;
import java.io.*;
import java.util.*;

public class Voznik extends Zaposleni
{
  private String kategorija;
  private String vrstaVozila;

  public Voznik()
	{
		super();
		this.kategorija = "neznano";
    this.vrstaVozila = "osebni";
	}
	public String getKat()
	{
		return this.kategorija;
	}
  public String getVrsta()
  {
    return this.vrstaVozila;
  }
	public void setKateg(String k)
	{
		this.kategorija = k;
	}
  public void setVrsta(String v)
  {
    this.vrstaVozila = v;
  }
	public String toString()
	{
		String zapis = "";
		zapis += super.toString();
		zapis += "Delavec ima vozniski izpit za kategorijo: " + getKat();
    zapis += "Delavec vozi avto, ki je vrste: " + getVrsta() + "]";
		zapis += "\r\n";

		return zapis;
	}
	public String shraniKotNiz()
	{
			String zapis = "";
			zapis += "*V\r\n";
			zapis += getIme() + "\r\n";
			zapis += getRD() + "\r\n";
			zapis += getSpol() + "\r\n";
			zapis += getStarost() + "\r\n";
			zapis += getKat() + "\r\n";
      zapis += getVrsta() + "\r\n";

			zapis += "##\r\n";

			return zapis;
	}
	public static Voznik preberiIzNiza(ArrayList<String> zapis)
	{
		Voznik novinec = new Voznik();

		try
		{
			novinec.setIme(zapis.get(0));
			novinec.setRD(zapis.get(1));
			novinec.setSpo(zapis.get(2));
			novinec.setStarost(Integer.parseInt(zapis.get(3)));
			novinec.setKateg(zapis.get(4));
      novinec.setVrsta(zapis.get(5));

			return novinec;
		}
		catch(Exception ex)
		{
			System.out.println("Prišlo je do napake: ");
			throw ex;
		}
	}
	public static Voznik vnosSoferja() throws Exception
	{
			BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

			Voznik novipri = new Voznik();

			System.out.println("**  Vnos novega voznika  **");

			String nov = "Voznik";
			novipri.setTip(nov);


			System.out.println("Vnesi ime voznika (sumniki niso priporoceni, ker jih cmd ne prepozna): ");
			String ime2 = vhod.readLine();
			novipri.setIme(ime2);

			System.out.println("Vnesi Rojstni dan voznika: ");
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

      System.out.println("Vnesite kategorijo vozniskega izpita");
      String katego = vhod.readLine();

      if(katego.equals("A") || katego.equals("A"))
      {
        novipri.setKateg(katego);
      }
      if(katego.equals("b") || katego.equals("B"))
      {
        novipri.setKateg(katego);
      }
      if(katego.equals("c") || katego.equals("C"))
      {
        novipri.setKateg(katego);
      }

		loop:
		while(true)
		{
			System.out.println("Vnesite katero vrsto vozila ima voznik: ");
			String niz = vhod.readLine();
			if ( niz.equals("Osebni") || niz.equals("osebni") || niz.equals("OSEBNI"))
			{
				novipri.setVrsta(niz);
			}
			else if( niz.equals("Tovorni") || niz.equals("tovorni") || niz.equals("TOVORNI"))
			{
				novipri.setVrsta(niz);
			}
      else if(niz.equals("Moped") || niz.equals("moped") || niz.equals("MOPED"))
      {
        novipri.setVrsta(niz);
      }
			else
			{
				System.out.println("Napaka pri vnosu");
				continue loop;
			}
			break;
		}

		System.out.println("Novi voznik uspesno vnesen");

		return novipri;
	}

}
=======
package rest;
import java.io.*;
import java.util.*;

public class Voznik extends Zaposleni
{
  private String kategorija;
  private String vrstaVozila;

  public Voznik()
	{
		super();
		this.kategorija = "neznano";
    this.vrstaVozila = "osebni";
	}
	public String getKat()
	{
		return this.kategorija;
	}
  public String getVrsta()
  {
    return this.vrstaVozila;
  }
	public void setKateg(String k)
	{
		this.kategorija = k;
	}
  public void setVrsta(String v)
  {
    this.vrstaVozila = v;
  }
	public String toString()
	{
		String zapis = "";
		zapis += super.toString();
		zapis += "Delavec ima vozniski izpit za kategorijo: " + getKat();
    zapis += "Delavec vozi avto, ki je vrste: " + getVrsta() + "]";
		zapis += "\r\n";

		return zapis;
	}
	public String shraniKotNiz()
	{
			String zapis = "";
			zapis += "*V\r\n";
			zapis += getIme() + "\r\n";
			zapis += getRD() + "\r\n";
			zapis += getSpol() + "\r\n";
			zapis += getStarost() + "\r\n";
			zapis += getKat() + "\r\n";
      zapis += getVrsta() + "\r\n";

			zapis += "##\r\n";

			return zapis;
	}
	public static Voznik preberiIzNiza(ArrayList<String> zapis)
	{
		Voznik novinec = new Voznik();

		try
		{
			novinec.setIme(zapis.get(0));
			novinec.setRD(zapis.get(1));
			novinec.setSpo(zapis.get(2));
			novinec.setStarost(Integer.parseInt(zapis.get(3)));
			novinec.setKateg(zapis.get(4));
      novinec.setVrsta(zapis.get(5));

			return novinec;
		}
		catch(Exception ex)
		{
			System.out.println("Prišlo je do napake: ");
			throw ex;
		}
	}
	public static Voznik vnosSoferja() throws Exception
	{
			BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

			Voznik novipri = new Voznik();

			System.out.println("**  Vnos novega voznika  **");

			String nov = "Voznik";
			novipri.setTip(nov);


			System.out.println("Vnesi ime voznika (sumniki niso priporoceni, ker jih cmd ne prepozna): ");
			String ime2 = vhod.readLine();
			novipri.setIme(ime2);

			System.out.println("Vnesi Rojstni dan voznika: ");
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

      System.out.println("Vnesite kategorijo vozniskega izpita");
      String katego = vhod.readLine();

      if(katego.equals("A") || katego.equals("A"))
      {
        novipri.setKateg(katego);
      }
      if(katego.equals("b") || katego.equals("B"))
      {
        novipri.setKateg(katego);
      }
      if(katego.equals("c") || katego.equals("C"))
      {
        novipri.setKateg(katego);
      }

		loop:
		while(true)
		{
			System.out.println("Vnesite katero vrsto vozila ima voznik: ");
			String niz = vhod.readLine();
			if ( niz.equals("Osebni") || niz.equals("osebni") || niz.equals("OSEBNI"))
			{
				novipri.setVrsta(niz);
			}
			else if( niz.equals("Tovorni") || niz.equals("tovorni") || niz.equals("TOVORNI"))
			{
				novipri.setVrsta(niz);
			}
      else if(niz.equals("Moped") || niz.equals("moped") || niz.equals("MOPED"))
      {
        novipri.setVrsta(niz);
      }
			else
			{
				System.out.println("Napaka pri vnosu");
				continue loop;
			}
			break;
		}

		System.out.println("Novi voznik uspesno vnesen");

		return novipri;
	}

}
>>>>>>> bba9f3dc6e03ed882c48ad5a808d0165642e9017
