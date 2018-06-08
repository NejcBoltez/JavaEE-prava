<<<<<<< HEAD
package rest;
import java.io.*;
import java.util.*;
public class Raziskovalec extends Zaposleni
{
	private String podrocjeRaziskovanja;

	public Raziskovalec()
	{
		super();
		this.podrocjeRaziskovanja = "neznano";
	}
	public String getPod()
	{
		return this.podrocjeRaziskovanja;
	}
	public void setPodrocje(String x)
	{
		this.podrocjeRaziskovanja = x;
	}
	public String toString()
	{
		String zapis = "";
		zapis += super.toString();
		zapis += "Podrocje raziskovanja: " + getPod() + "]";
		zapis += "\r\n";

		return zapis;
	}
	public String shraniKotNiz()
	{
			String zapis = "";
			zapis += "*R\r\n";
			zapis += getIme() + "\r\n";
			zapis += getRD() + "\r\n";
			zapis += getSpol() + "\r\n";
			zapis += getStarost() + "\r\n";
			zapis += getPod() + "\r\n";

			zapis += "##\r\n";

			return zapis;
	}
	public static Raziskovalec preberiIzNiza(ArrayList<String> zapis)
	{
		Raziskovalec novinec = new Raziskovalec();

		try
		{
			novinec.setIme(zapis.get(0));
			novinec.setRD(zapis.get(1));
			novinec.setSpo(zapis.get(2));
			novinec.setStarost(Integer.parseInt(zapis.get(3)));
			novinec.setPodrocje(zapis.get(4));

			return novinec;
		}
		catch(Exception ex)
		{
			System.out.println("Prislo je do napake: ");
			throw ex;
		}
	}
	public static Raziskovalec vnosRaziskava() throws Exception
	{
		BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

			Raziskovalec novipri = new Raziskovalec();

			System.out.println("**  Vnos novega raziskovalca  **");

			String nov = "Raziskovalec";
			novipri.setTip(nov);

			System.out.println("Vnesi ime delavca (sumniki niso priporoceni, ker jih cmd ne prepozna): ");
			String ime2 = vhod.readLine();
			novipri.setIme(ime2);

			System.out.println("Vnesi Rojstni dan raziskovalca: ");
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


		System.out.println("Vnesi podrocje raziskovanja, ki ga ima raziskovalec: ");
		String niz = vhod.readLine();
		novipri.setPodrocje(niz);

		System.out.println("Novi raziskovalec uspesno vnesen");

		return novipri;
	}

}
=======
package rest;
import java.io.*;
import java.util.*;
public class Raziskovalec extends Zaposleni
{
	private String podrocjeRaziskovanja;

	public Raziskovalec()
	{
		super();
		this.podrocjeRaziskovanja = "neznano";
	}
	public String getPod()
	{
		return this.podrocjeRaziskovanja;
	}
	public void setPodrocje(String x)
	{
		this.podrocjeRaziskovanja = x;
	}
	public String toString()
	{
		String zapis = "";
		zapis += super.toString();
		zapis += "Podrocje raziskovanja: " + getPod() + "]";
		zapis += "\r\n";

		return zapis;
	}
	public String shraniKotNiz()
	{
			String zapis = "";
			zapis += "*R\r\n";
			zapis += getIme() + "\r\n";
			zapis += getRD() + "\r\n";
			zapis += getSpol() + "\r\n";
			zapis += getStarost() + "\r\n";
			zapis += getPod() + "\r\n";

			zapis += "##\r\n";

			return zapis;
	}
	public static Raziskovalec preberiIzNiza(ArrayList<String> zapis)
	{
		Raziskovalec novinec = new Raziskovalec();

		try
		{
			novinec.setIme(zapis.get(0));
			novinec.setRD(zapis.get(1));
			novinec.setSpo(zapis.get(2));
			novinec.setStarost(Integer.parseInt(zapis.get(3)));
			novinec.setPodrocje(zapis.get(4));

			return novinec;
		}
		catch(Exception ex)
		{
			System.out.println("Prislo je do napake: ");
			throw ex;
		}
	}
	public static Raziskovalec vnosRaziskava() throws Exception
	{
		BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

			Raziskovalec novipri = new Raziskovalec();

			System.out.println("**  Vnos novega raziskovalca  **");

			String nov = "Raziskovalec";
			novipri.setTip(nov);

			System.out.println("Vnesi ime delavca (sumniki niso priporoceni, ker jih cmd ne prepozna): ");
			String ime2 = vhod.readLine();
			novipri.setIme(ime2);

			System.out.println("Vnesi Rojstni dan raziskovalca: ");
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


		System.out.println("Vnesi podrocje raziskovanja, ki ga ima raziskovalec: ");
		String niz = vhod.readLine();
		novipri.setPodrocje(niz);

		System.out.println("Novi raziskovalec uspesno vnesen");

		return novipri;
	}

}
>>>>>>> bba9f3dc6e03ed882c48ad5a808d0165642e9017
