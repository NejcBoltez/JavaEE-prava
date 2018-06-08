<<<<<<< HEAD
package rest;
import java.io.*;
import java.util.*;

public class Tovarna implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9154657259476711081L;
	private int id;
	private String naziv;
	private List<Zaposleni> delavci;

	public Tovarna(){
		delavci = new ArrayList<Zaposleni>();
	}
	
	public Tovarna(int id, String naziv)
	{
		delavci = new ArrayList<Zaposleni>();
		this.id = id;
		this.naziv = naziv;
	}
	
	
//	public static Tovarna Novo(Tovarna t)
//	{
//		System.out.println("Pozdravljeni");
//		t = new Tovarna();
//		//System.out.println(t);
//		return t;
//	}
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//	public ArrayList<Zaposleni> getDelavec()
//	{
//		return this.delavci;
//	}
//	public static void setDelavci(Tovarna t, Zaposleni delavec)
//	{
//		t.delavci.add(delavec);
//		for(Zaposleni z : t.delavci) {
//			System.out.println(z);
//		}
//		System.out.println();
//	}
	public void Print() {
		for(Zaposleni z : this.delavci) {
			System.out.println(z);
		}
		System.out.println("HELLO");
	}

	public List<Zaposleni> getDelavci() {
		return delavci;
	}
	
	public void setDelavci(List<Zaposleni> delavci) {
		this.delavci = delavci;
	}

	public void addDelavci(Zaposleni delavci) {
		this.delavci.add(delavci);
	}
	public String toString()
	{
		String print = "";
		if ( this.delavci.size() == 0)
		{
			print += "\n V tovarni trenutno ni zaposlenih.";
		}
		if ( this.delavci.size() >= 1)
		{
			print += "\nTrenutno so v tovarni zaposleni naslednji delavci:\n";

		for(int i=0; i<this.delavci.size(); i++)
		{

			if(this.delavci.get(i) != null)
			{
				print += this.delavci.get(i).toString() + "\r\n"; // Ukaza sta enaka!
			}

		}
		}
		print += "\r\n\r\n";
		return print;
	}

	public void shraniVDatoteko(String imeDatoteke) throws IOException
	{
		FileWriter fw = new FileWriter(imeDatoteke, true); // Drugi parameter doloca, da se obstojeci datoteki zapis doda
		PrintWriter dat = new PrintWriter(fw);

		for(Zaposleni delavec : this.delavci)
		{
			dat.print(delavec.shraniKotNiz());
		}
		dat.println("###");

		dat.close();
	}


	/*public void dodajIzDatoteke(String imeDatoteke) throws IOException
	{
		FileReader fr = new FileReader(imeDatoteke);
		BufferedReader dat = new BufferedReader(fr);

		ArrayList<String> podatkiDelavca;
		while(dat.ready())
		{
			String vrstica = dat.readLine().trim();
			if(vrstica.equals("*I"))
			{
				podatkiDelavca = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("##"))
				{
					vrstica = dat.readLine().trim();
					podatkiDelavca.add(vrstica);

				}
				Informatik delavec = Informatik.preberiIzNiza(podatkiDelavca);
				delavec.setTip(delavec, "Informatik");
				this.setDelavci(delavec);
			}
			if(vrstica.equals("*DVP"))
			{
				podatkiDelavca = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("##"))
				{
					vrstica = dat.readLine().trim();
					podatkiDelavca.add(vrstica);

				}
				DelavecVpisarni delavec = DelavecVpisarni.preberiIzNiza(podatkiDelavca);
				delavec.setTip(delavec, "Delavec v pisarni");
				this.setDelavci(delavec);
			}
			if(vrstica.equals("*R"))
			{
				podatkiDelavca = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("##"))
				{
					vrstica = dat.readLine().trim();
					podatkiDelavca.add(vrstica);

				}
				Raziskovalec delavec = Raziskovalec.preberiIzNiza(podatkiDelavca);
				delavec.setTip(delavec, "Raziskovalec");
				this.setDelavci(delavec);
			}
			if(vrstica.equals("*dvp"))
			{
				podatkiDelavca = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("##"))
				{
					vrstica = dat.readLine().trim();
					podatkiDelavca.add(vrstica);

				}
				DelavecVproizvodnji delavec = DelavecVproizvodnji.preberiIzNiza(podatkiDelavca);
				delavec.setTip(delavec, "Delavec v proizvodnji");
				this.setDelavci(delavec);
			}
			if(vrstica.equals("*T"))
			{
				podatkiDelavca = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("##"))
				{
					vrstica = dat.readLine().trim();
					podatkiDelavca.add(vrstica);

				}
				Tajnik delavec = Tajnik.preberiIzNiza(podatkiDelavca);
				delavec.setTip(delavec, "Tajnik");
				this.setDelavci(delavec);
			}
			if(vrstica.equals("*V"))
			{
				podatkiDelavca = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("##"))
				{
					vrstica = dat.readLine().trim();
					podatkiDelavca.add(vrstica);
				}
				Voznik delavec = Voznik.preberiIzNiza(podatkiDelavca);
				delavec.setTip(delavec, "Voznik");
				this.setDelavci(delavec);
			}
			if(vrstica.equals("###"))
			{
				break;
			}
		}
		dat.close();
	}*/

	public static void main(String[] args) throws IOException
	{

//		System.out.println("\n*** Dobrodosli v programu! ***\n");
//		Zaposleni novidelavec= new Zaposleni();
//		Tovarna tovarna = new Tovarna();
		while (true)
		{
			/*BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Pritisnite (d) za vnos delavca");
			System.out.println("Pritisnite (i) za izpis vseh zaposlenih v tovarni");
			System.out.println("Pritisnite (p) za izpis dolocenega tipa zaposlenih");
			System.out.println("Pritisnite (r) za branje iz datoteke");
			System.out.println("Pritisnite (s) za shranjevanje");
			System.out.println("Pritisnite (e) za izbris dolocenega delavca");
			System.out.println("Pritisnite (x) za izhod");
			String niz;

			try
			{
				niz = vhod.readLine();
				char izbira = niz.charAt(0);
				String datoteka;

				switch (izbira)
				{
					case 'd':
						System.out.println("Izberite tip (1 - Informatik, 2 - Delavec v pisarni, 3 - Delavec v proizvodnji, 4 - Tajnik, 5 - Raziskovalec, 6 - Voznik): ");
						izbira = vhod.readLine()/*.toLowerCase().charAt(0);

						switch(izbira)
						{
							case '1':
								novidelavec = Informatik.vnosInfo();
								break;
							case '2':
								novidelavec = DelavecVpisarni.vnosDvp();
								break;
							case '3':
								novidelavec = DelavecVproizvodnji.vnosProizvod();
								break;
							case '4':
								novidelavec = Tajnik.vnosTaj();
								break;
							case '5':
								novidelavec = Raziskovalec.vnosRaziskava();
								break;
							case '6':
								novidelavec = Voznik.vnosSoferja();
								break;
							default:
								System.out.println("Napaka pri vnosu");
								break;
						}
						tovarna.setDelavci(novidelavec);


					case 'i':
						System.out.println(tovarna);
						break;

					case 'p':
						System.out.println("Izberite tip (1 - Informatik, 2 - Delavec v pisarni, 3 - Delavec v proizvodnji, 4 - Tajnik, 5 - Raziskovalec, 6 - Voznik): ");
						int novejse = Integer.parseInt(vhod.readLine());
						for(int i=0; i<tovarna.delavci.size(); i++)
						{
							switch(novejse)
							{
								case 1:
									if(tovarna.delavci.get(i) instanceof Informatik)
									{
										System.out.println(tovarna.delavci.get(i).toString());
										break;
									}
								case 2:
									if(tovarna.delavci.get(i) instanceof DelavecVpisarni)
									{
										System.out.println(tovarna.delavci.get(i).toString());
										break;
									}
								case 3:
									if(tovarna.delavci.get(i) instanceof DelavecVproizvodnji)
									{
										System.out.println(tovarna.delavci.get(i).toString());
										break;
									}

								case 4:
									if (tovarna.delavci.get(i) instanceof Tajnik)
									{
										System.out.println(tovarna.delavci.get(i).toString());
										break;
									}
								case 5:
									if(tovarna.delavci.get(i) instanceof Raziskovalec)
									{
										System.out.println(tovarna.delavci.get(i).toString());
										break;
									}
								case 6:
									if(tovarna.delavci.get(i) instanceof Voznik)
									{
										System.out.println(tovarna.delavci.get(i).toString());
										break;
									}

								default:
									System.out.println("Prislo je do napake");
									break;
							}
						}
						break;

					case 's':
						System.out.print(" Vnesi ime datoteke:\n");
						datoteka = vhod.readLine();
						tovarna.shraniVDatoteko(datoteka);
						System.out.print("\nDelavci so shranjeni!\n\n");
						break;
					case 'r':
						System.out.print(" Vnesi ime datoteke:\n");
						datoteka = vhod.readLine();
						tovarna.dodajIzDatoteke(datoteka);
						System.out.print("\nV tovarni je trenutno zaposlenih " + tovarna.delavci.size() + " delavcev!\n\n");
						break;
					case'e':
						System.out.println("Izberite tip (1 - Informatik, 2 - Delavec v pisarni, 3 - Delavec v proizvodnji, 4 - Tajnik, 5 - Raziskovalec, 6 - Voznik): ");
						int tip = Integer.parseInt(vhod.readLine());

						System.out.println("Vnesi ime delavca, ki ga zelite odstraniti iz seznama: ");
						String imeDel = vhod.readLine();

						System.out.println("Vnesi starost delavca, ki ga zelite odstraniti iz  seznama");
						int starDel = Integer.parseInt(vhod.readLine());

						System.out.println("Vnesite spol delavca, ki ga zelite odstraniti: ");
						String spolDel = vhod.readLine();

						for(int i = 0; i < tovarna.getDelavec().size(); i++)
						{
							switch(tip)
							{

								case 1:
								if(tovarna.delavci.get(i) instanceof Informatik)
								{
									if(imeDel.equals(tovarna.getDelavec().get(i).getImeDelavca()))
									{
											if(starDel == tovarna.getDelavec().get(i).getStarost())
											{
												if (spolDel.equals(tovarna.getDelavec().get(i).getSpol()))
												{
													tovarna.getDelavec().remove(i);
													System.out.println("Delavec uspesno odstranjen");
													break;
												}
											}
										}
									}
								case 2:
									if(tovarna.delavci.get(i) instanceof DelavecVpisarni)
									{
										if(imeDel.equals(tovarna.getDelavec().get(i).getImeDelavca()))
										{
											if(starDel == tovarna.getDelavec().get(i).getStarost())
											{
												if (spolDel.equals(tovarna.getDelavec().get(i).getSpol()))
												{
													tovarna.getDelavec().remove(i);
													System.out.println("Delavec uspesno odstranjen");
													break;
												}
											}
										}
									}
								case 3:
									if(tovarna.delavci.get(i) instanceof DelavecVproizvodnji)
									{
										if(imeDel.equals(tovarna.getDelavec().get(i).getImeDelavca()))
										{
											if(starDel == tovarna.getDelavec().get(i).getStarost())
											{
												if (spolDel.equals(tovarna.getDelavec().get(i).getSpol()))
												{
													tovarna.getDelavec().remove(i);
													System.out.println("Delavec uspesno odstranjen");
													break;
												}
											}
										}
									}
								case 4:
									if(tovarna.delavci.get(i) instanceof Tajnik)
									{
										if(imeDel.equals(tovarna.getDelavec().get(i).getImeDelavca()))
										{
											if(starDel == tovarna.getDelavec().get(i).getStarost())
											{
												if (spolDel.equals(tovarna.getDelavec().get(i).getSpol()))
												{
													tovarna.getDelavec().remove(i);
													System.out.println("Delavec uspesno odstranjen");
													break;
												}
											}
										}
									}
								case 5:
									if(tovarna.delavci.get(i) instanceof Raziskovalec)
									{
										if(imeDel.equals(tovarna.getDelavec().get(i).getImeDelavca()))
										{
											if(starDel == tovarna.getDelavec().get(i).getStarost())
											{
												if (spolDel.equals(tovarna.getDelavec().get(i).getSpol()))
												{
													tovarna.getDelavec().remove(i);
													System.out.println("Delavec uspesno odstranjen");
													break;
												}
											}
										}
									}
								case 6:
									if(tovarna.delavci.get(i) instanceof Voznik)
									{
										if(imeDel.equals(tovarna.getDelavec().get(i).getImeDelavca()))
										{
											if(starDel == tovarna.getDelavec().get(i).getStarost())
											{
												if (spolDel.equals(tovarna.getDelavec().get(i).getSpol()))
												{
													tovarna.getDelavec().remove(i);
													System.out.println("Voznik uspesno odstranjen");
													break;
												}
											}
										}
									}

								default:
									break;
						}
					}

					break;
				case'x':
					System.out.println("Konec programa");
					return;
				default:
					System.out.println("Prislo je do napake");
					break;
				}
			}
			catch (Exception e)
			{
				System.out.println("Napaka - poskusite znova!");
			}*/
		}
	}
}
=======
package rest;
import java.io.*;
import java.util.*;

public class Tovarna implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9154657259476711081L;
	private int id;
	private String naziv;
	private List<Zaposleni> delavci;

	public Tovarna(){
		delavci = new ArrayList<Zaposleni>();
	}
	
	public Tovarna(int id, String naziv)
	{
		delavci = new ArrayList<Zaposleni>();
		this.id = id;
		this.naziv = naziv;
	}
	
	
//	public static Tovarna Novo(Tovarna t)
//	{
//		System.out.println("Pozdravljeni");
//		t = new Tovarna();
//		//System.out.println(t);
//		return t;
//	}
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//	public ArrayList<Zaposleni> getDelavec()
//	{
//		return this.delavci;
//	}
//	public static void setDelavci(Tovarna t, Zaposleni delavec)
//	{
//		t.delavci.add(delavec);
//		for(Zaposleni z : t.delavci) {
//			System.out.println(z);
//		}
//		System.out.println();
//	}
	public void Print() {
		for(Zaposleni z : this.delavci) {
			System.out.println(z);
		}
		System.out.println("HELLO");
	}

	public List<Zaposleni> getDelavci() {
		return delavci;
	}
	
	public void setDelavci(List<Zaposleni> delavci) {
		this.delavci = delavci;
	}

	public void addDelavci(Zaposleni delavci) {
		this.delavci.add(delavci);
	}
	public String toString()
	{
		String print = "";
		if ( this.delavci.size() == 0)
		{
			print += "\n V tovarni trenutno ni zaposlenih.";
		}
		if ( this.delavci.size() >= 1)
		{
			print += "\nTrenutno so v tovarni zaposleni naslednji delavci:\n";

		for(int i=0; i<this.delavci.size(); i++)
		{

			if(this.delavci.get(i) != null)
			{
				print += this.delavci.get(i).toString() + "\r\n"; // Ukaza sta enaka!
			}

		}
		}
		print += "\r\n\r\n";
		return print;
	}

	public void shraniVDatoteko(String imeDatoteke) throws IOException
	{
		FileWriter fw = new FileWriter(imeDatoteke, true); // Drugi parameter doloca, da se obstojeci datoteki zapis doda
		PrintWriter dat = new PrintWriter(fw);

		for(Zaposleni delavec : this.delavci)
		{
			dat.print(delavec.shraniKotNiz());
		}
		dat.println("###");

		dat.close();
	}


	/*public void dodajIzDatoteke(String imeDatoteke) throws IOException
	{
		FileReader fr = new FileReader(imeDatoteke);
		BufferedReader dat = new BufferedReader(fr);

		ArrayList<String> podatkiDelavca;
		while(dat.ready())
		{
			String vrstica = dat.readLine().trim();
			if(vrstica.equals("*I"))
			{
				podatkiDelavca = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("##"))
				{
					vrstica = dat.readLine().trim();
					podatkiDelavca.add(vrstica);

				}
				Informatik delavec = Informatik.preberiIzNiza(podatkiDelavca);
				delavec.setTip(delavec, "Informatik");
				this.setDelavci(delavec);
			}
			if(vrstica.equals("*DVP"))
			{
				podatkiDelavca = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("##"))
				{
					vrstica = dat.readLine().trim();
					podatkiDelavca.add(vrstica);

				}
				DelavecVpisarni delavec = DelavecVpisarni.preberiIzNiza(podatkiDelavca);
				delavec.setTip(delavec, "Delavec v pisarni");
				this.setDelavci(delavec);
			}
			if(vrstica.equals("*R"))
			{
				podatkiDelavca = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("##"))
				{
					vrstica = dat.readLine().trim();
					podatkiDelavca.add(vrstica);

				}
				Raziskovalec delavec = Raziskovalec.preberiIzNiza(podatkiDelavca);
				delavec.setTip(delavec, "Raziskovalec");
				this.setDelavci(delavec);
			}
			if(vrstica.equals("*dvp"))
			{
				podatkiDelavca = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("##"))
				{
					vrstica = dat.readLine().trim();
					podatkiDelavca.add(vrstica);

				}
				DelavecVproizvodnji delavec = DelavecVproizvodnji.preberiIzNiza(podatkiDelavca);
				delavec.setTip(delavec, "Delavec v proizvodnji");
				this.setDelavci(delavec);
			}
			if(vrstica.equals("*T"))
			{
				podatkiDelavca = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("##"))
				{
					vrstica = dat.readLine().trim();
					podatkiDelavca.add(vrstica);

				}
				Tajnik delavec = Tajnik.preberiIzNiza(podatkiDelavca);
				delavec.setTip(delavec, "Tajnik");
				this.setDelavci(delavec);
			}
			if(vrstica.equals("*V"))
			{
				podatkiDelavca = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("##"))
				{
					vrstica = dat.readLine().trim();
					podatkiDelavca.add(vrstica);
				}
				Voznik delavec = Voznik.preberiIzNiza(podatkiDelavca);
				delavec.setTip(delavec, "Voznik");
				this.setDelavci(delavec);
			}
			if(vrstica.equals("###"))
			{
				break;
			}
		}
		dat.close();
	}*/

	public static void main(String[] args) throws IOException
	{

//		System.out.println("\n*** Dobrodosli v programu! ***\n");
//		Zaposleni novidelavec= new Zaposleni();
//		Tovarna tovarna = new Tovarna();
		while (true)
		{
			/*BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Pritisnite (d) za vnos delavca");
			System.out.println("Pritisnite (i) za izpis vseh zaposlenih v tovarni");
			System.out.println("Pritisnite (p) za izpis dolocenega tipa zaposlenih");
			System.out.println("Pritisnite (r) za branje iz datoteke");
			System.out.println("Pritisnite (s) za shranjevanje");
			System.out.println("Pritisnite (e) za izbris dolocenega delavca");
			System.out.println("Pritisnite (x) za izhod");
			String niz;

			try
			{
				niz = vhod.readLine();
				char izbira = niz.charAt(0);
				String datoteka;

				switch (izbira)
				{
					case 'd':
						System.out.println("Izberite tip (1 - Informatik, 2 - Delavec v pisarni, 3 - Delavec v proizvodnji, 4 - Tajnik, 5 - Raziskovalec, 6 - Voznik): ");
						izbira = vhod.readLine()/*.toLowerCase().charAt(0);

						switch(izbira)
						{
							case '1':
								novidelavec = Informatik.vnosInfo();
								break;
							case '2':
								novidelavec = DelavecVpisarni.vnosDvp();
								break;
							case '3':
								novidelavec = DelavecVproizvodnji.vnosProizvod();
								break;
							case '4':
								novidelavec = Tajnik.vnosTaj();
								break;
							case '5':
								novidelavec = Raziskovalec.vnosRaziskava();
								break;
							case '6':
								novidelavec = Voznik.vnosSoferja();
								break;
							default:
								System.out.println("Napaka pri vnosu");
								break;
						}
						tovarna.setDelavci(novidelavec);


					case 'i':
						System.out.println(tovarna);
						break;

					case 'p':
						System.out.println("Izberite tip (1 - Informatik, 2 - Delavec v pisarni, 3 - Delavec v proizvodnji, 4 - Tajnik, 5 - Raziskovalec, 6 - Voznik): ");
						int novejse = Integer.parseInt(vhod.readLine());
						for(int i=0; i<tovarna.delavci.size(); i++)
						{
							switch(novejse)
							{
								case 1:
									if(tovarna.delavci.get(i) instanceof Informatik)
									{
										System.out.println(tovarna.delavci.get(i).toString());
										break;
									}
								case 2:
									if(tovarna.delavci.get(i) instanceof DelavecVpisarni)
									{
										System.out.println(tovarna.delavci.get(i).toString());
										break;
									}
								case 3:
									if(tovarna.delavci.get(i) instanceof DelavecVproizvodnji)
									{
										System.out.println(tovarna.delavci.get(i).toString());
										break;
									}

								case 4:
									if (tovarna.delavci.get(i) instanceof Tajnik)
									{
										System.out.println(tovarna.delavci.get(i).toString());
										break;
									}
								case 5:
									if(tovarna.delavci.get(i) instanceof Raziskovalec)
									{
										System.out.println(tovarna.delavci.get(i).toString());
										break;
									}
								case 6:
									if(tovarna.delavci.get(i) instanceof Voznik)
									{
										System.out.println(tovarna.delavci.get(i).toString());
										break;
									}

								default:
									System.out.println("Prislo je do napake");
									break;
							}
						}
						break;

					case 's':
						System.out.print(" Vnesi ime datoteke:\n");
						datoteka = vhod.readLine();
						tovarna.shraniVDatoteko(datoteka);
						System.out.print("\nDelavci so shranjeni!\n\n");
						break;
					case 'r':
						System.out.print(" Vnesi ime datoteke:\n");
						datoteka = vhod.readLine();
						tovarna.dodajIzDatoteke(datoteka);
						System.out.print("\nV tovarni je trenutno zaposlenih " + tovarna.delavci.size() + " delavcev!\n\n");
						break;
					case'e':
						System.out.println("Izberite tip (1 - Informatik, 2 - Delavec v pisarni, 3 - Delavec v proizvodnji, 4 - Tajnik, 5 - Raziskovalec, 6 - Voznik): ");
						int tip = Integer.parseInt(vhod.readLine());

						System.out.println("Vnesi ime delavca, ki ga zelite odstraniti iz seznama: ");
						String imeDel = vhod.readLine();

						System.out.println("Vnesi starost delavca, ki ga zelite odstraniti iz  seznama");
						int starDel = Integer.parseInt(vhod.readLine());

						System.out.println("Vnesite spol delavca, ki ga zelite odstraniti: ");
						String spolDel = vhod.readLine();

						for(int i = 0; i < tovarna.getDelavec().size(); i++)
						{
							switch(tip)
							{

								case 1:
								if(tovarna.delavci.get(i) instanceof Informatik)
								{
									if(imeDel.equals(tovarna.getDelavec().get(i).getImeDelavca()))
									{
											if(starDel == tovarna.getDelavec().get(i).getStarost())
											{
												if (spolDel.equals(tovarna.getDelavec().get(i).getSpol()))
												{
													tovarna.getDelavec().remove(i);
													System.out.println("Delavec uspesno odstranjen");
													break;
												}
											}
										}
									}
								case 2:
									if(tovarna.delavci.get(i) instanceof DelavecVpisarni)
									{
										if(imeDel.equals(tovarna.getDelavec().get(i).getImeDelavca()))
										{
											if(starDel == tovarna.getDelavec().get(i).getStarost())
											{
												if (spolDel.equals(tovarna.getDelavec().get(i).getSpol()))
												{
													tovarna.getDelavec().remove(i);
													System.out.println("Delavec uspesno odstranjen");
													break;
												}
											}
										}
									}
								case 3:
									if(tovarna.delavci.get(i) instanceof DelavecVproizvodnji)
									{
										if(imeDel.equals(tovarna.getDelavec().get(i).getImeDelavca()))
										{
											if(starDel == tovarna.getDelavec().get(i).getStarost())
											{
												if (spolDel.equals(tovarna.getDelavec().get(i).getSpol()))
												{
													tovarna.getDelavec().remove(i);
													System.out.println("Delavec uspesno odstranjen");
													break;
												}
											}
										}
									}
								case 4:
									if(tovarna.delavci.get(i) instanceof Tajnik)
									{
										if(imeDel.equals(tovarna.getDelavec().get(i).getImeDelavca()))
										{
											if(starDel == tovarna.getDelavec().get(i).getStarost())
											{
												if (spolDel.equals(tovarna.getDelavec().get(i).getSpol()))
												{
													tovarna.getDelavec().remove(i);
													System.out.println("Delavec uspesno odstranjen");
													break;
												}
											}
										}
									}
								case 5:
									if(tovarna.delavci.get(i) instanceof Raziskovalec)
									{
										if(imeDel.equals(tovarna.getDelavec().get(i).getImeDelavca()))
										{
											if(starDel == tovarna.getDelavec().get(i).getStarost())
											{
												if (spolDel.equals(tovarna.getDelavec().get(i).getSpol()))
												{
													tovarna.getDelavec().remove(i);
													System.out.println("Delavec uspesno odstranjen");
													break;
												}
											}
										}
									}
								case 6:
									if(tovarna.delavci.get(i) instanceof Voznik)
									{
										if(imeDel.equals(tovarna.getDelavec().get(i).getImeDelavca()))
										{
											if(starDel == tovarna.getDelavec().get(i).getStarost())
											{
												if (spolDel.equals(tovarna.getDelavec().get(i).getSpol()))
												{
													tovarna.getDelavec().remove(i);
													System.out.println("Voznik uspesno odstranjen");
													break;
												}
											}
										}
									}

								default:
									break;
						}
					}

					break;
				case'x':
					System.out.println("Konec programa");
					return;
				default:
					System.out.println("Prislo je do napake");
					break;
				}
			}
			catch (Exception e)
			{
				System.out.println("Napaka - poskusite znova!");
			}*/
		}
	}
}
>>>>>>> bba9f3dc6e03ed882c48ad5a808d0165642e9017
