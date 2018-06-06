package rest;
import java.io.*;
import java.util.*;

public class DelavecVproizvodnji extends Zaposleni
{
	private int normaNaUro;

	public DelavecVproizvodnji()
	{
		super();
		this.normaNaUro = 0;
	}
	public int getNorma()
	{
		return this.normaNaUro;
	}
	public void setNorma(int nor)
	{
		this.normaNaUro = nor;
	}
	public String toString()
	{
		String zapis = "";
		zapis += super.toString();
		zapis += "Norma delavca v evrih na uro: " + getNorma() + "]";
		zapis += "\r\n";

		return zapis;
	}
	public String shraniKotNiz()
		{
			String zapis = "";
			zapis += "*dvp\r\n";
			zapis += getIme() + "\r\n";
			zapis += getRD() + "\r\n";
			zapis += getSpol() + "\r\n";
			zapis += getStarost() + "\r\n";
			zapis += getNorma() + "\r\n";

			zapis += "##\r\n";

			return zapis;
		}
	public static DelavecVproizvodnji preberiIzNiza(ArrayList<String> zapis)
	{
		DelavecVproizvodnji novinec = new DelavecVproizvodnji();

		try
		{
			novinec.setIme(zapis.get(0));
			novinec.setRD(zapis.get(1));
			novinec.setSpo(zapis.get(2));
			novinec.setStarost(Integer.parseInt(zapis.get(3)));
			novinec.setNorma(Integer.parseInt(zapis.get(4)));

			return novinec;
		}
		catch(Exception ex)
		{
			System.out.println("Prislo je do napake: ");
			throw ex;
		}
	}
	public static DelavecVproizvodnji vnosProizvod() throws Exception
	{
		BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

			DelavecVproizvodnji novipri = new DelavecVproizvodnji();

			System.out.println("**  Vnos novega delavca v proizvodnji  **");

			String nov = "Delavec v proizvodnji";
			novipri.setTip(nov);

			System.out.println("Vnesi ime delavca (sumniki niso priporoceni, ker jih cmd ne prepozna): ");
			String ime2 = vhod.readLine();
			novipri.setIme(ime2);

			System.out.println("Vnesi Rojstni dan delavca: ");
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

		System.out.println("Vnesi normo, ki jo ima delavec(vnesite celo stevilo): ");
		int niz = Integer.parseInt(vhod.readLine());
		novipri.setNorma(niz);

		System.out.println("Novi delavec uspesno vnesen");

		return novipri;
	}
}
