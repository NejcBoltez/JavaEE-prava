package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/Zaposleni")
public class HelloWorldService2 {
	@Path("DodajIzobrazbo")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	public void getIzobrazba(Zaposleni delavec, String izobra) {
		Zaposleni.setIzo(delavec, izobra);
	}
	
	@Path("DodajIme")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	public void getIme(Zaposleni delavec, String ime) {
		Zaposleni.setImeDelavca(delavec, ime);
	}
	
	@Path("DodajRojstvo")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	public void getRojstvo(Zaposleni delavec, String rojstvo) {
		Zaposleni.setRojstniDatum(delavec, rojstvo);
	}

	@Path("DodajSektor")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	public void getSektor(Zaposleni delavec, String sek) {
		delavec.setSektor(delavec, sek);
	}
	@Path("DodajSpol")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	public void getSpol(Zaposleni delavec, String spol) {
		delavec.setSpol(delavec, spol);
	}
	@Path("DodajStarost")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	public void getStarost(Zaposleni delavec, int st) {
		delavec.setStarost(delavec, st);
	}
	@Path("DodajTip")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	public void getTip(Zaposleni delavec, String tip) {
		delavec.setTip(delavec, tip);
	}
}