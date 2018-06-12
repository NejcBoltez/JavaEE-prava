package rest;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

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

	protected void SQLzapisZ(Zaposleni zap, Tovarna tov)throws ServletException,IOException, SQLException
	{
	
	    try
	    {
	         System.out.println("Pozdrav");
	         Class.forName("com.mysql.jdbc.Driver").newInstance();
	         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","Opomin12."); 
	         
		     int idT = zap.getIdTov();
		     int idTova=tov.getId();
	         Statement st=con.createStatement();
	         int Tov=0;
	         ResultSet t=st.executeQuery("Select * from tovarna");
	         while(t.next()) {
	        	 int idTov=t.getInt("idT");
	        	 System.out.println(idTov);
	        	 if (idT==idTov) {
	        		 Tov++;
	        	 }
	        	 else {
	        		 continue;
	        	 }
	         }
	         if(Tov == 0){
	        	 System.out.println("Hello");
	        	 st.executeUpdate("insert into tovarna values("+idTova+",'"+tov.getNaziv()+"')");
	         }
	         st.executeUpdate("insert into zaposleni values("+zap.getId()+",'"+zap.getImeDelavca()+"',"+idT+",'"+zap.getTip()+"','"+zap.getRojstniDatum()+"','"+zap.getSpol()+"',"+zap.getStarost()+",'"+zap.getSektor()+"','"+zap.getIzobrazba()+"')"); 
	         
		     con.close();
	         System.out.println("Pozdrav");
	    }
	    catch (Exception e){
	        e.printStackTrace();
	    }
	
	}
}
