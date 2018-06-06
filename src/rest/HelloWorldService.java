package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/tovarna")
public class HelloWorldService {
	
	static ArrayList<Tovarna> tovarnaList = new ArrayList<Tovarna>();
	static ArrayList<Zaposleni> zaposleniList= new ArrayList<Zaposleni>();
	
	static {
		tovarnaList.add(new Tovarna(1, "Tovarna 1"));
		tovarnaList.add(new Tovarna(2, "Tovarna 2"));
		tovarnaList.add(new Tovarna(3, "Tovarna 3"));
		
	}
	
	@GET
	@Path("/sayHello")
	public String sayHello() {
		return "<h1>Hello World</h1>";
	}
	
	@Path("/PrintZ")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Zaposleni> PrintZ() {
		for (Zaposleni z : zaposleniList) {
			System.out.println("Delavec: ");
			System.out.println(z);
		}
		return zaposleniList;
	}
	@Path("/DeleteT")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void DeleteT(int id) {
		int idTo=id;
		Tovarna to=null;
		for (Tovarna t : tovarnaList) {
			if(t.getId()==idTo){
				to=t;
				break;
			}
		}
		tovarnaList.remove(to);
		
	}
	@Path("/DeleteZ")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void DeleteZ(int id) {
		int idZa=id;
		Zaposleni za=null;
		for (Zaposleni z : zaposleniList) {
			if(z.getId()==id){
				za=z;
				break;
			}
		}
		zaposleniList.remove(za);
		int idT=za.getIdTov();
		Tovarna to=null;
		for (Tovarna t : tovarnaList) {
			if(t.getId()==idT){
				to=t;
				break;
			}
		}
		to.getDelavci().remove(za);
		
	}
	@Path("/EditT")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Tovarna EditT(int tovarna) {
		Tovarna to=null;
		for (Tovarna t : tovarnaList) {
			if(t.getId()==tovarna){
				to=t;
				break;
			}
		}
		return to;
		
	}
	@Path("/SpremeniT")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void SpremeniT(Tovarna tovarna) {
		for (Tovarna t : tovarnaList) {
			if(t.getId()==tovarna.getId()){
				t.setNaziv(tovarna.getNaziv());
			}
		}
		
	}
	@Path("/EditZ/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Zaposleni EditZ(int delavec) {
		Zaposleni zap =null;
		for (Zaposleni z : zaposleniList) {
			if(z.getId()==delavec){
				zap=z;
				break;
			}
		}
		return zap;
		
	}
	@Path("/SpremeniZ/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Zaposleni SpremeniZ(Zaposleni dela) {
		Zaposleni nov=null;
		System.out.println(dela);
		for (Zaposleni z : zaposleniList) {
			System.out.println(z.getId());
			if(z.getId()==dela.getId()){
				z.setImeDelavca(dela.getImeDelavca());
				z.setTip(dela.getTip());
				z.setSpol(dela.getSpol());
				z.setSektor(dela.getSektor());
				z.setIzobrazba(dela.getIzobrazba());
				z.setIdTov(dela.getIdTov());
				nov=z;
			}
		}
		System.out.println(nov);
		return nov;
		
	}
	
	@Path("/dodajZaposleni")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void dodajZaposleni(Zaposleni delavec)
    {
		int idZ = 1;
		Tovarna tova = null;
		for (Zaposleni z : zaposleniList) {
			idZ++;
		}
		for (Tovarna t : tovarnaList) {
			if (delavec.getIdTov()== t.getId()) {
				tova = t;
			}
		}
		String RD = "";
		System.out.println("Hello");
		System.out.println("delavec:"+delavec.getId());
		for(int i=0; i<delavec.getRojstniDatum().length();i++) {
			if(delavec.getRojstniDatum().charAt(i)=='T') {
				break;
			}
			else {
				RD=RD+delavec.getRojstniDatum().charAt(i);
			}
		}
		delavec.setId(idZ);
		delavec.setRojstniDatum(RD);
		System.out.println(delavec.getIdTov());
		tova.addDelavci(delavec);
		zaposleniList.add(delavec);
		
    }
	@Path("/Delavecizbris")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void Izbrisdelavca(int id)
    {	
		zaposleniList.remove(id);
    }
	@Path("/Tovarnaizbris")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void Izbristovarne(int id)
    {	
		tovarnaList.remove(id);
    }
	
	@Path("dodajTovarno")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void dodajTovarno(String naziv)
    {	
		//System.out.println("Hello");
		int id = 1;
		for (Tovarna to : tovarnaList) {
			id++;
		}
		tovarnaList.add(new Tovarna(id, naziv));
    }
	@Path("Tovarna")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Tovarna> Tovarna()
    {	
		return tovarnaList;
    }

	
//	@Path("DodajIzobrazbo")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//	public void getIzobrazba(Zaposleni delavec, String izobra) {
//		Zaposleni.setIzo(delavec, izobra);
//	}
//	
//	@Path("DodajIme")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//	public void getIme(Zaposleni delavec, String ime) {
//		Zaposleni.setImeDelavca(delavec, ime);
//	}
//	
//	@Path("DodajRojstvo")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//	public void getRojstvo(Zaposleni delavec, String rojstvo) {
//		Zaposleni.setRojstniDatum(delavec, rojstvo);
//	}
//
//	@Path("DodajSektor")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//	public void getSektor(Zaposleni delavec, String sek) {
//		delavec.setSektor(delavec, sek);
//	}
//	@Path("DodajSpol")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//	public void getSpol(Zaposleni delavec, String spol) {
//		delavec.setSpol(delavec, spol);
//	}
//	@Path("DodajStarost")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//	public void getStarost(Zaposleni delavec, int st) {
//		delavec.setStarost(delavec, st);
//	}
//	@Path("DodajTip")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//	public void getTip(Zaposleni delavec, String tip) {
//		delavec.setTip(delavec, tip);
//	}
}
